package cz.muni.fi.pb162.hw01.impl.ciphers;

/**
 * Cipher interface mandating encrypt end decrypt functionality
 */
public interface Cipher {

    String ALPHABET =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "abcdefghijklmnopqrstuvwxyz" +
            "0123456789";

    /**
     * Encrypts given text by this cipher
     *
     * @param plainText text to be encrypted
     * @return encrypted text
     */
    String encrypt(String plainText);

    /**
     * Decrypts given cipher text
     *
     * @param cypherText encrypted text
     * @return original text
     */
    String decrypt(String cypherText);

}
