package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Karuchkin, group prpp2");

        TransportCard empty = new TransportCard();
        System.out.println("1) " + empty.getOwner() + " / " + empty.getBalance());

        TransportCard a = new TransportCard("Ivanov", 300);
        System.out.println("2) " + a.getOwner() + " / " + a.getBalance());

        TransportCard bad = new TransportCard("Petrov", -50);
        System.out.println("3) " + bad.getOwner() + " / " + bad.getBalance());

        a.topUp(0);
        a.topUp(-100);
        System.out.println("4) " + a.getBalance());

        a.topUp(200);
        System.out.println("5) " + a.getBalance());

        System.out.println("6) " + a.isPremium());

        boolean p1 = a.pay(35);
        boolean p2 = a.pay(35);
        boolean p3 = a.pay(40);
        System.out.println("7) " + p1 + " " + p2 + " " + p3);

        System.out.println("8) " + a.getBalance() + " " + a.getTrips() + " " + a.getSpent());

        System.out.println("9) " + a.getAverageFare());

        System.out.println("10) " + a.isPremium());

        boolean p4 = a.pay(1000);
        System.out.println("11) " + p4 + " " + a.getBalance() + " " + a.getTrips());

        boolean p5 = a.pay(0);
        System.out.println("12) " + p5 + " " + a.getTrips());

        System.out.println("13) " + empty.getAverageFare());

        TransportCard b = a;
        b.topUp(110);
        System.out.println("14) " + a.getBalance() + " " + b.getBalance());

        TransportCard c = new TransportCard(a);
        c.topUp(1000);
        System.out.println("15) " + a.getBalance() + " " + c.getBalance());

        System.out.println("16) " + a.isPremium() + " " + c.getTrips());
    }
}
