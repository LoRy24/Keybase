package com.github.lory24.keybase.exceptions;

/**
 * The Connection Already Closed exception is sent when the user tries to close an already closed connection. A default
 * message is sent when fired.
 *
 * @author                          Lorenzo Rocca
 */
public class ConnectionAlreadyClosedException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.  The cause is not initialized, and may subsequently
     * be initialized by a call to {@link #initCause}.
     */
    public ConnectionAlreadyClosedException() {
        super("You cannot close a connection that is already closed!");
    }
}
