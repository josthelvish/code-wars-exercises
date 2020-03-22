package sum_up_to_zero

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * ------------------------------------------
 * Find N Unique Integers Sum up to Zero
 * ------------------------------------------
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 * Example 1:
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 *
 * Example 2:
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 * Input: n = 1
 * Output: [0]
 *
 * Constraints:
 * 1 <= n <= 1000
 * */

const val DEBUG_FLAG = true

fun sumZero(n: Int): IntArray {
    val result = IntArray(n)
    var initialPosition = 0
    var shouldBePositive = true

    if (n.rem(2) != 0) {
        result[initialPosition] = 0
        initialPosition++
    }
    var value = 1
    for (i in initialPosition until n) {
        if (shouldBePositive) {
            result[i] = value
            shouldBePositive = false
        } else {
            result[i] = value * -1
            shouldBePositive = true
            value++
        }
    }
    if (DEBUG_FLAG) {
        println(result.asList())
    }
    return result
}

fun coolSumZero(n: Int): IntArray {
    val arr = IntArray(n)
    var i = 0
    var count = 1
    if (n == 1) {
        arr[i] = 0
    } else {
        repeat(n / 2) {
            arr[i] = count
            i++
            arr[i] = count * -1
            count++
            i++
        }
        if (n % 2 == 1) {
            arr[i] = 0
        }
    }
    return arr
}

class FindUniqueTest {
    @Test
    fun test1() {
        testing(sumZero(3).sum(), 0)
        testing(sumZero(5).sum(), 0)
        testing(sumZero(7).sum(), 0)
        testing(sumZero(2).sum(), 0)
        testing(sumZero(4).sum(), 0)
        testing(sumZero(6).sum(), 0)
    }

    companion object {
        private fun testing(actual: Int, expected: Int) {
            assertEquals(expected, actual)
        }
    }
}
