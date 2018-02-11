import scala.collection.mutable.ArrayBuffer

abstract class Player(val name: String){

  var score = 0
  var currentMove: Move.Value = _
  var moveList: ArrayBuffer[Move.Value] = ArrayBuffer()
  var getOppositionMoves: ArrayBuffer[Move.Value] = _ // = (arrayBuffer: ArrayBuffer[Move.Value]) => arrayBuffer


  def makeMove(move: Move.Value): Move.Value = {
    currentMove = move
    moveList.append(move)
    move
  }

  def genMove(): Move.Value

}
