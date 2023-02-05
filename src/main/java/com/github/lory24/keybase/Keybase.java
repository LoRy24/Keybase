package com.github.lory24.keybase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

/**
 * Keybase API main class. This contains all the utility functions that are used to work with the Keybase database system.
 * <p>
 * One of the main features of this class is the one that allows you to create a connection between you and the file. The
 * connection itself is not something that updates when the data is updated. In fact, it will only load the data into an
 * object that you can use to read it. The special thing about it is that the file is marked as "in use". For more details,
 * see {@link KeybaseConnection}
 *
 * @author                          Lorenzo Rocca
 * @see                             KeybaseConnection
 */
@UtilityClass
public class Keybase {

    /**
     * The GSON object used from the core
     */
    public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * This function creates a connection to a new file. Be sure that the file is created, and it doesn't contain any
     * data that is not in the proper format.
     *
     * @param fileLocation          The location of the database file
     * @throws IOException          If a IO error occurs when reading the data from the file
     * @throws JsonSyntaxException  If the file doesn't contain a proper JSON format for the database object
     * @return                      The initialized connection
     */
    public KeybaseConnection createConnection(final Path fileLocation) throws IOException {
        return new KeybaseConnectionImpl(Optional.ofNullable(gson.fromJson(new String(Files.readAllBytes(fileLocation)), KeybaseDatabaseObject.class))
                .orElse(new KeybaseDatabaseObject()), new File(fileLocation.toUri()));
    }
}
