package com.lockedme.application;

public class DisplayOptions {
	public static void displayWelcomeScreen() {
		System.out.println("****************** Welcome to Company Lockers Pvt. Ltd ********************\n"
				+ "Application Name : LockedMe.com\n" + "---------------Developer Details--------------------\n"
				+ "Name: Ashish Kumar Pathak \n" + "Designation: JAVA Developer\n" + "Date: 20-09-2022");
	}

	public static void displayMainMenu() {
		System.out.println(
				"---------------------MAIN MENU----------------------\n"
				+"****Please select any number from below menu and press Enter****\n\n"
				+ "Enter 1: To get file names in ascending order\n"
						+ "Enter 2: For Business Level Operation\n"
						+ "Enter 3: Close the Application");
	}

	public static void displayBusinessLevelOperationMenu() {
		System.out.println("-------------------BUSINESS LEVEL OPERATIONS MENU----------------------"
				+ "\n****Please select any number from below menu and press Enter ****\n\nEnter 1: Add a file"
				+ "\nEnter 2: Delete a file\nEnter 3: Search a file\nEnter 4: To Back to main menu");
	}
}
