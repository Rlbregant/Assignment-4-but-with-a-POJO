package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 

*/

public class ReadDataFile {

	public List<Student> readDateFile(String filename) {
		// Create three lists to store the students for each course
		List<Student> compSci = new ArrayList<>();
		List<Student> stat = new ArrayList<>();
		List<Student> apMth = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				// Split the line into an array of values
				String[] array = line.split(",");
				// Read the values from the array
				String id = array[0];
				String name = array[1];
				String course = array[2];
				String grade = array[3];
				// Remove the unwanted numbers from the course name
				course = course.replaceAll("\\d", "");
				// Remove any leading or trailing whitespace characters from the course name
				course = course.trim();
				// Create a new Student object with the values
				Student student1 = new Student(id, name, course, grade);
				// Add the student to the appropriate list
				if (course.equals("COMPSCI")) {
					compSci.add(student1);
				} else if (course.equalsIgnoreCase("STAT")) {
					stat.add(student1);
				} else if (course.equals("APMTH")) {
					apMth.add(student1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Print the number of students in each list (debug)
//		System.out.println("Number of students in COMPSCI: " + compSci.size());
//		System.out.println("Number of students in STAT: " + stat.size());
//		System.out.println("Number of students in APMTH: " + apMth.size());

		// Sort the lists of students by grade in descending order
		compSci.sort((s1, s2) -> s2.getGrade().compareTo(s1.getGrade()));
		stat.sort((s1, s2) -> s2.getGrade().compareTo(s1.getGrade()));
		apMth.sort((s1, s2) -> s2.getGrade().compareTo(s1.getGrade()));

//		List<Student> allStudents = new ArrayList<>();
//		allStudents.addAll(compSci);
//		allStudents.addAll(stat);
//		allStudents.addAll(apMth);
//		
//		System.out.println(allStudents);
		
		//Combine the three course Lists into a single List
		List<List<Student>> allStudents = List.of(compSci, stat, apMth);
		
		WriteCSVFile fileWriter = new WriteCSVFile();
		// For loop to pull each course from the main List based on the number of elements in each List
		for (int i = 0; i < allStudents.size(); i++) {
			List<Student> students = allStudents.get(i);
			fileWriter.writeCSVFile(students, "course" + (i + 1) + ".csv");
		}

		// Create a list of arrays of strings 
//		List<String[]> students = new ArrayList<>();

		// Iterate over the list of Student objects
//		for (Student student : compSci) {
		// Create an array of strings for the student
//			String[] studentArray = new String[] { student.getId(), student.getName(), student.getCourse(),
//					student.getGrade() };
		// Add the array to the list
//			students.add(studentArray);
		// Print the values for the student (debug)
//			System.out.println("ID: " + student.getId());
//			System.out.println("Name: " + student.getName());
//			System.out.println("Course: " + student.getCourse());
//			System.out.println("Grade: " + student.getGrade());
//		}

		// Write the list of arrays to a CSV file
//		WriteCSVFile fileWriter = new WriteCSVFile();
//		fileWriter.writeCSVFile(students, "course1.csv");

		// Create a list of arrays of strings
//		List<String[]> students1 = new ArrayList<>();

		// Iterate over the list of Student objects
//		for (Student student : stat) {
		// Create an array of strings for the student
//			String[] studentArray = new String[] { student.getId(), student.getName(), student.getCourse(),
//					student.getGrade() };
		// Add the array to the list
//			students1.add(studentArray);
		// Print the values for the student (debug)
//			System.out.println("ID: " + student.getId());
//			System.out.println("Name: " + student.getName());
//			System.out.println("Course: " + student.getCourse());
//			System.out.println("Grade: " + student.getGrade());

//		}
//		fileWriter.writeCSVFile(students1, "course2.csv");
		// Create a list of arrays of strings
//		List<String[]> students2 = new ArrayList<>();

		// Iterate over the list of Student objects
//		for (Student student : apMth) {
		// Create an array of strings for the student
//			String[] studentArray = new String[] { student.getId(), student.getName(), student.getCourse(),
//					student.getGrade() };
		// Add the array to the list
//			students2.add(studentArray);
		// Print the values for the student (debug)
//			System.out.println("ID: " + student.getId());
//			System.out.println("Name: " + student.getName());
//			System.out.println("Course: " + student.getCourse());
//			System.out.println("Grade: " + student.getGrade());
//		}
		// Write the list of arrays to a CSV file
//		fileWriter.writeCSVFile(students2, "course3.csv");
		// Not sure what else to return
		return null;
	}

}