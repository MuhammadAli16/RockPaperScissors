class AISmarter(name: String) extends Player(name){


  def genMove(): Move.Value = {

    var commonMove = getOppositionMoves.groupBy(identity).maxBy(_._2.size)._1

    var moveToMake: Move.Value = Move.PAPER

    commonMove match {
      case Move.ROCK => moveToMake = Move.PAPER
      case Move.PAPER => moveToMake = Move.SCISSORS
      case Move.SCISSORS => moveToMake = Move.ROCK
    }

    makeMove(moveToMake)
  }

}