package mycats.lib.syntax
import mycats.lib.morphisms.{Functor, Semigroupal}

object TupleCombineOps {

  implicit class Tuple2SemigroupalOps[F[_],A,B](ab:Tuple2[F[A],F[B]]){
    def mapN[C](f:Tuple2[A,B]=>C)(implicit semigroupalWithFunctor:Semigroupal[F] with Functor[F]): F[C] =
      semigroupalWithFunctor.map[(A,B),C](semigroupalWithFunctor.product[A,B](ab._1,ab._2))(f)
  }

}
