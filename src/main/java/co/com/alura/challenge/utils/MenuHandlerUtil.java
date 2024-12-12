package co.com.alura.challenge.utils;

import co.com.alura.challenge.config.AppConfig;
import co.com.alura.challenge.models.ExchangeValue;
import co.com.alura.challenge.services.IApiConsumptionService;
import co.com.alura.challenge.services.IConverterService;
import co.com.alura.challenge.services.implementations.ConverterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.io.IOException;


public class MenuHandlerUtil {
    public static void handleMenu() throws IOException, InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IApiConsumptionService apiConsumptionService = context.getBean(IApiConsumptionService.class);
        IConverterService converterService = new ConverterService();

        MenuUtil.showMenu();

        while (true) {
            int option = MenuUtil.optionMenu();

            switch (option) {
                case 1 -> {
                    double usd = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount in USD", "USD to COP", JOptionPane.INFORMATION_MESSAGE));

                    ExchangeValue exchangeValue = converterService.convertApiData(apiConsumptionService.getApiData("USD"));

                    double copRate = Double.parseDouble(exchangeValue.cop());
                    double copAmount = ConverterUtil.convertCurrency(usd, copRate);

                    JOptionPane.showMessageDialog(null, String.format("%.2f USD = %.2f COP", usd, copAmount), "USD to COP", JOptionPane.INFORMATION_MESSAGE);
                }
                case 2 -> {
                    double cop = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount in COP", "COP to USD", JOptionPane.INFORMATION_MESSAGE));

                    ExchangeValue exchangeValue = converterService.convertApiData(apiConsumptionService.getApiData("COP"));

                    double usdRate = Double.parseDouble(exchangeValue.usd());
                    double usdAmount = ConverterUtil.convertCurrency(cop, usdRate);

                    JOptionPane.showMessageDialog(null, String.format("%.2f COP = %.2f USD", cop, usdAmount), "COP to USD", JOptionPane.INFORMATION_MESSAGE);
                }
                case 3 -> {
                    double usd = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount in USD", "USD to EUR", JOptionPane.INFORMATION_MESSAGE));

                    ExchangeValue exchangeValue = converterService.convertApiData(apiConsumptionService.getApiData("USD"));

                    double eurRate = Double.parseDouble(exchangeValue.eur());
                    double eurAmount = ConverterUtil.convertCurrency(usd, eurRate);

                    JOptionPane.showMessageDialog(null, String.format("%.2f USD = %.2f EUR", usd, eurAmount), "USD to EUR", JOptionPane.INFORMATION_MESSAGE);
                }
                case 4 -> {
                    double eur = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount in EUR", "EUR to USD", JOptionPane.INFORMATION_MESSAGE));

                    ExchangeValue exchangeValue = converterService.convertApiData(apiConsumptionService.getApiData("EUR"));

                    double usdRate = Double.parseDouble(exchangeValue.usd());
                    double usdAmount = ConverterUtil.convertCurrency(eur, usdRate);

                    JOptionPane.showMessageDialog(null, String.format("%.2f EUR = %.2f USD", eur, usdAmount), "EUR to USD", JOptionPane.INFORMATION_MESSAGE);
                }
                case 5 -> {
                    double usd = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount in USD", "USD to ARS", JOptionPane.INFORMATION_MESSAGE));

                    ExchangeValue exchangeValue = converterService.convertApiData(apiConsumptionService.getApiData("USD"));

                    double arsRate = Double.parseDouble(exchangeValue.ars());
                    double arsAmount = ConverterUtil.convertCurrency(usd, arsRate);

                    JOptionPane.showMessageDialog(null, String.format("%.2f USD = %.2f ARS", usd, arsAmount), "USD to ARS", JOptionPane.INFORMATION_MESSAGE);
                }
                case 6 -> {
                    double ars = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount in ARS", "ARS to USD", JOptionPane.INFORMATION_MESSAGE));

                    ExchangeValue exchangeValue = converterService.convertApiData(apiConsumptionService.getApiData("ARS"));

                    double usdRate = Double.parseDouble(exchangeValue.usd());
                    double usdAmount = ConverterUtil.convertCurrency(ars, usdRate);

                    JOptionPane.showMessageDialog(null, String.format("%.2f ARS = %.2f USD", ars, usdAmount), "ARS to USD", JOptionPane.INFORMATION_MESSAGE);
                }
                case 7 -> {
                    JOptionPane.showMessageDialog(null, "Exit");
                    break;
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if (option == 7) break;
        }
    }
}
