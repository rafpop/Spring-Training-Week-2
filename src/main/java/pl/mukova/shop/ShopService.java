package pl.mukova.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ShopService {

    private List<Double> randomPrices;
    private List<Double> randomPricesWithTaxes;
    private List<Double> randomPricesWithTaxesAndDiscounts;
    private Double price;

    @Value("${tax-info.tax}")
    private double tax;
    @Value("${discount-info.discount}")
    private double discount;

    public List<Double> generateRandomPrices() {
        randomPrices = new ArrayList<>();
        randomPrices.add(ThreadLocalRandom.current().nextDouble(50, 300));
        randomPrices.add(ThreadLocalRandom.current().nextDouble(50,300));
        randomPrices.add(ThreadLocalRandom.current().nextDouble(50, 300));
        randomPrices.add(ThreadLocalRandom.current().nextDouble(50, 300));
        randomPrices.add(ThreadLocalRandom.current().nextDouble(50, 300));
        return randomPrices;
        }

        public List<Double> getPricesWithTaxes() {
            randomPricesWithTaxes = new ArrayList<>();

            for (int i = 0; i < randomPrices.size() ; i++) {
                price = (randomPrices.get(i) * tax) + randomPrices.get(i);
                randomPricesWithTaxes.add(price);
            }
            return randomPricesWithTaxes;
        }

        public List<Double> getPricesWithTaxesAndDiscounts() {
            randomPricesWithTaxesAndDiscounts = new ArrayList();

            for (int i = 0; i < randomPricesWithTaxes.size(); i++) {
                price = randomPricesWithTaxes.get(i) - (randomPricesWithTaxes.get(i) * discount);
                randomPricesWithTaxesAndDiscounts.add(price);
            }
            return randomPricesWithTaxesAndDiscounts;
        }

    public List<Double> getRandomPrices() {
        return randomPrices;
    }
}

