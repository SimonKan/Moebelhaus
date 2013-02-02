package article;

public class Closet extends Article {

    private int doors;
    private boolean slope;

    public Closet(long articleId, String name, float price,
            int material, int doors, boolean slope) {
        super(articleId, name, price, material);
        this.doors = doors;
        this.slope = slope;
    }

    public int getNumberDoors() {
        return this.doors;
    }

    public boolean getSlope() {
        return this.slope;
    }
}