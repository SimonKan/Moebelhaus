package article;

public abstract class Article {
  
    private long articleId;
    private String name;
    private float price;
    private int material;

    public Article(long articleId, String name, float price,
            int material) {

        this.articleId = articleId;
        this.name = name;
        this.price = price;
        this.material = material;
    }

    public long getArticleId() {
        return this.articleId;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

    public int getMaterial() {
        return this.material;
    }
}