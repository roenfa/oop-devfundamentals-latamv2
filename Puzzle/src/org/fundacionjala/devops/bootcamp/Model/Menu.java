package org.fundacionjala.devops.bootcamp.Model;

import org.fundacionjala.devops.bootcamp.Movement.Command;

public class Menu {
    private String _name;
    private Command _command;
    private int code;

    public Menu(String _name, Command _command, int code) {
        this._name = _name;
        this._command = _command;
        this.code = code;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public Command getCommand() {
        return _command;
    }

    public void setCommand(Command _command) {
        this._command = _command;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
