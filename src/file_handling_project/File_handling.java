package file_handling_project;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class File_handling {
	
	final static String Developer_name = "Shriharireddy K";
	final static String Application_name = "File handling project";
	final static String Welcome_screen = "*****Welcome to "+Application_name+"developed by "+Developer_name+"*****";

	public static void main(String[] args) {	
		
		System.out.println(Welcome_screen);
		while(true)
		{
			displayMenu();
			int options = Useroptions();
			switch(options)
			{
			case 1: displayFiles();
					break;
			case 2: FileOperations();
					break;
			case 3: Exit();
					break;
			}
			
		}

	}

	private static void Exit() {
		System.out.println("Good Bye");
		System.exit(0);
	}

	private static void FileOperations() {
		while(true)
		{
			displaydirectorymenu();
			int choice = Useroptions();
			switch(choice)
			{
			case 1: addFiles();
					break;
			case 2: deleteFiles();
					break;
			case 3: SearchFile();
					break;
			case 4: return;
			
			default: System.out.println("Wrong option entered !!!");
			         break;
			}
		}
		
	}

	private static void SearchFile() {
		System.out.println("Enter the filename to search :)");
		Scanner sc = new Scanner (System.in);
		String filename = sc.next();
		File directory = new File(".");
		File[] file = directory.listFiles();
		boolean found = false;
		for(File f: file)
		{
			if(f.getName().endsWith(filename))
			{
				System.out.println("File found :)");
				found = true;
				break;
			}
		}
		if(!found)
		{
			System.out.println("File not found");
		}
	}

	private static void deleteFiles() {
		System.out.println("Enter the name of the file :)");
		Scanner sc = new Scanner (System.in);
		String filename = sc.next();
		File file = new File(filename);
		if(!file.exists())
		{
			System.out.println("File not found");
		}
		if(file.exists())
		{
			if(file.delete())
			{
				System.out.println("File deleted successfully :(");
			}
		}
	}

	private static void addFiles() {
		System.out.println("Enter the Filename :)");
		Scanner sc = new Scanner (System.in);
		String filename = sc.next();
		File file = new File(filename.toLowerCase());
		try {
			if(file.exists())
			{
				System.out.println("File exisits !!!!!");
			}
			else
			{
				file.createNewFile();
				System.out.println("File created successfully :)");
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	private static void displaydirectorymenu() {
		System.out.println("\nSelect the options from 1 to 4");
		System.out.println("1.Add Files");
		System.out.println("2.Delete Files");
		System.out.println("3.Search Files");
		System.out.println("4.Main menu");
	}

	private static void displayFiles() {
		File directory = new File(".");
		System.out.println("\nDirectory = "+directory.getAbsolutePath());
		System.out.println("Displaying the Files in Ascending Order");
		File[] file = directory.listFiles();
		Arrays.sort(file);
		for(File f: file)
		{
			if(f.isFile())
			{
				System.out.println(f.getName());
			}
		}
	}

	private static int Useroptions() {
		Scanner sc = new Scanner (System.in);
		int choice = sc.nextInt();
		return choice;
	}

	private static void displayMenu() {
		System.out.println("\n1. Display Files");
		System.out.println("2. File Operations");
		System.out.println("3. Exit\n");
	}

}
