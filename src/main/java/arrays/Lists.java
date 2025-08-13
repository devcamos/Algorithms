package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lists {

  public static void main(String[] args) {
    String[] anagram = new String[3];
    anagram[0] = "String 1";
    anagram[1] = "String 2";
    anagram[2] = "String 3";

    for (String string : anagram) {
      System.out.println(string);
    }

    System.out.println(groupAnagrams(anagram));
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> listsOfLists = new ArrayList<>();
    List<String> outerList = new ArrayList<>();

    outerList.add("Outer string 1");
    outerList.add("Outer string 2");

    List<String> innerList = new ArrayList<>();

    outerList.addAll(Arrays.asList(strs));

    innerList.add("Inner string 1");
    innerList.add("Inner string 2");
    listsOfLists.add(outerList);
    listsOfLists.add(innerList);
    return listsOfLists;
  }
}
