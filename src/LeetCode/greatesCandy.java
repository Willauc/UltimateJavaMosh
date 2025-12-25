package LeetCode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class greatesCandy {

        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int max = Arrays.stream(candies).max().getAsInt();

            List<Boolean> result = new ArrayList<>();

            for (int c : candies ) {

                    result.add(c + extraCandies >= max);

            }

            return result;
    }
}
