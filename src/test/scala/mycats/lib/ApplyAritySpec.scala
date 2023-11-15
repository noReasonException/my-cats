package mycats.lib
import mycats.lib.morphisms.Apply
import mycats.instances.Option.optionalApplyInstance
import mycats.lib.syntax.ApplySyntax.applyAritySyntaxOps

class ApplyAritySpec extends org.scalatest.funsuite.AnyFunSuite {
  test("Apply Law : Arity 2 : Product should be associative") {
    val opt1:Option[Int]=Some(32)
    val opt2:Option[String]=Some("Hello world")
    val opt3:Option[Double]=Some(42.42)
    //assert((opt1.productN(opt2)).productN(opt3) == opt1.productN(opt2.productN(opt3)) ,"Semigroupal is not associative?")
    //wait for answer https://medium.com/@PerrottaFrancisco/semigroupal-parallel-applicative-in-cats-6df527b853da
  }
}
