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

	}
}