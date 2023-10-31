package mycats.instances

import mycats.lib.morphisms.Semigroupal

object OptionInstances {

  implicit val optionalSemigroupalInstance:Semigroupal[Option] = new Semigroupal[Option] {
    override def product[A, B](a:  Option[A], b:  Option[B]): Option[(A, B)] = {
      (a,b) match {
        case (Some(a),Some(b))=>Some((a,b))
        case _ => None
      }
    }
  }

}
