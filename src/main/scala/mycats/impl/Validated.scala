package mycats.impl
import mycats.lib.Apply

trait Validated[F[_],A,B] extends Apply[F]{
  override def ap[A, B](ff:  F[A => B])(fa:  F[A]): F[B] = ???
  override def map[A, B](fa:  F[A])(f:  A => B): F[B] = ???
  //todo next time
}
