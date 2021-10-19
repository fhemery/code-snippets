package principles.compositionOverInheritance

abstract class ChessPiece() {
    abstract fun move()
}

open class Bishop: ChessPiece() {
    override fun move() {
        println("Diagonal move!")
    }
}

open class Rook: ChessPiece() {
    override fun move() {
        println("Row or Column move!")
    }
}

class Queen: Rook() /*, Bishop() */ {
    override fun move() {
        super.move()                    // Ok. Which one ?
    }
}