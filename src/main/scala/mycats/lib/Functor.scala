package mycats.lib

/**


  ┌─────────────┐                     ┌─────────────┐
  │Invariant    │                     │Semigroupal  │
  │Semigroupal  ├───────────────┬────►│             │
  │             │               │     │             │
  └─────────────┘               │     └─────────────┘
                                │
                                │
  ┌─────────────┐               │     ┌─────────────┐
  │Functor      │               └────►│Invariant    │
  │             │                     │             │
  │             ├────────────────────►│             │
  └─────────────┘                     └─────────────┘
 */
trait Functor[F[_]] extends Invariant[F]{

  def map[A,B](fa:F[A])(f:A=>B):F[B]
  override def imap[A, B](fa:  F[A])(f:  A => B)(g:  B => A): F[B] = map(fa)(f)
}
