package cz.muni.fi.pb162.hw01.impl;

/**
 * @author Petr Urbanek
 */
public class VigenereCipher {

    private final String MESSAGE;
    private String keyMessage;
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public VigenereCipher(String text, String key){
        keyMessage = key;
        MESSAGE = text;
    }

    public void encode(){
        String letters = "";
        int moveBy;
        int y;
        for (int i = 0; i < MESSAGE.length(); i++){
            y = i;
            while (y > keyMessage.length() - 1){
                y = y - keyMessage.length();
            }
            moveBy = ALPHABET.indexOf(MESSAGE.charAt(i)) + ALPHABET.indexOf(keyMessage.charAt(y));
            if (moveBy > ALPHABET.length() - 1){
                moveBy -= ALPHABET.length();
            }
            if (moveBy < 0){
                moveBy += ALPHABET.length();
            }
            letters = letters.concat(Character.toString(ALPHABET.charAt(moveBy)));
        }
        System.out.println(letters + "\n");
    }

    public void decode(){
        String newKeyMessage = "";
        String character = "";
        for (int i = 0; i < keyMessage.length(); i++) {
            character = Character.toString(ALPHABET.charAt(ALPHABET.length() - ALPHABET.indexOf(keyMessage.charAt(i))));
            newKeyMessage = newKeyMessage.concat(character);
        }
        keyMessage = newKeyMessage;
        encode();
    }
}
