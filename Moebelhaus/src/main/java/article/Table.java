package article;

public class Table extends Article {

    private boolean pullOut;
    private int categorie;

    public Table(long articleId, String name, float price,
            int material, boolean pullOut, int categorie) {
        super(articleId, name, price, material);
        this.categorie = categorie;
        this.pullOut = pullOut;
    }

    public boolean getPullOut() {
        return this.pullOut;
    }

    public int getCategorie() {
        return this.categorie;
    }
}