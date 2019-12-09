//val min = 134_564
//val max = 585_159

val min = 134_564
val max = 585_159

var possiblePasswords = HashSet<Int>()
for (i in min..max) {
    println("testing $i")
    if (isPossiblePassword(i)) {
        println("success! valid number")
        possiblePasswords.add(i)
    }
}

println("possible passwords/total combinations: ${possiblePasswords.size}/${max-min + 1}")

fun isPossiblePassword(num: Int): Boolean {
    // must be a 6 digit number
    println("validating the number has 6 digits")
    if ((99_999 > num) or (num > 1_000_000)) {
        println("the number is not 6 digits")
        return false
    }

    // validate that there are two adjacent same digits
    println("validating for two adjacent digits")
    // 122345 / 1 * 100000
    var previous = 0
    var adjacent = false
    for (i in 5 downTo 0) {
        val divisor = (Math.pow(10.toDouble(), i.toDouble())).toInt()
        val digit = ((num / divisor) % 10).toInt()
        // adjacent numbers!
        if (previous == digit) {
            println("two in a row! $previous -> $digit")
            adjacent = true
            break
        }
        previous = digit
    }

    if (!adjacent) {
       return false
    }

    // validate the digits do not decrease
    println("validating for no decreases")
    previous = 0
    for (i in 5 downTo 0) {
        val divisor = (Math.pow(10.toDouble(), i.toDouble())).toInt()
        val digit = ((num / divisor) % 10).toInt()
        if (previous > digit) {
            println("the digit decreases")
            return false
        }
        previous = digit
    }

    return true
}