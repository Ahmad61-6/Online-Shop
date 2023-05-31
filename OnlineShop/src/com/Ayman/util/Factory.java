package com.Ayman.util;
import com.Ayman.bo.CartBO;
import com.Ayman.bo.ProductBO;


public class Factory {
    private static Style style = new Style();
    private static final String SHOP_NAME = "𝐖𝐄𝐋𝐂𝐎𝐌𝐄 𝐓𝐎 𝐒𝐇𝐎𝐏𝐏𝐈𝐍𝐆";
    private static CartBO cartBO = new CartBO();
    private static ProductBO productBO = new ProductBO();

    public static Style getStyle() {
        return style;
    }

    public static String getShopName() {
        return String.format("%-41s", SHOP_NAME);
    }

    public static CartBO getCartBO() {
        return cartBO;
    }

    public static ProductBO getProductBO() {
        return productBO;
    }

}
