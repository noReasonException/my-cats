package mycats.lib.obj

trait Semigroup[A] {
  def combine(x:A,y:A):A

}
