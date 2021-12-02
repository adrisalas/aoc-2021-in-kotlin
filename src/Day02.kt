enum class Direction {
    forward, down, up
}

class Command(val direction: Direction, val unit: Int) {}

fun main() {

    fun part1(commands: List<Command>): Int {
        var depth = 0
        var horizontal = 0
        for (command in commands) {
            when (command.direction) {
                Direction.forward -> horizontal += command.unit
                Direction.down -> depth += command.unit
                Direction.up -> depth = if (depth - command.unit > 0) (depth - command.unit) else (0)
            }
        }
        return depth * horizontal
    }

    fun part2(commands: List<Command>): Int {
        var depth = 0
        var horizontal = 0
        var aim = 0
        for (command in commands) {
            when (command.direction) {
                Direction.forward -> {
                    horizontal += command.unit
                    depth += command.unit * aim
                }
                Direction.down -> aim += command.unit
                Direction.up -> aim -= command.unit
            }
        }
        return depth * horizontal
    }

    val testCommands =
        readInput("Day02_test").map { s -> Command(Direction.valueOf(s.split(" ")[0]), s.split(" ")[1].toInt()) }
    check(part1(testCommands) == 150)
    check(part2(testCommands) == 900)

    val commands = readInput("Day02").map { s -> Command(Direction.valueOf(s.split(" ")[0]), s.split(" ")[1].toInt()) }
    println(part1(commands))
    println(part2(commands))
}