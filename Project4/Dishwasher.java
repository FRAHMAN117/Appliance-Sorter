/**
 * @author Fahmin Rahman
 * 
 * The dishwasher class is used to create the dishwasher object with 
 * properities unique to the dishwasher elements
 */

public class Dishwasher extends Appliance {
   /**
     * private instances is used to maked the vairblae only 
     * assible. as it is only needed for the dishwasher elements, it doesn't 
     * need to be protected
     * price is used for the second column 
     * undercounter is used for third column
     */
    private double price;
    private boolean undercounter;

    /**
     *  This is used to create a constuctuor for dishwasher in the format shown in file for better structure.
     *
     * @param serialNumber is used for the first columns.  it is superred as it is shared in appliance class
     * and is common to the other types of elements in txt file.
     * 
     * @param price sets price to itself using this method
     * @param undercounter sets undercover to itself using this method
     */
    
    public Dishwasher(String serialNumber, double price, boolean undercounter){
        super(serialNumber);
        this.price=price;
        this.undercounter= undercounter;
        //this.undercounter= undercounter;
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
     * set method is used for converting elements into distinctable ones
     * @return the undercover variable
     */
    public boolean getUndercounter(){
        return undercounter;
    }

    /**
     * the toString method act like the print method for the class. the purpose of the tostring method
     * is to make the elements thsat needs to be seen on the screen and convert to string.
     * the return is formmated in a way so that the text are strctured in a way that will show up in the GUI
     */
   
    @Override
    public String toString() {
      return "Dishwasher- SerialNumber: "+ serialNumber +",  Price: $ "+ getPrice()+", Undercounter: "+undercounter;
    }
}
