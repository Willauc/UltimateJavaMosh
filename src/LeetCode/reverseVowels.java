package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class reverseVowels {
    public String reverseVowels(String s) {
        var sArr = s.toCharArray();
        List<Character> vowelsInS = new ArrayList<>();
        Set<Character> vowels = Set.of('a','e','i','o','u','A','E','I','O','U');

        for (char c : sArr) {
            if (vowels.contains(c)){
                vowelsInS.add(c);
            }
        }
        int nombreVowels = vowelsInS.size();

        for (int i = 0; i < sArr.length; i++) {
            if (vowels.contains(sArr[i])) {
                sArr[i] = vowelsInS.get(nombreVowels - 1);
                vowelsInS.remove(nombreVowels - 1);
                nombreVowels--;
            }
        }
        return new String(sArr);

    }
}
