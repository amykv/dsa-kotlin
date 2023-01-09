package ctci.chapterone

//1.7 - page 91
// Given an image represented by an N x N matrix, where each pixel in the image is represented by an integer, write a
// method in Kotlin to rotate the image by 90 degrees.

//Create a new matrix of the same size as the original matrix.
//Iterate through the original matrix, and for each element at position (i, j), set the element at position (j, N - 1 - i) in the new matrix to the same value.
//Return the new matrix.

fun main() {

    val matrix = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9)
    )

    val rotated = rotateMatrix(matrix)
    for (row in rotated) {
        println(row)
    }
}

//This function creates a new matrix of the same size as the original matrix, and then iterates through the original
// matrix setting the elements of the new matrix to the corresponding rotated elements.

fun rotateMatrix(matrix: List<List<Int>>): List<List<Int>> {
    val n = matrix.size
    val rotated = MutableList(n) { MutableList(n) { 0 } }
    for (i in 0 until n) {
        for (j in 0 until n) {
            rotated[j][n - 1 - i] = matrix[i][j]
        }
    }
    return rotated
}

//The time complexity of this function is O(n^2), where n is the size of the matrix, since the function iterates
// through each element in the matrix once. The space complexity is also O(n^2), since the function creates a new
// matrix of the same size as the original matrix.