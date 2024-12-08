
fun main() {

    fun part1(input: String): Int {
        val regex = Regex("mul\\(\\d{1,3},\\d{1,3}\\)")
        val finalRegex = Regex("\\d{1,3},\\d{1,3}")
        var res = 0
        val matches = regex.findAll(input)
        val tmp = matches.map { it.value }.joinToString(", ")
        val operations = finalRegex.findAll(tmp).map { it.value }.toList()
        for (operation in operations) {
            val values = operation.split(",")
            res += values[0].toInt() * values[1].toInt()
        }
        return res
    }

    fun part2(input: String): Int {
        val regex = """(do\(\)|don't\(\)|mul\(([0-9]{1,3}),([0-9]{1,3})\))""".toRegex()
        var enabled = true
        var res = 0
        regex.findAll(input).forEach { match ->
            val str = match.groups[0]!!.value
            if (str.startsWith("do(")) {
                enabled = true
            } else if (str.startsWith("don't(")) {
                enabled = false
            } else if (enabled) {
                check(str.startsWith("mul("))
                res += match.groups[2]!!.value.toInt() * match.groups[3]!!.value.toInt()
            }
        }
        return res
    }


    val input = readInputOneLine("day03")
    part1(input).println()
    part2(input).println()
}