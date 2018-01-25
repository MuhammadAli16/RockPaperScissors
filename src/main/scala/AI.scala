class AI(name: String) extends Player(name){

  def genMove(): Move.Value = {
    val move = Move(scala.util.Random.nextInt(Move.maxId))
    makeMove(move)
  }
}
