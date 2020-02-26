package strip_comments

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

fun stripComments(input: String, markers: CharArray): String {
    return input.replace("\\s*(${markers.map { "\\" + it }.joinToString("|")}).*".toRegex(), "")
}

fun coolSolution(input: String, markers: CharArray): String {
    return input.split("\n").joinToString("\n") {
        it.takeWhile { char -> !markers.contains(char) }.trim()
    }.trim()
}

class TestExample {
    @Test
    fun testFixed() {
        assertEquals(
            "apples, plums\npears\noranges",
            stripComments("apples, plums % and bananas\npears\noranges !applesauce", charArrayOf('%', '!'))
        )
        assertEquals("Q\nu\ne", stripComments("Q @b\nu\ne -e f g", charArrayOf('@', '-')))
        assertEquals(
            "bananas tangerine apples\n" +
                    "kiwi bananas apples", stripComments(
                "bananas tangerine apples\n" +
                        "kiwi bananas apples", charArrayOf('$')
            )
        )

        assertEquals(
            "quince kiwi avocado bananas\n" +
                    "apples avocado kiwi", stripComments(
                "quince kiwi avocado bananas # bananas bananas\n" +
                        "apples avocado kiwi $ pears apples", charArrayOf('#', '$')
            )
        )

        assertEquals(
            "quince pears\n" +
                    "kiwi apples\n" +
                    "kiwi kiwi grapes apples\n" +
                    "quince quince avocado pears", stripComments(
                "quince pears ! quince kiwi\n" +
                        "kiwi apples $ grapes avocado bananas\n" +
                        "kiwi kiwi grapes apples\n" +
                        "quince quince avocado pears", charArrayOf('$', '!')
            )
        )
    }
}