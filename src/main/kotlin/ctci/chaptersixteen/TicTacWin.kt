package ctci.chaptersixteen

// 16.4 - page 181
// In Kotlin, design an algorithm to figure out if someone has won a game of tic-tac-toe.

//This implementation uses a two-dimensional board array to store the state of the game, and a makeMove method to
// place a player's symbol (either 'X' or 'O') on the board. The checkForWin method then checks if any player has
// won the game by examining the rows, columns, and diagonals of the board. If a player has won, the checkForWin
// method returns their symbol, otherwise it returns a space character.

fun main() {
    val game = TicTacToe()

    // Player X makes the first move
    game.makeMove('X', 0, 0)
    game.makeMove('O', 1, 1)
    game.makeMove('X', 0, 1)
    game.makeMove('O', 1, 2)
    game.makeMove('X', 0, 2)

    // Check for win
    val winner = game.checkForWin()
    if (winner != ' ') {
        println("Player $winner has won the game!")
    } else {
        println("The game is still ongoing.")
    }
}

class TicTacToe {
    private val board = Array(3) { CharArray(3) { ' ' } }

    fun makeMove(player: Char, row: Int, col: Int) {
        board[row][col] = player
    }

    fun checkForWin(): Char {
        // Check rows
        for (i in 0..2) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return board[i][0]
            }
        }

        // Check columns
        for (i in 0..2) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return board[0][i]
            }
        }

        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return board[0][0]
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != ' ') {
            return board[2][0]
        }

        return ' '
    }
}