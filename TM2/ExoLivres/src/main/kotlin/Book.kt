class Book(private val name: String, private val author:String, private val pages: Int, private val readPages: Int) {
    constructor(name: String, author: String, pages: Int) : this(name, author, pages,0) {
    }

    fun getName() : String {
        return this.name
    }

    fun getAuthor(): String {
        return this.name
    }

    fun getPages() : Int {
        return this.pages
    }

    fun getReadPages() : Int {
        return this.readPages
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (name != other.name) return false
        if (author != other.author) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + pages
        return result
    }
}