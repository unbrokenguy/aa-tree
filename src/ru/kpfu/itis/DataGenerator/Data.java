package ru.kpfu.itis.DataGenerator;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Data{
    private static Generator g;
    private static FileWriter fw;
    public static void init(Generator generator, File file) throws IOException{
        fw = new FileWriter(file, true);
        g = generator;
    }

    public static void generate() throws IOException{
        for(int i = 0; i < 100; i++){
            String toWrite = g.generate() + "\n";
            fw.write(toWrite);
            fw.flush();
        }
        fw.flush();
    }
}
