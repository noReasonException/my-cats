package mycats.instances

import mycats.algebras.ValidatedNel.ValidatedNel
import mycats.algebras.{Invalid, Valid, Validated}
import mycats.examples.common.Expense
import mycats.examples.common.Utils.NonEmptyList
import mycats.instances.ValidatedNelInstances.validatedNelInstance
import mycats.lib.syntax.ApplySyntax.Tuple2ApplyOps
import mycats.instances.ValidatedNelInstances._
import mycats.lib.syntax.SemigroupSyntax._
class ValidatedNelInstancesSpec extends org.scalatest.funsuite.AnyFunSuite {
  test("Semigroup NonEmptyList: combine should behave as expected") {
    val nonEmpty1:NonEmptyList[Int] = 1::2::3::Nil
    val nonEmpty2:NonEmptyList[Int] = 4::5::6::Nil
    assert(nonEmpty1.combine(nonEmpty2)==(1 to 6).toList,"Semigroupal's .product does not return F[(A,B)] when applied in Option Algebra")
  }
  //BiFunctor (bimap)
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
