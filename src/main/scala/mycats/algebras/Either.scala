package mycats.algebras

sealed trait Either[+E,+A]{
  def isRight:Boolean = false
  def isLeft :Boolean = false
}

case class Right[+A](value:A) extends Either[Nothing,A]{
  override def isRight: Boolean = true
}
case class Left[+A](value:A) extends Either[A,Nothing]{
  override def isLeft: Boolean = true
}