package mycats.lib.syntax
import mycats.lib.morphisms.{Apply, Semigroupal}

object ApplySyntax {
  implicit class applyAritySyntaxOps[F[_],A](fa:F[A]){
    def productN[B,C](fb:F[B],fc:F[C])(implicit apply:Apply[F]) = apply.product2(fa,fb,fc)
  }
  implicit class Tuple2ApplyOps[F[_],A,B](ab:Tuple2[F[A],F[B]]){
    def mapN[C](f:Tuple2[A,B]=>C)(implicit apply:Apply[F]): F[C] =
      apply.map[(A,B),C](apply.product[A,B](ab._1,ab._2))(f)
  }
  implicit class applySyntaxOps[F[_],A](fa:F[A]){
    def ap[B](f:F[A=>B])(implicit applyF:Apply[F]):F[B]=applyF.ap(f)(fa)
  }
}
