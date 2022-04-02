package pl.pjait;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Product product1 = new Product("242", "Milk", 3.50, 2.70);

        Product product2 = new Product();
        product2.setCode("123");
        product2.setPrice(250);
        product2.setDiscountPrice(230);
        product2.setName("Kettle");

        Product product3 = new Product("234", "Coffee", 25.0, 22.0);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(new Product("111", "Water", 300, 1.00));
        productList.add(new Product("125", "Beer", 3.0, 2.5));


        Cart cart = new Cart();
        cart.setProducts(productList);

        //System.out.println(cart.toString());

        //System.out.println("Cart After discount: ");

        iCanCalculateSpecialOffer discount300plus = new Discount300Plus();
        iCanCalculateSpecialOffer freeCup = new ApplyFreeCup();
        iCanCalculateSpecialOffer thirdForFree = new ApplyDiscountThirdForFree();

        CartService cartService = new CartService();


        cart.applyDiscount(thirdForFree);
        cart.applyDiscount(discount300plus);
        cart.applyDiscount(freeCup);

        //System.out.println(cart.toString());

        //********************Sorting products by Price ********************

        //cartService.sortProductsByPrice(productList);

        //System.out.println(cart.toString());

        //********************sorting products by name*********************

        //cartService.sortProductsByName(productList);

        //System.out.println(cart.toString());

        int how_many_cheap =3;
        int how_many_exp = 1;

        // Displaying n the cheapest products from product list
        System.out.println(cartService.getnCheapestOne(productList, how_many_cheap));

        // Displaying n most expensive products from product list
        System.out.println(cartService.getnExpensiveOne(productList, how_many_exp));

        //Displaying tax rates
        System.out.println("Stawka VAT: " + InvoicePosition.TAX_5);
        System.out.println("Stawka VAT: " + InvoicePosition.TAX_8);
        System.out.println("Stawka VAT: " + InvoicePosition.TAX_23);

        Product product = new Product("ABC123", "Tv", 1000,00);
        InvoicePosition position = new InvoicePosition(product);


        Invoice invoice = new Invoice();
        invoice.addPosition(position);

        invoice.addPosition(new Product("ABC999", "TV", 1200, 00 ));
        invoice.addPosition(new Product("AAA222","PC",5200,00));

        printoutInvoice(invoice);



    }

    private static void printoutInvoice(Invoice invoice){
        System.out.println("|NAZWA\t|ILOŚĆ\t|CENA NETTO\t|CENA BRUTTO|STAWKA VAT\t|PODATEK|");
        System.out.println("*************************************************************");
        for (InvoicePosition p : invoice.getPositions()){
            System.out.print("|"+ p.getProduct().getName() + "\t\t|");
            System.out.print(p.getCount() + "\t\t|");
            System.out.print(p.getNettoPrice() + "\t\t|");
            System.out.print(p.getGrossPrice() + "\t\t|");
            System.out.print(p.getTax() + "\t\t|");
            System.out.println(p.getTaxValue() + "\t|");
            System.out.println("-------------------------------------------------------------");

        }
    }

}


