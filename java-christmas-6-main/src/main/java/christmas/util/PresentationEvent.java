package christmas.util;

public class PresentationEvent {
    private static final int amountRestriction = 120000;
    private static final int champagnePrice = 25000;

    public int presentationChampagne(int totalAmount){
        if(totalAmount >= amountRestriction){
            return champagnePrice;
        }
        return 0;
    }
}
