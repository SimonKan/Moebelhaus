package controller;

import main.Model;

/**
 *
 * @author Simon
 */
public abstract class Navigator extends Controller {
    
    public Navigator(Model model) {
        super(model);
    }

    @Override
    protected int read() {
        int result = FAILURE;
        do {
            String in = input.next();
            if ("abort".equals(in)) {
                return ABORT;
            }
            if ("exit".equals(in)) {
                return EXIT;
            }
            for (Controller c : controllers) {
                if (in.equals(c.getToken())) {
                    result = SUCCESS;
                    int successor = c.execute(getOffset() + 1);

                    if (successor == EXIT) {
                        return EXIT;
                    }
                    if (successor == FAILURE) {
                        throw new IllegalStateException(
                            "cannot return with FAILURE");
                    }
                    return result;
                }
            }
        } while (result == FAILURE);
        return result;
    }
}