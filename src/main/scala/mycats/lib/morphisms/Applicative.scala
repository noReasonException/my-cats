package mycats.lib.morphisms

/*

                                                   ┌─────────────┐                     ┌─────────────┐
                                                   │Invariant    │                     │Semigroupal  │
                                             ┌────►│Semigroupal  ├───────────────┬────►│+product     │
                                             │     │             │               │     │             │
       ┌────────────┐     ┌────────────┐     │     └─────────────┘               │     └─────────────┘
       │Applicative │     │Apply       │     │                                   │
       │+pure       ├────►│+ap         ├─────┤                                   │
       │            │     │            │     │     ┌─────────────┐               │     ┌─────────────┐
       └────────────┘     └────────────┘     │     │Functor      │               └────►│Invariant    │
                                             └────►│+map         │                     │+imap        │
                                                   │             ├────────────────────►│             │
                                                   └─────────────┘                     └─────────────┘

Applicative is a pure-lift capable apply
 */
trait Applicative[F[_]] extends Apply[F]{
  def pure[A](a:A):F[A]
}
