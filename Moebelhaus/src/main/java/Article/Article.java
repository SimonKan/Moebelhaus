package Article;

public abstract class Article {

	private long uniqueId;
	private long articleId;
	private String name;
	private float price;
	private int material;

	public long getUniqueId() {
		return this.uniqueId;
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