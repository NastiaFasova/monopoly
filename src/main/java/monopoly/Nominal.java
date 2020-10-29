package monopoly;

import monopoly.exception.NotEnoughValueForNominalException;

public enum Nominal {
    ONE(1, Color.WHITE),
    TEN(10, Color.BLUE),
    TWENTY(20, Color.GREEN),
    FIFTY(50, Color.PURPLE),
    HUNDREED(100, Color.YELLOW),
    FIVEHUNDREED(500, Color.ORANGE);

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 500;
    public int val;
    public Color color;

    Nominal(int value, Color c) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new NotEnoughValueForNominalException("The value should be more than 1 and less than 500");
        }
        val = value;
        color = c;
    }

    public static String showTypeOfNominal() {
        System.out.print("TypeOfFlower enum: ");
        StringBuilder stringBuilder = new StringBuilder();
        for (Nominal nominal : Nominal.values()) {
                stringBuilder.append(nominal)
                        .append(" value: ")
                        .append(nominal.val)
                        .append("; color: ")
                        .append(nominal.color);
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }

    @Override
    public String toString() {
        return "Nominal{" +
                "val=" + val +
                ", color=" + color +
                "} " + super.toString();
    }
}

