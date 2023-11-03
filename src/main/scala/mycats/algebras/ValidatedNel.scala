package mycats.algebras
import mycats.examples.common.Utils.NonEmptyList

object ValidatedNel {
  type ValidatedNel[A] = Validated[NonEmptyList[String],A]

}
