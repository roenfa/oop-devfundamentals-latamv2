package org.fundacionjala.devops.bootcamp.KevinCardenas.Interfaz;

import org.fundacionjala.devops.bootcamp.KevinCardenas.App.FastReader;
import org.fundacionjala.devops.bootcamp.KevinCardenas.App.IInterfaz;
import org.fundacionjala.devops.bootcamp.KevinCardenas.Movement.Command;
import org.fundacionjala.devops.bootcamp.KevinCardenas.Movement.MenuManager;

public class InterfazImp implements IInterfaz {
    private FastReader _reader;
    private MenuManager _menuManager;


    public InterfazImp(MenuManager menuManager) {
        _reader = new FastReader();
        _menuManager=menuManager;
    }

    @Override
    public void menu() {
        Command command= _menuManager.getMenus().stream().filter(a->a.getName().equals("main")).findFirst().orElseThrow(()->new RuntimeException("Command not found")).getCommand();
        command.execute();
        while (true) {
            int option = _reader.nextInt();
            command=_menuManager.getMenus().stream().filter(a->a.getCode()== option).findFirst().orElseThrow(()-> new RuntimeException("Command not found")).getCommand();
            command.execute();
        }
    }

    @Override
    public FastReader getReader() {
        return _reader;
    }
}
