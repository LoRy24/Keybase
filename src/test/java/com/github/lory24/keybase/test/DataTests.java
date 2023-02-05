package com.github.lory24.keybase.test;

import com.github.lory24.keybase.Keybase;
import com.github.lory24.keybase.KeybaseConnection;
import com.github.lory24.keybase.exceptions.ConnectionAlreadyClosedException;
import com.github.lory24.keybase.exceptions.ConnectionClosedException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class DataTests {

    @Test
    public void test1() throws IOException, ConnectionClosedException, ConnectionAlreadyClosedException {
        // Create the first connection
        KeybaseConnection connection = Keybase.createConnection(new File("./testdb.kyb").toPath());
        connection.setString("Hello", "World");
        connection.save();
        connection.close();

        KeybaseConnection connection2 = Keybase.createConnection(new File("./testdb.kyb").toPath());
        String value = connection2.getString("Hello");
        connection2.close();

        Assert.assertEquals(value, "World");
    }
}
