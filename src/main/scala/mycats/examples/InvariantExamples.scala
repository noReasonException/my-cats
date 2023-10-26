package mycats.examples
import mycats.examples.common.Expense
import mycats.lib.instances.InvariantInstances.invariantSemigroup
import mycats.lib.obj.Semigroup
import mycats.lib.syntax.InvariantSyntax.InvariantSyntaxOps

object InvariantExamples {

  implicit val expenseSemigroup:Semigroup[Expense] = (l: Expense, r: Expense) => Expense(Math.max(l.id,r.id),l.amount+r.amount)


  def main(args: Array[String]): Unit = {

    val transformedSemigroup:Semigroup[String] = expenseSemigroup
      .imap(exp=>exp.id+","+exp.amount)(str=>Expense(str.split(",").head.toLong,str.split(",").tail.head.toDouble))
    print(transformedSemigroup.combine("1,2","3,4"))
  }

}
