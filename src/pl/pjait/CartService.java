package pl.pjait;

import java.util.*;

public class CartService {


    public Product getCheapestOne(List<Product> products) {
        Product temporaryProduct = new Product();
        for (Product product : products ) {
            if(product.getPrice() <= temporaryProduct.getPrice()) {
                temporaryProduct = product;
            }
        }
        return temporaryProduct;
    }


    public Product getExpensiveOne(List<Product> products) {
        Product temporaryProduct = new Product();
        for (Product product : products ) {
            if(product.getPrice() >= temporaryProduct.getPrice()) {
                temporaryProduct = product;
            }
        }
        return temporaryProduct;

    }

    public List<Product> sortProductsByName(List<Product> products){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return products;
    }

    public List<Product> sortProductsByPrice(List<Product> products){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.valueOf((int) o1.getPrice()).compareTo((int) o2.getPrice());
            }
        });
        return products;
    }

    public double getSumOfCart(Cart cart) {
        double totalPrice = 0;
        for (Product product : cart.getProducts()) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
    public List<Product> getnCheapestOne(List<Product> products, int n) {
        sortProductsByPrice(products);
        List<Product> temporaryList = new ArrayList();
        for (int i = 0; i <= n - 1; i++ ) {
            temporaryList.add(products.get(i));
        }
        return temporaryList;
    }
    public List<Product> getnExpensiveOne(List<Product> products, int n) {
        sortProductsByPrice(products);
        List<Product> temporaryList = new ArrayList();
        for (int i = products.size() - 1; i >= products.size() - n; i-- ) {
            temporaryList.add(products.get(i));
        }
        return temporaryList;
    }


}
