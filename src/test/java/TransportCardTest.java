package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransportCardTest {

    @Test
    public void defaultConstructorLeavesFieldsEmpty() {
        TransportCard card = new TransportCard();
        assertNull(card.getOwner());
        assertEquals(0, card.getBalance());
        assertEquals(0, card.getTrips());
        assertEquals(0, card.getSpent());
    }

    @Test
    public void constructorRejectsNegativeBalance() {
        TransportCard card = new TransportCard("Ivanov", -50);
        assertEquals("Ivanov", card.getOwner());
        assertEquals(0, card.getBalance());
    }

    @Test
    public void topUpIgnoresNonPositiveAmount() {
        TransportCard card = new TransportCard("Ivanov", 300);
        card.topUp(0);
        card.topUp(-100);
        assertEquals(300, card.getBalance());
    }

    @Test
    public void topUpAddsPositiveAmount() {
        TransportCard card = new TransportCard("Ivanov", 300);
        card.topUp(200);
        assertEquals(500, card.getBalance());
    }

    @Test
    public void isPremiumIsTrueExactlyAt500() {
        TransportCard card1 = new TransportCard("Ivanov", 500);
        TransportCard card2 = new TransportCard("Ivanov", 499);
        assertTrue(card1.isPremium());
        assertFalse(card2.isPremium());
    }

    @Test
    public void payReducesBalanceAndCountsTrip() {
        TransportCard card = new TransportCard("Ivanov", 500);
        boolean result = card.pay(35);
        assertTrue(result);
        assertEquals(465, card.getBalance());
        assertEquals(1, card.getTrips());
        assertEquals(35, card.getSpent());
    }

    @Test
    public void payRejectsAmountGreaterThanBalance() {
        TransportCard card = new TransportCard("Ivanov", 100);
        boolean result = card.pay(1000);
        assertFalse(result);
        assertEquals(100, card.getBalance());
        assertEquals(0, card.getTrips());
    }

    @Test
    public void averageFareUsesIntegerDivision() {
        TransportCard card = new TransportCard("Ivanov", 500);
        card.pay(35);
        card.pay(35);
        card.pay(40);
        assertEquals(36, card.getAverageFare());
    }

    @Test
    public void averageFareIsZeroWithoutTrips() {
        TransportCard card = new TransportCard();
        int result = 0;
        try {
            result = card.getAverageFare();
        } catch (ArithmeticException e) {
            fail();
        }
        assertEquals(0, result);
    }

    @Test
    public void copyConstructorMakesIndependentCopy() {
        TransportCard original = new TransportCard("Ivanov", 300);
        TransportCard copy = new TransportCard(original);
        assertEquals(original.getOwner(), copy.getOwner());
        assertEquals(original.getBalance(), copy.getBalance());

        copy.topUp(1000);
        assertEquals(300, original.getBalance());
        assertEquals(1300, copy.getBalance());
    }
}
