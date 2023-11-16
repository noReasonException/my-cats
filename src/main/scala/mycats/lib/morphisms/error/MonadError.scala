package mycats.lib.morphisms.error
import mycats.lib.morphisms.Monad

trait MonadError[F[_],E] extends ApplicativeError[F,E] with Monad[F]{
  def ensure[A](fa:F[A])(error: =>E)(predicate:A=>Boolean):F[A] = ???
  def ensureOr[A](fa:F[A])(error: A=>E)(predicate:A=>Boolean):F[A] =
    flatMap[A,A](fa)(v => if(predicate(v)) pure(v) else raiseError[A](error(v)))

  def adaptError[A](fa:F[A])(pf:PartialFunction[E,E]):F[A]
  def rethrow[A,EE<:E](fa:F[Either[EE,A]]):F[A]

}
