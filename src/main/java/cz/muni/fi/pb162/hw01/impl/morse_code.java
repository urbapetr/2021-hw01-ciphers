package cz.muni.fi.pb162.hw01.impl;

/**
 * @author Petr Urbanek
 */
public class morse_code {

    private final String message;

    public morse_code(String text){
        message = text;
    }

    public void encode(){
        String letters = "";
        for (int i = 0; i < message.length(); i++)
            switch(message.charAt(i)){
                case 'A': letters  = letters.concat(".-"); break;
                case 'B': letters  = letters.concat("-..."); break;
                case 'C': letters  = letters.concat("-.-."); break;
                case 'D': letters  = letters.concat("-.."); break;
                case 'E': letters  = letters.concat("."); break;
                case 'F': letters  = letters.concat("..-."); break;
                case 'G': letters  = letters.concat("--."); break;
                case 'H': letters  = letters.concat("...."); break;
                case 'I': letters  = letters.concat(".."); break;
                case 'J': letters  = letters.concat(".---"); break;
                case 'K': letters  = letters.concat("-.-"); break;
                case 'L': letters  = letters.concat(".-.."); break;
                case 'M': letters  = letters.concat("--"); break;
                case 'N': letters  = letters.concat("-"); break;
                case 'P': letters  = letters.concat(".--."); break;
                case 'O': letters  = letters.concat("---"); break;
                case 'Q': letters  = letters.concat("--.-"); break;
                case 'R': letters  = letters.concat(".-."); break;
                case 'S': letters  = letters.concat("..."); break;
                case 'T': letters  = letters.concat("-"); break;
                case 'U': letters  = letters.concat("..-"); break;
                case 'V': letters  = letters.concat("...-"); break;
                case 'W': letters  = letters.concat(".--"); break;
                case 'X': letters  = letters.concat("-..-"); break;
                case 'Y': letters  = letters.concat("-.--"); break;
                case 'Z': letters  = letters.concat("--.."); break;
                case '0': letters  = letters.concat("-----"); break;
                case '1': letters  = letters.concat(".----"); break;
                case '2': letters  = letters.concat("..---"); break;
                case '3': letters  = letters.concat("...--"); break;
                case '4': letters  = letters.concat("....-"); break;
                case '5': letters  = letters.concat("....."); break;
                case '6': letters  = letters.concat("-...."); break;
                case '7': letters  = letters.concat("--..."); break;
                case '8': letters  = letters.concat("---.."); break;
                case '9': letters  = letters.concat("----."); break;
                case '.': letters  = letters.concat(".-.-.-"); break;
                case ',': letters  = letters.concat("--..--"); break;
                case '?': letters  = letters.concat("..--.."); break;
                case '!': letters  = letters.concat("..--."); break;
                case ' ': letters  = letters.concat("|"); break;
            }
            letters = letters.concat("|");
        System.out.println(letters + "\n");
    }

    public void decode(){
        String words = "";
        String letters = "";
        for (int i = 0; i < message.length(); i++)
            if (message.charAt(i) == '|'){
                if (message.charAt(i+1) == '|'){

                }
            }

            switch(message.charAt(i)){
                case ".-": letters = letters.concat("A"); break;
                case 'B': letters  = letters.concat("-..."); break;
                case 'C': letters  = letters.concat("-.-."); break;
                case 'D': letters  = letters.concat("-.."); break;
                case 'E': letters  = letters.concat("."); break;
                case 'F': letters  = letters.concat("..-."); break;
                case 'G': letters  = letters.concat("--."); break;
                case 'H': letters  = letters.concat("...."); break;
                case 'I': letters  = letters.concat(".."); break;
                case 'J': letters  = letters.concat(".---"); break;
                case 'K': letters  = letters.concat("-.-"); break;
                case 'L': letters  = letters.concat(".-.."); break;
                case 'M': letters  = letters.concat("--"); break;
                case 'N': letters  = letters.concat("-"); break;
                case 'P': letters  = letters.concat(".--."); break;
                case 'O': letters  = letters.concat("---"); break;
                case 'Q': letters  = letters.concat("--.-"); break;
                case 'R': letters  = letters.concat(".-."); break;
                case 'S': letters  = letters.concat("..."); break;
                case 'T': letters  = letters.concat("-"); break;
                case 'U': letters  = letters.concat("..-"); break;
                case 'V': letters  = letters.concat("...-"); break;
                case 'W': letters  = letters.concat(".--"); break;
                case 'X': letters  = letters.concat("-..-"); break;
                case 'Y': letters  = letters.concat("-.--"); break;
                case 'Z': letters  = letters.concat("--.."); break;
                case '0': letters  = letters.concat("-----"); break;
                case '1': letters  = letters.concat(".----"); break;
                case '2': letters  = letters.concat("..---"); break;
                case '3': letters  = letters.concat("...--"); break;
                case '4': letters  = letters.concat("....-"); break;
                case '5': letters  = letters.concat("....."); break;
                case '6': letters  = letters.concat("-...."); break;
                case '7': letters  = letters.concat("--..."); break;
                case '8': letters  = letters.concat("---.."); break;
                case '9': letters  = letters.concat("----."); break;
                case '.': letters  = letters.concat(".-.-.-"); break;
                case ',': letters  = letters.concat("--..--"); break;
                case '?': letters  = letters.concat("..--.."); break;
                case '!': letters  = letters.concat("..--."); break;
                case ' ': letters  = letters.concat("|"); break;
            }
        letters = letters.concat("|");
        System.out.println(letters + "\n");
    }

}
