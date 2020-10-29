package monopoly.equals_hashcode;

import monopoly.Card;
import monopoly.NotRealBank;

public class ExamplesOfEqualsAndHashcode {

    public static void main(String[] args) {
        EqualsExamples equalsExamples = new EqualsExamples();
        HashcodeExamples hashcodeExamples = new HashcodeExamples();
        System.out.println("Examples with equals(): ");
        System.out.println(equalsExamples.nonOverriddenEquals(new NotRealBank()));
        System.out.println(equalsExamples.nonOverriddenEquals(new NotRealBank(), new NotRealBank()));

        Card firstCard = new Card("title", "description", "affect");
        Card secondCard = new Card("title", "description", "affect");
        System.out.println(equalsExamples.overriddenEquals(firstCard, secondCard));

        System.out.println("Examples with hashcode(): ");
        System.out.println(hashcodeExamples.nonOverriddenHashOfTwoObjects(new NotRealBank(), new NotRealBank()));

        System.out.println(hashcodeExamples.overriddenHashcode(firstCard, secondCard));

    }

}
