package mycats.lib

/**
 *
 * Semigroupal captures the idea of composing independent effectful values.
 * It is of particular interest when taken together with Functor(Apply) -
 * where Functor captures the idea of applying a unary pure function to an effectful value,
 * calling product with map allows one to apply a function of arbitrary arity to multiple independent effectful values.
 *

                           ┌─────────────┐                     ┌─────────────┐
                           │Invariant    │                     │Semigroupal  │
                     ┌────►│Semigroupal  ├───────────────┬────►│             │
                     │     │             │               │     │             │
  ┌────────────┐     │     └─────────────┘               │     └─────────────┘
  │Apply       │     │                                   │
  │            ├─────┤                                   │
  │            │     │     ┌─────────────┐               │     ┌─────────────┐
  └────────────┘     │     │Functor      │               └────►│Invariant    │
                     └────►│             │                     │             │
                           │             ├────────────────────►│             │
                           └─────────────┘                     └─────────────┘




 */
trait Apply {

}
