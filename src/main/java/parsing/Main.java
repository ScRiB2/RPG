package parsing;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\ScRiB\\Desktop\\1\\data.csv"), ',', '"', 1);

        ArrayList<Geo> geos = new ArrayList<>();

        readFile(geos, reader);
        System.out.println("Изменение численности населения с 2013 по 2016");
//        for (Geo geo : geos) {
//            diffPop(geo);
//        }
        printTop(geos);
    }

    private static ArrayList<Geo> readFile(ArrayList<Geo> geos, CSVReader reader) throws IOException {
        Geo temp;
        while ((temp = getNext(reader)) != null) {
            geos.add(temp);
        }
        return geos;
    }

    private static int getPop(String nextLine) {
        int pop;
        try {
            pop = Integer.parseInt(nextLine);
        } catch (NumberFormatException e) {
            pop = 0;
        }
        return pop;
    }

    private static Geo getNext(CSVReader reader) throws IOException {
        String[] nextLine = reader.readNext();
        if (nextLine != null) {
            return new Geo(nextLine[0], nextLine[2], getPop(nextLine[3]), getPop(nextLine[4]),
                    getPop(nextLine[5]), getPop(nextLine[6]));
        } else
            return null;
    }

    private static void diffPop(Geo geo) {
        System.out.printf("%-37s", geo.geoName);
        System.out.println("   " + geo.getDiff());
    }

    private static void printTop(ArrayList<Geo> geos) {
        Collections.sort(geos, Comparator.comparingInt(Geo::getDiff));
        Collections.reverse(geos);
        for (int i = 0; i < 5; i++) {
            diffPop(geos.get(i));
        }
    }

}
