class Collection {
    // Doublons non autorisés => SET
    private var booksSet = HashSet<Book>()
    private var searchSet = HashSet<Book>()
    private var totPages: Double = 0.0
    private var totRead: Double = 0.0

    fun add(bookToAdd: Book): Boolean {
        if(!booksSet.contains(bookToAdd)) {
            return booksSet.add(bookToAdd)
        }
        return false
    }

    fun size() : Int {
        return booksSet.size
    }

    fun remove(bookToRemove : Book) : Unit {
        for(b in booksSet) {
            if (b.hashCode() == bookToRemove.hashCode()) booksSet.remove(bookToRemove)
        }
    }

    fun computeProgressionPercentage() : Double {
        for (b in booksSet) {
            totPages += b.getPages()
            totRead += b.getReadPages()

        }
        return totRead/totPages
    }

    fun booksOf(authorToFind : String) : HashSet<Book> {
        for (b in booksSet) {
            if(b.getAuthor() == authorToFind) {
                searchSet.add(b)
            }
        }
        return searchSet
    }
}