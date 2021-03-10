package cz.muni.fi.pb162.hw01;

import cz.muni.fi.pb162.hw01.impl.Application;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

final class CipherTest {

    private static PrintStream outBcp;
    private static PrintStream errBcp;

    private static ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static PrintStream outStream = new PrintStream(out);
    private static ByteArrayOutputStream err = new ByteArrayOutputStream();
    private static PrintStream errStream = new PrintStream(err);

    @BeforeAll
    static void setupClass() {
        outBcp = System.out;
        errBcp = System.err;
        System.setOut(outStream);
        System.setErr(errStream);
    }

    @AfterAll
    static void teardownClass() {
        System.setOut(outBcp);
        System.setErr(errBcp);
    }

    void assertOutput(ByteArrayOutputStream stream, boolean ignoreCase, String expected) {
        String actual = stream.toString().trim();
        if (ignoreCase) {
            assertThat(actual).containsIgnoringCase(expected);
        } else {
            assertThat(actual).contains(expected);
        }
        stream.reset();
    }

    @TestFactory
    Stream<DynamicTest> cipherTestFactory() throws IOException {
        Path resources = Paths.get("src", "test", "resources");
        Stream<DynamicTest> morse = Files
                .list(resources.resolve("morse"))
                .flatMap(p -> testFromFile(p, this::testMorse));
        Stream<DynamicTest> caesar = Files
                .list(resources.resolve("caesar"))
                .flatMap(p -> testFromFile(p, this::testCaesar));
        Stream<DynamicTest> vigenere = Files
                .list(resources.resolve("vigenere"))
                .flatMap(p -> testFromFile(p, this::testVigenere));
        return Stream.concat(Stream.concat(morse, caesar), vigenere);
    }

    private Stream<DynamicTest> testMorse(Path path, String[] input) {
        String plainText = input[1].trim();
        String cipherText = input[2].trim();
        return testCipher(
                path, true, plainText, cipherText,
                new String[]{"-o", "ENCRYPT", "-t", plainText},
                new String[]{"-o", "DECRYPT", "-t", cipherText}
        );
    }

    private Stream<DynamicTest> testCaesar(Path path, String[] input) {
        String param = input[0].trim();
        String plainText = input[1].trim();
        String cipherText = input[2].trim();
        return testCipher(
                path, false, plainText, cipherText,
                new String[]{"-c", "CAESAR", "--shift", param, "-o", "ENCRYPT", "-t", plainText},
                new String[]{"-c", "CAESAR", "--shift", param, "-o", "DECRYPT", "-t", cipherText}
        );
    }

    private Stream<DynamicTest> testVigenere(Path path, String[] input) {
        String param = input[0].trim();
        String plainText = input[1].trim();
        String cipherText = input[2].trim();
        return testCipher(
                path, false, plainText, cipherText,
                new String[]{"-c", "VIGENERE", "--key", param, "-o", "ENCRYPT", "-t", plainText},
                new String[]{"-c", "VIGENERE", "--key", param, "-o", "DECRYPT", "-t", cipherText}
        );
    }

    private Stream<DynamicTest> testCipher(Path path, boolean ignoreCase, String plainText, String cipherText, String[] cipherCmd, String[] decipherCmd) {
        String name = path.getParent().getFileName().toString() + "_" + path.getFileName().toString();
        return Stream.of(
                DynamicTest.dynamicTest( name + "_cipher", () -> {
                    Application.main(cipherCmd);
                    assertOutput(out, ignoreCase, cipherText);
                }),
                DynamicTest.dynamicTest(name + "_decipher", () -> {
                    Application.main((decipherCmd));
                    assertOutput(out, ignoreCase, plainText);
                })
        );
    }

    private Stream<DynamicTest> unableToReadFile(Path path, String message) {
        return Stream.of(DynamicTest.dynamicTest(path.getFileName().toString(), () -> fail(message)));
    }

    private Stream<DynamicTest> testFromFile(Path path, BiFunction<Path, String[], Stream<DynamicTest>> cipherTest) {
        try {
            String content = Files.readString(path);
            String[] parts = content.split("===\\r?\\n", 3);
            if (parts.length != 3) {
                return unableToReadFile(path, "Invalid file format");
            }
            return cipherTest.apply(path, parts);
        } catch (IOException e) {
            return unableToReadFile(path, "Unable to read input file.");
        }
    }
}
