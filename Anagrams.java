//MIguel Wentzel
//4478677
//Practical 5
import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;

public class anagrams{
    public static String signature(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public static void main(String[] args){
        HashMap<String, ArrayList<String>> dictionary = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(""));
            String line;
            while ((line = reader.readline())!= null) {
                String[] words = line.split("\\s+");
                for ( String w : words){
                    w = w.replace("[.,;:_!-]");
                                        w = w.toLowerCase();
                    if (w.length()==0){
                        continue;
                    }
                    String key =signature(w);
                    if (!dictionary.containsKey(key)){
                        ArrayList<String> List = new ArrayList<>();
                        list.add(w);
                        dictionary.put(key, List);
                    } else {
                        dictionary.get(key).add(w);
                    }
                    
                }
                
            }
            reader.close();

        } catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        for (String key: dictionary.keySet()){
            ArrayList<String> words = dictionary
        }

    }
}
