/**
 * @author Fahmin Rahman
 * This java file is responsible for creating a GUI and setting its requirements
 */

import java.io.File;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.awt.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.Comparator;

public class ApplianceGUI extends JFrame {

    /**
     * This initialize the invidiaual treemap for each appliance and text area in the GUI based on the appliance type. The type id double as the data is being sorted by price.
     * as the individual appliaces will be sorted, it needs different treemaps.
     */
    private TreeMap<Double, Refrigerator> refrigerator;
    private TreeMap<Double, Dishwasher> dishwasher;
    private TreeMap<Double, Microwave> microwave;
    private JTextArea rText, dText, mText;

    /**
     * The ApplianGUI class is used to set the external appearence of the GUI such as the size, locaiton as well as create distinct secitons for each 
     * type of appliance
     */
    public ApplianceGUI(){
        /**
         * A Comparator tree is used to implement the general sorting logic in the form of tree map. here, the type is also intialized as double 
         * as the price is the sorting determinor.
         */
        Comparator<Double> comparator= new Comparator<Double>(){
            public int compare(Double obj1, Double obj2){
                return obj1.compareTo(obj2);
            }
        };

        //places comparator into each treemap to put the soritng logic
        refrigerator= new TreeMap<>(comparator);
        dishwasher= new TreeMap<>(comparator);
        microwave= new TreeMap<>(comparator);

        setSize(30000,200); //sets size of the GUI window
        setLocation(200,200); //sets where the GUI will be placed
        setTitle("Appliance"); //Sets title on thw GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE); //this is useful when the user wants to close the GUI window

        
        Container myContainer= getContentPane(); //this tintializes the overal text window of the GUI
        myContainer.setLayout(new GridLayout(1,3)); //sets the categorical size of the contentpane to give a measurable size of text area
        
        //intializes text areas
        rText= new JTextArea();
        dText= new JTextArea();
        mText= new JTextArea();
     
        //
        //adds the different text section to the GUI. top to bottom is similar to left to right.
        myContainer.add(new JScrollPane(rText));
        myContainer.add(new JScrollPane(dText));
        myContainer.add(new JScrollPane(mText));
        

      
        JMenuBar menuBar= new JMenuBar(); //intializes the menubar
        JMenu fileMenu= new JMenu("File"); //intializes the File button
        FileMenuHandler fmh  = new FileMenuHandler(this);

        /**
         * This create the button function Open, Quit, and Search and adds the filemenuhandler with the actionlistener.
         * This will call the filemenuhandler object and search for the string of the button and perform the aciton specified in the class.
         */
        JMenuItem openitem = new JMenuItem("Open"); 
        openitem.addActionListener(fmh);
        //fileMenu.addSeparator();           //add a horizontal separator line
        JMenuItem quititem = new JMenuItem("Quit");       //Quit
        quititem.addActionListener(fmh); //adds what the button will do 
        JMenuItem searchitem= new JMenuItem("Search"); //this creates a joption pane, and called the  ()searchApp function to ask for user input
        searchitem.addActionListener(fmh);

        //adds the buttons  and actions that comes with it to the GUI
        fileMenu.add(openitem);
        fileMenu.addSeparator();
        fileMenu.add(quititem);
        fileMenu.addSeparator();
        fileMenu.add(searchitem);
        menuBar.add(fileMenu);

        setJMenuBar(menuBar); 

        setVisible(true); //sets visible of the GUI
    }

    /**
     * The readFile will take data from the FileHandler and will check which data is valid or not. It'll connect the various exceptions in relation to the GUI.
     * @param Path this is takend fom the file menuhandler, which is the file path of the selected text file
     */
    public void readFile(String Path){
        try{
            TextFileInput ln= new TextFileInput(Path);
            String line= ln.readLine(); //pointer for reading each line
            while (line !=null){ 
                String array[]= line.split(","); //splits each line by the comma to sepearate the different data in each line.
                try{
                    if (array.length <3){
                        throw new IllegalArgumentException("incomplete input: " +line); //is used in case a file data is incomplete
                    }
                    String serialNumber = array[0]; //this array will be used to store the serial number part to check for error handeling
                    if (!Appliance.isValid(serialNumber)){
                        throw new IllegalApplianceException("invalid serial number: " + serialNumber); //called the invalid method to see if the serial Number has all the requirements for a serial number
                    }

            /**
             * after validing the serial number. It'll sort the input from each line and categorieze it to the separate appliance list. While ther treemap is used to sort the indicual price
             * this array sorts the general appliance data by serial number as well as put the three different appliance type into different categories.
             */
                if(serialNumber.charAt(0)=='R'){
                    double price= Double.parseDouble(array[1]);
                    int cubicfeet= Integer.parseInt(array[2]);
                    Refrigerator r= new Refrigerator(serialNumber, price, cubicfeet);
                    refrigerator.put(price,r);
                } else if (serialNumber.charAt(0)=='M'){
                    double price= Double.parseDouble(array[1]);
                    int watts= Integer.parseInt(array[2]);
                    Microwave m= new Microwave(serialNumber, price, watts);
                    microwave.put(price,m);
                
                } else if (serialNumber.charAt(0)=='D'){
                    double price= Double.parseDouble(array[1]);
                    boolean undercounter= array[2].equals("Y");
                    Dishwasher d= new Dishwasher(serialNumber, price, undercounter);
                    dishwasher.put(price,d);
                }
            /**
             * These try and catch block will take any additional errors that comes during the sorting
             */
            } catch (IllegalApplianceException e){
                System.out.println("Invalid Appliance: " + e.getMessage());
            } catch (NumberFormatException e){
                System.out.println("Invalid number: " + line);
            }  catch (IllegalArgumentException e){
                //invalid.add(e.getMessage());
                System.out.println(e.getMessage());
            }
            line = ln.readLine();
        }
            updateGUI(); //will call this method to print the data on the GUI
        } catch (Exception e) {
            System.out.println("Error reading file" + e.getMessage());
        }
    }

