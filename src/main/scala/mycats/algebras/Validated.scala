package mycats.algebras

sealed trait Validated[E,A] extends Product with Serializable{}
case class Valid[A](valid:A) extends Validated[Nothing,A]
case class Invalid[E](invalid:E) extends Validated[E,Nothing]


