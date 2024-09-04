package ennerre;

import ennerre.commands.AccountCreateCommand;
import ennerre.commands.AccountInfoCommand;
import ennerre.commands.CommandHandler;
import ennerre.commands.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Bank extends JavaPlugin {

    @Override
    public void onEnable() {
        var commandManager = new CommandManager()
                .addHandler(new AccountInfoCommand())
                .addHandler(new AccountCreateCommand());
        Objects.requireNonNull(getCommand("bank")).setExecutor(commandManager);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
