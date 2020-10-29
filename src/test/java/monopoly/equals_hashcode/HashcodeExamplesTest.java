package monopoly.equals_hashcode;

import monopoly.Card;
import monopoly.Nominal;
import monopoly.NotRealBank;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class HashcodeExamplesTest {

    private HashcodeExamples examples = new HashcodeExamples();

    @Test
    public void nonOverriddenHashOfTwoObjects() {
        Map<Nominal, Integer> map = new HashMap<>();
        map.put(Nominal.FIFTY, 10);
        Assert.assertFalse(examples.nonOverriddenHashOfTwoObjects(new NotRealBank(), new NotRealBank()));
        Assert.assertFalse(examples.nonOverriddenHashOfTwoObjects(new NotRealBank(map), new NotRealBank(map)));
    }

    @Test
    public void overriddenHashcode() {
        Card firstCard = new Card("title", "description", "affect");
        Card secondCard = new Card("title", "description", "affect");
        Assert.assertTrue(examples.overriddenHashcode(firstCard, secondCard));
    }
}