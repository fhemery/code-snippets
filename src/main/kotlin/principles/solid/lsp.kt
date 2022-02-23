package principles.solid

interface Collection<T> {
    fun add(item: T)
    fun get(index: Int): T
    fun getList(): List<T>
}

class OptimizedList<T>: Collection<T> {
    private val internalList = mutableListOf<T>()

    override fun add(item: T) {
        internalList.add(item)
    }

    override fun get(index: Int) : T {
        return internalList.get(index)
    }

    override fun getList(): List<T> {
        return internalList.toList()
    }
}

class OptimizedReadOnlyList<T>(private val lst: List<T>): Collection<T> {

    override fun add(item: T) {
        throw NotImplementedError()
    }

    override fun get(index: Int): T {
        return lst.get(index)
    }

    override fun getList(): List<T> {
        return lst
    }

}