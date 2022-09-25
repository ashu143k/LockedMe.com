package com.lockedme.application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LockedMeFileHandling {
	static Scanner scan = new Scanner(System.in);

	public static void createFolderIfNotPresent(String folderName) {
		File file = new File(folderName);

		// If file doesn't exist, create the "File" folder
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	public static void displayFilesInAscendingOrder(String path) {
		LockedMeFileHandling.createFolderIfNotPresent("Files");
		// All required files and folders inside "Files" folder relative to current
		// folder
		System.out.println("Displaying all files with directory structure in ascending order\n");

		// listFilesInDirectory displays files along with folder structure
		List<String> filesListNames = LockedMeFileHandling.listFilesInDirectory(path, 0, new ArrayList<String>());

		System.out.println("Displaying all files in ascending order\n");
		Collections.sort(filesListNames);

		filesListNames.stream().forEach(System.out::println);
	}
	public static List<String> listFilesInDirectory(String path, int blankSpaceCount, List<String> fileListNames) {
		File dir = new File(path);
		File[] files = dir.listFiles();
		
		List<File> filesList = Arrays.asList(files);
		Collections.sort(filesList);

		if (files != null && files.length > 0) {
			for (File file : filesList) {

				System.out.print(" ".repeat(blankSpaceCount * 2));

				if (file.isDirectory()) {
					System.out.println("``-- " + file.getName());

					// Recursively indent and display the files
					fileListNames.add(file.getName());
					listFilesInDirectory(file.getAbsolutePath(), blankSpaceCount + 1, fileListNames);
				} else {
					System.out.println("|- " + file.getName());
					fileListNames.add(file.getName());
				}
			}
		} else {
			System.out.print(" ".repeat(blankSpaceCount * 2));
			System.out.println("|- Empty Directory");
		}
		System.out.println();
		return fileListNames;
	}

	public static void createFile() {
		LockedMeFileHandling.createFolderIfNotPresent("Files");
		System.out.println("Enter your file name");
		String fileName = scan.next();
		Path pathToFile = Paths.get("./Files/" + fileName);
		try {
			Files.createDirectories(pathToFile.getParent());
			Files.createFile(pathToFile);
			System.out.println(fileName + " created successfully\n");

		} catch (IOException e) {
			System.out.println("Failed to create file " + fileName);
			System.out.println(e.getClass().getName());
		}
	}
	public static void displayFile() {
		List<String> fileListNames = new ArrayList<>();
		File searchFileDirectory = new File(System.getProperty("user.dir")+"//Files//");
		String path = searchFileDirectory.toString();
		System.out.println("Enter file name to search");
		String searchFileName = scan.next();
		LockedMeFileHandling.searchFile(path, searchFileName, fileListNames);
		
		if (fileListNames.isEmpty()) {
			System.out.println("\n\nCouldn't find any file with given file name \"" + searchFileName + "\"\n\n");
		} else {
			System.out.println("\n\nFound file at location(s):");
			List<String> files = IntStream.range(0, fileListNames.size())
					.mapToObj(index -> (index + 1) + ": " + fileListNames.get(index)).collect(Collectors.toList());

			files.forEach(System.out::println);
		}
	}
	public static void searchFile(String path, String fileName, List<String> fileListNames) {
		File dir = new File(path);
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);

		if (files != null && files.length > 0) {
			for (File file : filesList) {

				if (file.getName().startsWith(fileName)) {
					fileListNames.add(file.getAbsolutePath());
				}
				//To check if file is available in inside other directory.
				if (file.isDirectory()) {
					searchFile(file.getAbsolutePath(), fileName, fileListNames);
				}
			}
		}
	}

	public static void deleteFile() {
		System.out.println("Enter file name for deletion");
		String deleteFileName = scan.next();
		File deleteFileDirectory = new File(System.getProperty("user.dir")+"//Files//" + deleteFileName);
		if (deleteFileDirectory.delete())
			System.out.println(deleteFileName + " File is deleted\n");
		else
			System.out.println(deleteFileName + " is not deleted as file is not found in directory\n");
	}
}


