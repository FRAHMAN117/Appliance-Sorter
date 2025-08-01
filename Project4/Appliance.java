
/**
 * @author Fahmin Rahman
 * Project4
 * This is the Abstract class Appliance. The purpose of this class is to set general requirements for all the appliances through a shared class.
 */

public abstract class Appliance implements Comparable<Appliance> {
    
    /**
     * @param serialNumber takes each line in the tex file and is protected so it can be
     * passed to child class while being private
     */
    protected String serialNumber; //intializes the private variable serialNumber
  
    /**
     * the isValid method will be alled to other files. This checks if the serialnumber folloed the format
     * the first letter must br R, D, or M which is followed by 11 capiral letter of digits. 
     * This is a very useful mehtod as it decided if error handing will occur for serialnumber
     * @param serialNumber the constructur serialNumber sets it to itself using this keyword
     * @param relex sets the format that is acceptable which will be compared by the passaed serialNumber.
     */
    public static boolean isValid (String serialNumber){
        String relex= "^[RDM][A-Z0-9]{11}$";
        return serialNumber.matches(relex);
    }

    public Appliance (String serialNumber){
            //calles the !isValid method to set the default serialnumber or else throw ApplianceException
            if (!isValid(serialNumber)){
                throw new IllegalApplianceException("invalid serial number: " + serialNumber);
            }
            this.serialNumber= serialNumber;
    }    
    
  
    /**
     * get method are used for getting the information from the assigned variable
     * @return is used to take the information from the SerialNumber variable and return it
     */
    //gets the SerialNumber variable usgint the get method
    public String getSerialNumber(){
        return serialNumber;
    }
    /**
     * set method is used for converting elements into distinctable ones
     * @param serialNumber sets itself useing the this keyword
     */

     /**
      * The getPrice method is used to isolate the price variable. This is useful because the price is being used to sort using treemap
      * @return
      */
    
    public abstract double getPrice();
    public void setSerialNumber (String serialNumber) {
        //as it finalizes the serialNUmber, the isValid will be called here too.
        if (isValid(serialNumber)){
            this.serialNumber= serialNumber;
        }
        else{
            throw new IllegalApplianceException("invalid serial number: " + serialNumber);
        }
    
    }

    /**
     * the compareTo method is used to check if the current object is equal to the object called. This is used when cases where sorting and 
     * an organizaiton of elements is required
     * @param other refers to the object that will be passed from calling the Appliance method
     * @return is used to return how different is the serial number from current object object from the called object
     */

    @Override
    public int compareTo(Appliance other){
        int compare= this.serialNumber.compareTo(other.serialNumber);
        if (compare !=0){
            return compare;
        }
        
        return Double.compare(this.getPrice(), other.getPrice());
    }
    
    
    /**
     * the boolean method is used to see if any elements called is valid 
     * by checking if the object passed and the current object is equal
     *  @param num represent the object that will be called 
     */
    @Override
    public boolean equals(Object num) { 
        
        /**
         * the if statement checks if the informaiton stored currently is equal to the one
         * passed through object
         * this is used to check if the memories are equal
         */
        if (this== num) {
            return true; //return true if the current object is equals to the object passed using num
        }

        /**
         * this method is important as it prevents comaparing an object that doesnt fit with the appliance class
         * the instanceof is used to check if object is in any subclasses or related class in Appliance
         */
        if (num instanceof Appliance){ //checks if object is instance of Appliance class
            Appliance other= (Appliance) num; //cast object num into Appliance object
            return this.serialNumber.equals(other.serialNumber); //compares serial numbers
        }
        
            return false; //return false if Object num is not an Appliance object
    }
    

    /**
     * the toString method act like the print method for the class. the purpose of the tostring method
     * is to make the elements thsat needs to be seen on the screen and convert to string.
     */

     @Override
    public String toString() {
        return  serialNumber; //returns the indivisual string serial numbers 
    }
}
