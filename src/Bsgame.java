import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bsgame {

    public record Card(int value, String cardname) {}

    public static void epiccarddeliverypackagessystem(ArrayList<Card> Playercardcardsplayer){
        for (int i = 0; i< Playercardcardsplayer.size(); i++){
            System.out.println((i+1) + ": " + Playercardcardsplayer.get(i));

        }
    }


    public static void main(String[] args) {
        boolean botbscall=false;
        boolean playbscall=false;

        System.out.println("Time to play epic card game!");
        System.out.println("How the game works:");
        System.out.println("    In this super epic card game, players take turns playing cards face-down and make claims about what cards they've played. The other players can challenge the claim, and if they think the\n player is lying, they can call \"BS!\" If the card claimed doesn't match the card played, the liar must pick up the entire pile. If the card claimed is truthful, the challenger must pick up the pile instead. The goal is to be the\n first player to get rid of all their cards. At the beginning of the game, after shuffling the deck, a random card is drawn to begin the play. This card could be any card from the deck, so it's not predetermined like the\n Ace of Spades. The first player places this random card face down on the table and claims it’s a specific rank—say, a \"2 of Diamonds.\" They may or may not be telling the truth. The next player then takes their turn. They\n must play a card of the next rank in the sequence, which could be the \"3 of Hearts\" if the claim was about a \"2 of Diamonds.\" They again make a claim about the card they've placed, and the next player has the option to\n either believe them or challenge by calling \"BS. If a challenge is made, the card in question is revealed. If the player was lying, they must pick up the pile; if they were telling the truth, the challenger must pick up\n the pile. The game continues, with players taking turns, claiming the next card in the sequence, and possibly lying about what they've played. As the game progresses, players must keep track of the ranks and attempt to\n deceive others into believing they have played a card that aligns with the sequence. However, they must also be cautious not to get caught in a lie, as this will result in a penalty of picking up the entire pile of\n discarded cards. The game continues until one player has successfully discarded all their cards and is declared the winner. If a player challenges too often without cause, they may end up accumulating too many penalty\n cards, which puts them at a disadvantage.");
        ArrayList<Card> deck = new ArrayList<>();
        Card[] _deck = {
                new Card(2,"2 of Hearts"), new Card(3,"3 of Hearts"),new Card(4,"4 of Hearts"), new Card(5,"5 of Hearts"), new Card(6,"6 of Hearts"), new Card(7,"7 of Hearts"), new Card(8,"8 of Hearts"), new Card(9,"9 of Hearts"), new Card(10,"10 of Hearts"), new Card(11,"Jack of Hearts"), new Card(12,"Queen of Hearts"),new Card(13,"King of Hearts"), new Card(1,"Ace of Hearts"),
                new Card(2,"2 of Diamonds"), new Card(3,"3 of Diamonds"),new Card(4,"4 of Diamonds"), new Card(5,"5 of Diamonds"), new Card(6,"6 of Diamonds"), new Card(7,"7 of Diamonds"), new Card(8,"8 of Diamonds"), new Card(9,"9 of Diamonds"), new Card(10,"10 of Diamonds"), new Card(11,"Jack of Diamonds"), new Card(12,"Queen of Diamonds"),new Card(13,"King of Diamonds"), new Card(1,"Ace of Diamonds"),
                new Card(2,"2 of Clubs"), new Card(3,"3 of Clubs"),new Card(4,"4 of Clubs"), new Card(5,"5 of Clubs"), new Card(6,"6 of Clubs"), new Card(7,"7 of Clubs"), new Card(8,"8 of Clubs"), new Card(9,"9 of Clubs"), new Card(10,"10 of Clubs"), new Card(11,"Jack of Clubs"), new Card(12,"Queen of Clubs"),new Card(13,"King of Clubs"), new Card(1,"Ace of Clubs"),
                new Card(2,"2 of Spades"), new Card(3,"3 of Spades"),new Card(4,"4 of Spades"), new Card(5,"5 of Spades"), new Card(6,"6 of Spades"), new Card(7,"7 of Spades"), new Card(8,"8 of Spades"), new Card(9,"9 of Spades"), new Card(10,"10 of Spades"), new Card(11,"Jack of Spades"), new Card(12,"Queen of Spades"),new Card(13,"King of Spades"), new Card(1,"Ace of Spades"),
//                "2 of Diamonds", "3 of Diamonds", "4 of Diamonds", "5 of Diamonds", "6 of Diamonds", "7 of Diamonds", "8 of Diamonds", "9 of Diamonds", "10 of Diamonds", "Jack of Diamonds", "Queen of Diamonds", "King of Diamonds", "Ace of Diamonds",

                //"2 of Clubs", "3 of Clubs", "4 of Clubs", "5 of Clubs", "6 of Clubs", "7 of Clubs", "8 of Clubs", "9 of Clubs", "10 of Clubs", "Jack of Clubs", "Queen of Clubs", "King of Clubs", "Ace of Clubs",
               // "2 of Spades", "3 of Spades", "4 of Spades", "5 of Spades", "6 of Spades", "7 of Spades", "8 of Spades", "9 of Spades", "10 of Spades", "Jack of Spades", "Queen of Spades", "King of Spades", "Ace of Spades",
                new Card(14,"Red Joker"), new Card(14, "Black Joker")
        };

        deck.addAll(List.of(_deck));





        Scanner scanner = new Scanner(System.in);

        Random rand = new Random();
        ArrayList<Card> playerhand = new ArrayList<>();

        ArrayList<Card> bothand = new ArrayList<>();

        ArrayList<Card> cardpile = new ArrayList<>();


        int state = 0;
        // state 0: deal cards to player and bot
        // state 1: player plays card, check if its a valid card
        // state 2: if player plays correct card, bot plays or 20% to call BS
        // state 3: if player plays wrong card, bot plays or 75% to call BS
        // state 4: if player plays wrong card in bot's hand, bot plays or has a 90% to call BS
        // state 5: bot calls BS
        // state 6: bot plays card, check if its a valid card in bots hand
        // state 7: player chooses either BS or plays
        // state 8: player calls BS
        // state 9: player gets deck
        // state 10: bot gets deck
        // state 11: player wins
        // state 12: bot wins

        boolean bot_has_correct_card = false;
        boolean player_placed_correct_card = false;
        int card_value_to_be_placed = 1;
        while (true) {

            while (state == 0) {

                int deck_size = deck.size()/3; //TODO: check if the number of remiaing cards in deck is enough to deal

                for (int i = 0; i < deck_size; i++){
                    int player_draw = rand.nextInt(deck.size());


                    playerhand.add(deck.remove(player_draw));

                    int bot_draw = rand.nextInt(deck.size());
                    bothand.add(deck.remove(bot_draw));

                }

                if(true /* exit condition*/) {
                    state = 1;
                }
            }
            while (state == 1) {
                System.out.println("The card value supposed to be placed is " + card_value_to_be_placed + "!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                player_placed_correct_card = false;
               epiccarddeliverypackagessystem(playerhand);
                int playerinp = scanner.nextInt();
                System.out.println("You placed down your chosen card!");
                Card placed_card = playerhand.remove(playerinp-1);

                //check if number valid
                cardpile.add(placed_card);

                //System.out.println(playerinp);
                // state 2: if player plays correct card, bot plays or 20% to call BS
                // state 3: if player plays wrong card, bot plays or 75% to call BS
                // state 4: if player plays wrong card in bot's hand, bot plays or has a 90% to call BS
                if(card_value_to_be_placed == placed_card.value()){
                    player_placed_correct_card = true;
                    state = 2;
                }

                System.out.println(card_value_to_be_placed + "," + placed_card);

                if(card_value_to_be_placed != placed_card.value() ){
                    int count = getCount(bothand, card_value_to_be_placed);
                    if(count == 4){

                        state = 4;
                    }
                    else {

                        state = 3;
                    }
                }


                if (placed_card.value() == 14){
                    player_placed_correct_card = true;
                    state = 4;
                }

                if(playerhand.size() == 0){
                    state = 11;
                }


                card_value_to_be_placed = ((card_value_to_be_placed) % 14) + 1;
            }
            while (state == 2) {
                System.out.println("You placed down a card, and the bot thinks about it!");
                if (rand.nextInt(100) <= 20){
                    state = 5;
                }
                else {
                    state = 6;
                }

            }
            while (state == 3) {
                System.out.println("You placed down a card, and the bot analyzes quickly!");
                if(rand.nextInt(100) <= 40){
                    state = 5;

                }
                else {
                    state = 6;
                }
            }
            while (state == 4) {
                System.out.println("You placed down the card! And the bot smiles very mischievously.");
                if (rand.nextInt(100) <= 90){
                    state = 5;
                }
                else {
                    state = 6;
                }
            }
            while (state == 5) {
                botbscall = true;
                System.out.println("Bot called BS!");
                if(player_placed_correct_card == true){
                    System.out.println("Easy pickins");
                    state = 10;
                } else if (player_placed_correct_card==false) {
                    System.out.println("You might be cooked.");
                    state = 9;
                }
                 }
            while (state == 6) {
                System.out.println("The bot ponders about what choice of cards should he play.");
                bot_has_correct_card = false;

                for (int i = 0; i < bothand.size(); i++) {
                    if (bothand.get(i).value() == card_value_to_be_placed){
                        bot_has_correct_card = true;
                        cardpile.add(bothand.remove(i));
                        state = 7;
                        break;

                    }
                }

                if (bot_has_correct_card) {
                    card_value_to_be_placed = ((card_value_to_be_placed) % 14) + 1;
                    break;
                }
                System.out.println("Bot has placed down his chosen card!");
                cardpile.add(bothand.remove(rand.nextInt(bothand.size())));
                card_value_to_be_placed = ((card_value_to_be_placed) % 14) + 1;

                state = 7;
                if(bothand.size()==0){
                    state = 12;
                }

//                if (bothand.contains(card_value_to_be_placed)){
//                    int placed_card =
//                }
            }
            while (state == 7) {
                System.out.println("Bot placed down a card. Call BS or play?");
                String playerinp = scanner.nextLine().trim().toLowerCase();

                if(playerinp.contains("bs")){
                    playbscall = true;
                    state = 8;
                }
                else if (playerinp.contains("pl")){
                    state = 1;
                } else {
                    playerinp = scanner.nextLine().trim().toLowerCase();
                    if(playerinp.contains("bs")){
                        playbscall = true;
                        state = 8;
                    }
                    else
                        state = 1;
                }
            }
            while (state == 8) {

                if(bot_has_correct_card == true || player_placed_correct_card == false){
                    System.out.println("You got baited");
                    state = 9;
                } else if (bot_has_correct_card == false || player_placed_correct_card == true) {
                    System.out.println("Easy pickins");
                    state = 10;
                }
            }
            while (state == 9) {
                System.out.println("You took the cardpile!!");
                playerhand.addAll(cardpile);

                cardpile.clear();
                if(bothand.isEmpty()){
                    state = 12;
                }
                else{
                    if(playbscall == true){
                        state = 1;
                        playbscall=false;
                    }
                    else
                        state = 6;
                }
            }
            while (state == 10) {
                System.out.println("Bot got all of the cards. L bozo");
                bothand.addAll(cardpile);
                cardpile.clear();
//                state = 1;
                if(playerhand.isEmpty()){
                    state = 11;
                }
                else{
                    if(botbscall == true){
                        state=6;
                        botbscall=false;
                    }
                    else
                        state = 1;

                }
            }
            while (state == 11) {
                System.out.println("You won");
            }
            while (state == 12) {
                System.out.println("Bot won, you lost, womp womp");
            }


        }





    }

    public static int getCount(ArrayList<Card> bothand, int card_value_to_be_placed) {
        int count = 0;
        for (int i = 0; i < bothand.size(); i++) {
            if (bothand.get(i).value() == card_value_to_be_placed) {
                count++;
            }
        }
        return count;
    }
}