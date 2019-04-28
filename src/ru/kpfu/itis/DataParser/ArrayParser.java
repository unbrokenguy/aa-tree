package ru.kpfu.itis.DataParser;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayParser implements Parser{
    private Scanner sc;

    public ArrayParser(InputStream in){
        this.sc = new Scanner(in);
    }

    @Override
    public List<Integer> next(){
        String s = sc.nextLine();
        return Arrays.stream(s.split(",")).map(Integer::new).collect(Collectors.toList());
    }
    @Override
    public boolean hasNext(){
        return sc.hasNextLine();
    }
}
