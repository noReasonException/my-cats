package mycats.lib.morphisms

/**
 * Semigroupal captures the idea of composing independent effectful values.
 * It is of particular interest when taken together with Functor(Apply) -
 * where Functor captures the idea of applying a unary pure function to an effectful value,
 * calling product with map allows one to apply a function of arbitrary arity to multiple independent effectful values.
 *
 *
 * While Semigroup allows us to join values, Semigroupal allows us to join contexts.
 *
 */
trait Semigroupal[F[_]] {
  def product[A,B](a:F[A],b:F[B]):F[(A,B)]
}
