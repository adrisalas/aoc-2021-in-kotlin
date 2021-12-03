fun main() {

    class Counter(var ones: Int = 0, var zeros: Int = 0) {
        override fun toString(): String {
            return "Counter(ones=$ones, zeros=$zeros)"
        }
    }

    fun part1(input: List<String>): Int {
        val sizeOfInput = input[0].length
        val counter = MutableList(sizeOfInput) { Counter() }

        // When you split("") you get this list: [,0,0,1,0,0,] which has a leading and trailing empty thing ¿?
        // WEIRD STUFF KOTLIN
        input.forEach {
            it.split("")
                .subList(1, sizeOfInput + 1)
                .forEachIndexed { index, s ->
                    if (s == "0") {
                        counter[index].zeros++
                    } else {
                        counter[index].ones++
                    }
                }
        }
        val gamma = Integer.parseInt(
            counter.fold("") { s: String, c: Counter -> if (c.zeros > c.ones) s + "0" else s + "1" },
            2
        )
        val epsilon = Integer.parseInt(
            counter.fold("") { s: String, c: Counter -> if (c.zeros < c.ones) s + "0" else s + "1" },
            2
        )
        return gamma * epsilon
    }

    fun part2(input: List<String>): Int {

        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
