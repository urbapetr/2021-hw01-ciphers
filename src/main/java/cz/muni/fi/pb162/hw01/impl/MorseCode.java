package cz.muni.fi.pb162.hw01.impl;

/**
 * Morse code, every character have his own "code", this code is
 * joined together into message of . (dots) and - (minus), or
 * better said, into . (short) and - (long) signal
 * @author Petr Urbanek
 */
public class MorseCode {

    private final String message;

    /**
     * @param text which will be decoded/encoded
     */
    public MorseCode(String text){
        message = text;
    }

    /**
     * Encode of Morse code using switch to identify
     * each character
     */
    public void encode(){
        String letters = "";
        for (int i = 0; i < message.length(); i++) {
            switch (message.charAt(i)) {
                case 'a': case 'A': letters = letters.concat(".-|"); break;
                case 'b': case 'B': letters = letters.concat("-...|"); break;
                case 'c': case 'C': letters = letters.concat("-.-.|"); break;
                case 'd': case 'D': letters = letters.concat("-..|"); break;
                case 'e': case 'E': letters = letters.concat(".|"); break;
                case 'f': case 'F': letters = letters.concat("..-.|"); break;
                case 'g': case 'G': letters = letters.concat("--.|"); break;
                case 'h': case 'H': letters = letters.concat("....|"); break;
                case 'i': case 'I': letters = letters.concat("..|"); break;
                case 'j': case 'J': letters = letters.concat(".---|"); break;
                case 'k': case 'K': letters = letters.concat("-.-|"); break;
                case 'l': case 'L': letters = letters.concat(".-..|"); break;
                case 'm': case 'M': letters = letters.concat("--|"); break;
                case 'n': case 'N': letters = letters.concat("-.|"); break;
                case 'p': case 'P': letters = letters.concat(".--.|"); break;
                case 'o': case 'O': letters = letters.concat("---|"); break;
                case 'q': case 'Q': letters = letters.concat("--.-|"); break;
                case 'r': case 'R': letters = letters.concat(".-.|"); break;
                case 's': case 'S': letters = letters.concat("...|"); break;
                case 't': case 'T': letters = letters.concat("-|"); break;
                case 'u': case 'U': letters = letters.concat("..-|"); break;
                case 'v': case 'V': letters = letters.concat("...-|"); break;
                case 'w': case 'W': letters = letters.concat(".--|"); break;
                case 'x': case 'X': letters = letters.concat("-..-|"); break;
                case 'y': case 'Y': letters = letters.concat("-.--|"); break;
                case 'z': case 'Z': letters = letters.concat("--..|"); break;
                case '0': letters = letters.concat("-----|"); break;
                case '1': letters = letters.concat(".----|"); break;
                case '2': letters = letters.concat("..---|"); break;
                case '3': letters = letters.concat("...--|"); break;
                case '4': letters = letters.concat("....-|"); break;
                case '5': letters = letters.concat(".....|"); break;
                case '6': letters = letters.concat("-....|"); break;
                case '7': letters = letters.concat("--...|"); break;
                case '8': letters = letters.concat("---..|"); break;
                case '9': letters = letters.concat("----.|"); break;
                case '.': letters = letters.concat(".-.-.-|"); break;
                case ',': letters = letters.concat("--..--|"); break;
                case '?': letters = letters.concat("..--..|"); break;
                case '!': letters = letters.concat("..--.|"); break;
                case ' ': letters = letters.concat("|"); break;
                default: break;
            }
        }
        System.out.println(letters + "\n");
    }

    /**
     * Decode of Morse code using switch to identify
     * each character
     */
    public void decode(){
        String letters = "";
        String word = "";
        String newChar = "";
        boolean space = false;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == '|') {
                if (word.equals("")) {
                    space = true;
                } else{
                    newChar = decodeCharacter(word);
                            if (newChar.equals("NONE")){
                                word = "";
                            } else {
                                word = newChar;
                            }
                }
                if (space) {
                    letters = letters.concat(" ").concat(word);
                } else {
                    letters = letters.concat(word);
                }
                space = false;
                word = "";
            } else {
                word = word.concat(Character.toString(message.charAt(i)));
            }
        }
        System.out.println(letters + "\n");
    }

    /**
     *  Decoder characters
     * @param character to decode
     * @return decoded char
     */
    public String decodeCharacter(String character){
        switch (character){
            case ".-": return "A";
            case "-...": return "B";
            case "-.-.": return "C";
            case "-..": return "D";
            case ".": return "E";
            case "..-.": return "F";
            case "--.": return "G";
            case "....": return "H";
            case "..": return "I";
            case ".---": return "J";
            case "-.-": return "K";
            case ".-..": return "L";
            case "--": return "M";
            case "-.": return "N";
            case ".--.": return "P";
            case "---": return "O";
            case "--.-": return "Q";
            case ".-.": return "R";
            case "...": return "S";
            case "-": return "T";
            case "..-": return "U";
            case "...-": return "V";
            case ".--": return "W";
            case "-..-": return "X";
            case "-.--": return "Y";
            case "--..": return "Z";
            case "-----": return "0";
            case ".----": return "1";
            case "..---": return "2";
            case "...--": return "3";
            case "....-": return "4";
            case ".....": return "5";
            case "-....": return "6";
            case "--...": return "7";
            case "---..": return "8";
            case "----.": return "9";
            case ".-.-.-": return ".";
            case "--..--": return ",";
            case "..--..": return "?";
            case "..--.": return "!";
            default: return "NONE";
        }
    }
}