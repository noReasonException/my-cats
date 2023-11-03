package mycats.instances
import mycats.algebras.Validated
import mycats.examples.common.Utils.NonEmptyList
import mycats.instances.ValidatedInstances.validatedApplicativeErrorInstance
import mycats.lib.morphisms.bi.BiFunctor
import mycats.lib.morphisms.error.ApplicativeError
import mycats.lib.obj.Semigroup

object ValidatedNelInstances {
  implicit def semigroupOfNonEmptyList[A]:Semigroup[NonEmptyList[A]] = (x: NonEmptyList[A], y: NonEmptyList[A]) => x.appendedAll(y)
  implicit val validatedNelInstance: ApplicativeError[({type Valid[C] = Validated[NonEmptyList[String], C]})#Valid, NonEmptyList[String]] with BiFunctor[Validated] = validatedApplicativeErrorInstance[NonEmptyList[String]]

}