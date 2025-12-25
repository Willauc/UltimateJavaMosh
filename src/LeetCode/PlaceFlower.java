package LeetCode;

public class PlaceFlower {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int placeAvalable = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i <  flowerbed.length; i++) {
            if (i ==0) {start = 0;
            } else {start = flowerbed[i-1];}
            if (i == flowerbed.length - 1) {end = 0;
            }else {end = flowerbed[i+1];}

            if (start == 0 && flowerbed[i] == 0 && end == 0) {
                placeAvalable++;
                flowerbed[i] = 1;
            }
        }

        return placeAvalable >= n;
    }
}
