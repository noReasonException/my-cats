package mycats.examples

import mycats.algebras.ValidatedNel.ValidatedNel
import mycats.algebras.{Invalid, Valid, Validated}
import mycats.examples.common.Expense
import mycats.examples.common.Utils.NonEmptyList
import mycats.instances.ValidatedNel.{semigroupOfNonEmptyList, validatedNelInstance}
import mycats.lib.syntax.ApplySyntax.Tuple2ApplyOps
import mycats.instances.ValidatedNel._
object ValidatedExample {
  private def expenseIdValidation(expenseID:Long):ValidatedNel[Long]=
    if(expenseID<=0) Invalid(List("Expense ID cannot be negative")) else Valid(expenseID)

  private def expenseAmountValidation(expenseAmount:Double):ValidatedNel[Double]=
    if(expenseAmount<=0) Invalid(List("Expense amount cannot be negative")) else Valid(expenseAmount)

  private def mkExpense(id:Long,amount:Double):ValidatedNel[Expense] = {
    val v1 = expenseIdValidation(id)
    val v2 = expenseAmountValidation(amount)

    val product: Validated[NonEmptyList[String], (Long, Double)] = validatedNelInstance.product(v1,v2)
    validatedNelInstance.map(product)((Expense.apply _).tupled)

  }
  private def mkExpenseMapN(id:Long,amount:Double):ValidatedNel[Expense] =
    (expenseIdValidation(id), expenseAmountValidation(amount)).mapN((Expense.apply _).tupled)


  def main(args: Array[String]): Unit = {
    val valid = mkExpenseMapN(-1,-12.0)
    print(valid)

  }
}
