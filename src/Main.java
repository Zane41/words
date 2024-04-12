import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        vivod(countWords(reading("INPUT.txt")));


    }



    public static String countWords(ArrayList<String> list) {
        int temp=0; String otvet=null;
        HashMap<String, Integer> tempHash = new HashMap<>();
        for (String x : list) {
            if (tempHash.containsKey(x))
                tempHash.put(x, tempHash.get(x)+1);
            else tempHash.put(x, 1);
        }
        for (String x:tempHash.keySet()){
            if (tempHash.get(x)==temp){
                otvet=x+" & "+otvet;
            }
            if(tempHash.get(x)>temp){
                temp=tempHash.get(x); otvet=x;
        }

        }
    return otvet;
    }

    public static void vivod(String otvet) {
        System.out.println("Чаще всего встречается "+otvet);
    }

    public static ArrayList<String> reading(String file) throws FileNotFoundException {
        Scanner vvod = new Scanner(new File(file));
        ArrayList<String> list = new ArrayList<>();
        while (vvod.hasNext()) {
            list.add(vvod.next());
        }
        vvod.close();
        return list;
    }
}