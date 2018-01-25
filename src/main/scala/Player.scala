abstract class Player(val name: String){

  name
  var score = 0
  var currentMove: Move.Value = _

  def makeMove(): Move.Value

}
