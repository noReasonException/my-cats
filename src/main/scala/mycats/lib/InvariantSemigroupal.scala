package mycats.lib

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
