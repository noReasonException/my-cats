package mycats.instances
import mycats.algebras.{Invalid, Valid, Validated}
import mycats.lib.morphisms.bi.BiFunctor
import mycats.lib.morphisms.error.ApplicativeError

object ValidatedInstances {
  //??? next time
  implicit def validatedApplicativeErrorInstance[E,A]=
    new ApplicativeError[({type Valid[C] = Validated[E, C]})#Valid,E] with BiFunctor[Validated]{
      override def raiseError[A](e:  E): Validated[E, A] = Invalid(e)
      override def handleErrorWith[A](fa:  Validated[E, A])(f:  E => Validated[E, A]): Validated[E, A] = ???
      override def handleError[A](fa:  Validated[E, A])(f:  E => A): Validated[E, A] = ???
      override def bimap[A, B, C, D](fab:  Validated[A, B])(fac:  A => C)(fbd:  B => D): Validated[B, D] = ???
      override def pure[A](a:  A): Validated[E, A] = Valid(a)
      override def map[A, B](fa:  Validated[E, A])(f:  A => B): Validated[E, B] = fa match {
        case Valid(valid) => Valid(f(valid))
        case p@Invalid(invalid)=>p
      }
      override def ap[A, B](ff:  Validated[E, A => B])(fa:  Validated[E, A]): Validated[E, B] = ???
  }
}
