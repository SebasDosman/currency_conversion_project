package co.com.alura.challenge.models;


public record ExchangeValue(
        String usd,
        String cop,
        String eur,
        String ars
) {
    public static ExchangeValue fromApiResponse(ExchangeRateResponse response) {
        return new ExchangeValue(
                String.valueOf(response.getRate("USD")),
                String.valueOf(response.getRate("COP")),
                String.valueOf(response.getRate("EUR")),
                String.valueOf(response.getRate("ARS"))
        );
    }
}
