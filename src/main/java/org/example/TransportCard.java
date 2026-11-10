package org.example;

public class TransportCard {
    private String owner;
    private int balance;
    private int trips;
    private int spent;

    public TransportCard() {
    }

    public TransportCard(String owner, int balance) {
        this.owner = owner;
        if (balance > 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    public TransportCard(TransportCard other) {
        this.owner = other.owner;
        this.balance = other.balance;
        this.trips = other.trips;
        this.spent = other.spent;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public int getTrips() {
        return trips;
    }

    public int getSpent() {
        return spent;
    }

    public void topUp(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean pay(int fare) {
        if (fare <= 0 || fare > balance) {
            return false;
        }
        balance -= fare;
        spent += fare;
        trips++;
        return true;
    }

    public boolean isPremium() {
        return balance >= 500;
    }

    public int getAverageFare() {
        if (trips == 0) {
            return 0;
        }
        return spent / trips;
    }
}
