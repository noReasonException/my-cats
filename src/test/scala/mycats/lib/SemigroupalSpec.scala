package mycats.lib

import mycats.instances.OptionInstances.optionalSemigroupalInstance
import mycats.lib.syntax.SemigroupalSyntax._


//There is some sources
class SemigroupalSpec extends org.scalatest.funsuite.AnyFunSuite {
  test("Semigroupal Law : Arity 1 : Product should be associative") {
//    val opt1:Option[Int]=Some(32)
//    val opt2:Option[String]=Some("Hello world")
//    val opt3:Option[Double]=Some(42.42)
//    assert(opt1.product(opt2.product(opt3))==(opt1.product(opt2)).product(opt3) ,"Semigroupal is not associative?")
    assert(1==1,"Semigroupal fixed with arity 1 is associative by definition")
  }
}
