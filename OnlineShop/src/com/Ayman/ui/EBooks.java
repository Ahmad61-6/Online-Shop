package com.Ayman.ui;
import com.Ayman.bo.ProductBO;
import com.Ayman.util.Factory;
import com.Ayman.util.TakeInput;
public class EBooks implements UICategory{
    @Override
    public void category() {
        String categories[] = { "Navels", "Fiction Book", "EBooks" };
        Factory.getStyle().printMenu("Books", categories, false);
        int choice = TakeInput.takeChoice(categories.length);
        ProductBO productBO = Factory.getProductBO();
        switch (choice) {
            case 1:
                UI.printSubCategory(productBO.getNovelBooks(), "NOVELS");
                break;
            case 2:
                UI.printSubCategory(productBO.getFictionBooks(), "FICTION BOOKS");
                break;
            case 3:
                UI.printSubCategory(productBO.getEBooks(), "EBOOKS");
                break;
        }
    }
}
