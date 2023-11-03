package mycats.lib.syntax
import mycats.lib.morphisms.bi.BiFunctor

object BiFunctorSyntax {
  implicit class BiFunctorSyntaxOps[F[_,_],A,B](fa:F[A,B]){
    def bimap[C,D](f:A=>C)(g:B=>D)(implicit bifunctorInstance:BiFunctor[F]):F[C,D] = bifunctorInstance.bimap(fa)(f)(g)
  }
}
