package ennerre.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public interface CommandHandler {
    boolean canHandle(String command);
    boolean handle(CommandSender sender, String command, List<String> params);
    String help();
}
