package mycats.lib.syntax
import mycats.lib.obj.Semigroup

object SemigroupSyntax {
  implicit class SemigroupSyntaxOps[A](va:A){
    def combine(vb:A)(implicit semigroupInstance:Semigroup[A]):A = semigroupInstance.combine(va,vb)
  }

}
