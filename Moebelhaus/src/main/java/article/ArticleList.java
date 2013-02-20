package article;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Simon
 */
/**
 * Liste der Articel die im System geführt werden. Liste kann durch
 * verschiedene Werte durchsucht werden. Liste wird durchsucht, indem alle
 * Elemente die dem Suchkriterium entsprechen in eine NEUE LISTE vom selben Typ
 * kopiert werden, sodass beide Listen vorhanden sind. Dieses Vorgehen kann
 * wiederholt ausgeführt werden, um die Liste immer weiter zu verkleinern.
 */
public class ArticleList {

    private List<ConcreteArticle> articles;
// Liste wird erstellt

    public ArticleList() {
        articles = new ArrayList<ConcreteArticle>();
    }

    /**
     *
     * neuer Konstruktor zum Übertragen der {@link List} in eine
     * {@link ArticleList}.
     *
     * @param articles Artikel der Liste
     */
    public ArticleList(List<ConcreteArticle> articles) {
        if (articles == null) {
            throw new IllegalArgumentException("articles was null");
        }
        this.articles = new ArrayList<ConcreteArticle>(articles);
    }

    /**
     *
     * @param article ein neuer Artikel
     *
     * @return {@code true} wenn der Artikel neu zur Liste hinzukam,
     *         {@code false} falls der Artikel bereits in der Liste ist
     *
     * @throws IllegalArgumentException <ul>
     *                                  <li>if article is null</li>
     *                                  </ul>
     */
    public boolean add(ConcreteArticle article) {
        if (article == null) {
            throw new IllegalArgumentException("article was null");
        }
        if (!articles.contains(article)) {
            articles.add(article);
            return true;
        }
        return false;
    }

    /**
     *
     * @param article der Artikel der aus der Liste zu entfernen ist
     *
     * @return {@code true} wenn der Artikel zuvor in der Liste war,
     *         {@code false} sonst
     */
    public boolean remove(ConcreteArticle article) {
        if (article == null) {
            throw new IllegalArgumentException("article was null");
        }
        return articles.remove(article);
    }

    /**
     *
     * @param article ein Artikel
     *
     * @return {@code true} wenn der Artikel in der Liste ist, {@code false}
     *         sonst
     */
    public boolean contains(ConcreteArticle article) {
        if (article == null) {
            throw new IllegalArgumentException("article was null");
        }
        return articles.contains(article);
    }

    /*
     * Methoden zum Durchsuchen der Liste nach uniqueId, articleId, name,
     * material, price Rückgabetyp jeweils eine neue Liste die mit den Elementen
     * gefüllt wird
     */
    /**
     * Durchsucht die Artikelliste nach einem Artikel anhand der UniqueId
     *
     * @param uid UniqueId
     *
     * @return {@link Article artikel} Artikel vom Typ Article
     *
     * UID existiert
     */
    public ConcreteArticle getArticleByUniqueId(long uid) {
        for (ConcreteArticle article : articles) {
            if (article.getUniqueId() == uid) {
                return article;
            }
        }
        return null;
    }

    /**
     * Durchsucht die Liste der Artikel anhand der ArticleId und gibt eine Liste
     * zurück
     *
     * @param aid ArtikelId
     *
     * @return {@link ArticleList searchlist}
     */
    public ArticleList getArticlesByArticleId(long aid) {
        List<ConcreteArticle> searchList = new ArrayList<ConcreteArticle>();

        for (ConcreteArticle article : articles) {
            if (article.getArticle().getArticleId() == aid) {
                searchList.add(article);
            }
        }

        return new ArticleList(searchList);
    }

    /**
     * Durchsucht die Artikelliste anhand des Namens und gibt eine Liste der
     * Artikel zurück
     *
     * @param name Name des Artikels
     *
     * @return {@link Articlelist searchlist}
     *
     * @throws IllegalArgumentException <ul><li>wenn Name null ist</li><li>wenn
     *                                  name leer ist</li><li>wenn der name nicht dem Schema entspricht</li><ul>
     */
    public ArticleList getArticlesByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name was null");
        }
        name = name.trim().toLowerCase();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        List<ConcreteArticle> searchList = new ArrayList<ConcreteArticle>();

        /*
         * Ermöglicht das Suchen von Stichwörtern wie "Stuhl" Sodass alle Stühle
         * gefunden werden und nicht der GrüneStuhl draußen bleibt
         */
        Pattern pattern = Pattern.compile("\\.*" + name + "\\.*");

        for (ConcreteArticle article : articles) {
            if (pattern.matcher(article.getArticle().getName().toLowerCase()).matches()) {
                searchList.add(article);
            }
        }
        return new ArticleList(searchList);
    }

    /**
     * Durchsucht die Artikelliste nach einem Material und wirft eine Liste aus
     *
     * @param material Material des Artikels
     *
     * @return {@link ArticleList}
     */
    public ArticleList getArticlesByMaterial(int material) {
        List<ConcreteArticle> searchList = new ArrayList<ConcreteArticle>();

        for (ConcreteArticle article : articles) {
            if (article.getArticle().getMaterial() == material) {
                searchList.add(article);
            }
        }

        return new ArticleList(searchList);
    }

    /**
     * Preis wird um eine Lower und eine UpperBound ergänzt um Preisabschnitte
     * suchen zu können wird die Grenze falsch gewählt gibt das System eine
     * Fehlermeldung aus. Alle Preise größer etwas können durch die Suche nach
     * der oberen Grenze unendlich getätigt werden.
     *
     * @param lowerBound obere Grenze des Preises
     * @param upperBound untere Grenze des Preises
     *
     * @return {@link ArticleList}
     *
     * @throws IllegalArgumentException <ul><li>wenn untere Schranke falsch
     *                                  ist</li><li>wenn oberer Schranke falsch ist</li><ul>
     */
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

    /**
     * Erzeugt eine Arraylist bestehend aus Articles
     *
     * @return {@link List<Concrete Article>}
     */
    public List<ConcreteArticle> toList() {
        return new ArrayList<ConcreteArticle>(articles);
    }
}
