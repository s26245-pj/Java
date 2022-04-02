package pl.pjait;

public class InvoicePosition {

    private Product product;
    private int count;
    private double tax = TAX_23;

    public static final double TAX_5 = 0.05;
    public static final double TAX_8 = 0.08;
    public static final double TAX_23 = 0.23;

    public Product getProduct() {
        return product;
    }

    public InvoicePosition(Product product) {
        this.product = product;
        this.count = 1;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getNettoPrice() {
        return product.getPrice() * count;
    }

    public double getGrossPrice(){
        return getNettoPrice() * (1 + tax);
    }

    public double getTaxValue(){
        return getGrossPrice() - getNettoPrice();
    }



}
