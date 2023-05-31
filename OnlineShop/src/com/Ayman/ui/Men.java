package com.Ayman.ui;
import com.Ayman.bo.ProductBO;
import com.Ayman.util.Factory;
import com.Ayman.util.TakeInput;
public class Men implements UICategory {
    @Override
    public void category() {
        String categories[] = { "T-Shirts", "Shirts", "Suits & Blazers" };
        Factory.getStyle().printMenu("Men", categories, false);
        int choice = TakeInput.takeChoice(categories.length);
        ProductBO productBO = Factory.getProductBO();
        switch (choice) {
            case 1:
                UI.printSubCategory(productBO.getTshirts(), "T-Shirts");
                break;
            case 2:
                UI.printSubCategory(productBO.getShirts(), "Shirts");
                break;
            case 3:
                UI.printSubCategory(productBO.getSuits(), "Suits & Blazers");
                break;
        }
    }
}
