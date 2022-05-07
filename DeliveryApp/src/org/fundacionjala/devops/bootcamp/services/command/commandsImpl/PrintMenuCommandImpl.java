package org.fundacionjala.devops.bootcamp.services.command.commandsImpl;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.scanner.impl.MenuCard;
import org.fundacionjala.devops.bootcamp.services.command.Commands;

public class PrintMenuCommandImpl implements Commands {

    private MenuCard menu;
    public PrintMenuCommandImpl (MenuCard menu){
        this.menu=menu;
    }

    @Override
    public void execute() {
        for ( String category : menu.getMenu().keySet()){
            System.out.println("==============================================================================");
            System.out.println(category);
            System.out.println("==============================================================================");
            for (Item in : menu.getMenu().get(category)){
                System.out.println(in.toString());
            }
        }
    }

    @Override
    public int getCommandCode() {
        return 1;
    }

//    public void addFoodToMenu(){
//        scannerClass.add(new Item("Pizza", BigDecimal.valueOf(1.1)));
//        scannerClass.add(new Item("Chicken", BigDecimal.valueOf(1.2)));
//        scannerClass.add(new Item("Hamburger", BigDecimal.valueOf(1.3)));
//        scannerClass.add(new Item("Sandwich", BigDecimal.valueOf(1.4)));
//    }

}