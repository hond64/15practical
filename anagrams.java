//MIguel Wentzel
//4478677
//Practical 5
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
            BufferedReader reader = new BufferedReader(new FileReader("joyce1922_ulysses.text"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for ( String w : words){
                    w = w.replaceAll("[.,;:_!-)]","");
                                        w = w.toLowerCase();
                    if (w.length()==0){
                        continue;
                    }
                    String key =signature(w);
                    if (!dictionary.containsKey(key)){
                        ArrayList<String> List = new ArrayList<>();
                        List.add(w);
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
            ArrayList<String> words = dictionary.get(key);

            if (words.size()>=2){
                System.out.println(key + " : "+ words);
            }
        }
        try {
            PrintWriter writer = new PrintWriter("anagrams.tex");
            for (String key: dictionary.keySet()){
                ArrayList<String> string = dictionary.get(key);
                if (string.size()>=2){
                    Collections.sort(string);
                    writer.print("\\textbf{"+ key+ "} : ");

                    for (String word: string){
                        writer.print(word + " ");

                    }
                    writer.println("\\\\");
                }
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error");
        }

    }
}
