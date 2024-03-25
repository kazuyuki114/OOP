public class Aims {
    public static void main(String[] args){
        Cart cart = new Cart();
        DigitalVideoDisc disc1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers",87,19.95f);
        DigitalVideoDisc disc2 = new DigitalVideoDisc("Star Wars","Science Fiction", "George Lucas",87,24.95f);
        DigitalVideoDisc disc3 = new DigitalVideoDisc("Aladin","Animation", 18.99f);
        cart.addDigitalVideoDisc(disc1);
        cart.addDigitalVideoDisc(disc2);
        cart.addDigitalVideoDisc(disc3);
        System.out.println(cart.totalCost());
        cart.removeDigitalVideoDisc(disc1);
        System.out.println(cart.totalCost());
        cart.removeDigitalVideoDisc(disc1);

    }
}
