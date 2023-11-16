package mycats.instances

import mycats.algebras.ValidatedNel.ValidatedNel
import mycats.algebras.{Invalid, Valid}
import mycats.examples.common.Expense
import mycats.examples.common.Utils.NonEmptyList
import mycats.instances.ValidatedNel._
import mycats.lib.syntax.ApplicativeErrorSyntax._
import mycats.lib.syntax.ApplySyntax.{Tuple2ApplyOps, applySyntaxOps}
import mycats.lib.syntax.BiFunctorSyntax.BiFunctorSyntaxOps
import mycats.lib.syntax.FunctorSyntax.FunctorSyntaxOps
import mycats.lib.syntax.SemigroupSyntax._
import mycats.lib.syntax.SemigroupalSyntax.SemigroupalSyntaxOps
import mycats.instances.Either._
class EitherSpec extends org.scalatest.funsuite.AnyFunSuite {

  test("Either BiFunctor: bimap should transform valid context") {
    val right:Either[String,Int] = Right(42)
    assert(right.bimap(identity)(String.valueOf)==Right("42"),"Either BiFunctor: bimap should transform valid context")
  }
  test("Either BiFunctor: bimap should transform invalid context") {
    val left:Either[String,Int] = Left("Error")
    assert(left.bimap(identity)(String.valueOf)==Left("Error"),"Either BiFunctor: bimap should transform invalid context")
  }
  test("Either ApplicativeError: raiseError should lift E to Left[E,A] as invalid projection") {
    assert(eitherMonadErrorInstance.raiseError("Some Error")==Left("Some Error"),"Either ApplicativeError: raiseError should lift E to Left[E,A] as invalid projection")
  }
  test("Either ApplicativeError: handleError should behave as identity map when acted upon a valid instance") {
    val right:Either[String,Int] = Right(42)
    val identical:Either[String,Int] = right.handleError[String](_=>40)
    assert(identical==right,"Either ApplicativeError: handleError should behave as identity map when acted upon a valid instance")
  }
//  test("ValidatedNel ApplicativeError: handleError should recover an invalid operation") {
//    val invalidNel:ValidatedNel[Int] = Invalid(List("ExistentialCrisisErr: Unable to find meaning of life"))
//    val recover:ValidatedNel[Int] = invalidNel.handleError[NonEmptyList[String]](_=>42)
//    assert(recover==Valid(42),"ValidatedNel ApplicativeError: handleError should recover an invalid operation")
//  }
//  test("ValidatedNel ApplicativeError: handleErrorWith should behave as identity map when acted upon a valid instance") {
//    val validatedNel:ValidatedNel[Int] = Valid(42)
//    val identity:ValidatedNel[Int] = validatedNel.handleErrorWith[NonEmptyList[String]](_=>Valid(40))
//    assert(identity==validatedNel,"ValidatedNel ApplicativeError: handleErrorWith should behave as identity map when acted upon a valid instance")
//  }
//  test("ValidatedNel ApplicativeError: handleErrorWith should recover an invalid operation") {
//    val invalidNel:ValidatedNel[Int] = Invalid(List("ExistentialCrisisErr: Unable to find meaning of life"))
//    val recover:ValidatedNel[Int] = invalidNel.handleErrorWith[NonEmptyList[String]](_=>Valid(42))
//    assert(recover==Valid(42),"ValidatedNel ApplicativeError: handleErrorWith should recover an invalid operation")
//  }
//  test("ValidatedNel Applicative: pure maps to valid") {
//    assert(validatedNelInstance.pure(42)==Valid(42),"ValidatedNel Applicative: pure maps to valid")
//  }
//  test("ValidatedNel Apply: ap maps a valid transformation to a valid context ") {
//    val validNel:ValidatedNel[Int] = Valid(42)
//    val fnNel:ValidatedNel[Int=>String] = Valid({
//      case 42 => "Meaning of life"
//      case _ => "Not the meaning of life"
//    })
//    assert(validNel.ap(fnNel)==Valid("Meaning of life"),"ValidatedNel Apply: ap maps a valid transformation to a valid context ")
//  }
//  test("ValidatedNel Apply: ap maps a valid transformation to a invalid context ") {
//    val invalidNel:ValidatedNel[Int] = Invalid(List("Unexpected Error"))
//    val fnNel:ValidatedNel[Int=>String] = Valid({
//      case 42 => "Meaning of life"
//      case _ => "Not the meaning of life"
//    })
//    assert(invalidNel.ap(fnNel)==Invalid(List("Unexpected Error")),"ValidatedNel Apply: ap maps a valid transformation to a invalid context ")
//  }
//  test("ValidatedNel Apply: ap maps a invalid transformation to a valid context ") {
//    val validNel:ValidatedNel[Int] = Valid(42)
//    val invalidfnNel:ValidatedNel[Int=>String] = Invalid(List("Tranformation failure"))
//    assert(validNel.ap(invalidfnNel)==Invalid(List("Tranformation failure")),"ValidatedNel Apply: ap maps a invalid transformation to a valid context")
//  }
//  test("ValidatedNel Apply: ap maps a invalid transformation to a invalid context (accumulate errors)") {
//    val invalidNel:ValidatedNel[Int] = Invalid(List("Unexpected Error"))
//    val invalidfnNel:ValidatedNel[Int=>String] = Invalid(List("Tranformation failure"))
//    assert(invalidNel.ap(invalidfnNel)==Invalid(List("Tranformation failure","Unexpected Error")),"ValidatedNel Apply: ap maps a invalid transformation to a invalid context (accumulate errors)")
//  }
//  test("ValidatedNel Functor: map maps a valid[A] into a valid[B]") {
//    val validNel:ValidatedNel[Int] = Valid(32)
//    assert(validNel.map(_+10)==Valid(42),"ValidatedNel Functor: map maps a valid[A] into a valid[B]")
//  }
//  test("ValidatedNel Functor: map identity when instance is Invalid") {
//    val invalidNel:ValidatedNel[Int] = Invalid(List("Unexpected Error"))
//    assert(invalidNel.map(_+10)==invalidNel,"ValidatedNel Functor: map identity when instance is Invalid")
//  }
//  test("ValidatedNel Semigroupal: product maps to product category (A,B), both valid") {
//    val validNel:ValidatedNel[Int] = Valid(42)
//    val validNel2:ValidatedNel[Int] = Valid(42)
//    assert(validNel.product(validNel2)==Valid((42,42)),"ValidatedNel Semigroupal: product A,B maps to product category (A,B), both valid")
//  }
//  test("ValidatedNel Semigroupal: product maps to product category (A,B), both invalid") {
//    val validNel:ValidatedNel[Int] = Invalid("Error 1"::Nil)
//    val validNel2:ValidatedNel[Int] = Invalid("Error 2"::Nil)
//    assert(validNel.product(validNel2)==Invalid("Error 2"::"Error 1"::Nil),"ValidatedNel Semigroupal: product A,B maps to product category (A,B), both invalid")
//  }
//  test("ValidatedNel Semigroupal: product maps to product category (A,B), first invalid") {
//    val validNel:ValidatedNel[Int] = Invalid("Error 1"::Nil)
//    val validNel2:ValidatedNel[Int] = Valid(42)
//    assert(validNel.product(validNel2)==Invalid("Error 1"::Nil),"ValidatedNel Semigroupal: product A,B maps to product category (A,B), first invalid")
//  }
//  test("ValidatedNel Semigroupal: product maps to product category (A,B), second invalid") {
//    val validNel:ValidatedNel[Int] = Valid(42)
//    val validNel2:ValidatedNel[Int] = Invalid("Error 2"::Nil)
//    assert(validNel.product(validNel2)==Invalid("Error 2"::Nil),"ValidatedNel Semigroupal: product A,B maps to product category (A,B), second invalid")
//  }
//
//  //Arity (map2,product2)
//  //Invariant(imap)
//
//  private def expenseIdValidation(expenseID:Long):ValidatedNel[Long]=
//    if(expenseID<=0) Invalid(List("Expense ID cannot be negative")) else Valid(expenseID)
//
//  private def expenseAmountValidation(expenseAmount:Double):ValidatedNel[Double]=
//    if(expenseAmount<=0) Invalid(List("Expense amount cannot be negative")) else Valid(expenseAmount)
//
//  private def mkExpenseMapN(id:Long,amount:Double):ValidatedNel[Expense] =
//    (expenseIdValidation(id), expenseAmountValidation(amount)).mapN((Expense.apply _).tupled)

}
