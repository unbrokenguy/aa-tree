package ru.kpfu.itis.DataGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ArrayGenerator implements Generator{
    private List<Integer> data = new ArrayList<>();
    private Random r = new Random();

    private void shuffle(){
        Collections.shuffle(data);
    }

    @Override
    public String generate(){
        this.data.clear();
        int size = (int)(Math.random() * 9901) + 100;
        for(int i = 0; i < size; i++){
            this.data.add(i);
        }
        this.shuffle();
        StringBuffer sb = new StringBuffer();
        this.data.forEach(x ->sb.append(x.toString()).append(","));
        return sb.toString();
    }
    public List<Integer> generate(boolean flag){
        this.data.clear();
        int size = (int)(Math.random() * 9901) + 100;
        for(int i = 0; i < size; i++){
            this.data.add(i);
        }
        this.shuffle();
        return data;
    }

}
