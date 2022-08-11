package principles.solid

interface ReadableCollection<T>  {
    fun get(index: Int): T
    fun getList(): List<T>
}

interface WritableCollection<T> {
    fun add(item: T)
}

class UnoptimizedList<T>: ReadableCollection<T>, WritableCollection<T> {
    override fun get(index: Int): T {
        TODO("Not yet implemented")
    }

    override fun getList(): List<T> {
        TODO("Not yet implemented")
    }

    override fun add(item: T) {
        TODO("Not yet implemented")
    }

}

class ReadonlyUnoptimizedList<T> : ReadableCollection<T> {
    override fun get(index: Int): T {
        TODO("Not yet implemented")
    }

    override fun getList(): List<T> {
        TODO("Not yet implemented")
    }
}