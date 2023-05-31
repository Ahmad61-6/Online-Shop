package com.Ayman.bo;
import com.Ayman.Cart;
import com.Ayman.util.CartArrayList;
import com.Ayman.util.Factory;
import com.Ayman.util.Style;

public class CartBO {
    private CartArrayList carts;

    public CartBO() {
        this.carts = new CartArrayList();
    }

    public void add(Cart cart) {
        carts.add(cart);
    }

    public void remove(int index) {
        resetID(index - 1, carts.remove(index - 1).getId());
    }

    public void removeRange(int from, int to) {
        int id = carts.get(from - 1).getId();
        carts.removeRange(from - 1, to);
        resetID(from - 1, id);
    }

    public void changeQuantity(int index, int quantity) {
        carts.get(index - 1).setQuantity(quantity);
    }

    public int getNextId() {
        return carts.size() + 1;
    }

    public boolean isEmpty() {
        return carts.isEmpty();
    }

    public double display() {
        double totalCost = 0;
        Style style = Factory.getStyle();
        style.cartHeading();
        for (Cart cart : carts) {
            style.cartDetail(cart);
            totalCost += cart.getCost();
        }
        style.printColumn("Bottom");
        return totalCost;
    }

    public void displayBill() {
        Style style = Factory.getStyle();
        style.printTotal(carts.size(), display());
    }

    private void resetID(int index, int id) {
        while (index < carts.size()) {
            carts.get(index++).setId(id++);
        }
    }
}
