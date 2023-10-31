package mycats.lib.morphisms.error
import mycats.lib.morphisms.Applicative
trait ApplicativeError[F[_],E] extends Applicative[F]{
  def raiseError[A](e:E):F[A]
  def handleErrorWith[A](fa:F[A])(f:E=>F[A]):F[A]
  def handleError[A](fa:F[A])(f:E=>A):F[A]
  //attempt and recover are omitted to avoid circular Either'
}
