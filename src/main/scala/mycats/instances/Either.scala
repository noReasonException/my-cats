package mycats.instances
import mycats.lib.morphisms.error.MonadError
import mycats.lib.obj.Semigroup

object Either {
  implicit def eitherMonadErrorInstance[E](implicit semiOfE:Semigroup[E]) = new MonadError[({type F[C] = Either[E,C]})#F,E] {

    override def ensure[A](fa:  Either[E, A])(error:  =>E)(predicate:  A => Boolean): Either[E, A] = ensureOr(fa)(_=>error)(predicate)

    override def ensureOr[A](fa:  Either[E, A])(error:  A => E)(predicate:  A => Boolean): Either[E, A] = fa match {
      case p@Right(value) if predicate(value) => p
      case Right(value) => Left(error(value))
      case p=>p
    }

    override def adaptError[A](fa:  Either[E, A])(pf:  PartialFunction[E, E]): Either[E, A] = fa match {
      case Left(value) => Left(pf.orElse[E,E]({case e=>e})(value))
      case p@Right(_) => p
    }
    override def rethrow[A, EE <: E](fa:  Either[E, Either[EE, A]]): Either[E, A] = fa.flatten //cheat

    override def flatMap[A, B](fa:  Either[E, A])(f:  A => Either[E, B]): Either[E, B] = rethrow(map(fa)(f))

    override def raiseError[A](e:  E): Either[E, A] = Left(e)

    override def handleErrorWith[A](fa:  Either[E, A])(f:  E => Either[E, A]): Either[E, A] = fa match {
      case Left(e) => f(e)
      case p => p
    }

    override def handleError[A](fa:  Either[E, A])(f:  E => A): Either[E, A] = handleErrorWith(fa)(f andThen pure)

    override def pure[A](a:  A): Either[E, A] = Right(a)

    override def ap[A, B](ff:  Either[E, A => B])(fa:  Either[E, A]): Either[E, B] = (ff,fa) match {
      case (Right(f),Right(a))=>Right(f(a))
      case (Left(f),_)=>Left(f)
      case (_,Left(a))=>Left(a)
      case (Left(f),Left(a))=>Left(semiOfE.combine(f,a))

    }

    override def map[A, B](fa:  Either[E, A])(f:  A => B): Either[E, B] = flatMap(fa)(f andThen pure)
  }
}
