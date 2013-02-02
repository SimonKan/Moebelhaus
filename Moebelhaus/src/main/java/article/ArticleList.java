package article;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Simon
 */
public class ArticleList {

    private List<ConcreteArticle> articles;

    public ArticleList() {
        articles = new ArrayList<ConcreteArticle>();
    }

    /**
     *
     * neuer Konstruktor zum Übertragen der List<ConcreteArticle> in eine
     * {@link ArticleList}.
     *
     * @param articles
     */
    public ArticleList(List<ConcreteArticle> articles) {
        if (articles == null) {
            throw new IllegalArgumentException("articles was null");
        }
        this.articles = new ArrayList<ConcreteArticle>(articles);
    }

    public ConcreteArticle getArticleByUniqueId(long uid) {
        for (ConcreteArticle article : articles) {
            if (article.getUniqueId() == uid) {
                return article;
            }
        }
        return null;
    }

    public ArticleList getArticlesByArticleId(long aid) {
        List<ConcreteArticle> searchList = new ArrayList<ConcreteArticle>();

        for (ConcreteArticle article : articles) {
            if (article.getArticle().getArticleId() == aid) {
                searchList.add(article);
            }
        }

        return new ArticleList(searchList);
    }

    public ArticleList getArticlesByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name was null");
        }
        name = name.trim().toLowerCase();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        List<ConcreteArticle> searchList = new ArrayList<ConcreteArticle>();

        //Ermöglicht das suchen von Stichwörtern 
        Pattern pattern = Pattern.compile("\\.*" + name + "\\.*");

        for (ConcreteArticle article : articles) {
            if (pattern.matcher(article.getArticle().getName().toLowerCase()).matches()) {
                searchList.add(article);
            }
        }
        return new ArticleList(searchList);
    }

    public ArticleList getArticlesByMaterial(int material) {
        List<ConcreteArticle> searchList = new ArrayList<ConcreteArticle>();

        for (ConcreteArticle article : articles) {
            if (article.getArticle().getMaterial() == material) {
                searchList.add(article);
            }
        }

        return new ArticleList(searchList);
    }

    public ArticleList getArticlesByPrice(float lowerBound, float upperBound) {
        if (Float.isNaN(lowerBound)) {
            throw new IllegalArgumentException("lowerBound was NaN");
        }
        if (Float.isNaN(upperBound)) {
            throw new IllegalArgumentException("upperBound was NaN");
        }

        List<ConcreteArticle> searchList = new ArrayList<ConcreteArticle>();

        for (ConcreteArticle article : articles) {
            if (lowerBound <= article.getArticle().getPrice()
                    || article.getArticle().getPrice() <= upperBound) {
                searchList.add(article);
            }
        }

        return new ArticleList(searchList);
    }

    public List<ConcreteArticle> toList() {
        return new ArrayList<ConcreteArticle>(articles);
    }
}
