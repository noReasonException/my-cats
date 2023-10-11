package mycats.lib

trait Semigroup[A] {
  def combine(x:A,y:A):A

}
