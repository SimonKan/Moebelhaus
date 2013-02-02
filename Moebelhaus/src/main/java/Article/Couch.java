package Article;

import Article.Article;

public class Couch extends Article {

	private boolean coner;
	private boolean pullOut;

	public boolean getCorner() {
		throw new UnsupportedOperationException();
	}

	public boolean getPullOut() {
		return this.pullOut;
	}

}