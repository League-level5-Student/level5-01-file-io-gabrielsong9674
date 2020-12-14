package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.FloatBuffer;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DirectoryIterator {
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		/*JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File directory = jfc.getSelectedFile();
			File[] files = directory.listFiles();
			if(files != null) {
				for(File f : files) {
				  System.out.println(f.getAbsolutePath());
				}
			}
		}
		*/
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */
		File file = new File("/Users/gracegabrielson/Desktop/level5-01-file-io-gabrielsong9674/src");
		iteratePackage(file);
	}
	
	public static void iteratePackage(File file) {
		String type = "";
		String fileName = file.getName();
		String copyright = "//Copyright © 2020 Grace Gabrielson";
		if(file!=null) {
			if(file.isDirectory()) {
				File[] files = file.listFiles();
				for(File f : files) {
					iteratePackage(f);
				}
			}
			else {
				int dot = fileName.lastIndexOf('.');
				type = fileName.substring(dot, fileName.length());
				if(type.equals(".java")) {
					try {
						FileWriter fw = new FileWriter(file, true);
						fw.write(copyright);
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}
//Copyright © 2020 Grace Gabrielson//Copyright © 2020 Grace Gabrielson