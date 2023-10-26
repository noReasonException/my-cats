package mycats.lib.instances
import mycats.lib.morphisms.Invariant
import mycats.lib.obj.Semigroup

object InvariantInstances {
  implicit val invariantSemigroup:Invariant[Semigroup] = new Invariant[Semigroup] {
    override def imap[A, B](fa:  Semigroup[A])(f:  A => B)(g:  B => A): Semigroup[B] = (x: B, y: B) => f(fa.combine(g(x),g(y)))
  }
}
