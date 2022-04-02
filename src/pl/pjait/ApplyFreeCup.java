package pl.pjait;

public class ApplyFreeCup implements  iCanCalculateSpecialOffer{

    @Override
    public boolean canCalculate(Cart cart) {
        CartService cartService = new CartService();
        return  cartService.getSumOfCart(cart) > 200;
    }

    @Override
    public void calculateOffer(Cart cart) {
        Product freeCup = new Product("000", "Cup", 0, 0);
        cart.AddNewProductToCart(freeCup);

    }
}
