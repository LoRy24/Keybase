package com.github.lory24.keybase;

import lombok.Getter;

import java.util.HashMap;

public class KeybaseDatabaseObject {

    @Getter
    private final HashMap<String, Object> data = new HashMap<>();
}
