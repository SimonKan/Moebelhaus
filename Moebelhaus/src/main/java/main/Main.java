/*
 * Main.java
 *
 * Created on 02.02.2013, 19:10:28
 */
package main;

import article.ArticleFactory;
import article.ConcreteArticle;

/**
 *
 *
 * @author Simon
 * @since 02.02.2013
 * @version 1.0.0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArticleFactory factory = new ArticleFactory();

        ConcreteArticle a;

        a = factory.createBath(0, "Bad", 10.0f, 0, true, 0);
        a = factory.createBath(0, "", 10.0f, 0, true, 0);
        a = factory.createBath(0, "   ", 10.0f, 0, true, 0);
    }
}
