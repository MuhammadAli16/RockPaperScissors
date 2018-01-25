class AI(name: String) extends Player(name){

  def makeMove(): Move.Value = {
    val move = Move(scala.util.Random.nextInt(Move.maxId))
    currentMove = move
    move
  }
}
