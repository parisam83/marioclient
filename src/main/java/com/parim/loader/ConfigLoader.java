package com.parim.loader;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class ConfigLoader extends Properties {
    private static final String defaultAddress = "src/main/resources/configs/config.properties";
    private static ConfigLoader instance;

    public static ConfigLoader getInstance(){
        if (instance == null) instance = new ConfigLoader(defaultAddress);
        return instance;
    }
    private ConfigLoader(String address) {
        super();
        Reader reader;
        try {
            reader = new FileReader(address);
            this.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <E> E getProperty(Class<E> c, String propertyName) {
        return getObject(c, getProperty(propertyName));
    }

    private <E> E getObject(Class<E> c, String value){
        E e = null;
        try {
            Constructor<E> constructor = c.getConstructor(String.class);
            e = constructor.newInstance(value);
        } catch (ReflectiveOperationException exception) {
            exception.printStackTrace();
        }
        return e;
    }
}
