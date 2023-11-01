package mycats.examples

import mycats.algebras.Validated
import mycats.instances.ValidatedInstances.validatedApplicativeErrorInstance
object ValidatedExample {
  val validatedInstance = validatedApplicativeErrorInstance[Throwable,String]
  def main(args: Array[String]): Unit = {
    val valid:Validated[Throwable,String] = validatedInstance.pure("Any")
    val invalid:Validated[Throwable,String] = validatedInstance.raiseError(new Throwable("Mem error"))
    val fn :String=>String=_+"hellow world"
    val invalidMap = validatedInstance.map[String,String](invalid)(fn)
    print(invalidMap)

  }
}
