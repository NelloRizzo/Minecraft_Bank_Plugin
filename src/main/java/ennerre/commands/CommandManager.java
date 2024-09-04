package ennerre.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CommandManager implements CommandExecutor {

    private final List<CommandHandler> commands = new ArrayList<>();
    private final Logger logger = Bukkit.getLogger();

    public CommandManager addHandler(CommandHandler handler) {
        commands.add(handler);
        return this;
    }

    public CommandManager removeHandler(CommandHandler handler) {
        commands.remove(handler);
        return this;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String commandStr, String[] params) {
        if (params.length == 0) {
            commandSender.sendMessage("Devi specificare un comando del plug-in. Per un elenco dei comandi disponibili" +
                    " digita /bank help");
            return false;
        }
        if (params[0].equalsIgnoreCase("help")) {
            if (commands.isEmpty())
                commandSender.sendMessage("Attualmente non ci sono comandi disponibili");
            else
                commandSender.sendMessage(commands.stream().map(CommandHandler::help).collect(Collectors.joining("\n")));
        }
        return commands.stream().filter(c -> c.canHandle(params[0]))
                .allMatch(c -> c.handle(commandSender, params[0], Arrays.stream(params).sequential().skip(1).collect(Collectors.toList())));
    }
}
