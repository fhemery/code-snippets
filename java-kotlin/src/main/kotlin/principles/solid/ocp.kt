package principles.solid

interface Shape

class Rectangle(val width: Double, val height: Double): Shape {

}

class AreaCalculator {

    fun computeArea(shapes: List<Shape>): Double {
        var totalArea = 0.0

        for (shape in shapes) {
            totalArea += when(shape) {
                is Rectangle -> shape.width * shape.height
                else -> 0.0
            }
        }
        return totalArea
    }

}

fun main() {
    val calculator = AreaCalculator()
    println("With one rectangle : " + calculator.computeArea(listOf(Rectangle(2.0, 3.0))))
}