package cz.muni.fi.pb162.hw01.impl;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import cz.muni.fi.pb162.hw01.CipherType;
import cz.muni.fi.pb162.hw01.Operation;
import cz.muni.fi.pb162.hw01.Utils;
import cz.muni.fi.pb162.hw01.cmd.CipherTypeConverter;
import cz.muni.fi.pb162.hw01.cmd.OperationConverter;

/**
 * Application class represents the command line interface of this application.
 *
 * You are expected to implement  the  {@link Application#run()} method
 *
 * @author jcechace
 */
public class Application {

    @Parameter(names = {"--cipher", "-c"}, converter = CipherTypeConverter.class)
    private CipherType cipherType = CipherType.MORSE_CODE;

    @Parameter(names = {"--operation", "-o"}, required = true, converter = OperationConverter.class)
    private Operation operation;

    @Parameter(names = {"--text", "-t"}, required = true)
    private String text;

    @Parameter(names = {"--shift"})
    private int caesarShift;

    @Parameter(names = {"--key"})
    private String vigenereKey;

    @Parameter(names = "--help", help = true)
    private boolean showUsage = false;

    /**
     * Application entry point
     *
     * @param args command line arguments of the application
     */
    public static void main(String[] args) {
        Application app = new Application();

        JCommander commander = JCommander.newBuilder().addObject(app).build();
        commander.setProgramName("application");
        try {
            commander.parse(args);
        } catch (ParameterException pe) {
            System.err.println("Error: " + pe.getMessage());
            commander.usage();
            System.exit(1);
        }

        if (app.showUsage) {
            commander.usage();
            return;
        }
        app.run();
    }

    /**
     * Application runtime logic
     */
    private void run() {
        Utils.error("Remove this and implement this method");
    }
}
