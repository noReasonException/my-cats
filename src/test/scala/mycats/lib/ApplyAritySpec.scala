package mycats.lib

import mycats.instances.OptionInstances.optionalSemigroupalInstance
import mycats.lib.syntax.SemigroupalSyntax._
import mycats.instances.OptionInstances.optionalApplyInstance
import mycats.lib.morphisms.Apply
import mycats.lib.morphisms.arity.ApplyArityFunctions
import mycats.lib.syntax.ApplySyntax.applyAritySyntaxOps
//There is some sources
class ApplyAritySpec extends org.scalatest.funsuite.AnyFunSuite {
  test("Apply Law : Arity 2 : Product should be associative") {
//    implicit val he:Apply[Option] = optionalApplyInstance
//    val opt1:Option[Int]=Some(32)
//    val opt2:Option[String]=Some("Hello world")
//    val opt3:Option[Double]=Some(42.42)
//
//    val left = applyAritySyntaxOps(opt1).product(opt2)(he)
//    val right = opt2.product(opt2,opt3)(he)
//
//    assert(optionalApplyInstance.pro(opt1,opt2,opt3)) ,"Semigroupal is not associative?")
  }
}
