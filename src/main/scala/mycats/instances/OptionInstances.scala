package mycats.instances

import mycats.lib.morphisms.{Apply, Semigroupal}

object OptionInstances {

  implicit val optionalSemigroupalInstance:Semigroupal[Option] = new Semigroupal[Option] {
    override def product[A, B](a:  Option[A], b:  Option[B]): Option[(A, B)] = {
      (a,b) match {
        case (Some(a),Some(b))=>Some((a,b))
        case _ => None
      }
    }
  }
  implicit val optionalApplyInstance:Apply[Option] = new Apply[Option] {
    override def product[A, B](a:  Option[A], b:  Option[B]): Option[(A, B)] = optionalSemigroupalInstance.product(a,b)
    override def ap[A, B](ff:  Option[A => B])(fa:  Option[A]): Option[B] = ???
    override def map[A, B](fa:  Option[A])(f:  A => B): Option[B] = fa match {
      case Some(value) => Some(f(value))
      case None => None
    }
}

}