    /**
     * This method first takes an input from the user through JOptionPane and placed the input into the list array. It goes through the sort treemap, finding matches that
     * satify both the appliaance type and all the price less than the inputed price value. This method also include exception handeling to check for invalid inputs and outputs.
     */
    public void searchApp(){
        String response= JOptionPane.showInputDialog(null, "Enter appliance type and price in the format (M,3000): ");// asks for input
            if(response !=null){
                String[] list= response.split(","); //split the type and price value input into an array called list. Makes it easier to seach for both type and price matches.
                
                //check to see if the price and type value was properly place in the list
               if (list.length !=2){
                    JOptionPane.showMessageDialog(null, "Invalid Input"); 
                    return;
                }
                String type= list[0].toUpperCase(); //fix edge cases of lower case letters and create a variable for the type input
                double price2; //intialize variable to specify the cutoff price from the list

                /**
                 * this try and block is used to check if the price input is a valid number or formatted correctly
                 */
                try{
                    price2= Double.parseDouble(list[1]);
                } catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "invalid price");
                    return;
                }
                String result=""; //insitalize result variable used to store the 
                /**
                 * This if statement narrows down the sort method base of the appliance type input.  Then it goes through the designated tree map and check for the matches
                 * through the key value
                 */
                if (type.equals("R")){ //checks appliance type
                    for (Map.Entry<Double, Refrigerator> entry: refrigerator.entrySet()){ //goes through treemap
                        if(entry.getKey() <=price2){ //checks if the key is less than the price
                            result += entry.getValue().toString() + "\n"; //converts the price into a string and store it into result
                        }
                    }
                }   else if (type.equals("D")){ //same as like 193
                        for (Map.Entry<Double, Dishwasher> entry: dishwasher.entrySet()){ //goes through tree map
                            if (entry.getKey() <= price2){
                                result += entry.getValue().toString() + "\n"; //same as line 196
                            }
                        }
                    } else if (type.equals("M")){
                        for (Map.Entry<Double, Microwave> entry : microwave.entrySet()){
                            if (entry.getKey() <= price2){
                                result += entry.getValue().toString() + "\n"; 
                            }
                        }
                    } else{
                        JOptionPane.showMessageDialog(null, "Invalid type"); //check if the type in user input isn't 'R','D', or 'M'
                        return;
                    }
                    //check for condition when matches are found. This is because the result varible will store something if this condition if true
                    if(!result.isEmpty()){
                        System.out.println("Results:" + "\n" + result);  
                    } else{
                    JOptionPane.showMessageDialog(null, "No Matches"); //when the result variable is empty
                }
                
            }
        }

    /**
     * after setting all error handeling, the update GUI will actually take all the data and print it on the differect section of the GUI.
     * The purpose of this method is to like the treemap into the GUI so the physical nature of the result from
     * the sorting (searchApp) can be shown
     */

    private void updateGUI(){
        //Sets difault text for each section
        rText.setText("");
        dText.setText("");
        mText.setText("");
        
    
        Set<Map.Entry<Double, Refrigerator>> rSet= refrigerator.entrySet(); //return all the matches, which are key-valuye pairs from the appliance refrigerator map which is stored in rSet
        Iterator<Map.Entry<Double, Refrigerator>> rIterator = rSet.iterator(); //This creates a pointer that will ioterate through the map
        while (rIterator.hasNext()){ //this while loop functions until the pointer each the end of the tree map
            Map.Entry<Double, Refrigerator> entry= rIterator.next(); //goes to the next entry
            rText.append(entry.getValue().toString()+ "\n"); //adds the entry value directly into the GUI
        }
        
        //does the same thing as lines 236-241 but for dishwasher
        Set<Map.Entry<Double, Dishwasher>> dSet= dishwasher.entrySet();
        Iterator<Map.Entry<Double, Dishwasher>> dIterator = dSet.iterator();
        while (dIterator.hasNext()){
            Map.Entry<Double, Dishwasher> entry= dIterator.next();
            dText.append(entry.getValue().toString()+ "\n");
        }

        //does the same thing as lines 236-241 but for microwave
        Set<Map.Entry<Double, Microwave>> mSet= microwave.entrySet();
        Iterator<Map.Entry<Double, Microwave>> mIterator = mSet.iterator();
        while (mIterator.hasNext()){
            Map.Entry<Double, Microwave> entry= mIterator.next();
            mText.append(entry.getValue().toString()+ "\n");
        }
    }
}
