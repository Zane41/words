import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        vivod(countWords(reading("INPUT.txt")));
        zamena(createChangebleMap(reading2("INPUT.txt")), createCript(reading("INPUT2.txt")));

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
                otvet=otvet+" & "+x;
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
        while (vvod.hasNextLine()) {
            list.add(vvod.nextLine());
        }
        vvod.close();
        return list;
    }
    public static ArrayList<String> reading2(String file) throws FileNotFoundException {
        Scanner vvod = new Scanner(new File(file));
        ArrayList<String> list = new ArrayList<>();
        while (vvod.hasNext()) {
            list.add(vvod.next());
        }
        vvod.close();
        return list;
    }
    public static void zamena (HashMap<Integer,String> changebleMap, HashMap<String, String> criptedMap){
        for (Integer c:changebleMap.keySet()) {
            for (String x : criptedMap.keySet()) {
                if (changebleMap.get(c).equals(x)){
                    changebleMap.replace(c, criptedMap.get(x));
                }
            }
        }
        System.out.println(changebleMap.values());
    }
    public static HashMap<String , String> createCript (ArrayList<String> list){
        HashMap<String, String> cript = new HashMap<>(); String [] temp;
        for (String x: list) {
            temp = x.split(" ");
            cript.put(temp[0], temp[1]);
        }
    return cript;
    }
    public static HashMap<Integer , String> createChangebleMap (ArrayList<String> list){
        HashMap<Integer, String> change = new HashMap<>();
        int i =0;
        for (String x: list) {
            change.put(i, x);
            i++;
        }
        return change;
    }
}