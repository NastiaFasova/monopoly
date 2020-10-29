package monopoly;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        System.out.println("Look at this color: " + Color.BLUE);
        Monopoly game = new Monopoly();
        System.out.println("Lets start with all available Chances:");
        game.getAvailableChances();
        System.out.println("Lets get one random Chance Card:");
        game.generateRandomChance();
        System.out.println("Lets walk through all available Properties:");
        System.out.println(Arrays.toString(game.getAvailableProperties()));
        System.out.println("Now well see one random Property:");
        game.generateRandomProperty();
        System.out.println("What about banknotes in the Bank?");
        game.getBank().showBank();

        Card card = new Card("Title", "description", "effect");

        System.out.println(card.overallInfo());//Use of StringBuilder

        //Use of split()
        System.out.println(Arrays.toString(game.generateRandomChance()));
        System.out.println(Arrays.toString(game.generateRandomProperty()));

        //Use of concatenation of different types
        System.out.println(game.getPropertiesByIndex(1));
    }
}
