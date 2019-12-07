fun main(args: Array<String>) {
    
    // get all the instructions
    val input = "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,13,19,1,9,19,23,1,6,23,27,2,27,9,31,2,6,31,35,1,5,35,39,1,10,39,43,1,43,13,47,1,47,9,51,1,51,9,55,1,55,9,59,2,9,59,63,2,9,63,67,1,5,67,71,2,13,71,75,1,6,75,79,1,10,79,83,2,6,83,87,1,87,5,91,1,91,9,95,1,95,10,99,2,9,99,103,1,5,103,107,1,5,107,111,2,111,10,115,1,6,115,119,2,10,119,123,1,6,123,127,1,127,5,131,2,9,131,135,1,5,135,139,1,139,10,143,1,143,2,147,1,147,5,0,99,2,0,14,0"
//    val input = "1,9,10,3,2,3,11,0,99,30,40,50"
    val instructions = ArrayList<Int>()
    input.split(",").forEach { instructions.add(it.toInt()) }

    println("***********")
    println("Part 1")
    println("***********")
    part1(instructions)
    println()
    println("***********")
    println("Part 2")
    println("***********")
    part2(instructions)
}

fun part1(instructions: ArrayList<Int>) {
//    Once you have a working computer, the first step is to restore the gravity assist program (your puzzle input)
//    to the "1202 program alarm" state it had just before the last computer caught fire. To do this, before running
//    the program, replace position 1 with the value 12 and replace position 2 with the value 2. What value is left
//    at position 0 after the program halts?
    instructions.set(1, 12)
    instructions.set(2, 2)

    val result = runComputer(instructions)

    println("Position 0 Value: ${result.get(0)}")
}

fun part2(instructions: ArrayList<Int>) {
    var noun = 0
    var verb = 0
    val expectedResult = 19690720
    var found = false

    for (i in 0..100) {
        for (j in 0..100) {
            instructions.set(1, i)
            instructions.set(2, j)
            val result = runComputer(instructions)

//            println("Noun=$i Verb=$j -> ${result.get(0)}")

            if (expectedResult == result.get(0)) {
                noun = i
                verb = j
                println("found noun/verb combination to equal $expectedResult. noun=$noun verb=$verb")
                found = true
                break
            }
        }
        if (found) {
            break
        }
    }

    val result = 100 * noun + verb
    println("Result: $result")
}

fun runComputer(inputInstructions: ArrayList<Int>): List<Int> {

    // create clone of input so that we do not have to reset the input array
    val instructions = ArrayList<Int>()
    inputInstructions.forEach { instructions.add(it) }

    var programCounter = 0
    var keepTheDreamAlive = true
    while (keepTheDreamAlive and (programCounter < instructions.size)) {
        val instruction = instructions.get(programCounter)
//        println("processing instruction #${programCounter}: ${instruction}")

        when (instruction) {
            1 -> {
//                println("opcode 1 found. starting add instruction")

                val addressA = instructions.get(programCounter+1)
                val addressB = instructions.get(programCounter+2)
                val storeLocation = instructions.get(programCounter+3)

//                println("found instruction: ADD &$addressA &$addressB -> &$storeLocation")
                val aValue = instructions.get(addressA)
                val bValue = instructions.get(addressB)

//                println("resolved instruction: $aValue + $bValue")
                val result = aValue + bValue

//                println("got result $result. Storing in location $storeLocation")
                val previousValue = instructions.get(storeLocation)
                instructions.set(storeLocation, result)
                val newValue = instructions.get(storeLocation)
//                println("prev: $previousValue expected: $result actual: $newValue")

//                println("add instruction complete")
                programCounter += 4
            }
            2 -> {
//                println("opcode 2 found. starting multiply instruction")
                val addressA = instructions.get(programCounter+1)
                val addressB = instructions.get(programCounter+2)
                val storeLocation = instructions.get(programCounter+3)

//                println("found instruction: MULTIPLY &$addressA &$addressB -> &$storeLocation")
                val aValue = instructions.get(addressA)
                val bValue = instructions.get(addressB)

//                println("resolved instruction: $aValue * $bValue")
                val result = aValue * bValue

//                println("got result $result. Storing in location $storeLocation")
                val previousValue = instructions.get(storeLocation)
                instructions.set(storeLocation, result)
                val newValue = instructions.get(storeLocation)
//                println("prev: $previousValue expected: $result actual: $newValue")

//                println("multiply instruction complete")
                programCounter += 4
            }
            99 -> {
//                println("opcode 99 found. stopping processing")
                programCounter += 1
                keepTheDreamAlive = false
            }
        }
    }

    return instructions
}
