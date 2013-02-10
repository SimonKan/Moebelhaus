/*
 * ConcreteArticle.java
 *
 * Created on 02.02.2013, 18:22:28
 */
package article;

/**
 * ConcreteArticle umschließt die Klasse Article und erweitert sie um die
 * uniqueId. Aus schreibgründen wurde nicht der Weg über die Vererbung gewählt
 *
 * @author Simon
 * @since 02.02.2013
 * @version 1.0.0
 */
public class ConcreteArticle {

    private Article article;
    private long uniqueId;

    /**
     * Konstruktor der Klasse ConcreteArticle abhängig von einem Element article
     * vom Typ Article, sodass alle Attribute von Article übernommen werden.
     * 
     * TODO param-Tags hinzufügen
     */
    public ConcreteArticle(Article article, long uniqueId) {
        this.article = article;
        this.uniqueId = uniqueId;
    }

    /*
     * Get Methoden zum Aufruf der uniqueId und zum Aufruf des ursprünglichen
     * Articles der eingeschlossen wurde
     *
     * @return
     */
    public Article getArticle() {
        return this.article;
    }

    // TODO JavaDoc erzeugen
    public long getUniqueId() {
        return this.uniqueId;
    }
}
