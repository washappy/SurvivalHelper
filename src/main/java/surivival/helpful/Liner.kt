package surivival.helpful

object Liner {
    fun addLine(string: String) : String {
        return ("-"*string.length + "\n" + string + "\n" + "-"*string.length)
    }
}

private operator fun String.times(number: Int): String {
    var ret = ""

    for (i in 1..number) {
        ret += this
    }
    return ret
}
