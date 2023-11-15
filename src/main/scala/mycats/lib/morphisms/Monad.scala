package mycats.lib.morphisms

trait Monad[F[_]] extends Applicative[F] with FlatMap[F]