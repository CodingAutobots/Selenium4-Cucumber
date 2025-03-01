package org.selcu.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InterviewQuestions {

public static void main (String [] args){
    InterviewQuestions mn = new InterviewQuestions();
    //mn.reverseString();
    //mn.reverseWords();
    //mn.characterCountString();
    //mn.countWordsInParagraph();
    mn.findSecondLargestValue();
    mn.findVowels();
}

//WAP to reverse string/characters
public void reverseString(){
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    String  revstr = new StringBuilder(str).reverse().toString();
    System.out.println(revstr);
}

//WAP to reverse words
public void reverseWords(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the sentence: ");
    String sentence = sc.nextLine();
    String[] words = sentence.split(" ");
    StringBuilder reversedSentence = new StringBuilder();
    for(int i = words.length-1 ;i>=0;i--){
        reversedSentence.append(words[i]);
        if(i!=0){
            reversedSentence.append(" "); // Remove it too remove space from words
        }
    }
    System.out.println("Reversed Sentence: " + reversedSentence.toString());
    sc.close();
}

//WAP to accept a string and then output each character count in the string
    public void characterCountString(){
    //Scanner sc = new Scanner(System.in);
    System.out.println("Enter string to get duplicate character count: ");
    String input = "Malayamalmb";
    Map<Character,Integer> characterCountMap = new HashMap<>();
    for(char ch : input.toCharArray()){
        characterCountMap.put(ch,characterCountMap.getOrDefault(ch,0)+1);
    }
    System.out.println("Character counts in the String: ");
    for(Map.Entry<Character,Integer> entry: characterCountMap.entrySet()){
        System.out.println(entry.getKey()+" = "+entry.getValue());
    }
        //sc.close();
    }
    //WAP to accept a paragraph and then output each word count in it
    public void countWordsInParagraph(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a paragraph: ");
    String paragraph  = sc.nextLine();
    // Split the paragraph into words and normalize (lowercase) each word
    String[] words = paragraph.split("\\s+");
    Map<String, Integer> wordCountMap = new HashMap<>();
    for(String word : words){
        // Normalize the word to lowercase and remove any punctuation
        word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
    }
        System.out.println("Duplicate words and their counts:");
        boolean foundDuplicate = false;
        for(Map.Entry<String,Integer> entry :wordCountMap.entrySet()){
            if(entry.getValue()>1){
                System.out.println(entry.getKey()+" == "+entry.getValue());
                foundDuplicate = true;
            }
        }
        if (!foundDuplicate) {
            System.out.println("No duplicate words found.");
        }
sc.close();
    }

    public boolean checkIfNumberisPrime(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number: ");
    int num = sc.nextInt();
        if (num <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        // Check for factors from 2 to sqrt(num)/
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false; // num is divisible by i, so it's not prime
            }
        }
        return true;
    }

    //WAP for Second Largest number in an array
    public void findSecondLargestValue(){
    int [] arr = {12,12,35,1,10,3,1};
    if(arr.length<2){
        System.out.println("Array must contain atleast two elements");
    }
    int firstLargest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    for(int num: arr){
        if(num>firstLargest){
            secondLargest = firstLargest;
            firstLargest=num;
        } else if(num > secondLargest && num <firstLargest){
            secondLargest=num;
        }
    }
    if(secondLargest==Integer.MIN_VALUE){
        System.out.println("No second largest number found");
    }
    System.out.println("Second Largest Number :"+secondLargest);
    }

    public void findVowels(){
        // Create a scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a word
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();

        // Convert the word to lowercase to handle case insensitivity
        word = word.toLowerCase();

        // Variables to store counts of each vowel
        int aCount = 0;
        int eCount = 0;
        int iCount = 0;
        int oCount = 0;
        int uCount = 0;

        // Flag to check if any vowels exist
        boolean hasVowels = false;

        // Loop through each character in the word
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // Check if the character is a vowel
            switch (ch) {
                case 'a':
                    aCount++;
                    hasVowels = true;
                    break;
                case 'e':
                    eCount++;
                    hasVowels = true;
                    break;
                case 'i':
                    iCount++;
                    hasVowels = true;
                    break;
                case 'o':
                    oCount++;
                    hasVowels = true;
                    break;
                case 'u':
                    uCount++;
                    hasVowels = true;
                    break;
                default:
                    // Do nothing if it's not a vowel
            }
        }

        // Check if there are vowels in the word and display counts
        if (hasVowels) {
            System.out.println("Vowel counts:");
            System.out.println("a: " + aCount);
            System.out.println("e: " + eCount);
            System.out.println("i: " + iCount);
            System.out.println("o: " + oCount);
            System.out.println("u: " + uCount);
        } else {
            System.out.println("No vowels found in the word.");
        }

        scanner.close(); // Close the scanner to avoid resource leak
    }
}