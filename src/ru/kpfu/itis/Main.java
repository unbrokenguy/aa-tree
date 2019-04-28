package ru.kpfu.itis;

import ru.kpfu.itis.DataGenerator.ArrayGenerator;
import ru.kpfu.itis.DataGenerator.Data;
import ru.kpfu.itis.DataParser.ArrayParser;
import ru.kpfu.itis.aaTree.Tree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main{
        public static void main(String[] args){
            Tree<Integer> tree = new Tree<>();
            List<Integer> list = (new ArrayGenerator()).generate(true);
            list.forEach(tree::insert);
            tree.print();
//            list.forEach(tree::delete);
            tree.delete(list.get(0));
            list.forEach(x->System.out.print(tree.search(x)));
            tree.print();
        }
//    public static void main(String[] args) throws IOException{        //        Data.init(new ArrayGenerator(), new File("data/data.txt"));
        //        for(int i = 0; i < 100; i++)
        //            Data.generate();
        //        ru.kpfu.itis.aaTree.TreeTest.test(new File("data/data.txt"));
//    }
}
