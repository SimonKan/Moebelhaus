/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Article;

/**
 *
 * @author Simon
 */
public abstract class Article {
    
    private long articleID;
    private long uniqueID;
    private String name;
    private float price;
    private int storage; 
    private int material;
    
    
    public long getUniqueID()
    {
    return this.uniqueID;
}
    public long getArticleID(){
        return this.articleID;
    }
    public String getName(){
        return this.name;
    }
    public float getPrice()
    {
        return this.price;
    }
    
}
