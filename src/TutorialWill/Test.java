package TutorialWill;

public class Test {

    static boolean findNumber(int[] vector, int toFind) {

        for(int i : vector) {
            if(i == toFind) return true;
        }
        return false;
    }

    public static void findMissingNumber(int[] vector, int number) {

        for(int i = 1 ; i <= number ; i++) {
            if(!findNumber(vector, i)) System.out.println(i) ;
        }


    }
}
