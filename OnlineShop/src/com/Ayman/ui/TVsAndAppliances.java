package com.Ayman.ui;
import com.Ayman.bo.ProductBO;
import com.Ayman.util.Factory;
import com.Ayman.util.TakeInput;
public class TVsAndAppliances implements UICategory{
    @Override
    public void category() {
        String categories[] = { "Television", "Washing Machines", "Refrigerators", "Air Conditioners", "Microwaves" };
        Factory.getStyle().printMenu("HOME APPLIANCES", categories, false);
        int choice = TakeInput.takeChoice(categories.length);
        ProductBO productBO = Factory.getProductBO();
        switch (choice) {
            case 1:
                UI.printSubCategory(productBO.getTvs(), "Television");
                break;
            case 2:
                UI.printSubCategory(productBO.getwMachines(), "Washing Machines");
                break;
            case 3:
                UI.printSubCategory(productBO.getRefrigerator(), "Refrigerators");
                break;
            case 4:
                UI.printSubCategory(productBO.getAirConditioner(), "Air Conditioners");
                break;
            case 5:
                UI.printSubCategory(productBO.getMicrowaves(), "Microwaves");
                break;
        }
    }
}
