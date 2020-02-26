package string_incrementer

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/*
Your job is to write a function which increments a string, to create a new string.

If the string already ends with a number, the number should be incremented by 1.
If the string does not end with a number. the number 1 should be appended to the new string.
*/

/**
 * Increment the numeric value in a string
 */
fun incrementString(str: String): String {
    val string = str.filter { !it.isDigit() }
    if (string.length == str.length) return string + 1

    val digits = str.filter { it.isDigit() }
    return String.format("%s%0${digits.count()}d", string, digits.toInt() + 1)
}

/**
 * Real cool increment String approach seen.
 * Note: this solution was provided by the user 'FanSin'
 */
fun coolIncrementString(str: String): String {
    val i = str.takeLastWhile { it.isDigit() }
    return str.dropLast(i.length) + ((i.toIntOrNull() ?: 0) + 1).toString().padStart(i.length, '0')
}

/**
 * The unit tests implementation
 */
internal class StringIncrementerTest {
    @Test
    fun incrementStringTests() {
        assertEquals(incrementString("foobar000"), "foobar001")
        assertEquals(incrementString("foobar999"), "foobar1000")
        assertEquals(incrementString("foobar00999"), "foobar01000")
        assertEquals(incrementString("foo"), "foo1")
        assertEquals(incrementString("foobar001"), "foobar002")
        assertEquals(incrementString("foobar1"), "foobar2")
        assertEquals(incrementString("1"), "2")
        assertEquals(incrementString(""), "1")
        assertEquals(incrementString("009"), "010")
    }

    @Test
    fun coolIncrementStringTests() {
        assertEquals(coolIncrementString("foobar000"), "foobar001")
        assertEquals(coolIncrementString("foobar999"), "foobar1000")
        assertEquals(coolIncrementString("foobar00999"), "foobar01000")
        assertEquals(coolIncrementString("foo"), "foo1")
        assertEquals(coolIncrementString("foobar001"), "foobar002")
        assertEquals(coolIncrementString("foobar1"), "foobar2")
        assertEquals(coolIncrementString("1"), "2")
        assertEquals(coolIncrementString(""), "1")
        assertEquals(coolIncrementString("009"), "010")
    }
}
