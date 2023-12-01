fun main() {
    fun lineSum(input: List<String>): Int {
        return input.sumOf {line ->
            (line.first { char -> char.isDigit() }.digitToInt()*10 + line.last { char -> char.isDigit() }.digitToInt())
        }
    }

    fun part1(input: List<String>): Int {
        return lineSum(input)
    }

    val numbersFirst = mapOf(
        Pair("one", "o1e"),
        Pair("two", "t2o"),
        Pair("three", "t3e"),
        Pair("four", "f4r"),
        Pair("five", "f5e"),
        Pair("six", "s6x"),
        Pair("seven", "s7n"),
        Pair("eight", "e8t"),
        Pair("nine", "n9e"),
    )

    fun part2(input: List<String>): Int {
        return lineSum(input.map {line ->
            var replaced = line
            numbersFirst.keys.forEach {num ->
                replaced = replaced.replace(num, numbersFirst[num].orEmpty())
            }
            replaced
        })
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    checkEqual(part1(testInput), 142)

    val input = readInput("Day01")
    part1(input).println()

    val testInput2 = readInput("Day01_test2")
    checkEqual(part2(testInput2), 385)
    part2(input).println()
}
