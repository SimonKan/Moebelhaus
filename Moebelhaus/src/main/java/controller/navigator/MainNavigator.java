/*
 * MainNavigator.java
 *
 * Created on 20.02.2013, 22:11:53
 */
package controller.navigator;

import controller.Controller;
import main.Model;

/**
 *
 *
 * @Simon
 *
 */
public class MainNavigator extends Navigator {

    public MainNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Main";
    }

    @Override
    public String getToken() {
        return "main";
    }

    @Override
    public void showMenu() {
        println("Willkommen im Möbelhaus Management System.");
        println("Von hier aus stehen Ihnen eine Liste von Möglichkeiten zur");
        println("Verfügung.");
        println("Zum Auswählen geben Sie entweder die Nummer oder den Befehl ");
        println("in den runden Klammern ein.");
        println("Um das Programm zu Beenden, geben Sie 'exit' ein. Um den ");
        println("aktuellen Vorgang abzubrechen, geben Sie 'abort' ein.");
        println("");
        super.showMenu();
    }

    @Override
    protected int read() {
        int result = FAILURE;
        showMenu();
        do {
            print("Eingabe: ");
            String in = input.next();
            if ("exit".equals(in)) {
                return SUCCESS;
            }
            if ("help".equals(in)) {
                println("");
                println("");
                showMenu();
                continue;
            }
            if (in.matches("\\d+")) {
                println("");
                println("");

                int pos = Integer.parseInt(in);

                result = SUCCESS;
                int successor = controllers.get(pos - 1).execute(getOffset() + 1);

                if (successor == FAILURE) {
                    throw new IllegalStateException(
                        "cannot return with FAILURE");
                }
                if (successor == EXIT) {
                    return EXIT;
                }
            }
            for (Controller c : controllers) {
                if (in.equals(c.getToken())) {
                    println("");
                    println("");

                    result = SUCCESS;
                    int successor = c.execute(getOffset() + 1);

                    if (successor == FAILURE) {
                        throw new IllegalStateException(
                            "cannot return with FAILURE");
                    }
                    if (successor == EXIT) {
                        return SUCCESS;
                    }
                }
            }
            if (result == FAILURE) {
                println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut.");
                println("");
                println("");
            } else {
                result = FAILURE;
                println("");
                println("");
                showMenu();
            }
        } while (true);
    }
}
