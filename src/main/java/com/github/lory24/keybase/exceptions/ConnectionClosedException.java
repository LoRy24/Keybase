package com.github.lory24.keybase.exceptions;

/**
 * The connection closed exception is the exception thrown when an I/O actions is performed on a closed Keybase
 * connection. It sends a default message.
 *
 * @author                          Lorenzo Rocca
 */
public class ConnectionClosedException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.  The cause is not initialized, and may subsequently
     * be initialized by a call to {@link #initCause}.
     */
    public ConnectionClosedException() {
        super("You cannot execute any I/O action when the connection is closed!");
    }
}
