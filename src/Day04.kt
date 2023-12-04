import org.w3c.dom.css.Rect
import java.awt.Point
import java.awt.Rectangle

fun main() {
    fun part1(input: List<String>): Int {
        return 1
    }

    fun part2(input: List<String>): Int {
        return 1
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    checkEqual(part1(testInput), 1)
    checkEqual(part2(testInput), 2)

    val input = readInput("Day04")
    "Part 1:".println()
    part1(input).println()
    "Part 2:".println()
    part2(input).println()
}
