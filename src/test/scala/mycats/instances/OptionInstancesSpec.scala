package mycats.instances

import mycats.instances.OptionInstances._
import mycats.lib.syntax.SemigroupalSyntax.SemigroupalSyntaxOps
class OptionInstancesSpec extends org.scalatest.funsuite.AnyFunSuite {
  test("Semigroupal Optional: Product should return F[(A,B}]") {
    val opt1:Option[String]=Some("The meaning of life")
    val opt2:Option[Int]=Some(42)
    assert((opt1).product(opt2)==Some(("The meaning of life",42)),"product does not return F[(A,B)] on Option Algebra")
  }
  //Functor, ap , imap
  test("Invariant Optional: imap should return F[B] given A=>B and B=>A") {
    val opt1:Option[String]=Some("The meaning of life")
    val opt2:Option[Int]=Some(42)
    assert((opt1).product(opt2)==Some(("The meaning of life",42)),"product does not return F[(A,B)] on Option Algebra")
  }

  test("Functor Optional: map should transform context") {
    val opt1:Option[String]=Some("The meaning of life")
    val opt2:Option[Int]=Some(42)
    assert((opt1).product(opt2)==Some(("The meaning of life",42)),"product does not return F[(A,B)] on Option Algebra")
  }
  test("Apply Optional: ap should do its ap thing") {
    val opt1:Option[String]=Some("The meaning of life")
    val opt2:Option[Int]=Some(42)
    assert((opt1).product(opt2)==Some(("The meaning of life",42)),"product does not return F[(A,B)] on Option Algebra")
  }
}
