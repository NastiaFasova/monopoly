package monopoly;

import monopoly.exception.LowPriceOfPropertyCardException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Monopoly {
    private static final int MIN_PRICE = 100;
    private NotRealBank bank;
    private Random rnd;
    private List<ChanceCard> chances;
    private List<PropertyCard> properties;

    public List<ChanceCard> getChances() {
        return chances;
    }

    public List<PropertyCard> getProperties() {
        return properties;
    }

    class ChanceCard extends Card {
        ChanceCard(String title, String description, String effect) {
            super(title, description, effect);
        }

        ChanceCard(){
            super("", "", "");
        }

        @Override
        public String getTitle() {
            return "\"" + title + "\"";
        }

        public String printInfo(){
            return "Your chance is here!\n" + getTitle() + "\n" + getDescription() + "\n";
        }

        public String action(){
            return "Well, now you have to " + getEffect();
        }
    }
    static class PropertyCard extends Card {
        private Integer price;
        private Integer gain;
        PropertyCard(String title, String description, String effect,
                     Integer price, Integer gain) throws LowPriceOfPropertyCardException {
            super(title, description, effect);
            if (price < MIN_PRICE) {
                throw new LowPriceOfPropertyCardException("Price of Property Card should be more than 200");
            }
            this.price = price;
            this.gain = gain;
        }
        PropertyCard(){
            super("", "", "");
        }
        public String printInfo(){
            return "This is the property:\n" + getTitle() + "\n" + getDescription() + "\n ";
        }
        public String action(){
            return "You can buy " + getTitle() + " for a fair price of " + price
                    + ", gain here equals " + gain + " when " + getEffect() + "; ";
        }

        public Integer getPrice() {
            return price;
        }

        public Integer getGain() {
            return gain;
        }


    }

    private void bankToDefault(){
        bank = new NotRealBank();
        bank.addBanknotes(Nominal.ONE, 100);
        bank.addBanknotes(Nominal.TEN, 100);
        bank.addBanknotes(Nominal.TWENTY, 100);
        bank.addBanknotes(Nominal.FIFTY, 50);
        bank.addBanknotes(Nominal.HUNDREED, 50);
        bank.addBanknotes(Nominal.FIVEHUNDREED, 20);
        this.setBank(bank);
    }

    Monopoly(){
        bankToDefault();
        rnd = new Random();

        chances = new ArrayList<ChanceCard>();
        chances.add(new ChanceCard("A", "Taxes!", "pay 150."));
        chances.add(new ChanceCard("B", "Rent!", "pay 200."));
        chances.add(new ChanceCard("C", "Competition!", "gain 10."));
        chances.add(new ChanceCard("D", "Fine!", "pay 20."));
        chances.add(new ChanceCard("E", "Salary!", "gain 500."));

        properties = new ArrayList<PropertyCard>();
        try {
            properties.add(new PropertyCard("pA", "A street.", "somebody walks", 200, 3));
            properties.add(new PropertyCard("pB", "A house.", "somebody stays", 500, 50));
            properties.add(new PropertyCard("pC", "A library.", "somebody reads", 300, 10));
            properties.add(new PropertyCard("pD", "A shop.", "somebody buys", 1000, 100));
            properties.add(new PropertyCard("pE", "A hotel.", "somebody sleeps", 2000, 250));
        } catch (LowPriceOfPropertyCardException e) {
            e.printStackTrace();
        }
    }

    //Use of split()
    public String[] generateRandomChance(){
        int ind = rnd.nextInt(chances.size());
        String result = chances.get(ind).printInfo() + chances.get(ind).action();
        return result.split("\\n");
    }

    //Use of split()
    public String[] generateRandomProperty(){
        int ind = rnd.nextInt(properties.size());
        String result = properties.get(ind).printInfo() + properties.get(ind).action();
        return result.split("\\n");
    }

    public void getAvailableChances(){
        Iterator<ChanceCard> iter = chances.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().getTitle());
        }
    }

    //Use of split()
    public String[] getAvailableProperties(){
        Iterator<PropertyCard> iter = properties.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Titles of properties: ");
        while(iter.hasNext()){
            stringBuilder.append(iter.next().getTitle()).append(" ");
        }
        return stringBuilder.toString().split(" ");
    }

    public NotRealBank getBank(){
        return bank;
    }

    public void setBank(NotRealBank bank) {
        this.bank = bank;
    }

    //Use of concatenation of different types
    public String getPropertiesByIndex(int index) {
        PropertyCard card = properties.get(index);
        return card.getDescription() + card.getGain() + card.getPrice();
    }
}
