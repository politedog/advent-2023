import org.w3c.dom.css.Rect
import java.awt.Point
import java.awt.Rectangle

fun main() {
    fun findSymbols(input: List<String>, starOnly: Boolean = false): List<Point> {
        val symbols = input.flatMapIndexed { y, s ->
            s.mapIndexed { x, c ->
                if ((c=='*') || (!starOnly && !c.isDigit() && c!='.')) {
                    Point(x, y)
                } else {
                    null
                }
            }.filterNotNull()
        }
        return symbols
    }

    fun findParts(input: List<String>): List<Pair<String, Rectangle>> {
        var acc = ""
        var accx = -1
        var accy = -1
        val parts = input.flatMapIndexed { y, s ->
            s.mapIndexed { x, c ->
                var part: Pair<String, Rectangle>? = null
                if (c.isDigit()) {
                    acc = acc + c
                    accx = x
                    accy = y
                } else {
                    if (accx>=0 && accy>=0) {
                        part = Pair(acc, Rectangle(accx-acc.length, accy-1, acc.length+2, 3))
                        acc = ""
                        accx = -1
                        accy = -1
                    }
                }
                part
            }
        }
        return parts.filterNotNull()
    }

    fun part1(input: List<String>): Int {
        val symbols = findSymbols(input)
        val parts = findParts(input)
        var total = 0
        parts.forEach { part ->
            if (symbols.any {symbol ->
                    part.second.contains(symbol)
                }) {
                total += part.first.toInt().also { it.println() }
            }
        }
        return total
    }

    fun part2(input: List<String>): Int {
        val symbols = findSymbols(input, true)
        val parts = findParts(input)
        var total = 0
        symbols.forEach {symbol ->
            val adjacent = parts.filter {part ->
                part.second.contains(symbol)
            }
            if (adjacent.size == 2) {
                total += adjacent[0].first.toInt() * adjacent[1].first.toInt()
            }
        }
        return total
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    checkEqual(part1(testInput), 4361)
    checkEqual(part2(testInput), 467835)

    val input = readInput("Day03")
    "Part 1:".println()
    part1(input).println()
    "Part 2:".println()
    part2(input).println()
}
