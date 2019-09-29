package pl.mukova.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("start")
public class ShopStart implements Basic {

    private List<Product> productList;
    private ShopService shopService;

    @Autowired
    public ShopStart(ShopService shopService) {
        this.shopService = shopService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        shopService.generateRandomPrices();
        System.out.println();

        getStartProduct().forEach(System.out::println);
        sumPrices();
    }

    @Override
    public List<Product> getStartProduct() {
        productList = new ArrayList<>();
        productList.add(new Product("Lemon", shopService.getRandomPrices().get(0)));
        productList.add(new Product("Potato", shopService.getRandomPrices().get(1)));
        productList.add(new Product("Lollipop", shopService.getRandomPrices().get(2)));
        productList.add(new Product("Ice-Cream", shopService.getRandomPrices().get(3)));
        productList.add(new Product("Wine", shopService.getRandomPrices().get(4)));
        return productList;
    }

    @Override
    public List<Product> getPlusProduct() {
        return null;
    }

    @Override
    public List<Product> getProProduct() {
        return null;
    }

    @Override
    public void sumPrices() {
        Double totalPrice = 0.0;

        for (Product product : productList) {
            totalPrice += product.getPrice();
        }
        System.out.println();
        System.out.println("The total price for all products from the Start profile shown above is "
                + String.format("%.2f", totalPrice) + " PLN");
    }
}