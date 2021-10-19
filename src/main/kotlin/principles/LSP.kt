package principles

open class Whatever()

open class Item(val name: String): Whatever()

open class Book(name: String, val author: String): Item(name)

open class ItemShelf (val nbRows: Int) {
    open fun get(title: String): Item { TODO() }

    open fun add(item: Item) {}
}

class BookShelf(nbRows: Int): ItemShelf(nbRows) {
    override fun get(title: String) : Book { TODO() }

    /*override fun add(book: Whatever) {

    }*/
}

fun main() {
    val shelf: ItemShelf = BookShelf(2)
    shelf.add(Item("Dvd"))                  // BOOM
}

fun main2() {
    val shelf: ItemShelf = BookShelf(2)
    shelf.get("Whatever").name                     // BOOM
}