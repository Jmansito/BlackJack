import java.util.Random;

public class game extends Main{
    public static String getCard() {

        // Method to get a random card and suit of that card
        // This could be done with a hash table or double array as well
        // Can convert this depending on how we need to implement the deck of cards

        // create instance of Random class
        Random rand = new Random();
        int rand_card = rand.nextInt(12);
        int rand_suit = rand.nextInt(3);
        String card = "";
        String[] deck = {"Ace", "King", "Queen", "Jack", "Ten", "Nine",
                "Eight", "Seven", "Six", "Five", "Four", "Three", "Two"};
        String[] suit = {"Spades", "Clubs", "Hearts", "Diamonds"};

        card = deck[rand_card] + " of " + suit[rand_suit];

        return card;
        }
    }

