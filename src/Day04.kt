import org.w3c.dom.css.Rect
import java.awt.Point
import java.awt.Rectangle

fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf {
            val winning = it.split(":")[1].split("|")[0].trim().split(" ").map {it.toIntOrNull()}.filterNotNull()
            val numbers = it.split("|")[1].trim().split(" ").map {it.toIntOrNull()}.filterNotNull()
            val matches = numbers.count {winning.contains(it)}
            val score = if (matches == 0) 0 else 1 shl (matches-1)
            "$numbers match $matches out of $winning for $score points".println()
            score
        }
    }

    data class Card(val matches:Int, var count: Int=1)

    fun part2(input: List<String>): Int {
        val matches = input.map {
            val winning = it.split(":")[1].split("|")[0].trim().split(" ").map { it.toIntOrNull() }.filterNotNull()
            val numbers = it.split("|")[1].trim().split(" ").map { it.toIntOrNull() }.filterNotNull()
            Card(numbers.count { winning.contains(it) })
        }
        matches.forEachIndexed { index, card ->
            var target = index + card.matches
            while (target > index) {
                matches[target].count+=card.count
                target--
            }
        }
        return matches.sumOf {it.count}
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    checkEqual(part1(testInput), 13)
    checkEqual(part2(testInput), 30)

    val input = readInput("Day04")
    "Part 1:".println()
    part1(input).println()
    "Part 2:".println()
    part2(input).println()
}
