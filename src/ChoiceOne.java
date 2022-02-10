import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ChoiceOne {

    public static void choiceOne() throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите полный путь к файлу, для его зашифровки.");
        String pathNotEncryptedFile = scanner.nextLine();

        System.out.println("Введите ключ шифровния.");
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите полный путь к файлу, в который записать зашифрованный файл.");
        String pathEncryptedFile = scanner.nextLine();

        CeaserCliper ceaserCliper = new CeaserCliper();

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(pathNotEncryptedFile));
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(pathEncryptedFile))
        ) {
           while (bufferedReader.ready()) {
            String string = bufferedReader.readLine();
            String encryptedString = ceaserCliper.encrypted(string, key);
            bufferedWriter.write(encryptedString + System.lineSeparator());
           }
        }
        System.out.println("Содержимое файла зашифровано");
        //try - (ресурсы) попытка отлова ошибок
        //catch - обработка ошибок
        //finally - код выполнится всегда (чтобы не произашло)
    }
}
