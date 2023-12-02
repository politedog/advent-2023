fun main() {
    data class GameSet(val red: Int, val blue: Int, val green: Int)
    data class Game(val index: Int, val sets: List<GameSet>) {
        fun valid(): Boolean {
            return !sets.any {
                it.red >12 || it.green > 13 || it.blue > 14
            }
        }
        fun power(): Int {
            return sets.maxOf {it.red} * sets.maxOf {it.blue} * sets.maxOf {it.green}
        }
    }

    fun getGames(input: List<String>): List<Game> {
        val games = input.map {
            val index = it.split(":")[0].split(" ")[1].toInt()
            val sets = it.split(":")[1].split(";").map {
                val counts = it.split(",").map {
                    Pair(it.split(" ")[1].toIntOrNull(), it.split(" ")[2])
                }
                GameSet((counts.firstOrNull {it.second == "red"})?.first?:0,
                    counts.firstOrNull {it.second == "blue"}?.first?:0,
                    counts.firstOrNull {it.second == "green"}?.first?:0 )
            }
            Game(index, sets)
        }
        return games
    }

    fun part1(input: List<String>): Int {
        return getGames(input).sumOf { if (it.valid()) it.index else 0}
    }

    fun part2(input: List<String>): Int {

        return getGames(input).sumOf { it.power() }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    checkEqual(part1(testInput), 8)
    checkEqual(part2(testInput), 2286)

    val input = readInput("Day02")
    "Part 1:".println()
    part1(input).println()
    "Part 2:".println()
    part2(input).println()
}
