/*
 * ArticleFactory.java
 *
 * Created on 02.02.2013, 17:47:41
 */
package article;

import main.UniqueNumberGenerator;

/**
 *
 *
 * @author Simon
 * @since 02.02.2013
 * @version 1.0.0
 */
public class ArticleFactory {

    private UniqueNumberGenerator generator;

    public ArticleFactory() {
        this.generator = new UniqueNumberGenerator();
    }

    /**
     *
     * @param uniqueId
     * @param articleId
     * @param name
     * @param price
     * @param material
     * @param bathTub
     * @param numberSink
     * @return
     */
    public ConcreteArticle createBath(long articleId, String name,
            float price, int material, boolean bathTub, int numberSink) {

        // Check name 
        if (name == null) {
            throw new IllegalArgumentException("name was null");
        }
        name = name.trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name was empty");
        }

        // Check price
        if (price <= 0) {
            throw new IllegalArgumentException("price was " + price);
        }

        //Check numberSink
        if (numberSink <= 0) {
            throw new IllegalArgumentException("numberSink was " + numberSink);
        }

        return new ConcreteArticle(new Bath(articleId, name, price, material,
                bathTub, numberSink), generator.getNextNumber());
    }

    public ConcreteArticle createCouch(long articleId, String name, float price,
            int material, boolean pullOut, boolean corner) {

        // Check name 
        if (name == null) {
            throw new IllegalArgumentException("name was null");
        }
        name = name.trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name was empty");
        }

        // Check price
        if (price <= 0) {
            throw new IllegalArgumentException("price was " + price);
        }

        return new ConcreteArticle(new Couch(articleId, name, price,
                material, pullOut, corner), generator.getNextNumber());
    }

    public ConcreteArticle createTable(long articleId, String name, float price,
            int material, boolean pullOut, int categorie) {

        // Check name 
        if (name == null) {
            throw new IllegalArgumentException("name was null");
        }
        name = name.trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name was empty");
        }

        // Check price
        if (price <= 0) {
            throw new IllegalArgumentException("price was " + price);
        }

        //Check numberSink
        if (categorie <= 0) {
            throw new IllegalArgumentException("categorie was " + categorie);
        }

        return new ConcreteArticle(new Table(articleId, name, price, material,
                pullOut, categorie), generator.getNextNumber());
    }

    public ConcreteArticle createCloset(long articleId, String name, float price,
            int material, int doors, boolean slope) {

        // Check name 
        if (name == null) {
            throw new IllegalArgumentException("name was null");
        }
        name = name.trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name was empty");
        }

        // Check price
        if (price <= 0) {
            throw new IllegalArgumentException("price was " + price);
        }

        //Check numberSink
        if (doors <= 0) {
            throw new IllegalArgumentException("doors was " + doors);
        }

        return new ConcreteArticle(new Closet(articleId, name, price, material,
                doors, slope), generator.getNextNumber());
    }
}
