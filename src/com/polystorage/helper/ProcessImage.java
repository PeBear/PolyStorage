package com.polystorage.helper;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ProcessImage {

    private static String pathAva = System.getProperty("user.dir") + "/src/image/";

    public static void setAvatar(String path, JLabel lblAvatar) {
        ImageIcon imageIcon = new ImageIcon(pathAva + path); //get and set avt 
        Image image = imageIcon.getImage(); //  
        Image newimg = image.getScaledInstance(160, 175, java.awt.Image.SCALE_SMOOTH); // resize ảnh thành 160x175
        imageIcon = new ImageIcon(newimg);  // transform it back        
        lblAvatar.setIcon(imageIcon); //set Avatar vào label.
        lblAvatar.setToolTipText(path);
    }

    public static String getPathAva() {
        return pathAva;
    }

    public static void setPathAva(String pathAva) {
        ProcessImage.pathAva = pathAva;
    }
}
