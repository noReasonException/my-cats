package mycats.instances

import mycats.instances.Option._
import mycats.lib.syntax.ApplySyntax.applySyntaxOps
import mycats.lib.syntax.InvariantSyntax.InvariantSyntaxOps
import mycats.lib.syntax.SemigroupalSyntax.SemigroupalSyntaxOps
class OptionSpec extends org.scalatest.funsuite.AnyFunSuite {
  val opt1:Option[String]=Some("The meaning of life")
  val opt2:Option[Int]=Some(42)
  val opt3:Option[String]=Some("42")

  test("Semigroupal Optional: Product should return F[(A,B}]") {
    assert((opt1).product(opt2)==Some(("The meaning of life",42)),"Semigroupal's .product does not return F[(A,B)] when applied in Option Algebra")
  }
  //Functor, ap , imap
  test("Invariant Optional: imap should return F[B] given A=>B and B=>A") {
    assert(opt3.imap(Integer.valueOf)(String.valueOf)==Some(42),"Invariant Functor's .imap does not transform context when applied in Option Algebra")
  }

  test("Functor Optional: map should transform context") {
    assert(opt3.map(Integer.valueOf)==Some(42),"Functor's .map does not transform context when applied in Option Algebra")
  }
  test("Apply Optional: ap should do its ap thing") {
    val fnInContext: Option[Int=>String] = Some(String.valueOf)
    assert(opt2.ap(fnInContext)==opt3,"product does not return F[(A,B)] on Option Algebra")
  }
}
