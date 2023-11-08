package mycats.instances

import mycats.algebras.ValidatedNel.ValidatedNel
import mycats.algebras.{Invalid, Valid, Validated}
import mycats.examples.common.Expense
import mycats.examples.common.Utils.NonEmptyList
import mycats.instances.ValidatedNelInstances.validatedNelInstance
import mycats.lib.syntax.ApplySyntax.Tuple2ApplyOps
import mycats.instances.ValidatedNelInstances._
import mycats.lib.syntax.BiFunctorSyntax.BiFunctorSyntaxOps
import mycats.lib.syntax.SemigroupSyntax._
import mycats.lib.syntax.ApplicativeErrorSyntax._
import mycats.instances.ValidatedNelInstances.validatedNelInstance
class ValidatedNelInstancesSpec extends org.scalatest.funsuite.AnyFunSuite {
  test("Semigroup NonEmptyList: combine should behave as expected") {
    val nonEmpty1:NonEmptyList[Int] = 1::2::3::Nil
    val nonEmpty2:NonEmptyList[Int] = 4::5::6::Nil
    assert(nonEmpty1.combine(nonEmpty2)==(1 to 6).toList,"Semigroup NonEmptyList: combine does not concat the list as expected")
  }
  test("ValidatedNel BiFunctor: bimap should transform valid context") {
    val validatedNel:ValidatedNel[Int] = Valid(42)
    assert(validatedNel.bimap(_.headOption)(String.valueOf)==Valid("42"),"ValidatedNel BiFunctor: bimap does not transform Valid Context properly")
  }
  test("ValidatedNel BiFunctor: bimap should transform invalid context") {
    val validatedNel:ValidatedNel[Int] = Invalid("Error"::Nil)
    assert(validatedNel.bimap(_.head)(String.valueOf)==Invalid("Error"),"ValidatedNel BiFunctor: bimap does not transform Invalid Context properly")
  }
  test("ValidatedNel ApplicativeError: raiseError should lift E to Validated[E,A] as invalid projection") {
    assert(validatedNelInstance.raiseError(List("Some Error"))==Invalid(List("Some Error")),"ValidatedNel ApplicativeError: raiseError does not lift E to Validated[E,A] as invalid projection")
  }
  test("ValidatedNel ApplicativeError: handleError should behave as identity map when acted upon a valid instance") {
    val validatedNel:ValidatedNel[Int] = Valid(42)
    val identity:ValidatedNel[Int] = validatedNel.handleError[NonEmptyList[String]](_=>40)
    assert(identity==validatedNel,"ValidatedNel ApplicativeError: handleError alters a Valid Instance")
  }
  test("ValidatedNel ApplicativeError: handleError should recover an invalid operation") {
    val invalidNel:ValidatedNel[Int] = Invalid(List("ExistentialCrisisErr: Unable to find meaning of life"))
    val recover:ValidatedNel[Int] = invalidNel.handleError[NonEmptyList[String]](_=>42)
    assert(recover==Valid(42),"ValidatedNel ApplicativeError: handleError does not recover failed operation")
  }


  //ApplicativeError (raiseError,handleErrorWith,handleError)
  //Applicative (pure)
  //Apply (ap)
  //Functor (map)
  //Arity (map2,product2)
  //Invariant(imap)
  //Semigroupal(product)



  private def expenseIdValidation(expenseID:Long):ValidatedNel[Long]=
    if(expenseID<=0) Invalid(List("Expense ID cannot be negative")) else Valid(expenseID)

  private def expenseAmountValidation(expenseAmount:Double):ValidatedNel[Double]=
    if(expenseAmount<=0) Invalid(List("Expense amount cannot be negative")) else Valid(expenseAmount)

  private def mkExpenseMapN(id:Long,amount:Double):ValidatedNel[Expense] =
    (expenseIdValidation(id), expenseAmountValidation(amount)).mapN((Expense.apply _).tupled)

}
