fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    checkEqual(part1(testInput), 1)
    //checkEqual(part2(testInput), 1)

    val input = readInput("Day03")
    "Part 1:".println()
    part1(input).println()
    "Part 2:".println()
    part2(input).println()
}
