package ctci.chapterseven

// 7.3 - page127
// Design a musical jukebox in Kotlin using object-oriented principles.

fun main() {
    val jukebox = Jukebox()
    jukebox.addSong(Song("song1", "artist1"))
    jukebox.addSong(Song("song2", "artist2"))
    jukebox.addSong(Song("song3", "artist3"))
    jukebox.play()
    jukebox.next()
    jukebox.next()
    jukebox.previous()
    jukebox.stop()
}

//The Jukebox class has a list of Song objects, a current song, and a flag to keep track of whether the jukebox is
// currently playing a song. The Jukebox class has methods to add songs to the list, play and stop the current song,
// and skip to the next or previous song.

//The Song class has a title and an artist, and it's toString method format the song in the following
// format "$title by $artist"
class Jukebox {
    private var songs: List<Song> = listOf()
    private var currentSong: Song? = null
    private var isPlaying: Boolean = false

    fun addSong(song: Song) {
        songs += song // can also use songs = songs + song
    }


    fun play() {
        if (songs.isEmpty()) {
            println("No songs in the jukebox.")
            return
        }

        if (currentSong == null) {
            currentSong = songs[0]
        }

        println("Playing song: $currentSong")
        isPlaying = true
    }

    fun stop() {
        if (isPlaying) {
            println("Stopping song: $currentSong")
            isPlaying = false
        }
    }

    fun next() {
        if (isPlaying) {
            val currentIndex = songs.indexOf(currentSong)
            if (currentIndex + 1 < songs.size) {
                currentSong = songs[currentIndex + 1]
                println("Playing next song: $currentSong")
            } else {
                println("No more songs.")
                stop()
            }
        }
    }

    fun previous() {
        if (isPlaying) {
            val currentIndex = songs.indexOf(currentSong)
            if (currentIndex > 0) {
                currentSong = songs[currentIndex - 1]
                println("Playing previous song: $currentSong")
            } else {
                println("No previous songs.")
            }
        }
    }
}

class Song(val title: String, val artist: String) {
    override fun toString(): String {
        return "$title by $artist"
    }
}
