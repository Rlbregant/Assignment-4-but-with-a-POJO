package com.coderscampus;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriteCSVFile {
	public void writeCSVFile(List<Student> students, String filename) {
		try (PrintWriter pw = new PrintWriter(new File(filename))) {
			// Print the column names
			pw.println("Student ID    Student Name  	      Course  	Grade");

			// Print a line of dashes to separate the column names from the data
			pw.println("------------  ------------  	      ------  	-----");

			// Iterate over the elements of the students list
			for (Student student : students) {
				// Print the data from the student object with left alignment
				pw.printf("%-12s  %-20s  %-12s  %-12s%n", student.getId(), student.getName(), student.getCourse(), student.getGrade());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}