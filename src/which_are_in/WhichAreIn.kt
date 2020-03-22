package which_are_in

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are
 * substrings of strings of a2.
 * #Example 1: a1 = ["arp", "live", "strong"]
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 * returns ["arp", "live", "strong"]
 *
 * #Example 2: a1 = ["tarp", "mice", "bull"]
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 * returns []
 *
 * Notes:
 * Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.
 * In Shell bash a1 and a2 are strings. The return is a string where words are separated by commas.
 * Beware: r must be without duplicates.
 * Don't mutate the inputs.
 * */


fun inArray(array1: Array<String>, array2: Array<String>): Array<String> {
    return array1.distinct().sorted().filter {
        it in array2.toList().toString()
    }.toTypedArray()
}

class TestExample {

    private lateinit var timeSpent: TimeSpent

    @BeforeEach
    internal fun setUp() {
        timeSpent = TimeSpent()
    }

    @AfterEach
    internal fun tearDown() {
        timeSpent.finish()
    }

    @Test
    fun testFixed() {
        val a2 = arrayOf<String>("lively", "alive", "harp", "sharp", "armstrong")
        assertArrayEquals(arrayOf<String>("live", "strong"), inArray(arrayOf<String>("xyz", "live", "strong"), a2))
        assertArrayEquals(
            arrayOf<String>("arp", "live", "strong"),
            inArray(arrayOf<String>("live", "strong", "arp"), a2)
        )
        assertArrayEquals(arrayOf<String>(), inArray(arrayOf<String>("tarp", "mice", "bull"), a2))
    }

    private class TimeSpent(val start:Long = System.currentTimeMillis()){
        fun finish() {
            println("Time spent : ${System.currentTimeMillis() - start}ms")
        }
    }
}

