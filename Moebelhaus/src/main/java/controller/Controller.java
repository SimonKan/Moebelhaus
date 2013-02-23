/*
 * Controller.java
 *
 * Created on 20.02.2013, 22:06:11
 */
package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import main.Model;

/**
 *
 *
 * @ Simon
 *
 */
public abstract class Controller {

    public static final int EXIT = 0;
    public static final int ABORT = 1;
    public static final int FAILURE = 2;
    public static final int SUCCESS = 3;
    protected final Scanner input;
    protected final Model model;
    private int offset;

    public Controller(Model model) {
        if (model == null) {
            throw new IllegalArgumentException("model was null");
        }
        this.model = model;
        this.offset = 0;
        input = new Scanner(new BufferedReader(
            new InputStreamReader(System.in)));
    }

    public abstract String getName();

    public abstract String getToken();

    public int execute(int offset) {
        this.offset = offset;
        showMenu();
        int result = read();
        this.offset = 0;
        return result;
    }

    protected int getOffset() {
        return offset;
    }

    public abstract void showMenu();

    protected abstract int read();

    protected void print(String s) {
        String hash = "";
        for (int i = 0; i < offset; i++) {
            hash += "#";
        }
        System.out.print(hash);
        System.out.print((offset <= 0 ? "" : " ") + s);
    }

    protected void println(String s) {
        print(s + "\n");
    }
}
