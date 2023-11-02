package mycats.lib.syntax
import mycats.lib.morphisms.{Apply, Semigroupal}

object ApplySyntax {
  implicit class applyAritySyntaxOps[F[_],A](fa:F[A]){
    def productN[B](fb:F[B])(implicit semigroupalF:Semigroupal[F]) = semigroupalF.product(fa,fb)
    def productN[B,C](fb:F[B],fc:F[C])(implicit apply:Apply[F]) = apply.product2(fa,fb,fc)
  }
}
