package exercises.pyramidgenerator

//Given a positive integer n implement a function which returns a list representing the generatePyramid shape with n
//levels. The function should console log a generatePyramid shape with N levels using the # character. Make sure the
//generatePyramid has spaces on both the left and right hand sides.
//
//Examples
//
//pyramid(1)
//'#'
//
//pyramid(2)
//' # '
//'###'
//
//pyramid(3)
//'  #  '
//' ### '
//'#####'

fun main(){
    val myNum = 3

    val myPyramid = generatePyramid(myNum)
    print(myPyramid)
}

private fun generatePyramid(n: Int): MutableList<String> {
    val list = mutableListOf<String>()
    val maxRowLen = n * 2 - 1

    for (i in 1..n) {
        val rowLen = i * 2 - 1

        val sideString = " ".repeat((maxRowLen - rowLen) / 2)
        val hashString = "#".repeat(rowLen)

        list.add("$sideString$hashString$sideString")
    }
    return list
}