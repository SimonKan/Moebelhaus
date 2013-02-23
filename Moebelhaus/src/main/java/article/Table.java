package article;

/**
 * Klasse erweitert Article um zwei Attribute
 *
 * @author Simon
 */
public class Table extends Article {

    public static final class Categories {

        public static final int KITCHENTABLE = 1;
        public static final int DININGTABLE = 2;
        public static final int LIVINGROOMTABLE = 3;
        public static final int COUCHTABLE = 4;
    }

    private boolean pullOut;
    private int category;

    /**
     * Konstruktor der Klasse Tisch
     *
     * @param articleId
     * @param name
     * @param price
     * @param material
     * @param pullOut
     * @param category
     */
    public Table(long articleId, String name, float price,
                 int material, boolean pullOut, int category) {
        super(articleId, name, price, material);
        this.category = category;
        this.pullOut = pullOut;
    }
// Get Methoden zum Aufruf der Attribute,  die ergänzt wurden

    public boolean getPullOut() {
        return this.pullOut;
    }

    public int getCategory() {
        return this.category;
    }

    @Override
    public String toString() {
        return "Tisch - " + super.toString();
    }
}