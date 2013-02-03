package article;

/**
 * Abstrakte Klasse Article mit vier verschiedenen Attribute. Diese werden an
 * vier weitere Unterklassen vererbt.
 *
 * @author Simon
 */
public abstract class Article {

    private long articleId;
    private String name;
    private float price;
    private int material;

    // Konstruktor der Klasse Article.
    public Article(long articleId, String name, float price,
            int material) {

        this.articleId = articleId;
        this.name = name;
        this.price = price;
        this.material = material;
    }

    /**
     * Getter Methoden der Klasse Article,dienen zum Aufruf der erstellten
     * Werte.
     *
     * @return
     */
    public long getArticleId() {
        return this.articleId;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

    public int getMaterial() {
        return this.material;
    }
}