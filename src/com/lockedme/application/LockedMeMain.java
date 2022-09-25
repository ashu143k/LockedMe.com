package com.lockedme.application;

public class LockedMeMain {
	public static void main(String[] args) {
		//Files Folder is created if not exist in the project.
		LockedMeFileHandling.createFolderIfNotPresent("Files");

		DisplayOptions.displayWelcomeScreen();
		//Calls the Method to display Main Menu.
		OperationHandling.mainMenu();
		
	}
}
