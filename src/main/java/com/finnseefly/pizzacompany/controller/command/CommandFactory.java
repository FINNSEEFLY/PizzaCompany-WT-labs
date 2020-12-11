package com.finnseefly.pizzacompany.controller.command;

import com.finnseefly.pizzacompany.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private Map<String, Command> commands = new HashMap<>();
    public final String PARAMETER_COMMAND = "command";
    public final String goToMainCommand = "go_to_main";
    public final String goToContactsCommand = "go_to_contacts";
    public final String goToLoginCommand = "go_to_login";
    public final String goToRegisterCommand = "go_to_register";
    public final String goToCartCommand = "go_to_cart";
    public final String goToCabinetCommand = "go_to_cabinet";
    public final String logOutCommand = "log_out";

    public CommandFactory() {
        commands.put(goToMainCommand, new GoToMainCommand());
        commands.put(goToContactsCommand, new GoToContactsCommand());
        commands.put(goToLoginCommand, new GoToLoginCommand());
        commands.put(goToRegisterCommand, new GoToRegisterCommand());
        commands.put(goToCartCommand, new GoToCartCommand());
        commands.put(goToCabinetCommand, new GoToCabinetCommand());
        commands.put(logOutCommand, new LogOutCommand());
    }

    public String getPARAMETER_COMMAND() {
        return PARAMETER_COMMAND;
    }

    public String getGoToMainCommand() {
        return goToMainCommand;
    }

    public String getGoToContactsCommand() {
        return goToContactsCommand;
    }

    public String getGoToLoginCommand() {
        return goToLoginCommand;
    }

    public String getGoToRegisterCommand() {
        return goToRegisterCommand;
    }

    public String getGoToCartCommand() {
        return goToCartCommand;
    }

    public String getGoToCabinetCommand() {
        return goToCabinetCommand;
    }

    public String getLogOutCommand() {
        return logOutCommand;
    }

    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }

}
