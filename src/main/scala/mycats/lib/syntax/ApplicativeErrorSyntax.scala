package mycats.lib.syntax
import mycats.lib.morphisms.error.ApplicativeError

object ApplicativeErrorSyntax {
  implicit class ApplicativeErrorSyntaxOps[F[_],A](fa:F[A]){
    def handleErrorWith[E](handle:E=>F[A])(implicit ae:ApplicativeError[F,E]):F[A]=ae.handleErrorWith(fa)(handle)
    def handleError[E](handle:E=>A)(implicit ae:ApplicativeError[F,E]):F[A]=ae.handleError(fa)(handle)
  }
}
