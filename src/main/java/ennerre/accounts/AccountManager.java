package ennerre.accounts;

import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountManager {
    private static int ACCOUNT_NUMBER = 1;
    private static final List<Account> accounts = new ArrayList<>();

    public void createAccount(Player player) {
        var number = String.format("%05d", ACCOUNT_NUMBER++);
        var account = new Account(player, number, BigDecimal.ZERO);
        accounts.add(account);
    }

    public List<Account> getAccounts(String playerName) {
        return accounts.stream().filter(a -> a.getPlayer().getDisplayName().equalsIgnoreCase(playerName)).toList();
    }

    public Optional<Account> getAccount(String number){
        return accounts.stream().filter(a -> a.getNumber().equals(number)).findFirst();
    }
}
