package controller;

import controller.Controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import main.Model;

/**
 * Oberklasse zum Aufstellen der Navigation durch das Menü.
 * @author Simon
 */
public abstract class Navigator extends Controller {

    protected final List<Controller> controllers;

    public Navigator(Model model) {
        super(model);
        controllers = new ArrayList<>();
    }

    public void add(Controller c) {
        if (!controllers.contains(c)) {
            controllers.add(c);
        }
    }

    public void remove(Controller c) {
        controllers.remove(c);
    }

    @Override
    public void showMenu() {
        for (int i = 0; i < controllers.size(); i++) {
            println("\t" + (i + 1) + ") " + controllers.get(i).getName()
                + " (" + controllers.get(i).getToken() + ")");
        }
        println("");
    }

    @Override
    protected int read() {
        int result = FAILURE;

        do {
            print("Eingabe: ");
            String in = input.nextLine();
            in = in.split("\\s+")[0];

            if ("exit".equals(in)) {
                return EXIT;
            }
            if ("abort".equals(in)) {
                return ABORT;
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
                        return EXIT;
                    }
                }
            }
            if (result == FAILURE) {
                println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut.");
                println("");
                println("");
            }
        } while (result == FAILURE);
        return result;
    }
}
