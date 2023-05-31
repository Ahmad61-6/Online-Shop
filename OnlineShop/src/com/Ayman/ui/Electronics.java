package com.Ayman.ui;
import com.Ayman.bo.ProductBO;
import com.Ayman.util.Factory;
import com.Ayman.util.TakeInput;

public class Electronics implements UICategory{
    @Override
    public void category() {
        String categories[] = { "Laptops", "Mobiles", "Headphones", "Camera" };
        Factory.getStyle().printMenu("ELECTRONICS", categories, false);
        int choice = TakeInput.takeChoice(categories.length);
        ProductBO productBO = Factory.getProductBO();
        switch (choice) {
            case 1:
                UI.printSubCategory(productBO.getLaptops(), "LAPTOPS");
                break;
            case 2:
                UI.printSubCategory(productBO.getMobiles(), "MOBILES");
                break;
            case 3:
                UI.printSubCategory(productBO.getHeadphones(), "HEADPHONES");
                break;
            case 4:
                UI.printSubCategory(productBO.getCamera(), "CAMERA");
                break;
        }
    }
}
