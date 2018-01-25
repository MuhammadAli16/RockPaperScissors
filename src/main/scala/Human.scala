class Human(name: String) extends Player(name){

  def makeMove(): Move.Value = {
    val userMove = scala.io.StdIn.readLine("Make a move ")
    val move = inputToMove(userMove)
    currentMove = move
    move
  }

  def inputToMove(str: String): Move.Value = {
    if (str.equals("r") || str.equals("Rock")){
      Move.ROCK
    } else if (str.equals("p") || str.equals("Paper")){
      Move.PAPER
    } else {
      Move.SCISSORS
    }

  }

}
