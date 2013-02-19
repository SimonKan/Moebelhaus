/*
 * UniqueNumberGenerator.java
 *
 * Created on 02.02.2013, 17:51:13
 */
package misc;

/**
 * Der UniqueNumberGenerator generiert die Nummern, die für die Erstellung der
 * Ids benötigt werden. Er kann dabei so eingestellt werden, dass aber ab einer
 * bestimmten Zahl anfängt zu zählen in diesem Fall 1,
 *
 * @author Simon
 * @since 02.02.2013
 * @version 1.0.0
 */
public class UniqueNumberGenerator {

    private long number = 1;

    /**
     * Generiert eine Zahlenreihe
     *
     * @return number
     */
    public long getNextNumber() {
        return number++;
    }
}
