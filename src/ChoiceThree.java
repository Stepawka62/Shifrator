import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class ChoiceThree {

    public static void choiceThree() throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("ВВедите полный путь к файлу, для его расшифровки.");
        String pathEncryptedFile = scanner.nextLine();

        System.out.println("Введите полный путь к фалйу, в который записать расшифрованный текст.");
        String pathNotEncryptedFile = scanner.nextLine();

        CeaserCliper ceaserCliper = new CeaserCliper();

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(pathEncryptedFile));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(pathNotEncryptedFile))
             ) {
            StringBuilder stringBuilder = new StringBuilder();

           while (bufferedReader.ready()) {
               String string = bufferedReader.readLine();
               stringBuilder.append(string).append(System.lineSeparator());
           }
            for (int i = 0; i < ceaserCliper.maxSize; i++) { //key = 10
               String deEncrypted =  ceaserCliper.deEncrypted(stringBuilder.toString(), i);
               if(isValidText(deEncrypted)) {
                   bufferedWriter.write(deEncrypted);
                   System.out.println("Содержимое файла расшифровано методом перебора ключей.K = " + i);
                   break;
               }
            }
        }
    }
    private static boolean isValidText(String text) {

       boolean flag = false;

       String[] strings =  text.split(" ");
        for (String string : strings) {
            if(string.length() > 24) {
                return  false;
            }

        }
        if(text.contains(". ") || text.contains(", ") || text.contains("! ") || text.contains("? ")) {
            flag = true;
        }

        int stringStart = new Random().nextInt(text.length() / 2);

        System.out.println(text.substring(stringStart, stringStart + (int)Math.sqrt(text.length())));
        System.out.println("Понятен ли вам данный текст? y / n ");

        Scanner scanner = new Scanner(System.in);
        String nextline = scanner.nextLine();
        if(nextline.equalsIgnoreCase("Y")) {
            flag = true;
        } else if (nextline.equalsIgnoreCase("N")) {
            flag =  false;
        } else {
            System.out.println("Выберите или Y или N");
        }
        return flag;
    }
}
