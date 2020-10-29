package monopoly.equals_hashcode;

import monopoly.Card;
import monopoly.Nominal;
import monopoly.NotRealBank;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class EqualsExamplesTest {

    private EqualsExamples examples = new EqualsExamples();

    @Test
    public void overriddenEqualsTest() {
        Card firstCard = new Card("title", "description", "affect");
        Card secondCard = new Card("title", "description", "affect");
        Assert.assertTrue(examples.overriddenEquals(firstCard, secondCard));
    }

    @Test
    public void nonOverriddenEqualsTest() {
        Map<Nominal, Integer> map = new HashMap<>();
        map.put(Nominal.FIFTY, 10);
        Assert.assertTrue(examples.nonOverriddenEquals(new NotRealBank()));
        Assert.assertTrue(examples.nonOverriddenEquals(new NotRealBank(map)));
    }

    @Test
    public void nonOverriddenEqualsOfTwoObjectsTest() {
        Map<Nominal, Integer> map = new HashMap<>();
        map.put(Nominal.FIFTY, 10);
        Assert.assertFalse(examples.nonOverriddenEquals(new NotRealBank(), new NotRealBank()));
        Assert.assertFalse(examples.nonOverriddenEquals(new NotRealBank(map),
                new NotRealBank(map)));
    }
}