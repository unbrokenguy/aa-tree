package ru.kpfu.itis.aaTree;

import ru.kpfu.itis.DataParser.ArrayParser;

import java.io.*;
import java.util.List;
import java.util.function.Consumer;

public class TreeTest{
    private static aaTree<Integer> tree = new Tree<>();
    private static FileWriter fw;

    static{
        try{
            fw = new FileWriter("data/answer.csv", true);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void test(File file) throws IOException{
        tree.clear();
        ArrayParser parser = new ArrayParser(new FileInputStream(file));
        while(parser.hasNext()){
            List<Integer> list = parser.next();
            String insertTest = test(tree::insert, list);
            String searchTest = test(tree::search, list);
            String deleteTest = test(tree::delete, list);
            fw.write(list.size() + "," + insertTest + "," + searchTest + "," + deleteTest + "\n");
//            fw.flush();
        }
        fw.close();
    }

    private static String test(Consumer<Integer> consumer, List<Integer> list){
        ((Tree)tree).setIt();
        long startPoint = System.nanoTime();
        list.forEach(consumer);
        return String.valueOf(System.nanoTime() - startPoint) + "," + ((Tree)tree).getIt();
    }
}

