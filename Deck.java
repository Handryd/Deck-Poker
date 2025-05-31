import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    // Clase interna: Card
    static class Card {
        private final String suit;   // Palo
        private final String color;  // Color
        private final String value;  // Valor

        public Card(String suit, String color, String value) {
            this.suit = suit;
            this.color = color;
            this.value = value;
        }

        @Override
        public String toString() {
            return suit + "," + color + "," + value;
        }
    }

    private final List<Card> cards;
    private final List<Card> discardedCards;

    public Deck() {
        cards = new ArrayList<>();
        discardedCards = new ArrayList<>();
        initializeDeck();
    }

    // Crear las 52 cartas del deck
    private void initializeDeck() {
        String[][] suits = {
            {"Tréboles", "Negro"},
            {"Picas", "Negro"},
            {"Corazones", "Rojo"},
            {"Diamantes", "Rojo"}
        };
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String[] suitData : suits) {
            String suit = suitData[0];
            String color = suitData[1];
            for (String value : values) {
                cards.add(new Card(suit, color, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (!cards.isEmpty()) {
            Card card = cards.remove(0);
            discardedCards.add(card);
            System.out.println(card);
            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("El deck está vacío.");
        }
    }

    public void pick() {
        if (!cards.isEmpty()) {
            Random rand = new Random();
            int index = rand.nextInt(cards.size());
            Card card = cards.remove(index);
            discardedCards.add(card);
            System.out.println(card);
            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("El deck está vacío.");
        }
    }

    public void hand() {
        if (cards.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card card = cards.remove(0);
                discardedCards.add(card);
                System.out.println(card);
            }
            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay suficientes cartas para repartir una mano.");
        }
    }

    // Método principal
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();
    }
}
