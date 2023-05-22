public class Lot {
    private int lotNumber;
    private String description;
    private int currentBid;
    private int bidIncrement;
    private boolean sold;

    private static int lotCount = 1001;

    public Lot(){
        lotNumber = lotCount++;
        description = "Unknown Item";
        currentBid = 0;
        bidIncrement = 0;
        sold = false;
    }
    public Lot(String desc, int cBid, int bidInc){
        lotNumber = lotCount++;
        description = desc;
        currentBid = cBid;
        bidIncrement = bidInc;
        sold = false;
    }
    public void markSold(){
        sold = true;
    }
    public boolean get_sold(){
        return sold;
    }
    public int get_bidIncrement(){
        return bidIncrement;
    }
    public String get_description(){
        return description;
    }

    public void set_currentBid(int i){
        currentBid = i;
    }

    public int nextBid(){
        int nextBid = currentBid + bidIncrement;
        return nextBid;
    }
    @Override
    public String toString() {
        String override = "";
        if(sold == true) {
            override = "Lot " +
                    lotNumber +
                    ". " +
                    description +
                    " was sold for $" +
                    currentBid;
        } else if(sold == false) {
            override = "Lot " +
                    lotNumber +
                    ". " +
                    description +
                    " current bid: $" +
                    currentBid +
                    " minimum bid: $" +
                    nextBid();
        }
        return override;
    }

}
