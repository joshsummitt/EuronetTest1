package com.company;

import java.io.File;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        File file = new File("problem_1_data.txt");
        String str = "";

        try
        {
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine())
            {
                str = fileReader.nextLine();
            }
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

        int x = 0;
        int y = 10;
        int streetAddressLength;
        int hobbiesLength;

        while (y < str.length())
        {
            Person person = new Person();
            String hobbies = "";

            person.setFirstName(str.substring(x, y).trim());

            if (person.getFirstName().matches("^[ A-Za-z]+$"))
            {
                System.out.println("First Name:     " + person.getFirstName());
            }
            else if (person.getFirstName().length() < 1)
            {
                System.out.println("First Name:     (empty)");
            }
            else
            {
                System.out.println("First Name:     ERROR " + person.getFirstName() + " is invalid");
            }

            x += 10;
            y += 10;

            person.setMiddleName(str.substring(x, y).trim());

            if (person.getMiddleName().matches("^[ A-Za-z]+$"))
            {
                System.out.println("Middle Name:     " + person.getMiddleName());
            }
            else if (person.getMiddleName().length() < 1)
            {
                System.out.println("Middle Name:     (empty)");
            }
            else
            {
                System.out.println("Middle Name:     ERROR " + person.getMiddleName() + " is invalid");
            }

            x += 10;
            y += 30;

            person.setLastName(str.substring(x, y).trim());

            if (person.getLastName().matches("^[ A-Za-z]+$"))
            {
                System.out.println("Last Name:     " + person.getLastName());
            }
            else if (person.getLastName().length() < 1)
            {
                System.out.println("Last Name:     (empty)");
            }
            else
            {
                System.out.println("Last Name:     ERROR" + person.getLastName() + " is invalid");
            }

            x += 30;
            y += 3;
            streetAddressLength = Integer.parseInt(str.substring(x, y));
            y += streetAddressLength;
            x += 3;

            person.setStreetAddress(str.substring(x, y).trim());

            if (person.getStreetAddress().matches("^[a-zA-Z0-9 #./,]+$"))
            {
                System.out.println("Street Address:     " + person.getStreetAddress());
            }
            else if (person.getStreetAddress().length() < 1)
            {
                System.out.println("Street Address:     (empty)");
            }
            else
            {
                System.out.println("Street Address:     ERROR" + person.getStreetAddress() + " is invalid");
            }

            x += streetAddressLength;
            y += 1;
            hobbiesLength = Integer.parseInt(str.substring(x, y));
            x += 1;
            y += 10;

            for (int i = 1; i <= hobbiesLength; i++)
            {
                person.setHobbies(str.substring(x, y));

                x += 10;
                y += 10;
            }

            System.out.print("Hobbies:  ");
            if (person.getHobbies().size() > 0)
            {
                for (int i = 0; i < person.getHobbies().size(); i++)
                {
                    if (person.getHobbyItem(i).matches("^[ A-Za-z ,]+$"))
                    {
                        System.out.print(person.getHobbyItem(i) + " ");
                    }
                    else
                    {
                        System.out.println("ERROR   " + person.getHobbyItem(i) + " is invalid");
                    }
                }
            }
            else
            {
                System.out.print("(empty)");
            }
            System.out.println("\n");
        }
    }
}
