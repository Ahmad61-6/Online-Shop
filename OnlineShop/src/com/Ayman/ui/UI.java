package com.Ayman.ui;
import java.util.ArrayList;

import com.Ayman.Cart;
import com.Ayman.User;
import com.Ayman.bo.CartBO;
import com.Ayman.product.Product;
import com.Ayman.util.Factory;
import com.Ayman.util.Style;
import com.Ayman.util.TakeInput;

public class UI {

        private User user;
        private Style style = Factory.getStyle();

        public void login() {
            style.printName(Factory.getShopName());
            user = new User();
            user.setName(TakeInput.takeString("Enter name : ", "(([A-Za-z.\\s]).{2,21}([A-Za-z]$))", "name : ", false));
            user.setMobileNo(
                    TakeInput.takeString("Enter your Mobile number(11digit):+88", "([0-9]).{10}", "mobile number: ", false));
            mainPage();
        }

        public void mainPage() {
            String categories[] = { "Electronics", "TVs & Appliances", "Men", "Women", "Books", "View Cart",
                    "Remove Cart" };
            style.printName(Factory.getShopName());
            style.printName(user.getName());
            UICategory ui;
            CartUI cartUI = new CartUI();
            while (true) {
                Factory.getStyle().printMenu("CATEGORIES", categories, true);
                int choice = TakeInput.takeChoice(categories.length) - 1;
                switch (choice) {
                    case 5:
                        cartUI.viewCart();
                        break;
                    case 6:
                        cartUI.removeCart();
                        break;
                    default:
                        ui = UIFactory.getUI(categories[choice]);
                        ui.category();
                        break;
                }
            }
        }

        public static void printSubCategory(ArrayList<Product> list, String categoryName) {
            Style style = Factory.getStyle();
            CartBO cartBO = Factory.getCartBO();
            style.printMenu(categoryName, list);
            int choice = TakeInput.takeChoice(list.size()) - 1;
            cartBO.add(new Cart(cartBO.getNextId(), list.get(choice).getName(), list.get(choice).getPrice(),
                    TakeInput.takeInt(0, "Enter the Quantity : ", "", "")));
            style.successMsg("Item Added to Cart");
        }
    }
