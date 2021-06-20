package Exercise42;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Andres Gacitua
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvParser
{

        public static ArrayList<Employee> readFile(String filename) throws IOException
        {
        ArrayList<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {

           String line = br.readLine();

            while (line != null)
            {
                if(line.isEmpty())
                {
                    line = br.readLine();  //Handles empty lines in the middle of the file
                }
                else
                {
                    String[] parsedLine = line.split(",");

                    String lastName = parsedLine[0];
                    String name = parsedLine[1];
                    double salary = Double.valueOf(parsedLine[2]);

                    Employee emp = new Employee(lastName, name, salary);
                    employees.add(emp);

                    line = br.readLine();
                }
            }
        }
        return employees;
    }
}