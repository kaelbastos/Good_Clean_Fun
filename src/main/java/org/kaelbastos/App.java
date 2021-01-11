package org.kaelbastos;

import org.kaelbastos.view.CLI.*;

import java.io.IOException;

/**
 * This is the code, enjoy it.
 *
 *
 * Do or do not, there is no try... Master Yoda.
 */

public class App {
    public static void main(String[] args) {
        MainCLI.menu();
        //ServiceCLI.menu();
        ClientCLI.menu();
        //WorkerCLI.menu();
        //ProductCLI.menu();
        //ServiceCLI.addService();
    }
}