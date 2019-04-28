package ru.kpfu.itis.DataParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface Parser<T>{
    T next();
    boolean hasNext();
}
