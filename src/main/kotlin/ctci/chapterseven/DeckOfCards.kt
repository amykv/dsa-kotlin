package ctci.chapterseven

// 7.1 - page 127
// In Kotlin, design the data structures for a generic deck of cards. Explain how you would subclass the data
// structures to implement blackjack.

fun main() {
    val deck = BlackjackDeck(1)
    deck.shuffle()
    val card = deck.draw()
    if (card == null) {
        println("Deck is empty, cannot draw a card.")
    } else {
        println("Drawn card: $card")
        println("Value of card: ${deck.getValue(card)}")
    }
}

//The Card class has two properties, suit and value, which are enumerations representing the suit and value of the
// card. The enumerations are defined inside the Card class to keep them scoped to the Card class.
class Card(val suit: Suit, val value: Value) {
    enum class Suit {
        SPADES, HEARTS, DIAMONDS, CLUBS
    }

    enum class Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    override fun toString(): String {
        return "${value.name} of ${suit.name}"
    }

}

//The Deck class has a property, cards, which is a mutable list of Card objects. The init block initializes the deck
// with one of each card, and the shuffle method shuffles the cards in the deck. The draw method removes and returns
// the top card from the deck.
// open is so BlackjackDeck can use this class.
open class Deck {
    val cards = mutableListOf<Card>()

    init {
        for (suit in Card.Suit.values()) {
            for (value in Card.Value.values()) {
                cards.add(Card(suit, value))
            }
        }
    }

    fun shuffle() {
        cards.shuffle()
    }

    fun draw(): Card? {
        return if (cards.isNotEmpty()) cards.removeAt(0) else null
    }
}

//This class takes in a number of decks as a parameter, which is used to initialize the numberOfDecks property. The
// class also has a getValue function that can retrieve the numerical value of a card, depending on the card's value.

//In the init block, it calls the setter for numberOfDecks which clears the cards in the deck and rebuilds it with
// the number of decks specified.

//This class can be used in a Blackjack game to create, shuffle, draw and value cards according to the game rules,
// providing a more specific interface for blackjack game .
class BlackjackDeck(numberOfDecks: Int) : Deck() {
    var numberOfDecks: Int = numberOfDecks
        set(value) {
            field = value
            cards.clear()
            for (i in 1..numberOfDecks) {
                for (suit in Card.Suit.values()) {
                    for (value in Card.Value.values()) {
                        cards.add(Card(suit, value))
                    }
                }
            }
        }

    init {
        this.numberOfDecks = numberOfDecks
    }

    fun getValue(card: Card) : Int {
        return when(card.value) {
            Card.Value.ACE -> 11
            Card.Value.TWO -> 2
            Card.Value.THREE -> 3
            Card.Value.FOUR -> 4
            Card.Value.FIVE -> 5
            Card.Value.SIX -> 6
            Card.Value.SEVEN -> 7
            Card.Value.EIGHT -> 8
            Card.Value.NINE -> 9
            Card.Value.TEN, Card.Value.JACK, Card.Value.QUEEN, Card.Value.KING -> 10
        }
    }
}


