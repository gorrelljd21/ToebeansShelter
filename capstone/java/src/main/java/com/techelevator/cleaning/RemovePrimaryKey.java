package com.techelevator.cleaning;

import java.util.Scanner;


public class RemovePrimaryKey {

    public static void main(String[] args) {
        clean(50);
    }

//insert into animal_photos (photo_id, animal_id, photo_link) values (1, 1, 'https://i.imgur.com/Yds4Jka.jpg');
//takes a row amount, then run the program and pass values in via copy, paste, it removes the pk field and values from ^^
    public static void clean(int rows) {
        Scanner scanner = new Scanner(System.in);
        String[] result = new String[rows];

        for (int i = 0; i < rows; i++) {
            String fixed = "";
            String line = scanner.nextLine();
            fixed = line.substring(0, 27);
            fixed += line.substring(37, 68);
            fixed += line.substring(71);
            result[i] = fixed;
        }

        for (String out : result) {
            System.out.println(out);
        }
    }
}
