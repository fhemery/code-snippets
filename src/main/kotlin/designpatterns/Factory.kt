enum class PizzaType {
    Margarita, FourCheese, Roma
}

enum class Ingredient {
    TomatoSauce, Cream, Mozzarella, Camembert, BlueCheese, GoatCheese, Mushrooms, Ham
}

abstract class Pizza (val ingredients: List<Ingredient>) {
    companion object {
        fun makePizza(type: PizzaType) {
            when(type) {
                PizzaType.FourCheese -> FourCheesePizza()
                PizzaType.Margarita -> MargaritaPizza()
                PizzaType.Roma -> RomaPizza()
            }
        }
    }

    abstract fun rate(): String
}

class MargaritaPizza() : Pizza(listOf(Ingredient.TomatoSauce, Ingredient.Mozzarella)) {
    override fun rate(): String {
        return "Simple, yet so efficient"
    }
}

class FourCheesePizza() : Pizza(listOf(Ingredient.Cream, Ingredient.Mozzarella, Ingredient.Camembert, Ingredient.BlueCheese)) {
    override fun rate(): String {
        return "More cheese, please!"
    }
}

class RomaPizza() : Pizza(listOf(Ingredient.TomatoSauce, Ingredient.Mozzarella, Ingredient.Ham, Ingredient.Mushrooms)) {
    override fun rate(): String {
        return "Mushroom and Ham <3"
    }
}