fun main() {
    fun part1(input: List<String>): Int {
        return 1
    }

    fun part2(input: List<String>): Int {
        return 1
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    checkEqual(part1(testInput), 1)
    checkEqual(part2(testInput), 2)

    val input = readInput("Day05")
    "Part 1:".println()
    part1(input).println()
    "Part 2:".println()
    part2(input).println()
}
