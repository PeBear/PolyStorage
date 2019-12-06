package com.polystorage.helper;

import java.awt.Component;
import javax.swing.JOptionPane;

public class DialogHelper {

    static String title = "Hệ thống quản lý kho";

    public static void showMessageDialog(Component parent, String mess) {
        JOptionPane.showMessageDialog(parent, mess, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(Component parent, String mess) {
        int ok = JOptionPane.showConfirmDialog(parent, mess, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return ok == JOptionPane.YES_OPTION;
    }

}
