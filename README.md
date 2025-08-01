# Appliance Management System

---

## Overview

This repository contains a Java-based application for managing and displaying appliance information. The program is a **graphical user interface (GUI)** that reads structured data about various appliances, such as refrigerators, from a text file. The project is designed to provide a clear and extensible codebase, leveraging **object-oriented principles** for handling and visualizing appliance-related data.

## Project Goal

The main objective is to create a robust and user-friendly application that can:

1.  **Read structured appliance data** from an external text file.
2.  **Parse this data** into a hierarchy of appliance objects.
3.  **Display the information** in a clear and organized manner using a GUI.

## Core Components

The project is built with the following key components:

* `Project4.java`: The main entry point of the application. It initializes the graphical user interface.
* `ApplianceGUI.java`: (Inferred from `Project4.java`) The class responsible for building and managing the graphical user interface where appliance data is displayed.
* `Appliance.java`: (Inferred from `Refrigerator.java`) An abstract or base class that defines common properties and behaviors for all types of appliances, such as a serial number.
* `Refrigerator.java`: A concrete class that extends the `Appliance` class. It includes specific properties like **`price`** and **`cubicfeet`** and overrides methods like `toString()` to provide a formatted description.
* `TextFileInput.java`: A custom utility class for handling file input operations. It provides methods to safely open files, read lines, and perform input validation, which helps prevent runtime errors.

## Key Functionalities & Classes

The project demonstrates a clear separation of concerns with the following class responsibilities:

### `Refrigerator` Class:

* **Constructs `Refrigerator` objects** with a `serialNumber`, `price`, and `cubicfeet`.
* **Encapsulates unique properties** for refrigerators, such as **`price`** and **`cubicfeet`**.
* **Overrides `toString()`** to format a descriptive string for each refrigerator object, which is essential for displaying data in the GUI.

### `TextFileInput` Class:

* **Manages file reading operations** by handling `IOExceptions` and `NullPointerExceptions` internally.
* **Provides methods** like `readLine()` to safely read data from a specified text file.
* **Includes utility methods** such as `isOneOf()` and `readSelection()` for robust input validation.

### `Project4` Class:

* **Serves as the application's entry point.**
* **Initializes the `ApplianceGUI`** to launch the graphical user interface.

## Methodology

The application follows a standard object-oriented approach for data management:

1.  The **`Project4`** class starts the program and creates the GUI instance.
2.  The **`ApplianceGUI`** likely prompts the user to select a text file containing appliance data.
3.  The **`TextFileInput`** class is used to read each line from the selected file.
4.  For each line, the program parses the data and instantiates the appropriate appliance object (e.g., a `Refrigerator`).
5.  These appliance objects are then managed and displayed within the **`ApplianceGUI`**. The custom `toString()` method in each class ensures the data is presented clearly to the user.

---

## Setup and Usage

### Prerequisites

* **Java Development Kit (JDK) 8 or newer**
* A Java-compatible IDE (e.g., Eclipse, IntelliJ IDEA, NetBeans) or a command-line build environment.

### Installation

1.  **Clone this repository** to your local machine.
2.  **Open the project** in your preferred Java IDE.

### Running the Program

1.  **Compile all the Java source files** (`.java`).
2.  **Run the `Project4.java` file**.
3.  The application's **GUI will launch**. You will likely be prompted to select a text file with appliance data to load.

---

## Troubleshooting

* **"Compilation Errors"**: Ensure all `.java` files are in the same directory and compile them together. Check for syntax errors if the code has been modified.
* **`FileNotFoundException`**: If the application throws this error, make sure the text file you are trying to open exists and that the file path is correct relative to where the program is executed.
* **"Malformed Input"**: If the text file's format is incorrect (e.g., missing data points, incorrect types), the program may throw a parsing error. Ensure the data aligns with the expected structure for each appliance type.

---

## Future Work

* **Add support for more appliance types** (e.g., `Microwave`, `Dishwasher`) by creating new classes that extend `Appliance`.
* **Implement a feature to save** the current appliance list to a new text file.
* **Enhance the GUI** with features like editing, adding, or removing appliances directly within the application.
