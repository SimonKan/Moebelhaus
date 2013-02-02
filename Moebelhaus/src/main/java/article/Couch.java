package article;

public class Couch extends Article {

    private boolean corner;
    private boolean pullOut;

    public Couch(long articleId, String name, float price,
            int material, boolean pullOut, boolean corner) {
        super(articleId, name, price, material);
        this.corner = corner;
        this.pullOut = pullOut;
    }

    public boolean getCorner() {
        return this.corner;
    }

    public boolean getPullOut() {
        return this.pullOut;
    }
}