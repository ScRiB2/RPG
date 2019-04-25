package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    static Path path = Paths.get("D:\\MyDataFiles\\data.csv");

    private static String getYear(String s) {
        return (s.substring(0, s.indexOf(";")));
    }

    private static void parser() {
        List<String> lines = new ArrayList<>();
        int beginIndex = 5;
        try (Stream<String> lineStream = Files.lines(path)) {
            System.out.println("Года, в которых прожиточный минимум выше 7000 рублей");
            String result = lineStream
                    .skip(1)
                    .filter(s -> {
                        int capita = Integer.parseInt(s.substring(beginIndex, s.indexOf(";", beginIndex)));
                        return capita > 7000;
                    })
                    .peek(s -> System.out.println(getYear(s)))
                    .max((s1, s2) -> {
                        int capita1 = Integer.parseInt(s1.substring(beginIndex, s1.indexOf(";", beginIndex)));
                        int capita2 = Integer.parseInt(s2.substring(beginIndex, s2.indexOf(";", beginIndex)));
                        return Integer.compare(capita1, capita2);
                    }).get();
            System.out.println("\nВ " + result.substring(0, 4) + " году " +
                    "самый высокий прожиточный минимум равный " + result.substring(5, result.indexOf(";", 5)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copy() {
        File file = path.toFile();

    }

    public static void main(String[] args) throws IOException {
        File activationFile = new File(path.getParent() + "\\data.done");

        while (!activationFile.canRead()) {

        }
        Files.copy(path, Paths.get(path.getRoot() + "Temp\\data.csv"));
        parser();
    }


}
