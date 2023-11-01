package mycats.lib.morphisms.bi


//Bifunctor is a functor with 2 type arguments, or put it in another way, is simply a functor whose domain is a product category:
//https://ncatlab.org/nlab/show/bifunctor
trait BiFunctor[F[_,_]]{
  def bimap[A,B,C,D](fab:F[A,B])(fac:A=>C)(fbd:B=>D):F[C,D]
}
