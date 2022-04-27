package org.fundacionjala.devops.bootcamp.Movement;

import org.fundacionjala.devops.bootcamp.Model.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private List<Menu> menus;
    public MenuManager() {
        this.menus = new ArrayList<>();
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public MenuManager add(String name, Command command,int code){
        menus.add((new Menu(name,command,code)));
        return this;
    }
    public List<Menu> build(){
        return menus;
    }
}
