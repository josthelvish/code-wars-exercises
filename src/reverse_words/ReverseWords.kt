package reverse_words

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Complete the solution so that it reverses all of the words within the string passed in.
 *
 * Example:
 * reverseWords("The greatest victory is that which requires no battle")
 * // must return "battle no requires which that is victory greatest The"
 */
object Reverse {
    fun reverseWords(str: String): String = str.split(" ").reversed().joinToString(" ")
}

class TestExample {
    @Test
    fun sample() {
        assertEquals("eating like I", Reverse.reverseWords("I like eating"))
        assertEquals("flying like I", Reverse.reverseWords("I like flying"))
        assertEquals("nice is world The", Reverse.reverseWords("The world is nice"))
        assertEquals("it!! Split Just", Reverse.reverseWords("Just Split it!!"))
        assertEquals("!!! !! !", Reverse.reverseWords("! !! !!!"))
        assertEquals("7777 777 77 7", Reverse.reverseWords("7 77 777 7777"))
        assertEquals("D : Jpazzy", Reverse.reverseWords("Jpazzy : D"))
    }
}
