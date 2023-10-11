package mycats.lib

trait Semigroupal[F[_]] {
  def product[A,B](a:F[A],b:F[B]):F[Tuple2[A,B]]
}
