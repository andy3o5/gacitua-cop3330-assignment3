/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Andres Gacitua
 */

package Exercise41;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class NameSorter
{

    private ArrayList<String> names = new ArrayList<>();

    public void readFile(String filename) throws IOException
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line = reader.readLine();
            if (line == null)
            {
                System.out.print("File is empty.");
            } else
            {
                while (line != null)
                {
                    names.add(line);
                    line = reader.readLine();
                }
                Collections.sort(names);
            }
        }
    }

    public void writeToFile(String filename) throws IOException
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
        {

            writer.write("Total of " + names.size() + " names");
            writer.newLine();
            writer.write("----------------------------");
            writer.newLine();


            for (String name : names)
            {
                writer.write(name);
                writer.newLine();
            }
        }
    }
}