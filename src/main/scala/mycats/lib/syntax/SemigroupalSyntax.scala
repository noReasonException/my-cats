package mycats.lib.syntax

import mycats.lib.Semigroupal
object SemigroupalSyntax {
  implicit class SemigroupalSyntaxOps[F[_],A](a:F[A]){
    def combine[B](b:F[B])(implicit semigroupal:Semigroupal[F]):F[(A,B)] = semigroupal.product(a,b)
  }
}
