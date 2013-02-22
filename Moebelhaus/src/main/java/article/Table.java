package article;

/**
 * Klasse erweitert Article um zwei Attribute
 *
 * @author Simon
 */
public class Table extends Article {

    public static final class Categories {
        // TODO kategorien einführen!
        // e.g. Esstisch, Nachttisch, etc.

        public static final int category1 = 1;
    }

    private boolean pullOut;
    private int categorie;

    /**
     * Konstruktor der Klasse Tisch
     *
     * @param articleId
     * @param name
     * @param price
     * @param material
     * @param pullOut
     * @param categorie
     */
    public Table(long articleId, String name, float price,
                 int material, boolean pullOut, int categorie) {
        super(articleId, name, price, material);
        this.categorie = categorie;
        this.pullOut = pullOut;
    }
// Get Methoden zum Aufruf der Attribute,  die ergänzt wurden

    public boolean getPullOut() {
        return this.pullOut;
    }

    public int getCategorie() {
        return this.categorie;
    }

    @Override
    public String toString() {
        return "Tisch - " + super.toString();
    }
}