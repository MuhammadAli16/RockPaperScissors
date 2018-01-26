class Game {
  var player1: Player = _
  var player2: Player = _

  def startGame(): Unit = {
    menu()

    val roundsStr = scala.io.StdIn.readLine("How many rounds? ")
    val rounds = roundsStr.toInt

    do {
      // Store the players moves - Ai will make decisions based on opposition moves
      player1.getOppositionMoves = player2.moveList
      player1.genMove()

      player2.getOppositionMoves = player1.moveList
      player2.genMove()

      println(player1.name + ": " + player1.currentMove)
      println(player2.name + ": " + player2.currentMove)
      checkWinner(player1, player2)
      displayScores()
      println()

    } while (player1.score != rounds && player2.score != rounds)

    theEnd()

  }

  def menu(): Unit = {
    println("Welcome to Rock Paper Scissors!")
    println("r or rock for Rock, p or paper for Paper, s or scissors for Scissors")
    println("NOTE: If you specify and incorrect input, your move will default to scissors!")
    println("Pick a game Mode")
    println("1. Player vs Ai")
    println("2. Player vs Player")
    println("3. Ai vs Ai")
    val gameMode =  scala.io.StdIn.readLine()

    gameMode match {
      case "1" => declarePlayers("1")
      case "2" => declarePlayers("2")
      case _ => declarePlayers("3")
    }
  }

  def declarePlayers(x: String): Unit = {
    if (x.equals("1")) {
      player1 = new Human("Human")
      println("Which Ai to face? 1. Random Ai 2. Slightly Better Ai")
      val gameMode =  scala.io.StdIn.readLine()
      if (gameMode.equals("1")) player2 = new AI("Guesser") else player2 = new AISmarter("Robocop")
    } else if (x.equals("2")) {
      player1 = new Human("Human")
      player2 = new Human("Human2")
    } else {
      player1 = new AI("Robocop")
      player2 = new AISmarter("SMARTER")
    }

  }

  def checkWinner(p1: Player, p2: Player): Unit =
    (p1.currentMove, p2.currentMove) match {
      case (x, y) if x == y => println("Tie!")
      case (Move.ROCK, Move.PAPER) => updateWinner(p2)
      case (Move.ROCK, Move.SCISSORS) => updateWinner(p1)
      case (Move.PAPER, Move.ROCK) => updateWinner(p1)
      case (Move.PAPER, Move.SCISSORS) => updateWinner(p2)
      case (Move.SCISSORS, Move.ROCK) => updateWinner(p2)
      case (Move.SCISSORS, Move.PAPER) => updateWinner(p1)
  }

  def updateWinner(winner: Player): Unit = {
    winner.score += 1
    println(winner.name + " won!")
  }

  def displayScores(): Unit = {
    println(player1.name + ": " + player1.score)
    println(player2.name + ": " + player2.score)
  }

  def theEnd(): Unit = {
    if (player1.score > player2.score)
      println(player1.name + " Congratulations! You Win!!")
    else if (player1.score < player2.score)
      println(player2.name + " Congratulations! You Win!!")

    println("Game Over!")
  }

}
