/*
 * ArticleFactory.java
 *
 * Created on 02.02.2013, 17:47:41
 */
package article;

import misc.UniqueNumberGenerator;

/**
 * ArticleFactory ist für das Erstellen der Objekte zuständig, in Abhängigkeit
 * der Anforderungen an Attributen und für die Überprüfung nach Fehlerhaften
 * Eingaben
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
     * Konstruktor der Klasse Bad
     *
     * @param articleId  Id des Artikels
     * @param name       Name des Artikels
     * @param price      Preis des Artikels
     * @param material   Material des Artikels
     * @param bathTub    ob Badewanne vorhanden
     * @param numberSink wieviele Waschbecken
     *
     * @return {@link Article Bad}
     *
     * @throws IllegalArgumentException <ul>
     *                                  <li> wenn Name null ist</li>
     *                                  <li>wenn Name leer ist</li>
     *                                  <li> wenn Preis negativ</li>
     *                                  <li>wenn Anzahl numberSink negativ </li>
     *                                  <ul>
     */
    public ConcreteArticle createBath(long articleId, String name,
                                      float price, int material,
                                      boolean bathTub, int numberSink) {

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

    /**
     * Konstruktor für einen Artikel Typ Couch
     *
     * @param articleId Id des Artikels
     * @param name      Name des Artikels
     * @param price     Preis des Artikels
     * @param material  Material des Artikels
     * @param pullOut   ob die Couch ausziehbar ist
     * @param corner    Ob couch eine Ecke hat
     *
     * @return {@link Article Couch}
     *
     * @throws IllegalArgumentException <ul>
     *                                  <li>wenn Name null ist</li>
     *                                  <li>wenn Name leer ist</li>
     *                                  <li>wenn Preis negativ ist</li>
     *                                  <ul>
     */
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

    /**
     * Konstruktor für eine Klasse vom Typ Tisch
     *
     * @param articleId Id des Artikels
     * @param name      Name des Artikels
     * @param price     Preis des Artikels
     * @param material  Material des Artikels
     * @param pullOut   ob ausziehbar
     * @param category welche Kategorie
     *
     * @return {@link Article Tisch}
     *
     * @throws IllegalArgumentException <ul>
     *                                  <li>wenn Name null ist</li>
     *                                  <li>wenn Name leer ist </li>
     *                                  <li>wenn Preis negativ ist </li>
     *                                  <li>wenn categorie leer ist</li>
     *                                  <ul>
     *
     */
    public ConcreteArticle createTable(long articleId, String name, float price,
                                       int material, boolean pullOut, int category) {

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

        //Check categorie
        if (category < 0) {
            throw new IllegalArgumentException("categorie was negative");
        }

        return new ConcreteArticle(new Table(articleId, name, price, material,
                                             pullOut, category), generator.getNextNumber());
    }

    /**
     * Konstruktor für Artikel vom Typ Schrank
     *
     * @param articleId Id des Artikels
     * @param name      Name des Artikels
     * @param price     Preis des Artikels
     * @param material  Material des Artikels
     * @param doors     Anzahl der Türen
     * @param slope
     *
     * @return {@link Article Closet}
     *
     * @throws IllegalArgumentException <ul><li>wenn name null ist</li>
     *                                  <li>wenn name leer ist </li>
     *                                  <li>wenn price negativ ist</li>
     *                                  <li>wenn doors kleiner null ist </li>
     *                                  </ul>
     *
     */
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

        //Check doors
        if (doors <= 0) {
            throw new IllegalArgumentException("doors was " + doors);
        }

        return new ConcreteArticle(new Closet(articleId, name, price, material,
                                              doors, slope), generator.getNextNumber());
    }
}
