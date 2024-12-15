package co.com.alura.challenge;

import co.com.alura.challenge.utils.MenuHandlerUtil;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        try {
            MenuHandlerUtil.handleMenu();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while trying to show the menu: ".concat(e.getMessage()), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}