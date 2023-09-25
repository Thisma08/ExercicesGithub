package books

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

import Historic
import Book

internal class HistoricTest {
    @Test
    fun testPush_tryPushFinishedBook_doNothing() {
        val historic = Historic()
        val book = Book("Test", "Test", 10, 10)

        assertThrows<IllegalArgumentException> { historic.push(book) }
    }

    @Test
    fun testPop_tryPopEmptyHistoric_returnNull() {
        val historic = Historic()

        assertNull(historic.pop())
    }

    @Test
    fun testPop_historicWithOneBook_returnTheBook() {
        val book = Book("Test", "Test", 10, 5)
        val historic = Historic().apply { push(book) }

        val actual = historic.pop()

        assertEquals(book, actual)
    }

    @Test
    fun testFindMostReadBooks_historicIsEmpty_returnEmptyArray() {
        val historic = Historic()

        val actual = historic.findMostReadBooks()

        assertEquals(0, actual.size)
    }

    @Test
    fun testFindMostReadBooks_historicContainsOneTopRead_returnTheBookInArray() {
        val historic = Historic().apply {
            push(Book("Test", "Author", 100, 10))
            push(Book("Other", "Author2", 100, 10))
            push(Book("Test", "Author", 100, 10))
        }

        val expected = arrayOf(Book("Test", "Author", 100, 10))
        val actual = historic.findMostReadBooks()

        assertArrayEquals(expected, actual)
    }

    @Test
    fun testFindMostReadBooks_historicContainsTwoTopRead_returnTwoBooksInArray() {
        val historic = Historic().apply {
            push(Book("Test", "Author", 100, 10))
            push(Book("Other", "Author2", 100, 10))
            push(Book("Test", "Author", 100, 10))
            push(Book("Other", "Author2", 100, 10))
            push(Book("Third book", "Author2", 100, 10))
        }

        val expected = arrayOf(
            Book("Test", "Author", 100, 10),
            Book("Other", "Author2", 100, 10)
        )

        val actual = historic.findMostReadBooks()

        assertArrayEquals(expected, actual)
    }

    @Test
    fun testComputeBooksFrequency_withDifferentBooks_returnCorrectFrequencies() {
        val historic = Historic().apply {
            push(Book("Test", "Author", 100, 10))
            push(Book("Other", "Author2", 100, 10))
            push(Book("Test", "Author", 100, 10))
            push(Book("Other", "Author2", 100, 10))
            push(Book("Third book", "Author2", 100, 10))
        }

        val expected = mapOf(
            Book("Test", "Author", 100, 10) to 2,
            Book("Other", "Author2", 100, 10) to 2,
            Book("Third book", "Author2", 100, 10) to 1
        )

        val actual = historic.computeBooksFrequency()

        assertEquals(expected, actual)
    }
}