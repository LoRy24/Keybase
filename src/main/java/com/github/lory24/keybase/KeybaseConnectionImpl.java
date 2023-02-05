package com.github.lory24.keybase;

import com.github.lory24.keybase.exceptions.ConnectionAlreadyClosedException;
import com.github.lory24.keybase.exceptions.ConnectionClosedException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * This class is the main implementation of the {@link KeybaseConnection} interface. If you want more details about the
 * connection system, you should visit that class.
 *
 * @author                          Lorenzo Rocca
 * @see                             KeybaseConnection
 */
public class KeybaseConnectionImpl implements KeybaseConnection {

    private final KeybaseDatabaseObject databaseObject;
    private final File file;
    private boolean closed = false;

    /**
     * Main constructor for the Keybase connection object. This initializes all the first fields.
     *
     * @param databaseObject        The database object loaded from the file
     * @param file                  The file from where the data is loaded
     */
    public KeybaseConnectionImpl(KeybaseDatabaseObject databaseObject, File file) {
        this.databaseObject = databaseObject;
        this.file = file;
    }

    /**
     * Gets an object from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    @Override
    public Object get(String key) throws ConnectionClosedException {
        if (this.closed) throw new ConnectionClosedException();
        return this.databaseObject.getData().get(key);
    }

    /**
     * Gets a String from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    @Override
    public String getString(String key) throws ConnectionClosedException {
        return (String) this.get(key);
    }

    /**
     * Gets an integer value from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    @Override
    public int getInt(String key) throws ConnectionClosedException {
        return (int) this.get(key);
    }

    /**
     * Gets a double value from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    @Override
    public double getDouble(String key) throws ConnectionClosedException {
        return (double) this.get(key);
    }

    /**
     * Gets a floating point value from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    @Override
    public float getFloat(String key) throws ConnectionClosedException {
        return (float) this.get(key);
    }

    /**
     * Gets a byte from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    @Override
    public byte getByte(String key) throws ConnectionClosedException {
        return (byte) this.get(key);
    }

    /**
     * Gets a short value from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    @Override
    public short getShort(String key) throws ConnectionClosedException {
        return (short) this.get(key);
    }

    /**
     * Gets a long value from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    @Override
    public long getLong(String key) throws ConnectionClosedException {
        return (long) this.get(key);
    }

    /**
     * Updates or add an Object to the database object of the connection. Cannot add multiple values with the same key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    @Override
    public void set(String key, Object value) throws ConnectionClosedException {
        if (this.closed) throw new ConnectionClosedException();
        if (!this.exists(key)) this.databaseObject.getData().put(key, value);
        else this.databaseObject.getData().replace(key, value);
    }

    /**
     * Updates or add a String to the database object of the connection. Cannot add multiple values with the same key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    @Override
    public void setString(String key, String value) throws ConnectionClosedException {
        this.set(key, value);
    }

    /**
     * Updates or add an integer value to the database object of the connection. Cannot add multiple values with the
     * same key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    @Override
    public void setInt(String key, int value) throws ConnectionClosedException {
        this.set(key, value);
    }

    /**
     * Updates or add a double value to the database object of the connection. Cannot add multiple values with the same
     * key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    @Override
    public void setDouble(String key, double value) throws ConnectionClosedException {
        this.set(key, value);
    }

    /**
     * Updates or add a floating point value to the database object of the connection. Cannot add multiple values with
     * the same key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    @Override
    public void setFloat(String key, float value) throws ConnectionClosedException {
        this.set(key, value);
    }

    /**
     * Updates or add a byte to the database object of the connection. Cannot add multiple values with the same key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    @Override
    public void setByte(String key, byte value) throws ConnectionClosedException {
        this.set(key, value);
    }

    /**
     * Updates or add a short value to the database object of the connection. Cannot add multiple values with the same
     * key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    @Override
    public void setShort(String key, short value) throws ConnectionClosedException {
        this.set(key, value);
    }

    /**
     * Updates or add a long value to the database object of the connection. Cannot add multiple values with the same
     * key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    @Override
    public void setLong(String key, short value) throws ConnectionClosedException {
        this.set(key, value);
    }

    /**
     * Remove a value from the database register. The value can also not be present in the database. In that case, nothing
     * will be done.
     *
     * @param key                   The key of the object that should be removed
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    @Override
    public void remove(String key) throws ConnectionClosedException {
        if (this.closed) throw new ConnectionClosedException();
        this.databaseObject.getData().remove(key);
    }

    /**
     * This functions checks if a key is registered inside the database.
     *
     * @param key                   The key to check
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      If the key is present inside the db
     */
    @Override
    public boolean exists(String key) throws ConnectionClosedException {
        if (this.closed) throw new ConnectionClosedException();
        return this.databaseObject.getData().containsKey(key);
    }

    /**
     * Save all the edits in the file where the connection is connected to. Remember that if anyone has made an external
     * edit to it, it will be overwritten by this action.
     *
     * @throws ConnectionClosedException If the connection is closed, but an attempt to save the db is made
     * @throws IOException          If an I/O error occur
     */
    @Override
    public void save() throws IOException, ConnectionClosedException {
        if (this.closed) throw new ConnectionClosedException();
        Files.write(this.file.toPath(), Keybase.gson.toJson(this.databaseObject).getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Closes the connection by closing the writing bridge between the application and the application. This will also
     * empty the database object, in order to clean the memory in the JVM. If any IO action is executed after the connection
     * is closed, an exception will be thrown.
     *
     * @throws ConnectionAlreadyClosedException If the application tries to close the application when it's already
     *                              closed
     */
    @Override
    public void close() throws ConnectionAlreadyClosedException {
        if (this.closed) throw new ConnectionAlreadyClosedException();
        this.closed = true;
        this.databaseObject.getData().clear();
    }

    /**
     * This function returns the status of the connection (if it's closed or not). Because the idea is this, you can run
     * this function also when the connection is closed.
     *
     * @return True or false
     */
    @Override
    public boolean isClosed() {
        return this.closed;
    }

    @Override
    protected void finalize() throws Throwable {
        this.save();
        this.close();
    }
}
