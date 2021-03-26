package cz.muni.fi.pb162.hw01.impl;

/**
 * Morse code, every character have his own "code", this code is
 * joined together into message of . (dots) and - (minus), or
 * better said, into . (short) and - (long) signal
 * @author Petr Urbanek
 */
public class MorseCode {

    private final String MESSAGE;

    public MorseCode(String text){
        MESSAGE = text;
    }

    /**
     * Encode of Morse code using switch to identify
     * each character
     */
    public void encode(){
        String letters = "";
        for (int i = 0; i < MESSAGE.length(); i++)
            switch(MESSAGE.charAt(i)){
                case 'a':
                case 'A': letters  = letters.concat(".-|"); break;
                case 'b':
                case 'B': letters  = letters.concat("-...|"); break;
                case 'c':
                case 'C': letters  = letters.concat("-.-.|"); break;
                case 'd':
                case 'D': letters  = letters.concat("-..|"); break;
                case 'e':
                case 'E': letters  = letters.concat(".|"); break;
                case 'f':
                case 'F': letters  = letters.concat("..-.|"); break;
                case 'g':
                case 'G': letters  = letters.concat("--.|"); break;
                case 'h':
                case 'H': letters  = letters.concat("....|"); break;
                case 'i':
                case 'I': letters  = letters.concat("..|"); break;
                case 'j':
                case 'J': letters  = letters.concat(".---|"); break;
                case 'k':
                case 'K': letters  = letters.concat("-.-|"); break;
                case 'l':
                case 'L': letters  = letters.concat(".-..|"); break;
                case 'm':
                case 'M': letters  = letters.concat("--|"); break;
                case 'n':
                case 'N': letters  = letters.concat("-.|"); break;
                case 'p':
                case 'P': letters  = letters.concat(".--.|"); break;
                case 'o':
                case 'O': letters  = letters.concat("---|"); break;
                case 'q':
                case 'Q': letters  = letters.concat("--.-|"); break;
                case 'r':
                case 'R': letters  = letters.concat(".-.|"); break;
                case 's':
                case 'S': letters  = letters.concat("...|"); break;
                case 't':
                case 'T': letters  = letters.concat("-|"); break;
                case 'u':
                case 'U': letters  = letters.concat("..-|"); break;
                case 'v':
                case 'V': letters  = letters.concat("...-|"); break;
                case 'w':
                case 'W': letters  = letters.concat(".--|"); break;
                case 'x':
                case 'X': letters  = letters.concat("-..-|"); break;
                case 'y':
                case 'Y': letters  = letters.concat("-.--|"); break;
                case 'z':
                case 'Z': letters  = letters.concat("--..|"); break;
                case '0': letters  = letters.concat("-----|"); break;
                case '1': letters  = letters.concat(".----|"); break;
                case '2': letters  = letters.concat("..---|"); break;
                case '3': letters  = letters.concat("...--|"); break;
                case '4': letters  = letters.concat("....-|"); break;
                case '5': letters  = letters.concat(".....|"); break;
                case '6': letters  = letters.concat("-....|"); break;
                case '7': letters  = letters.concat("--...|"); break;
                case '8': letters  = letters.concat("---..|"); break;
                case '9': letters  = letters.concat("----.|"); break;
                case '.': letters  = letters.concat(".-.-.-|"); break;
                case ',': letters  = letters.concat("--..--|"); break;
                case '?': letters  = letters.concat("..--..|"); break;
                case '!': letters  = letters.concat("..--.|"); break;
                case ' ': letters  = letters.concat("||"); break;
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
        for (int i = 0; i < MESSAGE.length(); i++)
            if (MESSAGE.charAt(i) == '|'){
                switch(word) {
                    case ".-": letters = letters.concat("A"); break;
                    case "-...": letters = letters.concat("B"); break;
                    case "-.-.":letters = letters.concat("C"); break;
                    case "-..": letters = letters.concat("D"); break;
                    case ".": letters = letters.concat("E"); break;
                    case "..-.": letters = letters.concat("F"); break;
                    case "--.": letters = letters.concat("G"); break;
                    case "....": letters = letters.concat("H"); break;
                    case "..": letters = letters.concat("I"); break;
                    case ".---": letters = letters.concat("J"); break;
                    case "-.-": letters = letters.concat("K"); break;
                    case ".-..": letters = letters.concat("L"); break;
                    case "--": letters = letters.concat("M"); break;
                    case "-.": letters = letters.concat("N"); break;
                    case ".--.": letters = letters.concat("P"); break;
                    case "---": letters = letters.concat("O"); break;
                    case "--.-": letters = letters.concat("Q"); break;
                    case ".-.": letters = letters.concat("R"); break;
                    case "...": letters = letters.concat("S"); break;
                    case "-": letters = letters.concat("T"); break;
                    case "..-": letters = letters.concat("U"); break;
                    case "...-": letters = letters.concat("V"); break;
                    case ".--": letters = letters.concat("W"); break;
                    case "-..-": letters = letters.concat("X"); break;
                    case "-.--": letters = letters.concat("Y"); break;
                    case "--..": letters = letters.concat("Z"); break;
                    case "-----": letters = letters.concat("0"); break;
                    case ".----": letters = letters.concat("1"); break;
                    case "..---": letters = letters.concat("2"); break;
                    case "...--": letters = letters.concat("3"); break;
                    case "....-": letters = letters.concat("4"); break;
                    case ".....": letters = letters.concat("5"); break;
                    case "-....": letters = letters.concat("6"); break;
                    case "--...": letters = letters.concat("7"); break;
                    case "---..": letters = letters.concat("8"); break;
                    case "----.": letters = letters.concat("9"); break;
                    case ".-.-.-": letters = letters.concat("."); break;
                    case "--..--": letters = letters.concat(","); break;
                    case "..--..": letters = letters.concat("?"); break;
                    case "..--.": letters = letters.concat("!"); break;
                    case "": letters = letters.concat(" "); break;
                }
                word = "";
            }
            else{word = word.concat(Character.toString(MESSAGE.charAt(i)));}
        System.out.println(letters + "\n");
    }

}
