package mycats.lib.syntax
import mycats.lib.morphisms.Invariant

object InvariantSyntax {
  implicit class InvariantSyntaxOps[F[_],A](fa:F[A]){
    def imap[B](f:A=>B)(g:B=>A)(implicit inv:Invariant[F]):F[B]=inv.imap(fa)(f)(g)
  }

}
