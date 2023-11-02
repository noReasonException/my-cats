package mycats.lib.morphisms.arity
import mycats.lib.morphisms.{Apply, Functor, Semigroupal}

trait ApplyArityFunctions[F[_]] {

  self:Apply[F]=>
    //This has arity2, as arity1 is the plain product, arity seems to be n+1 as the first arg is a product category ((Α,Β),C)
    //that's speculation, i need to ask around
    def map2[A,B,C,Z](fa:F[A],fb:F[B],fc:F[C])(f:(A,B,C)=>Z):F[Z]=
      map(product2(fa,fb,fc))((f).tupled)


    def product2[A,B,C](fa:F[A],fb:F[B],fc:F[C]):F[(A,B,C)]=
      map(product[A,(B,C)](fa,product[B,C](fb,fc))){case (a0,(a1,a2))=>(a0,a1,a2)}
}
