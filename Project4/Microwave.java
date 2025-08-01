/**
 * @author Fahmin Rahman
 * The microwave class is used to create the microwave object with 
 * properities unique to the microwave elements
 */

public class Microwave extends Appliance {
    /**
     * private instances is used to maked the vairblae only 
     * assible. as it is only needed for the dishwasher elements, it doesn't 
     * need to be protected
     * price is used for the second column 
     * watts is used for third column
     */
    private double price;
    private int watts;

    /**
     * This is used to create a constuctuor for microwave in the format shown in file for better structure.
     *
     * @param serialNumber is super as it is shared in appliance class
     * @param price sets itself 
     * @param watts sets itself
     */

    public Microwave(String serialNumber, double price, int watts) {
        super(serialNumber);
        this.price= price;
        this. watts= watts;
    }

    /**
     * get method are used for getting the information from the assigned variable
     * @return used to return price variable
     */

     @Override
    public double getPrice(){
        return this.price;
    }

    /**
     * used to get the watts
     * @return is used to return watts
     */

    public int getWatts(){
        return watts;
    }

    /**
     * the toString method act like the print method for the class. the purpose of the tostring method
     * is to make the elements thsat needs to be seen on the screen and convert to string.
     * the return is formmated in a way so that the text are strctured in a way that will show up in the GUI
     */

    @Override
    public String toString() {
        return  "Microwave- SerialNumber: "+ serialNumber +", Price: $"+ price +", Watts: "+ watts + " J/s";
    }
}
