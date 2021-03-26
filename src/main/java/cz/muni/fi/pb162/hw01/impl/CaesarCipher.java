package cz.muni.fi.pb162.hw01.impl;

/**
 * Caesar cipher is using key to move with characters
 * @author Petr Urbanek
 */
public class CaesarCipher {

    private final String MESSAGE;
    private int key;
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public CaesarCipher(String text, int number){
        key = -1*number;
        MESSAGE = text;
    }

    /**
     * Encode of Caesar cipher using moveBy to count
     * which character it is from ALPHABET
     */
    public void encode(){
        String letters = "";
        int moveBy;
        for (int i = 0; i < MESSAGE.length(); i++){
            moveBy = ALPHABET.indexOf(MESSAGE.charAt(i)) + key;
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

    /**
     * Using encode with (-1) * key
     */
    public void decode(){
        key *=-1;
        encode();
    }
}
