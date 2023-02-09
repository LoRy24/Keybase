package com.github.lory24.keybase;

import lombok.Getter;

import java.util.HashMap;

/**
 * The KeybaseDatabaseObject is the object that is used during the serialization of the database file. This contains the
 * data HashMap, that stores all the keys and values.
 *
 * @author                          Lorenzo Rocca
 */
public class KeybaseDatabaseObject {

    // The Data object
    @Getter
    private final HashMap<String, Object> data = new HashMap<>();
}
