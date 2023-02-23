package com.github.lory24.keybase;

import com.github.lory24.keybase.exceptions.ConnectionAlreadyClosedException;
import com.github.lory24.keybase.exceptions.ConnectionClosedException;

import java.io.IOException;

/**
 * The Keybase connection is a "writing-bridge" between the Java application and the database itself. When this object is
 * initialized, it will contain the data of the database, and it will also create a writing connection towards the db
 * file.
 * <p>
 * Note that is a good practice to close the connection after having used it, because keeping it opened won't allow any
 * edit to the file, because when you flush it, every change made externally to the file is lost.
 * <p>
 * Because this is only an interface, you can use this to define variables to work with, but the api will give you a
 * {@link KeybaseConnectionImpl} object, which is an implementation of this interface.
 *
 * @author                          Lorenzo Rocca
 */
@SuppressWarnings("unused")
public interface KeybaseConnection {

    /**
     * Gets an object from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    Object get(String key) throws ConnectionClosedException;

    /**
     * Gets a String from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    String getString(String key) throws ConnectionClosedException;

    /**
     * Gets an integer value from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    int getInt(String key) throws ConnectionClosedException;

    /**
     * Gets a double value from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    double getDouble(String key) throws ConnectionClosedException;

    /**
     * Gets a floating point value from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    float getFloat(String key) throws ConnectionClosedException;

    /**
     * Gets a byte from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    byte getByte(String key) throws ConnectionClosedException;

    /**
     * Gets a short value from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    short getShort(String key) throws ConnectionClosedException;

    /**
     * Gets a long value from the database object of the connection.
     *
     * @param key                   The key of the value to get
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    long getLong(String key) throws ConnectionClosedException;

    /**
     * Gets a serialized object value from the database object of the connection. The idea of this function is to simplify
     * the reading of serialized objects from the database without having to use the Gson lib by yourself.
     *
     * @param key                   The key of the value to get
     * @param objectClass           The type of the serialized object
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      The value
     */
    <T> T getSerializedObject(String key, Class<T> objectClass) throws ConnectionClosedException;

    /**
     * Updates or add an Object to the database object of the connection. Cannot add multiple values with the same key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    void set(String key, Object value) throws ConnectionClosedException;

    /**
     * Updates or add a String to the database object of the connection. Cannot add multiple values with the same key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    void setString(String key, String value) throws ConnectionClosedException;

    /**
     * Updates or add an integer value to the database object of the connection. Cannot add multiple values with the
     * same key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    void setInt(String key, int value) throws ConnectionClosedException;

    /**
     * Updates or add a double value to the database object of the connection. Cannot add multiple values with the same
     * key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    void setDouble(String key, double value) throws ConnectionClosedException;

    /**
     * Updates or add a floating point value to the database object of the connection. Cannot add multiple values with
     * the same key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    void setFloat(String key, float value) throws ConnectionClosedException;

    /**
     * Updates or add a byte to the database object of the connection. Cannot add multiple values with the same key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    void setByte(String key, byte value) throws ConnectionClosedException;

    /**
     * Updates or add a short value to the database object of the connection. Cannot add multiple values with the same
     * key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    void setShort(String key, short value) throws ConnectionClosedException;

    /**
     * Updates or add a long value to the database object of the connection. Cannot add multiple values with the same
     * key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    void setLong(String key, short value) throws ConnectionClosedException;

    /**
     * Updates or add a serialized (with JSON) object to the database object of the connection. Cannot add multiple values
     * with the same key.
     *
     * @param key                   The key that will contain the passed value
     * @param value                 The value to insert
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    void setSerializedObject(String key, Object value) throws ConnectionClosedException;

    /**
     * Remove a value from the database register. The value can also not be present in the database. In that case, nothing
     * will be done.
     *
     * @param key                   The key of the object that should be removed
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     */
    void remove(String key) throws ConnectionClosedException;

    /**
     * This functions checks if a key is registered inside the database.
     *
     * @param key                   The key to check
     * @throws ConnectionClosedException If the connection is closed, but an I/O action is made
     * @return                      If the key is present inside the db
     */
    boolean exists(String key) throws ConnectionClosedException;

    /**
     * Save all the edits in the file where the connection is connected to. Remember that if anyone has made an external
     * edit to it, it will be overwritten by this action.
     *
     * @throws ConnectionClosedException If the connection is closed, but an attempt to save the db is made
     * @throws IOException          If an I/O error occur
     */
    void save() throws ConnectionClosedException, IOException;

    /**
     * Closes the connection by closing the writing bridge between the application and the application. This will also
     * empty the database object, in order to clean the memory in the JVM. If any IO action is executed after the connection
     * is closed, an exception will be thrown.
     *
     * @throws ConnectionAlreadyClosedException If the application tries to close the application when it's already
     *                              closed
     * @throws IOException          In an error occurs while closing the connection
     */
    void close() throws ConnectionAlreadyClosedException, IOException;

    /**
     * This function returns the status of the connection (if it's closed or not). Because the idea is this, you can run
     * this function also when the connection is closed.
     *
     * @return                      True or false
     */
    boolean isClosed();
}
