package monopoly;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    private Card card;

    @Test
    public void overallInfo() {
        card = new Card("pB", "A house.", "somebody stays");
        String expected = "pB A house. somebody stays";
        String actual = card.overallInfo();
        Assert.assertEquals(expected, actual);
    }
}