Appliance Management System
Overview
This project is a Java-based desktop application designed to manage and display a list of appliances. It features a graphical user interface (GUI) for user interaction and robust file-handling capabilities to read appliance data from a text file. The system uses an object-oriented approach to model different types of appliances, validates data upon entry, and allows users to search for appliances based on specific criteria.

Features
GUI Interface: A user-friendly graphical interface built with Swing, which displays three separate sections for Refrigerators, Dishwashers, and Microwaves.

Object-Oriented Design: The core functionality is built around an abstract Appliance class. This class defines common behaviors and properties like a serial number and methods for comparison, ensuring consistency across all appliance types.

Data Validation: The application includes rigorous validation to ensure that each appliance's serial number adheres to a specific format. Invalid data is handled gracefully with custom exceptions.

File Handling: Users can open a text file containing appliance data using a "File" menu and a standard JFileChooser.

Data Sorting and Storage: Appliances are stored in TreeMap data structures, which automatically sort them by price.

Search Functionality: A "Search" menu option allows users to find all appliances of a specific type that are priced below a user-specified value.

Project Structure
Appliance.java: An abstract base class for all appliance types. It contains the logic for serial number validation and defines the getPrice() method that all subclasses must implement.

ApplianceGUI.java: The main GUI class that creates the window, menu bar, and text areas. It handles the display of appliance data, reads from files, and manages the search feature.

Dishwasher.java, Microwave.java, Refrigerator.java: Concrete classes that extend Appliance. Each class includes unique properties (e.g., watts for a Microwave) and a custom toString() method for formatted output.

FileMenuHandler.java: An ActionListener class that handles the events from the menu bar, directing the application to either open a file, perform a search, or quit.

IllegalApplianceException.java: A custom exception class used to handle invalid appliance data, specifically for improperly formatted serial numbers.

Project4.java: The main class that launches the GUI by creating a new ApplianceGUI object.

TextFileInput.java: A utility class for handling simplified buffered character input from text files. This class includes additional methods for line-by-line reading and error handling.

How to Compile and Run
To run this project, you need a Java Development Kit (JDK) installed on your system.

Save all files in a single directory.

Compile the Java source code from the command line:

javac *.java

Run the main class:

java Project4

Input File Format
The application expects a text file where each line represents an appliance. The data for each appliance should be separated by commas, following this specific order: serialNumber, price, specific_property.

Refrigerator: R<11-character-code>,<price>,<cubic-feet>

Microwave: M<11-character-code>,<price>,<watts>

Dishwasher: D<11-character-code>,<price>,<undercounter-boolean> (use Y or N for undercounter)

Example appliances.txt file:

REFRIGERATOR001,1200.50,22
MICROWAVE000000,150.00,1200
DISHWASHER001,850.75,Y
REFRIGERATOR002,999.99,18
MICROWAVE000001,175.99,1500
DISHWASHER002,910.00,N

Serial Number Format
All serial numbers must follow a strict format for validation:

They must begin with a single capital letter: R (for Refrigerator), D (for Dishwasher), or M (for Microwave).

The initial letter must be followed by exactly 11 uppercase letters or digits.

The total length of the serial number is always 12 characters.

Attribution
The TextFileInput.java utility class is copyrighted by Dorothy L. Nixon. All rights are reserved by the original author.
