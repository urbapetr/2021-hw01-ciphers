package cz.muni.fi.pb162.hw01.cmd;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

public final class CommandLineParser {

    private final JCommander commander;

    public CommandLineParser(Object application) {
        commander = JCommander.newBuilder()
                .addObject(application)
                .build();

        commander.setProgramName(application.getClass().getSimpleName());
    }

    public void parseArguments(String[] args) {
        try {
            commander.parse(args);
        } catch (ParameterException ex) {
            System.err.println("Error: " + ex.getMessage());
            showUsage(1);
        }
    }

    public void showUsage() {
        showUsage(0);
    }

    private void showUsage(int status) {
        commander.usage();
        System.exit(status);
    }
}
