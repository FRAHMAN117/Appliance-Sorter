
/**
 * @author Fahmin Rahman
 * This java file is like the backbone of all file handeling, such as opening a file, going through a laptop to get the file
 */
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileMenuHandler implements ActionListener {
   JFrame jframe;
   public FileMenuHandler (JFrame jf) {
      jframe = jf;
   }
   /**
    * this method is used to call the open file method and calls for the action of opening the file. It initalize the menu name. this basically check
    if the correct button is click through a string comparison. it exit the quit button. This method is like the first layer of the file handling work
    */
   public void actionPerformed(ActionEvent event) {
      String  menuName;
      menuName = event.getActionCommand();
      if (menuName.equals("Open"))
         openFile( ); 
      
      //This else if statement looks for the "Search" statement in menuName and calls the searchApp method to ask the user to input appliance type and price
      else if(menuName.equals("Search")){
         ((ApplianceGUI) jframe).searchApp();
      }

      //this else if statement search for the string "Quit" and exit the program.
      else if (menuName.equals("Quit"))
         System.exit(0);
   } //actionPerformed

   /**
    * This is like the deep layer of filehanding, which is responsible for actually navigating through the device's path.
    @param showOpenDialog responsible for showing the existing file in the desktop
    @param chosenFile responsible for the selection of the desired file. this than read file and send the file path to the Appliance GUI
    */
    private void openFile( ) {
       JFileChooser chooser= new JFileChooser();
       int status= chooser.showOpenDialog(null);
      
       if (status == JFileChooser.APPROVE_OPTION) { 
            File chosenFile= chooser.getSelectedFile();
            ((ApplianceGUI) jframe).readFile(chosenFile.getAbsolutePath());
        }
        //readSource(chooser.getSelectedFile());
       else {
          JOptionPane.showMessageDialog(null, "Open File dialog canceled");
        }
    } //openFile
}
