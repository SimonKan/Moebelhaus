/*
 * StatisticsNavigator.java
 *
 * Created on 24.02.2013, 18:05:17
 */
package controller.statistics;

import controller.Navigator;
import main.Model;

/**
 *
 *
 * @author Simon
 * @since 24.02.2013
 * @version 1.0.0
 *
 */
public class StatisticsNavigator extends Navigator {

    public StatisticsNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Statistik";
    }

    @Override
    public String getToken() {
        return "stats";
    }
}
