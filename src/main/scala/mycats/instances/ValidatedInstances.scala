package mycats.instances
import mycats.algebras.{Invalid, Valid, Validated}
import mycats.lib.morphisms.bi.BiFunctor
import mycats.lib.morphisms.error.ApplicativeError
import mycats.lib.obj.Semigroup

object ValidatedInstances {

  implicit def validatedApplicativeErrorInstance[E,A](implicit semigroupOfE:Semigroup[E])=
    new ApplicativeError[({type Valid[C] = Validated[E, C]})#Valid,E] with BiFunctor[Validated]{
      override def raiseError[A](e:  E): Validated[E, A] = Invalid(e)
      override def handleErrorWith[A](fa:  Validated[E, A])(f:  E => Validated[E, A]): Validated[E, A] = fa match {
        case p@Valid(_) => p
        case Invalid(invalid) => f(invalid)
      }
      override def handleError[A](fa:  Validated[E, A])(f:  E => A): Validated[E, A] = handleErrorWith(fa)(f andThen pure)

      override def bimap[A, B, C, D](fab:  Validated[A, B])(fac:  A => C)(fbd:  B => D): Validated[C, D] = fab match {
        case Valid(valid) => Valid(fbd(valid))
        case Invalid(invalid) => Invalid(fac(invalid))
      }
      override def pure[A](a:  A): Validated[E, A] = Valid(a)
      override def map[A, B](fa:  Validated[E, A])(f:  A => B): Validated[E, B] = fa match {
        case Valid(valid) => Valid(f(valid))
        case p@Invalid(invalid)=>p
      }
      //YEEEEEEE!
      override def ap[A, B](ff:  Validated[E, A => B])(fa:  Validated[E, A]): Validated[E, B] = (ff,fa) match {
        case (Valid(f),Valid(a))=>Valid(f(a))
        case (Invalid(err1),Invalid(err2))=>Invalid(semigroupOfE.combine(err1,err2))
        case (Invalid(err),_)=>Invalid(err)
        case (_,Invalid(err))=>Invalid(err)

      }
  }
}
