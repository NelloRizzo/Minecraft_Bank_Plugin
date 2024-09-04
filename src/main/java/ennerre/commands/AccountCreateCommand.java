package ennerre.commands;

import ennerre.accounts.Account;
import ennerre.accounts.AccountManager;
import org.bukkit.command.CommandSender;

import java.util.List;

public class AccountCreateCommand implements CommandHandler {
    private final AccountManager accounts = new AccountManager();

    @Override
    public boolean canHandle(String command) {
        return command.equalsIgnoreCase("apri");
    }

    @Override
    public boolean handle(CommandSender sender, String command, List<String> params) {
        accounts.createAccount(sender.getServer().getPlayer(sender.getName()));
        return true;
    }

    @Override
    public String help() {
        return "apri\n\tcrea un nuovo conto corrente associato all'utente";
    }
}
