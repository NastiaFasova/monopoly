package monopoly;

import java.util.List;
import java.util.Objects;

public class Card implements Printable {
    protected String title;
    private String description;
    private String effect;

    public Card(String t, String d, String e) {
        title = t;
        description = d;
        effect = e;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getEffect() {
        return effect;
    }

    public String printInfo() {
        return "Some info about the card";
    }

    public String action() {
        return "Some action the card does";
    }

    //Use of StringBuilder
    public String overallInfo() {
        List<String> info = List.of(getTitle(), getDescription(), getEffect());
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : info) {
            stringBuilder.append(str).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return Objects.equals(title, card.title) &&
                Objects.equals(description, card.description) &&
                Objects.equals(effect, card.effect);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (effect != null ? effect.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Card{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", effect='" + effect + '\'' +
                '}';
    }
}
