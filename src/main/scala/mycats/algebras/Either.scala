package mycats.algebras

object Either{
  implicit def eitherMonad[E]:({ type A = Either[E, A] })#A ={

  }
}
