fun main() {
    val calculate = Calculate()
    try {
        calculate.calculateAndPrintExpression(3, 4, 6, 10)
    } catch (exception: Exception) {
        println("Something went wrong: ${exception.message}")
    }
}