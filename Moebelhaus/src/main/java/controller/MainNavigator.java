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
    public String getName() {
        return "Main";
    }

    @Override
    public String getToken() {
        return "main";
    }

    @Override
    public void showMenu() {
        println("Willkommen im Möbelhaus Management System.\n");
        println("Von hier aus stehen Ihnen eine Liste von Möglichkeiten zur");
        println("Verfügung.\n");
        println("Zum Auswählen geben Sie entweder die Nummer oder den Befehl ");
        println("in den runden Klammern ein.\n");
        println("Um das Programm zu Beenden, geben Sie 'exit' ein. Um den ");
        println("aktuellen Vorgang abzubrechen, geben Sie 'abort' ein.\n");
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
                super.showMenu();
            } else {
                result = FAILURE;
                println("");
                println("");
                showMenu();
            }
        } while (true);
    }
}
