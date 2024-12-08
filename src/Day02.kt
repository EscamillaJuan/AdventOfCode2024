import kotlin.math.absoluteValue

fun main() {

    fun isSafe(report: List<Int>): Boolean {
        var isAscending = true
        var isDescending = true
        var isSafe = true
        var isLevelRemoved = false

        for (i in 0..<report.lastIndex) {
            if (report[i] > report[i + 1]) isAscending = false
            if (report[i] < report[i + 1]) isDescending = false
            isSafe = isSafe && (report[i] - report[i + 1]).absoluteValue in 1..3
        }

        return isSafe && (isDescending || isAscending)
    }

    fun part1(input: List<String>): Int {
        var result = 0
        for (line in input) {
            val report = line.split("\\s".toRegex()).map { it.toInt() }
            if (isSafe(report)) result++
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0
        for (line in input) {
            var isSafe = false
            val report = line.split("\\s".toRegex()).map { it.toInt() }
            for (i in 0..report.lastIndex) {
                isSafe = isSafe(report.toMutableList().apply { removeAt(i) })
                if (isSafe) break
            }
            if (isSafe) result++
        }
        return result
    }


    val input = readInput("day02")
    part1(input).println()
    part2(input).println()
}
