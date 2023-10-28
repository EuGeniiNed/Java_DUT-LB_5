public class Main {

    public static String decodeVowelReplacement(String encoded) {
        return encoded.replaceAll("1", "a")
                .replaceAll("2", "e")
                .replaceAll("3", "i")
                .replaceAll("4", "o")
                .replaceAll("5", "u");
    }

    public static String decodeConsonantReplacement(String encoded) {
        StringBuilder decoded = new StringBuilder();
        for (char c : encoded.toCharArray()) {
            if (Character.isLetter(c)) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    decoded.append(c);
                } else {
                    decoded.append(getNextConsonant(c));
                }
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }

    private static char getNextConsonant(char c) {
        String consonants = "bcdfghjklmnpqrstvwxyz";
        int index = consonants.indexOf(c);
        if (index != -1) {
            return consonants.charAt((index + 1) % consonants.length());
        }
        return c;
    }

    public static void main(String[] args) {
        String encodedVowel = "t2st3ng"; // Зашифроване слово заміною голосних
        String encodedConsonant = "ufttjoh"; // Зашифроване слово заміною приголосних

        System.out.println("Decoded Vowel Replacement: " + decodeVowelReplacement(encodedVowel));
        System.out.println("Decoded Consonant Replacement: " + decodeConsonantReplacement(encodedConsonant));
    }
}
