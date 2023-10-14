import constants.ErrorMessages

class Calculate {
    fun calculateAndPrintExpression(a: Int, b: Int, n: Int, m: Int) {
        checkArguments(a, b, n, m)
        println("a = $a\nb = $b\nn = $n\nm = $m\nWhole expression = Sum[Sum[Divide[i+j,i-2],{j,$b,$m}],{i,$a,$n}]\n")
        var sum = 0.0
        val iRange = a.toChar()..n.toChar()
        val jRange = b.toChar()..m.toChar()
        for (i: Char in iRange) {
            val denominator = (i.code.toDouble() - 2)
            if (denominator == 0.0) {
                throw Exception(ErrorMessages.DENOMINATOR_EQUALS_ZERO.message)
            }
            for (j: Char in jRange) {
                val numerator = (i.code + j.code)
                sum += numerator / denominator
            }
        }
        println(sum)

    }

    private fun checkArguments(a: Int, b: Int, n: Int, m: Int) {
        if (a > n) {
            throw IllegalArgumentException(ErrorMessages.A_GREATER.message)
        }
        if (b > m) {
            throw IllegalArgumentException(ErrorMessages.B_GREATER.message)
        }
        if (b < 0) {
            throw IllegalArgumentException(ErrorMessages.B_LESS_THAN_ZERO.message)
        }
    }
}