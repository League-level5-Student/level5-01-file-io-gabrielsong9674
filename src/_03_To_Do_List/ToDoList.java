package _03_To_Do_List;

import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	JFrame window = new JFrame();
	JButton addTask = new JButton("add task");
	JButton viewTasks = new JButton("view tasks");
	JButton removeTask = new JButton("remove task");
	JButton saveList = new JButton("save list");
	JButton loadList = new JButton("load list");
	public ToDoList() {
		ArrayList<String> tasks = new ArrayList<String>();
		tasks.removeAll(tasks);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new FlowLayout());
		window.setVisible(true);
		
		window.add(addTask);
		window.add(viewTasks);
		window.add(removeTask);
		window.add(saveList);
		window.add(loadList);
		window.pack();
		addTask.addActionListener((e)->{
			String task = JOptionPane.showInputDialog("Enter a task");
			tasks.add(task);
		});
		
		viewTasks.addActionListener((e)->{
			String taskList = "";
			for(String task : tasks) {
				taskList += task + "\n";
			}
			JOptionPane.showMessageDialog(null, taskList);
		});
		
		removeTask.addActionListener((e)->{
			String remove = JOptionPane.showInputDialog("Which task do you want to remove?");
			for(int i = 0; i < tasks.size(); i ++) {
				if(tasks.get(i).equals(remove)) {
					tasks.remove(i);
				}
			}
		});
		
		saveList.addActionListener((e)->{
			String taskList = "";
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/todo.txt");
				fw.write("");
				for(String task : tasks) {
					taskList += task + "\n";
					fw.write(taskList);
				}
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		loadList.addActionListener((e)->{
			String load = JOptionPane.showInputDialog("What is the file's location?");
			try {
				FileReader fr = new FileReader(load);
				BufferedReader br= new BufferedReader(fr);
				String line = br.readLine();
				System.out.println(line);

				while(line != null){
					tasks.add(line);
					
					line = br.readLine();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		
	}
	public static void main(String[] args) {
		new ToDoList();
	}
	
}//Copyright © 2020 Grace Gabrielson