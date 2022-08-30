package com.solvd.laba.bank.service;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AccountParser {
    private static final Logger LOGGER = Logger.getLogger(TextParser.class);

    /* Array with solid not separated strings, that will be filled after file reading */
    static ArrayList<String> solidStrings = new ArrayList<>();

    /**
     * Program takes .csv file and exude on demand any column into array.
     * println method called for visible result.
     */

    public static ArrayList <ArrayList<String>> runParse (String file) {
        ArrayList <ArrayList<String>> strings = extractColumns(file);
        if (strings == null) LOGGER.info(strings);
        return strings;
    }


    /**
     * Method opens file by given path and returns specified column from csv table as an array.
     *
     * @param filename path to .csv file
     * @param column   num of column to be extracted
     * @return an array of strings in specified column
     */

    private static ArrayList<ArrayList<String>> extractColumns(String filename) {
        try {
            fileToArray(filename);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (String solidString : solidStrings) {
            result.add(fieldsIn(solidString));
        }
        return result;
    }

    /**
     * Method processes over given line of .csv formatted text end extract proper text divided by columns
     *
     * @param line line of .csv formatted text
     * @return array of final strings without excessive quotation marks
     */
    private static ArrayList<String> fieldsIn(String line) {
        int quotesCount = 3; // count of quotation marks needed to process in column with quoted text
        String temp1 = "";
        ArrayList<String> tArr = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '=') {  // if there unquoted comma found adding string to array and starting new
                tArr.add(temp1);
                temp1 = "";
                continue;
            }
            if (line.charAt(i) == ',') {  // if there unquoted comma found adding string to array and starting new
                tArr.add(temp1);
                temp1 = "";
                i++;
                continue;
            }
            /* When first quotation mark found continue to searching next*/
            if (i + 1 < line.length() && line.charAt(i) == '"') {
                do {
                    i++;
                    if (line.charAt(i) != '"') temp1 += line.charAt(i); // adding chars to string
                }

                /* If there is found double quotation marks after single one, counting next marks back from 3 to 0*/
                while (line.charAt(i) != '"');
                if (i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    temp1 += line.charAt(i); // adding chars to string
                    i++;
                    do {
                        i++;
                        if (line.charAt(i) == '"') quotesCount--;
                        else temp1 += line.charAt(i); // adding chars to string
                    }
                    while (quotesCount != 0);
                    temp1 += line.charAt(i); // adding chars to string
                    quotesCount = 3;
                }
            }
            if (line.charAt(i) != '"') temp1 += line.charAt(i);  // adding chars to string
        }
        tArr.add(temp1);
        return tArr;
    }

    /**
     * Method open and reads .csv file line by line adding each one to an array.
     *
     * @param filename path to the given file.
     * @throws IOException
     */
    private static void fileToArray(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            solidStrings.add(line);
        }
        br.close();
    }
}
