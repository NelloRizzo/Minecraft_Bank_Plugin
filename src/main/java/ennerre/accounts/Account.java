package ennerre.accounts;

import org.bukkit.entity.Player;

import java.math.BigDecimal;

public class Account {
    private final Player player;
    private final String number;
    private BigDecimal funds;

    public Account(Player player, String number, BigDecimal funds) {
        this.player = player;
        this.number = number;
        this.funds = funds;
    }

    public void withdraw(BigDecimal amount) {
        if (funds.compareTo(amount) >= 0)
            funds = funds.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        funds = funds.add(amount);
    }

    public BigDecimal getAmount() {
        return funds;
    }

    public Player getPlayer() {
        return player;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Account{" +
                "player=" + player.getDisplayName() +
                ", number='" + number + '\'' +
                ", funds=" + funds +
                '}';
    }
}
