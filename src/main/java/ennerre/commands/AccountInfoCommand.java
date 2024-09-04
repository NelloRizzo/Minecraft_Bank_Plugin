package ennerre.commands;

import ennerre.accounts.Account;
import ennerre.accounts.AccountManager;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.stream.Collectors;

public class AccountInfoCommand implements CommandHandler {

    private final AccountManager accounts = new AccountManager();

    @Override
    public boolean canHandle(String command) {
        return command.equalsIgnoreCase("info");
    }

    @Override
    public boolean handle(CommandSender sender, String command, List<String> params) {
        var message = params.isEmpty() ?
                accounts.getAccounts(sender.getName()).stream().map(Account::toString).collect(Collectors.joining("\n")) :
                accounts.getAccount(params.getFirst()).toString();
        sender.sendMessage(message);
        return true;
    }

    @Override
    public String help() {
        return """
                info\s
                \tRestituirà l'elenco dei conti correnti associati all'utente
                
                info <numero conto>\s
                \tRestituirà le informazioni sul conto specificato (cinque cifre)""";
    }
}
