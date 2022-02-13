import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ChoiceFour {
    public static void choiceFour() throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите полный путь к файлу, для его расшифровкки.");
        String pathEncryptedFile = scanner.nextLine();

        System.out.println("Введите полный путь к файлу, для набора статистика.");
        String pathStatisticFile = scanner.nextLine();

        System.out.println("Введите полный путь к файлу, в который записать зашифрованный текст.");
        String pathNotEncryptedFile = scanner.nextLine();

        Map<Character, Integer> mapEncryptedFile = new HashMap<>();
        Map<Character, Integer> mapStatisticFile = new HashMap<>();

        List<Map.Entry<Character, Integer>> listEncryptedFile = fillMapValues(mapEncryptedFile, pathEncryptedFile);
        List<Map.Entry<Character, Integer>> listStatisticFile = fillMapValues(mapStatisticFile, pathStatisticFile);

        Map<Character, Character> mapDeEncrypted = new HashMap<>();

        if(listEncryptedFile.size() <= listStatisticFile.size()) {

            for (int i = 0; i < listStatisticFile.size(); i++) {
            mapDeEncrypted.put(listEncryptedFile.get(i).getKey(),listStatisticFile.get(i).getKey());
            }
            try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(pathNotEncryptedFile));
                 BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(pathEncryptedFile))
            ) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < string.length(); i++) {
                    char encryptedChar = string.charAt(i);
                    Character deEncryptedChar = mapDeEncrypted.get(encryptedChar);
                    stringBuilder.append(deEncryptedChar);
                }
                bufferedWriter.write(stringBuilder + System.lineSeparator());
            }
            }
        }else {
            System.out.println("Размер файла статистики недостаточен для расшифровки, необходим фаил большей длины чем зашиврованный.");
        }

    }


    private static List<Map.Entry<Character, Integer>> fillMapValues(Map<Character, Integer> map, String path) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(path))) {

            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                stringBuilder.append(string);
            }
            String bigString = stringBuilder.toString();
            for (int i = 0; i < bigString.length(); i++) {
                char charAt = bigString.charAt(i);
                if (!map.containsKey(charAt)) {
                    map.put(charAt, 1);
                } else {
                    map.put(charAt, map.get(charAt) + 1);
                }
            }
            List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

            Comparator<Map.Entry<Character, Integer>> comparator = Map.Entry.comparingByValue();

            list.sort(comparator.reversed());

            return list;
        }
    }
}