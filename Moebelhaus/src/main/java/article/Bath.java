package article;

public class Bath extends Article {

    private boolean bathTub;
    private int numberSink;

    public Bath(long articleId, String name, float price,
            int material, boolean bathTub, int numberSink) {
        super(articleId, name, price, material);
        this.bathTub = bathTub;
        this.numberSink = numberSink;
    }

    public boolean getBathTub() {
        return this.bathTub;
    }

    public int getNumberSink() {
        return this.numberSink;
    }
}