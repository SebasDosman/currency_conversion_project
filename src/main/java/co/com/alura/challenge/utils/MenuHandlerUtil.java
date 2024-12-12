package co.com.alura.challenge.utils;

import co.com.alura.challenge.config.AppConfig;
import co.com.alura.challenge.models.ExchangeValue;
import co.com.alura.challenge.services.IApiConsumptionService;
import co.com.alura.challenge.services.IConverterService;
import co.com.alura.challenge.services.implementations.ConverterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.io.IOException;
import java.util.function.BiFunction;


public class MenuHandlerUtil {
    private static final IApiConsumptionService apiConsumptionService;
    private static final IConverterService converterService;

    static {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        apiConsumptionService = context.getBean(IApiConsumptionService.class);
        converterService = new ConverterService();
    }

    public static void handleMenu() throws IOException, InterruptedException {
        MenuUtil.showMenu();

        while (true) {
            int option = MenuUtil.optionMenu();

            if (option == 7) {
                JOptionPane.showMessageDialog(null, "Thanks for using!", "Exit", JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            try {
                handleConversion(option);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void handleConversion(int option) throws IOException, InterruptedException {
        switch (option) {
            case 1 -> performConversion("USD", "COP", "Enter the amount in USD", "USD to COP", (amount, rate) -> amount * rate);
            case 2 -> performConversion("COP", "USD", "Enter the amount in COP", "COP to USD", (amount, rate) -> amount * rate);
            case 3 -> performConversion("USD", "EUR", "Enter the amount in USD", "USD to EUR", (amount, rate) -> amount * rate);
            case 4 -> performConversion("EUR", "USD", "Enter the amount in EUR", "EUR to USD", (amount, rate) -> amount * rate);
            case 5 -> performConversion("USD", "ARS", "Enter the amount in USD", "USD to ARS", (amount, rate) -> amount * rate);
            case 6 -> performConversion("ARS", "USD", "Enter the amount in ARS", "ARS to USD", (amount, rate) -> amount * rate);
            default -> JOptionPane.showMessageDialog(null, "Invalid option", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void performConversion(String fromCurrency, String toCurrency, String inputMessage, String dialogTitle, BiFunction<Double, Double, Double> conversionFunction) throws IOException, InterruptedException {
        double amount = Double.parseDouble(JOptionPane.showInputDialog(null, inputMessage, dialogTitle, JOptionPane.INFORMATION_MESSAGE));

        ExchangeValue exchangeValue = converterService.convertApiData(apiConsumptionService.getApiData(fromCurrency));

        double rate = Double.parseDouble(getExchangeRate(exchangeValue, toCurrency));
        double convertedAmount = conversionFunction.apply(amount, rate);

        JOptionPane.showMessageDialog(null, String.format("%.2f %s = %.2f %s", amount, fromCurrency, convertedAmount, toCurrency), dialogTitle, JOptionPane.INFORMATION_MESSAGE);
    }

    private static String getExchangeRate(ExchangeValue exchangeValue, String currency) {
        return switch (currency.toUpperCase()) {
            case "USD" -> exchangeValue.usd();
            case "COP" -> exchangeValue.cop();
            case "EUR" -> exchangeValue.eur();
            case "ARS" -> exchangeValue.ars();
            default -> throw new IllegalArgumentException("Unsupported currency: ".concat(currency));
        };
    }
}