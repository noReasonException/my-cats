package mycats.impl
import mycats.lib.morphisms.Monad

object Either{
  implicit def eitherMonad[E]:({ type A = Either[E, A] })#A ={

  }
}