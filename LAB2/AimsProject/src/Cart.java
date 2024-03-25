public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20; // Define the maxinum items a user can order
    private DigitalVideoDisc[] itemOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED]; // Array of discs
    public int currentItems = 0; // Give the index of the last item the user has ordered
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
        if (currentItems > 0) {
            int index = -1;
            for (int i = 0; i < currentItems; i++) {
                if (disc.equals(itemOrdered[i])) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                for (int i = index + 1; i < currentItems; i++) {
                    itemOrdered[i - 1] = itemOrdered[i];
                }
                itemOrdered[currentItems] = null;
                currentItems--;
            } else {
                System.out.println("Don't found the given disc!");
            }
        } else {
            System.out.println("The cart is empty!");
        }
    }
    public float totalCost(){
        float totalCost = 0;
        for (int i = 0; i < currentItems; i++){
            totalCost += itemOrdered[i].getCost();
        }
        return totalCost;
    }
}
