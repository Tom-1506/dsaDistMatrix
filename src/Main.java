import java.util.Random;

public class Main{
    public static int[] findShortest(int[][] arrayIn){
        int[] shortestArray = new int[arrayIn.length];

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

    public static int[] findShortestOp(int[][] arrayIn){
        int[] shortestArray = new int[arrayIn.length];

        for(int i = 0; i < arrayIn.length; i++){
            int shortest = arrayIn[i][0];

            if(shortest == 0){
                shortest = arrayIn[i + 1][0];
                for (int j = 0; j < arrayIn[i].length; j++){
                    if(arrayIn[j][i] < shortest && arrayIn[j][i] != 0){
                        shortest = arrayIn[j][i];
                    }
                }
            }

            for(int j = 0; j < arrayIn[i].length; j++){
                if(arrayIn[i][j] < shortest && arrayIn[i][j] != 0){
                    shortest = arrayIn[i][j];
                }
                if(arrayIn[i][j] == 0){
                    for (int k = 0; k < arrayIn.length; k++){
                        if(arrayIn[k][i] < shortest && arrayIn[k][i] != 0){
                            shortest = arrayIn[k][i];
                        }
                    }
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
        return arrayOut;
    }

    public static void printShortest(int[] shortestArray){
        for(int i = 0; i < shortestArray.length; i++){
            System.out.println(shortestArray[i]);
        }
    }

    public static void timeMatrix(int start, int iterSize, int numTests, int numIterations){
        for(int i = 0; i < numTests; i++) {
            long average = 0;
            for(int j = 0; j < numIterations; j++){
                int[][] avgArray = generateDistArray(start + (iterSize * i));

                long startTime = System.nanoTime();
                findShortest(avgArray);
                long endTime = System.nanoTime();

                average += (endTime - startTime)/numIterations;
            }
            System.out.println(average);
        }
    }

    public static void main(String[] args){
        timeMatrix(200, 100, 10, 100);
    }
}
