package com.polystorage.helper;

import java.text.DecimalFormat;

public class ProcessString {

    private static DecimalFormat formatter = new DecimalFormat("###,###,###.00");

    public static String toVietnamMoney(double money) {
        return formatter.format(money);
    }

    public static String toVietnamMoney(String money) {
        return formatter.format(money);
    }
    
    public static String toVietnamMoney(float money) {
        return formatter.format(money);
    }
}
