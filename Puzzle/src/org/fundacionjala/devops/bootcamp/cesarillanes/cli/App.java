package org.fundacionjala.devops.bootcamp.cesarillanes.cli;

public class App {
    private static final CLIFactory cliFactory = new ConcreteCLIFactory();
    public static void main(String[] args) {
        CLI cli = cliFactory.createCLI();
        cli.startApp();
    }
}
