package mycats.lib.morphisms

/**
                                        ┌──────────────┐
                                        │              │
                                  ┌────►│Semigroupal   │
                                  │     │              │
   ┌────────────────────────┐     │     └──────────────┘
   │                        │     │
   │InvariantSemigroupal    ├─────┤
   │                        │     │     ┌──────────────┐
   └────────────────────────┘     │     │              │
                                  └────►│Invariant     │
                                        │              │
                                        └──────────────┘
*/

trait InvariantSemigroupal[F[_]] extends Invariant [F] with Semigroupal [F]
