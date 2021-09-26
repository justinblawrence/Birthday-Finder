package com.company;
import java.io.*;
import java.util.*;

public class Main implements blueprint {
    public static void main(String[] args) throws FileNotFoundException {
        nameScanner(map(fileToStack()));
    }

    public static Stack<String> fileToStack() throws FileNotFoundException{
        Scanner file = new Scanner(new File("src/FamilyBirthdayList.rtf"));
        Stack<String> stack = new Stack<>();
        while(file.hasNext()){
            stack.add(file.next());
        }
        return stack;
    }

    public static HashMap<String, String> map(Stack<String> stack1)  {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        while(!stack1.empty()) {
            list.add(0,stack1.pop());
        }
        for(int i = 0 ; i < list.size()-1; i++){
            map.put(list.get(i), list.get(i+1));
        }
        return map;
    }

    public static void nameScanner(HashMap<String, String> x) throws FileNotFoundException {
        System.out.println("Whose birthday are you trying to find?");
        Scanner input = new Scanner(System.in);
        StringBuilder name = new StringBuilder();
        name.append(input.next());
        if(x.containsKey(name.toString())){
            System.out.println(name.toString() + "'s birthday is " + x.get(name.toString()));
        }else if(!x.containsValue(input)){
            System.out.println("No person found, try again. ");
            nameScanner(map(fileToStack()));
        }
        System.out.println("Would you like to know another birthday? ");
        if(input.next().toLowerCase().equals("yes")){
            nameScanner(map(fileToStack()));
        }else;
        return;
    }
}
