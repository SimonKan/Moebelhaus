/*
 * StatisticsNavigator.java
 *
 * Created on 24.02.2013, 18:05:17
 */
package controller.statistics;

import controller.Navigator;
import main.Model;

/**
 *TODO
 *
 * @author Simon
 * @since 24.02.2013
 * @version 1.0.0
 *
 */
public class StatisticsTopNavigator extends Navigator {
    
    private final int amount;

    public StatisticsTopNavigator(Model model, int amount) {
        super(model);
        this.amount = amount;
    }

    @Override
    public String getName() {
        return "Top " + amount;
    }

    @Override
    public String getToken() {
        return "top";
    }
}
