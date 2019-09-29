package pl.mukova.shop;

public class Product {

    private String productName;
    private Double price, priceWithVat, priceWithVatAndDiscount;


    public Product(String productName, Double price) {
        this.productName = productName;
        this.price = price;
    }

    public Product(String productName, Double price, Double priceWithVat) {
        this.productName = productName;
        this.price = price;
        this.priceWithVat = priceWithVat;
    }

    public Product(String productName, Double price, Double priceWithVat, Double priceWithVatAndDiscount) {
        this.productName = productName;
        this.price = price;
        this.priceWithVat = priceWithVat;
        this.priceWithVatAndDiscount = priceWithVatAndDiscount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPriceWithVat() {
        return priceWithVat;
    }

    public void setPriceWithVat(Double priceWithVat) {
        this.priceWithVat = priceWithVat;
    }

    public Double getPriceWithVatAndDiscount() {
        return priceWithVatAndDiscount;
    }

    public void setPriceWithVatAndDiscount(Double priceWithVatAndDiscount) {
        this.priceWithVatAndDiscount = priceWithVatAndDiscount;
    }

    @Override
    public String toString() {
        if (priceWithVatAndDiscount != null) {
            return "Product{" +
                    "productName='" + productName + '\'' +
                    ", price=" + String.format("%.2f", price) + " PLN" +
                    ", priceWithVat=" + String.format("%.2f", priceWithVat) + " PLN" +
                    ", priceWithVatAndDiscount=" + String.format("%.2f", priceWithVatAndDiscount) + " PLN" +
                    '}';
        } else if (priceWithVat != null) {
            return "Product{" +
                    "productName='" + productName + '\'' +
                    ", price=" + String.format("%.2f", price) + " PLN" +
                    ", priceWithVat=" + String.format("%.2f", priceWithVat) + " PLN" +
                    '}';
        } else {
            return "Product{" +
                    "productName='" + productName + '\'' +
                    ", price=" + String.format("%.2f", price) + " PLN" +
                    '}';
        }
    }
}