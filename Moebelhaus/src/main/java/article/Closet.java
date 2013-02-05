package article;

/**
 * Closet ist eine Unterklasse von Article erweitert diese um zwei Attribute die
 * mit Gettern aufgerufen werden können
 *
 * @author Simon
 */
public class Closet extends Article {

    private int doors;
    private boolean slope;


    /**
     * Konstruktor der Klasse Closet
     * @param articleId
     * @param name
     * @param price
     * @param material
     * @param doors
     * @param slope
     */
    public Closet(long articleId, String name, float price,
                  int material, int doors, boolean slope) {
        super(articleId, name, price, material);
        this.doors = doors;
        this.slope = slope;
    }

    /*
     * Getter Methoden der neuen Attribute
     */
    public int getNumberDoors() {
        return this.doors;
    }

    public boolean getSlope() {
        return this.slope;
    }
}