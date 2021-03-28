package cz.muni.fi.pb162.hw01.impl;

/**
 * Caesar cipher is using key to move with characters
 * @author Petr Urbanek
 */
public class CaesarCipher {

    private final String message;
    private int key;
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * @param text which will be decoded/encoded
     * @param number how much will by characters moved
     */
    public CaesarCipher(String text, int number){
        key = number;
        message = text;
    }

    /**
     * Encode of Caesar cipher using moveBy to count
     * which character it is from ALPHABET
     */
    public void encode(){
        String letters = "";
        int moveBy;
        boolean space = false;
        for (int i = 0; i < message.length(); i++){
            if ((Character.toString(message.charAt(i))).equals(" ")){
                space = true;
                continue;
            }
            if (!(alphabet.contains(Character.toString(message.charAt(i))))){
                System.out.println(message.charAt(i));
                letters = letters.concat(Character.toString(message.charAt(i)));
                continue;
            }
            moveBy = alphabet.indexOf(message.charAt(i)) + key;
            if (moveBy > alphabet.length() - 1){
                moveBy -= alphabet.length();
            }
            if (moveBy < 0){
                moveBy += alphabet.length();
            }
            if (space){
                letters = letters.concat(" ".concat(Character.toString(alphabet.charAt(moveBy))));
            } else {
                letters = letters.concat(Character.toString(alphabet.charAt(moveBy)));
            }
            space = false;
        }
        System.out.println(letters + "\n");
    }

    /**
     * Using encode with (-1) * key
     */
    public void decode(){
        key *=-1;
        encode();
    }
}
