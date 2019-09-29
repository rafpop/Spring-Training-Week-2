package pl.mukova.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("plus")
public class ShopPlus implements Basic {

    private List<Product> productList;
    private ShopService shopService;

    @Autowired
    public ShopPlus(ShopService shopService) {
        this.shopService = shopService;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        shopService.generateRandomPrices();
        shopService.getPricesWithTaxes();

        System.out.println();
        getPlusProduct().forEach(System.out::println);
        sumPrices();
    }

    @Override
    public List<Product> getStartProduct() {
        return null;
    }

    @Override
    public List<Product> getPlusProduct() {
        productList = new ArrayList<>();
        productList.add(new Product("Lemon", shopService.getRandomPrices().get(0),
                shopService.getPricesWithTaxes().get(0)));
        productList.add(new Product("Potato", shopService.getRandomPrices().get(1),
                shopService.getPricesWithTaxes().get(1)));
        productList.add(new Product("Lollipop", shopService.getRandomPrices().get(2),
                shopService.getPricesWithTaxes().get(2)));
        productList.add(new Product("Ice-Cream", shopService.getRandomPrices().get(3),
                shopService.getPricesWithTaxes().get(3)));
        productList.add(new Product("Wine", shopService.getRandomPrices().get(4),
                shopService.getPricesWithTaxes().get(4)));
        return productList;
    }

    @Override
    public List<Product> getProProduct() {
        return null;
    }

    @Override
    public void sumPrices() {
        Double totalPrice = 0.0;
        Double totalPriceWithVat = 0.0;

        for (Product product: productList) {
            totalPrice += product.getPrice();
        }
            for (Product productWithVat: productList) {
                totalPriceWithVat += productWithVat.getPriceWithVat();
            }
        System.out.println();
        System.out.println("The total price for all products from the Start profile shown above is "
                + String.format("%.2f", totalPrice) + " PLN");
        System.out.println("The total price with Vat for all products from the Plus profile shown above is "
                + String.format("%.2f", totalPriceWithVat) + " PLN");
    }
}
