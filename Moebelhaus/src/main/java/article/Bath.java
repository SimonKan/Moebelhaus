package article;

/**
 * Unterklasse der Klasse Article. Erbt vier Attribute und erweitert um zwei
 * weitere
 *
 * @author Simon
 */
public class Bath extends Article {

    private boolean bathTub;
    private int numberSink;

    /**
     * Konstruktor der Klasse Bad
     *
     * @param articleId
     * @param name
     * @param price
     * @param material
     * @param bathTub
     * @param numberSink
     */
    public Bath(long articleId, String name, float price,
                int material, boolean bathTub, int numberSink) {
        super(articleId, name, price, material);
        this.bathTub = bathTub;
        this.numberSink = numberSink;
    }

    /**
     * Getter Methode der Badewanne
     *
     * @return
     */
    public boolean getBathTub() {
        return this.bathTub;
    }

    /**
     * Getter Methode der Spühlbecken
     *
     * @return
     */
    public int getNumberSink() {
        return this.numberSink;
    }
}