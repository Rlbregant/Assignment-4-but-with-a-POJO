package com.coderscampus;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		new Main().execute();

	}

	private void execute() {
		// Read the data file and store it in a List of String arrays
		ReadDataFile dataReader = new ReadDataFile();
		List<Student> data = dataReader.readDateFile("student-master-list.csv");

	}
}