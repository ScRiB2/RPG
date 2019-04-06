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

//        for (Geo geo : geos) {
//            diffPop(geo);
//        }
        System.out.println("========================================================================");
        printTopByPop(geos);
        System.out.println("========================================================================");
        printTopByDiff(geos);
        System.out.println("========================================================================");
        forecastFor2017(geos);
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
        System.out.printf("%-40s", geo.geoName);
        System.out.printf("%,d%n", geo.getDiff());
    }

    private static void printTopByPop(ArrayList<Geo> geos) {
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.printf("%60s%n", "Топ 5 регионов по численности населения в 2016 году");
        System.out.println("////////////////////////////////////////////////////////////////////////");
        geos.sort(Comparator.comparingInt(o -> o.pop2016));
        Collections.reverse(geos);
        for (int i = 0; i < 5; i++) {
            popIn2016(geos.get(i));
        }
    }

    private static void popIn2016(Geo geo) {
        System.out.printf("%-40s", geo.geoName);
        System.out.printf("%,d%n", geo.pop2016);
    }

    private static void printTopByDiff(ArrayList<Geo> geos) {
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.printf("%68s%n", "Топ 5 регионов по изменению численности населения с 2013 по 2016");
        System.out.println("////////////////////////////////////////////////////////////////////////");
        geos.sort(Comparator.comparingInt(Geo::getDiff));
        Collections.reverse(geos);
        for (int i = 0; i < 5; i++) {
            diffPop(geos.get(i));
        }
    }

    private static void forecastFor2017(ArrayList<Geo> geos) {
        System.out.println("////////////////////////////////////////////////////////////////////////"); //72
        System.out.printf("%52s%n", "Прогноз по населению на 2017 год");
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.printf("%-40s", "Название региона");
        System.out.printf("%-13s%s%n", "Изменение", "Кол-во населения");
        System.out.println("------------------------------------------------------------------------");
        for (Geo geo : geos) {
            System.out.printf("%-40s%-+,10d     %-,8d%n", geo.geoName, geo.getForecast(), geo.getForecast() + geo.pop2016);
        }
    }
}
