package mycats.instances

import mycats.lib.morphisms.{Apply, Semigroupal}

object OptionInstances {

  implicit val optionalApplyInstance:Apply[Option] = new Apply[Option] {
    override def product[A, B](a:  Option[A], b:  Option[B]): Option[(A, B)] = {
      (a,b) match {
        case (Some(a),Some(b))=>Some((a,b))
        case _ => None
      }
    }
    override def ap[A, B](ff:  Option[A => B])(fa:  Option[A]): Option[B] = map(product(ff,fa))(tu2=>tu2._1(tu2._2))
    override def map[A, B](fa:  Option[A])(f:  A => B): Option[B] = fa match {
      case Some(value) => Some(f(value))
      case None => None
    }
}

}
