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
 * @author Simon <s9imhaff@stud.uni-saarland.de>
 * @since 24.02.2013
 * @version 1.0.0
 *
 */
public class StatisticsTopNavigator extends Navigator {

    public StatisticsTopNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Top";
    }

    @Override
    public String getToken() {
        return "top";
    }
}
