package hu.beervendingmachine.service;

import java.util.ArrayList;
import java.util.List;

public class PurchaseCalculator {
    private final List<Integer> subTotals;

    public PurchaseCalculator() {
        subTotals = new ArrayList<>();
    }

    public int calculateSubTotal(int price, int quantity) {
        return price * quantity;
    }

    public void addSubTotal(int subTotal) {
        subTotals.add(subTotal);
    }

    public int calculateTotalPrice() {
        int total = 0;

        for (Integer subTotal : subTotals) {
            total += subTotal;
        }

        return total;
    }
}
