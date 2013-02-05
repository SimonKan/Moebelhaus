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

    /**
     * Konstruktor der Klasse Article
     *
     * @param articleId eindeutige Id des Artikels
     * @param name Name des Artikels
     * @param price Preis des Artikels
     * @param material Material des Artikels
     */
    public Article(long articleId, String name, float price,
            int material) {

        this.articleId = articleId;
        this.name = name;
        this.price = price;
        this.material = material;
    }

    /**
     * Getter Methode
     *
     * @return ArtikelId
     */
    public long getArticleId() {
        return this.articleId;
    }

    /**
     * Getter Methode
     *
     * @return Namen
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter Methode
     *
     * @return Preis
     */
    public float getPrice() {
        return this.price;
    }

    /**
     * Getter Methode
     *
     * @return Material
     */
    public int getMaterial() {
        return this.material;
    }
}