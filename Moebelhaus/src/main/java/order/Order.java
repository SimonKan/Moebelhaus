package order;

import Article.Article;
import java.util.Date;
import java.util.List;
import java.util.Set;
import order.discount.Discount;

public class Order {

	private long id;
	private List<Article> article;
	private List<Integer> count;
	private float price;
	private Set<Discount> discounts;
	private boolean booked;
	private Date date;
	private Date deliveryDate;
	private float tax;

	public boolean getBooked() {
		return this.booked;
	}

	public float getPrice() {
		return this.price;
	}

	public Set<Article> getArticles() {
		throw new UnsupportedOperationException();
	}

	public long getId() {
		return this.id;
	}

	public float getDate() {
		throw new UnsupportedOperationException();
	}

	public float getDeliveryDate() {
		throw new UnsupportedOperationException();
	}

}