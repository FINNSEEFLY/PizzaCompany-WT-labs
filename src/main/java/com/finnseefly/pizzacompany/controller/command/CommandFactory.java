package com.finnseefly.pizzacompany.controller.command;

import com.finnseefly.pizzacompany.controller.command.impl.GoToMainCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private Map<String, Command> commands = new HashMap<>();
    public final String goToMainCommand = "go_to_main";

    public CommandFactory() {
        commands.put(goToMainCommand, new GoToMainCommand());
        //TODO Команды
    }

    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
