# ITMS

## Overview

The ITMS (Inventory and Transaction Management System) is a Java-based application designed to manage inventory and transactions efficiently. This system allows users to track items, manage inventory levels, and record transactions. It is built with a user-friendly interface using the FlatLaf library for an enhanced visual experience.

## Features

- **Inventory Management**: Add, edit, and delete inventory items.
- **Transaction Recording**: Record transactions with details of inventory changes.
- **User Interface**: Modern and intuitive UI with FlatLaf integration.

## Requirements

- Java Development Kit (JDK) 11 or higher
- Eclipse IDE
- FlatLaf library

## Installation Instructions (METHOD A)

### Step 1: Download all the files under this repository.

### Step 2: Import the project into Eclipse manually
1) Open Eclipse IDE.
2) Create a new project named `javaProj`.
3) Inside the project add the classes inside the `src` folder.
4) Copy all seven (7) txt files inside the `File Handling` folder to the javaProj folder containing the folders such as src, bin, etc.
5) Download the `media` folder.

### Step 3: Import the external library onto the project.
1) Right-click on your javaProj project in the Project Explorer.
2) Select Properties from the context menu.
3) In the Properties dialog, navigate to Java Build Path.
4) Select the Libraries tab.
5) Click on Add External JARs.
6) Navigate to the location where you downloaded flatlaf-<version>.jar.
7) Select the JAR file and click Open.
8) Click Apply and Close in the Properties dialog to apply the changes.

### Step 4: Make necessary code changes
As the txt and media files are downloaded, make sure to update the lines of code involving the file paths of the window icons/splash screen images and txt files to ensure that the program runs smoothly.

## Installation Instructions (METHOD B)

### Step 1: Clone the Repository

Clone this repository to your local machine using the following command:

```sh
git clone https://github.com/tammygeronimo/ITMS.git
```

### Step 2: Import the Project into Eclipse

1. Open Eclipse IDE.
2. Go to `File > Import`.
3. Select `Existing Projects into Workspace` under the General category and click `Next`.
4. Click `Browse` and select the directory where you cloned the repository.
5. Select the project and click `Finish`.

### Step 3: Add the FlatLaf Library

1. Download the FlatLaf library from the [FlatLaf GitHub repository](https://github.com/JFormDesigner/FlatLaf).
2. Unzip the downloaded file and locate the `flatlaf-<version>.jar` file.
3. In Eclipse, right-click on the ITMS project in the Project Explorer and select `Properties`.
4. Go to `Java Build Path` and select the `Libraries` tab.
5. Click `Add External JARs` and navigate to the location of the `flatlaf-<version>.jar` file.
6. Select the JAR file and click `Open`, then `Apply and Close`.

### Step 4: Run the Application

1. In the Project Explorer, navigate to the `src` folder and locate the main class file.
2. Right-click on the main class file and select `Run As > Java Application`.

### Usage

1. Launch the application following the instructions above.
2. Use the inventory management features to add, edit, or delete items.
3. Record transactions to update inventory levels.
4. Explore the user-friendly interface provided by FlatLaf.

### Contributing

If you wish to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.

### License
This project is licensed under the MIT License. See the LICENSE file for details.


