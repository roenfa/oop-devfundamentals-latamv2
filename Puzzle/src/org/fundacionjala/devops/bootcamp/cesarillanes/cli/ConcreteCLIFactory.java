package org.fundacionjala.devops.bootcamp.cesarillanes.cli;

public class ConcreteCLIFactory implements CLIFactory{
    @Override
    public CLI createCLI() {
        return new ConcreteCLI();
    }
}
