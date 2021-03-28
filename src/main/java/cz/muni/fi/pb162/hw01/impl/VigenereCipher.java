package cz.muni.fi.pb162.hw01.impl;

/**
 * This class works for Vigenere cipher which "move" character into different
 * character by another string
 * @author Petr Urbanek
 */
public class VigenereCipher {

    private final String message;
    private String keyMessage;
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * @param text which will be decoded/encoded
     * @param key messege which will be using every character like key
     */
    public VigenereCipher(String text, String key){
        keyMessage = key;
        message = text;
    }

    /**
     * Encode of Vigenere cipher using index of chars together into
     * moveBy to count which character it is from ALPHABET
     */
    public void encode(){
        String letters = "";
        int moveBy;
        int y;
        boolean space = false;
        for (int i = 0; i < message.length(); i++){
            y = i;
            if ((Character.toString(message.charAt(i))).equals(" ")){
                space = true;
                continue;
            }
            if (!(alphabet.contains(Character.toString(message.charAt(i))))){
                System.out.println(message.charAt(i));
                letters = letters.concat(Character.toString(message.charAt(i)));
                continue;
            }
            while (y > keyMessage.length() - 1){
                y = y - keyMessage.length();
            }
            moveBy = alphabet.indexOf(message.charAt(i)) + alphabet.indexOf(keyMessage.charAt(y));
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
     * Using encode
     */
    public void decode(){
        String newKeyMessage = "";
        String character = "";
        for (int i = 0; i < keyMessage.length(); i++) {
            character = Character.toString(alphabet.charAt(alphabet.length() - alphabet.indexOf(keyMessage.charAt(i))));
            newKeyMessage = newKeyMessage.concat(character);
        }
        keyMessage = newKeyMessage;
        encode();
    }
}
