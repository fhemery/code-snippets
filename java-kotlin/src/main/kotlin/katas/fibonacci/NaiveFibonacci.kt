package katas.fibonacci

class NaiveFibonacci {
    fun compute(n:Int): Int {
        if (n < 2)
            return 1
        return compute(n-2) + compute(n-1)
    }
}