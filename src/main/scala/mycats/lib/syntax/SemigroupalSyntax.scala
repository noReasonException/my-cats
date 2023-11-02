package mycats.lib.syntax

import mycats.lib.morphisms.Semigroupal
object SemigroupalSyntax {
  implicit class SemigroupalSyntaxOps[F[_],A](a:F[A]){
    def product[B](b:F[B])(implicit semigroupal:Semigroupal[F]):F[(A,B)] = semigroupal.product(a,b)
  }
}
