import java.util.Random;

public class Main{
    public static int[] findShortest(int[][] arrayIn){
        int[] shortestArray = new int[6];

        for(int i = 0; i < arrayIn.length; i++){
            int shortest = arrayIn[i][0];

            if(shortest == 0){
                shortest = arrayIn[i][1];
            }

            for(int j = 0; j < arrayIn[i].length; j++){
                if(arrayIn[i][j] < shortest && arrayIn[i][j] != 0){
                    shortest = arrayIn[i][j];
                }
            }
            shortestArray[i] = shortest;
        }
        return shortestArray;
    }

    public static int[][] generateDistArray(int dimension){
        int[][] arrayOut = new int[dimension][dimension];
        Random randNum = new Random();

        for(int i = 0; i < arrayOut.length; i++){
            for(int j = 0; j < arrayOut.length; j++){
                arrayOut[i][j] = randNum.nextInt(400) + 1;
            }
        }
        for(int i = 0; i < arrayOut.length; i++){
            for(int j = 0; j < arrayOut.length; j++){
                arrayOut[i][j] = arrayOut[j][i];
            }
        }

        //Set the diagonal zeros
        for(int i = 0; i < arrayOut.length; i++){
            arrayOut[i][i] = 0;
        }

        /*int[][] arrayOut =
                {{0, 58, 184, 271, 378, 379},
                 {58, 0, 167, 199, 351, 382},
                 {184, 167, 0, 43, 374, 370},
                 {271, 199, 43, 0, 394, 390},
                 {378, 351, 374, 394, 0, 47},
                 {379, 382, 370, 390, 47, 0}};*/
        return arrayOut;
    }

    public static void printShortest(int[] shortestArray){
        for(int i = 0; i < shortestArray.length; i++){
            System.out.println(shortestArray[i]);
        }
    }

    /*public static void printArray(int[][] arrayIn){
        for(int i = 0; i < arrayIn.length; i++){
            for(int j = 0; j < arrayIn.length; j++){
                System.out.println(arrayIn[i][j]);
            }
        }
    }*/

    public static void main(String[] args){
        int[][] testArray = generateDistArray(6);
        printShortest(findShortest(testArray));
    }
}
