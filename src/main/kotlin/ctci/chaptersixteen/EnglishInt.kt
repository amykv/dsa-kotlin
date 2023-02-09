package ctci.chaptersixteen

// 16.8 - page 182
// Given any integer, print an English phrase that describes the integer (e.g., "One Thousand, Two Hundred
// Thirty Four").

fun main() {
    val num = 123456
    println(numberToWords(num))
}

fun numberToWords(num: Int): String {
    if (num == 0) return "Zero"
    val words = arrayOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
        "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty")
    val tens = arrayOf("", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
    var n = num
    var result = ""
    if (n >= 1000000000) {
        result += numberToWords(n / 1000000000) + " Billion "
        n %= 1000000000
    }
    if (n >= 1000000) {
        result += numberToWords(n / 1000000) + " Million "
        n %= 1000000
    }
    if (n >= 1000) {
        result += numberToWords(n / 1000) + " Thousand "
        n %= 1000
    }
    if (n >= 100) {
        result += numberToWords(n / 100) + " Hundred "
        n %= 100
    }
    if (n >= 20) {
        result += tens[n / 10] + " "
        n %= 10
    }
    result += words[n]
    return result.trim()
}

//The space complexity of this algorithm is O(1), since we're using constant additional memory. The time complexity
// is O(log n), where n is the size of the input number.
