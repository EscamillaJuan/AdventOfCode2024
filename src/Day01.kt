import kotlin.math.absoluteValue


fun main() {
    fun part1(input: List<String>): Int {
        val left = arrayListOf<Int>()
        val right = arrayListOf<Int>()
        var res = 0
        input.map { line ->
            val values = line.split("\\s{3}".toRegex())
            left.add(values[0].toInt())
            right.add(values[1].toInt())
        }
        left.sort()
        right.sort()
        left.zip(right).map { pair ->
            res += (pair.first - pair.second).absoluteValue
        }
        return res
    }

    fun part2(input: List<String>): Int {
        val left = arrayListOf<Int>()
        val right = arrayListOf<Int>()
        var res = 0
        input.map { line ->
            val values = line.split("\\s{3}".toRegex())
            left.add(values[0].toInt())
            right.add(values[1].toInt())
        }
        left.map{ location ->
            val count = right.count{ it == location }
            res += location * count
        }

        return res
    }

    val input = readInput("day01")
    part1(input).println()
    part2(input).println()
}
