package com.lockedme.application;

import java.io.IOException;
import java.util.Scanner;

public class OperationHandling {
	public static void mainMenu() {
		// Do - While loop as True for Application to run until user give input to exit
		// the Application
		boolean isApplicationRunning = true;
		Scanner scan = new Scanner(System.in);
		do {
			try {
				DisplayOptions.displayMainMenu();
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					LockedMeFileHandling.displayFilesInAscendingOrder("Files");
					break;
				case 2:
					OperationHandling.businessLevelOperation();
					break;
				case 3:
					System.out.println("Program exited successfully.");
					isApplicationRunning = false;
					scan.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				mainMenu();
			} 
		} while (isApplicationRunning == true);
	}

	public static void businessLevelOperation() throws IOException {
		boolean isApplicationRunning = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {	
					DisplayOptions.displayBusinessLevelOperationMenu();
					// Switch is used to perform different type of task - input such given by the
					// user.
					int businessLevelOperationChoice = sc.nextInt();
					switch (businessLevelOperationChoice) {
					case 1: {
						LockedMeFileHandling.createFile();
						break;
					}
					case 2: {
						LockedMeFileHandling.deleteFile();
						break;
					}
					case 3: {
						LockedMeFileHandling.displayFile();
						break;
					}
					case 4: {
						System.out.println("Back to Main Menu is Successful");
						isApplicationRunning = false;
						return;
					}
					default:
						System.out.println("Please enter valid option from above.");
					}
				
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				businessLevelOperation();
			}
		} while (isApplicationRunning == true);
	}
}
