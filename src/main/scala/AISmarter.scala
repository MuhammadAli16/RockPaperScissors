class AISmarter(name: String) extends Player(name){


  def genMove(): Move.Value = {

    var commonMove = getOppositionMoves.groupBy(identity).maxBy(_._2.size)._1

    val moveToMake: Move.Value = commonMove match {
      case Move.ROCK => Move.PAPER
      case Move.PAPER => Move.SCISSORS
      case Move.SCISSORS => Move.ROCK
    }

    makeMove(moveToMake)
  }

}