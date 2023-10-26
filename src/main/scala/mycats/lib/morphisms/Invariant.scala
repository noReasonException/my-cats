package mycats.lib.morphisms

/**
 *
    ┌─────────┐               ┌─────────┐
    │         │               │         │
    │ Functor │ ───────────►  │ .map    │
    │         │               │         │
    └─────────┘               └─────────┘


    ┌─────────┐               ┌─────────┐
    │Invariant│               │         │
    │Functor  │ ───────────►  │.imap    │
    │         │               │         │
    └─────────┘               └─────────┘

 For example, Semigroup[A] forms an Invariant Functor(see examples)
 */
trait Invariant[F[_]] {
  def imap[A,B](fa:F[A])(f:A=>B)(g:B=>A):F[B]
}
