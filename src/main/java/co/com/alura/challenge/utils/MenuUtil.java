package co.com.alura.challenge.utils;

import co.com.alura.challenge.config.AppConfig;
import co.com.alura.challenge.services.IApiConsumptionService;
import co.com.alura.challenge.services.implementations.ApiConsumptionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.io.IOException;


public class MenuUtil {
    public static void showMenu() throws IOException, InterruptedException {
        JOptionPane.showMessageDialog(null, "Welcome to the currency converter!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int optionMenu() {
        return Integer.parseInt(JOptionPane.showInputDialog(null, """
                1. Convert USD to COP
                2. Convert COP to USD
                3. Convert USD to EUR
                4. Convert EUR to USD
                5. Convert USD to ARS
                6. Convert ARS to USD
                7. Exit
                """, "Principal Menu", JOptionPane.INFORMATION_MESSAGE));
    }
}
