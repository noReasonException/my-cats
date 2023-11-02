package mycats.lib.morphisms.arity
import mycats.lib.morphisms.{Apply, Functor, Semigroupal}

trait ApplyArityFunctions {
  //This has arity2, as arity1 is the plain product, arity seems to be n+1 as the first arg is a product category ((Α,Β),C)
  //that's speculation, i need to ask around
  def map2[F[_],A,B,C,Z](fa:F[A],fb:F[B],fc:F[C])(f:(A,B,C)=>Z)(implicit applyF:Apply[F]):F[Z]=
    applyF.map(applyF.product(fa,applyF.product(fb,fc))){case (a0,(a1,a2))=>f(a0,a1,a2)}

}
