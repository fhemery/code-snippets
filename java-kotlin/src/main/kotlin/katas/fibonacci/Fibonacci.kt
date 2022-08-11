package katas.fibonacci

class Fibonacci {

    private val alreadyComputedValues = HashMap<Int, Int>()

    fun getValue(n: Int): Int {
        if (n < 2)
            return 1

        return getLinearly(n)
        // return checkIfExists(n-1) + checkIfExists(n-2)
    }

    private fun getLinearly(n: Int): Int {
        var nMinus2 = 1
        var nMinus1 = 1
        var tmp: Int

        for (i in 2..n) {
            tmp = nMinus2 + nMinus1
            nMinus2 = nMinus1
            nMinus1 = tmp
        }

        return nMinus1
    }

    private fun checkIfExists (n : Int): Int {
        if (alreadyComputedValues.containsKey(n)) {
            return alreadyComputedValues[n]!!
        }
        val valueForN = getValue(n)
        alreadyComputedValues[n] = valueForN
        return valueForN
    }

    /* 800 -> 799

    1 + 1
    1 + 2
    2 + 3
    3 + 5

     */

}