package org.kaelbastos;

import org.kaelbastos.view.CLI.*;

/**
 * This is the code, enjoy it.
 *
 *
 * Do or do not, there is no try... Master Yoda.
 */
public class App {
    public static void main(String[] args) {
        ServiceCLI.run();
        ClientCLI.run();
        WorkerCLI.run();
        ProductCLI.run();
    }
}