/*
 * MainNavigator.java
 *
 * Created on 20.02.2013, 22:11:53
 */
package controller;

import main.Model;

/**
 *
 *
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 20.02.2013
 * @version 1.0.0
 *
 */
public class MainNavigator extends Navigator {

    public MainNavigator(Model model) {
        super(model);
    }

    @Override
    public String getToken() {
        return "main";
    }

    @Override
    protected void introduce() {
        println("Willkommen im Möbelhaus Management System.");
        println("Suchen (search)");
    }

    @Override
    protected int read() {
        do {
            String in = input.next();
            if ("exit".equals(in)) {
                return SUCCESS;
            }
            for (Controller c : controllers) {
                if (in.equals(c.getToken())) {
                    int successor = c.execute(getOffset() + 1);
                    if (successor == FAILURE) {
                        throw new IllegalStateException(
                            "cannot return with FAILURE");
                    }
                }
            }
        } while (true);
    }
}
