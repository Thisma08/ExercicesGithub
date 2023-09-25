package books

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import Collection
import Book

internal class CollectionTest {
    @Test
    fun testComputeProgressionPercentage_twoBooks_returnCorrectPercentageIncomplete() {
        val collection = Collection().apply {
            add(Book("test", "test", 10, 10))
            add(Book("test 2", "test", 10, 5))
        }

        val expected = 0.75
        val actual = collection.computeProgressionPercentage()

        assertEquals(expected, actual)
    }

    @Test
    fun testComputeProgressionPercentage_twoBooks_returnCorrectPercentageComplete() {
        val collection = Collection().apply {
            add(Book("test", "test", 10, 10))
            add(Book("test 2", "test", 10, 10))
        }

        val expected = 1.0
        val actual = collection.computeProgressionPercentage()

        assertEquals(expected, actual)
    }

    @Test
    fun testComputeProgressionPercentage_twoBooks_returnCorrectPercentageNotStarted() {
        val collection = Collection().apply {
            add(Book("test", "test", 10, 0))
            add(Book("test 2", "test", 10, 0))
        }

        val expected = .0
        val actual = collection.computeProgressionPercentage()

        assertEquals(expected, actual)
    }

    @Test
    fun testBooksOf_withTwoAuthors_returnBooksFromOneAuthor() {
        val collection = Collection().apply {
            add(Book("Test", "Author1", 100, 100))
            add(Book("Test", "Author2", 100, 100))
            add(Book("Test 2", "Author1", 100, 100))
        }

        val expected = listOf(
            Book("Test", "Author1", 100, 100),
            Book("Test 2", "Author1", 100, 100)
        )

        val actual = collection.booksOf("Author1")

        assertEquals(expected, actual)
    }
}