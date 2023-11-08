package mycats.lib.syntax

import mycats.lib.morphisms.Functor

object FunctorSyntax {
  implicit class FunctorSyntaxOps[F[_],A](fa:F[A]){
    def map[B](f:A=>B)(implicit functorInstance:Functor[F]):F[B] = functorInstance.map(fa)(f)
  }
}
