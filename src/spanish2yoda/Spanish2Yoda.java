package spanish2yoda;

import java.util.Scanner;
import java.util.Arrays;

public class Spanish2Yoda {

   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("---===Spanish-Yoda Translator 1.0===---\n");
        System.out.print("This will translate any Spanish sentence of up to 4 words into Yoda-Speak.\n");
        System.out.print("Press type 'yoda' to quit\n");
        while(true){
            System.out.print("Spanish: ");
            String spanish = input.nextLine();
            if(spanish.equals("yoda")) break;
            String yoda = Spanish2Yoda(spanish);
            System.out.printf("Yoda: %s\n", yoda);
        }
        
    }
    /**
     * Parses a sentence into an array of words
     * @param sentence the string sentence to parse
     * @return  an array of words (in the sentence
     */
    public static String[] GetWords(String sentence){
        return sentence.split(" ");
    }
    /**
     * Combines the words back into a sentence
     * @param words an array of strings
     * @return those strings, in order as once sentence.
     */
    public static String CombineWords(String[] words){
        String sentence = "";
        for(String w : words){
            sentence += w + " ";
        }
        return sentence;
    }
    /**
     * Translates from spanish to yoda
     * @param spanish a string sentence in spanish
     * @return the same sentence translated into yodakiu
     */
    public static String Spanish2Yoda(String spanish){
        String[] words = GetWords(spanish);
        String yoda="";
        String tmp;
        int len = words.length;
        if(len == 1){
            //do nothing
            yoda = spanish;
        }else if(len == 2){
            //reverse the sentence
            for(int i = len - 1;i >= 0; i--){
                yoda += words[i] + " ";
            }
        }else if (len == 3){
            //shift the end to the beginning
            yoda = words[2] + " "+ words[0] + " " + words[1];
        }else if (len == 4){
            //swap 0&2 plus 1&3
            yoda = words[2] + " " + words[3]+ " "+ words[0] + " "+ words[1];
        }else {
            yoda = "***Translation Error***";
        }
        return yoda;
    }
    
}
