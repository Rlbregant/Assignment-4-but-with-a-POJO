package com.coderscampus;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		new Main().execute();

	}

	private void execute() {
		// Read the data file and store it in a List of Student objects
		ReadDataFile dataReader = new ReadDataFile();
		List<Student> students = dataReader.readDateFile("student-master-list.csv");
		
		List<Student> compSci = new ArrayList<>();
		List<Student> stat = new ArrayList<>();
		List<Student> apMth = new ArrayList<>();
		
		compSci.sort((s1, s2) -> s2.getGrade().compareTo(s1.getGrade()));
		stat.sort((s1, s2) -> s2.getGrade().compareTo(s1.getGrade()));
		apMth.sort((s1, s2) -> s2.getGrade().compareTo(s1.getGrade()));
		
		List<List<Student>> allStudents = List.of(compSci, stat, apMth);

		WriteCSVFile fileWriter = new WriteCSVFile();

		for (int i = 0; i < allStudents.size(); i++) {
		    List<Student> students1 = allStudents.get(i);
		    fileWriter.writeCSVFile(students1, "course" + (i + 1) + ".csv");
		}
	}
}