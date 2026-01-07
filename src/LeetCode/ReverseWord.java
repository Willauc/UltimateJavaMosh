package LeetCode;

/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.


 */

public class ReverseWord {

    static public String reverseWords(String s) {
    String output = "";
    String[] words = s.split(" ");

    for (int i = (words.length - 1) ; i >= 0; i--) {
        String word = words[i];
        if (i != words.length - 1) {output = output.concat(" ");}

        output = output.concat(word);
    }

    return output.trim().replaceAll("\\s+", " ");
    }

    static public String reverseWords2(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() == 0) continue;
            if (i != words.length - 1) {
                sb.append(" ");
            }
            sb.append(words[i]);

        }

        return sb.toString();
    }
}
