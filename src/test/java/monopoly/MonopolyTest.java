package monopoly;

import monopoly.exception.LowPriceOfPropertyCardException;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class MonopolyTest {

    Monopoly monopoly = new Monopoly();

    @Test
    public void getAvailablePropertiesTest() throws LowPriceOfPropertyCardException {
        List<Monopoly.PropertyCard> properties = monopoly.getProperties();
        properties.clear();
        Monopoly.PropertyCard card1 = new Monopoly.PropertyCard("pA",
                "A street.", "somebody walks", 200, 3);
        Monopoly.PropertyCard card2 = new Monopoly.PropertyCard("pB",
                "A house.", "somebody stays", 500, 50);
        properties.add(card1);
        properties.add(card2);
        String[] expected = {"pA",  "pB"};
        String[] actual = monopoly.getAvailableProperties();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getPropertiesByIndexTest() throws LowPriceOfPropertyCardException {
        List<Monopoly.PropertyCard> properties = monopoly.getProperties();
        Monopoly.PropertyCard card = new Monopoly.PropertyCard("pA",
                "A street.", "somebody walks", 200, 3);
        properties.add(0, card);
        String expected = "A street.3200";
        String actual = monopoly.getPropertiesByIndex(0);
        Assert.assertEquals(expected, actual);
    }
}