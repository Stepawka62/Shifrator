public class CeaserCliper {

    private static final String ALPHABET_PART_ONE = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String ALPHABET_PART_TWO = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    private static final String ALPHABET = ALPHABET_PART_ONE + ALPHABET_PART_TWO;

    public String encrypted(String message, int key) { // кеу = 3.

        StringBuilder result = new StringBuilder(); //экономит ресурсы

            //Привет
        for (char aChar : message.toCharArray()) {

            int origAlphabetPosition = ALPHABET.indexOf(aChar); //номер буквы в алфавите (начальный)
            int newAlphabetPosition;// новая индекс зашиврованного символа.
            char newCharacter = 0;// новый символ (зашиврованный).

            if (origAlphabetPosition > 0) {
                if (key > 0) {
                    newAlphabetPosition = (origAlphabetPosition + key) % (ALPHABET.length() / 2);
                } else {
                    int newKey = key % (ALPHABET.length() / 2);
                    newAlphabetPosition = (origAlphabetPosition + (ALPHABET.length() / 2) + newKey) % ALPHABET.length();
                }
                newCharacter = ALPHABET.charAt(newAlphabetPosition); // находит новый символ с новой позицией (индекс)
            }
            result.append(newCharacter); //собираем новое слово из символов  (преобразует в StringBuilder)
        }
        return result.toString();
  }

  public String deEncrypted(String message, int key) {
        return encrypted(message, key * (-1));
    }

}
