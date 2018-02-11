class AI(name: String) extends Player(name){

  def genMove(): Move.Value = {
    makeMove(Move(scala.util.Random.nextInt(Move.maxId)))
  }
}
