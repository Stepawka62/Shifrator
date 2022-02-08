public class CeaserCliper {

    private static final String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";


    public String encrypted(String message, int key) { // кеу = 3.


        StringBuilder result = new StringBuilder(); //экономит ресурсы


            //Привет
        for (char aChar : message.toCharArray()) {

            int origAlphabetPosition = ALPHABET.indexOf(aChar); //номер буквы в алфавите (начальный)

            int newAlphabetPosition = (origAlphabetPosition + key) % (ALPHABET.length() / 2); // смещаем на значение KEY.

            char newCharapter = ALPHABET.charAt(newAlphabetPosition); // находит новый символ с новой позицией (индекс)

            result.append(newCharapter); //собираем новое слово из символов  (преобразует в StringBuilder)

        }





        return result.toString();
  }

  public String deEncrypted(String message, int key) {return null; }

}
