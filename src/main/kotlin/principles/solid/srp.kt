package principles.solid

class BooksManager {

    fun addBook(book: Book) {}

    fun getBook(id: String): Book? {
        TODO()
    }

    fun removeBook(id: String) {}

    fun updateBook(book: Book) {}

    fun printBook(book: Book) {}

    fun getBookPrices(books: List<Book>) {}

    fun recycleBook(book: Book) {}

}

data class Book(val id: String, val title: String)
