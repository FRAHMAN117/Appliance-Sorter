/**
 * @author Fahmin Rahman
 * The microwave class is used to create the microwave object with 
 * properities unique to the microwave elements
 */

public class  Refrigerator extends Appliance {

     /**
     * private instances is used to maked the vairblae only 
     * assible. as it is only needed for the dishwasher elements, it doesn't 
     * need to be protected
     * price is used for the second column 
     * cubicfeet is used for third column
     */
    private double price;
    private int cubicfeet;

    /**
     * This is used to create a constuctuor for microwave in the format shown in file for better structure.
     * @param serialNumber is super as it is shared in appliance class
     * @param price sets itself
     * @param cubicfeet sets itself
     */

    public Refrigerator( String serialNumber, double price, int cubicfeet) {
        super(serialNumber);
        this.price= price;
        this.cubicfeet= cubicfeet;
    }

     /**
     * get method are used for getting the information from the assigned variable
     * @return used to return price variable
     */
    @Override
    public double getPrice(){
        return price;
    }

   /**
     * used to get the watts
     * @return is used to return cubicfeet
     */

    public int getCubicFeet(){
        return cubicfeet;
    }
    
     /**
      * overide is used to defy traditional tostring structure
     * the toString method act like the print method for the class. the purpose of the tostring method
     * is to make the elements thsat needs to be seen on the screen and convert to string.
     * the return is formmated in a way so that the text are strctured in a way that will show up in the GUI
     */
    @Override
    public String toString() {
        return  "Refrigerator- SerialNumber: " + serialNumber + ", Price: $" + price + ", Feet: " + cubicfeet + " ft^3";
    }
}
