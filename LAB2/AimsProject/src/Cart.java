public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private  DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public int currentItems = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (currentItems == MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
        }
        else {
            itemOrdered[currentItems] = disc;
            currentItems++;
            System.out.println("The disc has been added");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){

    }
    public float totalCost(){
        float totalCost = 0;
        for (int i = 0; i < currentItems; i++){
            totalCost += itemOrdered[i].getCost();
        }
        return totalCost;
    }
}
