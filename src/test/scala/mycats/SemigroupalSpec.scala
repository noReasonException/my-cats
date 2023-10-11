package mycats

class SemigroupalSpec extends org.scalatest.funsuite.AnyFunSuite {
  test("Semigroupal Option") {
    import mycats.lib.Semigroupal

    val opt1:Option[Int]=Some(32)
    val opt2:Option[String]=Some("Hello world")
    assert(condition = opt1.combine(opt2)==Some((32,"Hello world")),"combine definition should be honored")
  }
}
