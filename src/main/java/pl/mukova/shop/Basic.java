package pl.mukova.shop;

import java.util.List;

public interface Basic {

    List<Product> getStartProduct();
    List<Product> getPlusProduct();
    List<Product> getProProduct();
    void sumPrices();
}
