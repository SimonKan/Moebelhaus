/*
 * ConcreteArticle.java
 *
 * Created on 02.02.2013, 18:22:28
 */
package article;

/**
 *
 *
 * @author Simon
 * @since 02.02.2013
 * @version 1.0.0
 */
public class ConcreteArticle {

    private Article article;
    private long uniqueId;

    public ConcreteArticle(Article article, long uniqueId) {
        this.article = article;
        this.uniqueId = uniqueId;
    }

    public Article getArticle() {
        return this.article;
    }

    public long getUniqueId() {
        return this.uniqueId;
    }
}
