
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String [] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            System.out.println("\nПриветсвую тебя мой друг, выбери действие: \n" +
                    "1 - зашировать \n" +
                    "2 - расшифровать \n" +
                    "3 - подобрать ключ к зашифрованному файлу методом Bruteforce \n" +
                    "4 - расшифровать текст в файле методом статистического перебора\n" +
                    " для выода из программы, введите EXIT");

            String stringSwitch = reader.readLine();

            switch (stringSwitch) {
                case ("1") -> ChoiceOne.choiceOne();
                case ("2") -> ChoiceTwo.choiceTwo();
                case ("3") -> ChoiceThree.choiceThree();
                case ("4") -> ChoiceFour.choiceFour();
            }
            if (stringSwitch.equalsIgnoreCase("Exit")) {
                break;
            }
        }
    }

}

