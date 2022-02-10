import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(pathNotEncryptedFile));
             ) {
            StringBuilder stringBuilder = new StringBuilder();

           while (bufferedReader.ready()) {
               String string = bufferedReader.readLine();
               stringBuilder.append(string).append(System.lineSeparator());
           }
            for (int i = 0; i < ceaserCliper.maxSize; i++) { //key = 10
               String deEncrypted =  ceaserCliper.deEncrypted(stringBuilder.toString(), i);
            }



        }






    }
}
