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
  │Composeable ├─────┤                                   │
  │Morphism    │     │     ┌─────────────┐               │     ┌─────────────┐
  └────────────┘     │     │Functor      │               └────►│Invariant    │
                     └────►│             │                     │             │
                           │             ├────────────────────►│             │
                           └─────────────┘                     └─────────────┘




 */

//While a functor is a morphism between categories while maintaining the algebraic structure, Applicative is
//a functor that can go from one category to the other, while the morphism itself is a category (is effectful)
//is basically a Semigroupoid Functor.
trait Apply[F[_]] extends InvariantSemigroupal[F] with Functor[F] {

  //ap is nessesary to define the heart of the 'Apply' functor, the composeability.
  override def product[A, B](a:  F[A], b:  F[B]): F[(A, B)] = {
    val fn:F[A=>(A,B)] = map(b)(v=>(a:A)=>(a,v))
    ap(fn)(a)
  }

  def ap[A,B](ff:F[A=>B])(fa:F[A]):F[B]

}
