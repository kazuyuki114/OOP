public class Aims {
    public static void main(String[] args){
        Cart cart = new Cart();
        DigitalVideoDisc disc1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers",87,18.95f);
        cart.addDigitalVideoDisc(disc1);
        System.out.println(cart.totalCost());
    }
}
