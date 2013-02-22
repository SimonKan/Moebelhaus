package article;

/**
 * Unterklasse von Article Erbt von Article und erweitert um zwei Attribute
 * Getter Methoden dienen zum Aufrufen der neuen Attribute
 *
 * @author Simon
 */
public class Couch extends Article {

    private boolean corner;
    private boolean pullOut;

    /**
     * Konstruktor der Klasse Couch
     *
     * @param articleId
     * @param name
     * @param price
     * @param material
     * @param pullOut
     * @param corner
     */
    public Couch(long articleId, String name, float price,
                 int material, boolean pullOut, boolean corner) {
        super(articleId, name, price, material);
        this.corner = corner;
        this.pullOut = pullOut;
    }
    /*
     * Getter Methoden der ergänzten Attribute
     */

    public boolean getCorner() {
        return this.corner;
    }

    public boolean getPullOut() {
        return this.pullOut;
    }

    @Override
    public String toString() {
        return "Couch - " + super.toString();
    }
}