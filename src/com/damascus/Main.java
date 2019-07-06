package com.damascus;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[] wordList = {  "apple", "able", "ale", "bale", "kangaroo" };
        String result = getSubsequent("abppplee", wordList);
        System.out.println(result);
    }

    private static String getSubsequent(String word, String[] wordList){

        HashMap<String, Integer> occurMap = new HashMap<>();
        String maxWord = null;
        int maxValue = 0;

        // Iterate through list
        for(String listWord : wordList){
            // Iterate through word
            int stepper = 0;
            for( Character letter : listWord.toCharArray() ){
                // Iterate through subsequent
                boolean isFound = false;
                for(int i = stepper; i < word.length(); i++) {
                    if( word.charAt(i) == letter ){
                        isFound = true;
                        if(occurMap.containsKey(listWord)){
                            // Obtain count
                            Integer count = occurMap.get(listWord);
                            count++;
                            occurMap.replace(listWord, count);
                        }else{
                            occurMap.put(listWord, 1);
                        }
                        break;
                    }
                }
                stepper++;
                if( !isFound ){
                    if( occurMap.containsKey(listWord) ){
                        occurMap.remove(listWord);
                    }
                    break;
                }
            }
        }

        for(Map.Entry<String, Integer> entry : occurMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " - " + value);

            if( value > maxValue ){
                maxValue = value;
                maxWord = key;
            }
        }

        return maxWord;
    }
}
