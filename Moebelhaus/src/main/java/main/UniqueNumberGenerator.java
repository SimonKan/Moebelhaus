/*
 * UniqueNumberGenerator.java
 *
 * Created on 02.02.2013, 17:51:13
 */

package main;

/**
 *
 *
 * @author Simon
 * @since 02.02.2013
 * @version 1.0.0
 */
public class UniqueNumberGenerator {
    
    private long number =1;
    
    public long getNextNumber(){
        return number++;
    }

}
