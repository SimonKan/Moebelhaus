/*
 * Controller.java
 *
 * Created on 20.02.2013, 22:06:11
 */
package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.Model;
import main.Model;

/**
 *
 *
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 20.02.2013
 * @version 1.0.0
 *
 */
public abstract class Controller {

    public static final int ABORT = 1;
    public static final int EXIT = 0;
    public static final int FAILURE = 2;
    public static final int SUCCESS = 3;
    protected final List<Controller> controllers;
    protected final Scanner input;
    private int offset;
    private final Model model;

    public Controller(Model model) {
        if (model == null) {
            throw new IllegalArgumentException("model was null");
        }
        this.model = model;
        this.offset = 0;
        controllers = new ArrayList<>();
        input = new Scanner(new BufferedReader(
            new InputStreamReader(System.in)));
    }

    public abstract String getToken();

    public void add(Controller c) {
        if (!controllers.contains(c)) {
            controllers.add(c);
        }
    }

    public void remove(Controller c) {
        controllers.remove(c);
    }

    public int execute(int offset) {
        this.offset = offset;
        // TODO introduce skippen um commands pipen zu können
        introduce();
        int result = read();
        this.offset = 0;
        return result;
    }

    protected Model getModel() {
        return model;
    }

    protected int getOffset() {
        return offset;
    }

    protected abstract void introduce();

    protected abstract int read();

    protected void print(String s) {
        for (int i = 0; i < offset; i++) {
            System.out.print("#");
        }
        System.out.print((offset <= 0 ? "" : " ") + s);
    }

    protected void println(String s) {
        print(s + "\n");
    }

    @Override
    public int hashCode() {
        return getToken().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj.getClass() == this.getClass())) {
            return false;
        }
        final Controller other = (Controller) obj;
        return this.getToken().equals(other.getToken());
    }
}
