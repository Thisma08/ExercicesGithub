class Historic {
    private var historic = ArrayList<Book>()

    fun push(bookToPush: Book): Boolean {
        if(bookToPush.getPages() != bookToPush.getReadPages()) {
            return historic.add(bookToPush)
        }
        else {
            throw IllegalArgumentException()
        }
    }

    fun computeBooksFrequency(): Map<Book, Int> {

    }

    fun pop(): Book? {
        return if(historic.isNotEmpty()) {
            val lastBook: Book = historic.last()
            historic.remove(lastBook)
            lastBook
        } else {
            null
        }
    }

    override fun toString(): String {
        var result: String = ""
        var i: Int = 1
        for (book: Book in historic) {
            result += i.toString() + " - " + book.getName() + " - " + book.getAuthor()
            i += 1;
        }
        return result
    }
}