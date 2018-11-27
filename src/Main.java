import java.util.Random;

public class Main{

    //method for creating array of shortest distances from each city
    public static int[] findShortest(int[][] arrayIn){
        //initialise array for inserting shortest distances
        int[] shortestArray = new int[arrayIn.length];

        //loop through rows of matrix
        for(int i = 0; i < arrayIn.length; i++){
            //set shortest as first int
            int shortest = arrayIn[i][0];

            //if it's 0, set to the next value along
            if(shortest == 0){
                shortest = arrayIn[i][1];
            }

            //loop through current row
            for(int j = 0; j < arrayIn[i].length; j++){
                //if current index is smaller than shortest then set it to shortest
                if(arrayIn[i][j] < shortest && arrayIn[i][j] != 0){
                    shortest = arrayIn[i][j];
                }
            }
            //add the shortest for this row to the array
            shortestArray[i] = shortest;
        }
        //return the shortest array
        return shortestArray;
    }

    //method for creating shortest array using only 1 half of the matrix
    public static int[] findShortestOp(int[][] arrayIn){
        //initialise array
        int[] shortestArray = new int[arrayIn.length];

        //loop through rows
        for(int i = 0; i < arrayIn.length; i++){
            //set shortest as first int
            int shortest = arrayIn[i][0];

            //if shortest is 0 set to next int below
            if(shortest == 0){
                shortest = arrayIn[i + 1][0];
                //loop through column
                for (int j = 0; j < arrayIn[i].length; j++){
                    //if current index smaller than shortest then set it to shortest
                    if(arrayIn[j][i] < shortest && arrayIn[j][i] != 0){
                        shortest = arrayIn[j][i];
                    }
                }
            }

            //loop through current row
            for(int j = 0; j < arrayIn[i].length; j++){
                //if current index smaller than shortest then set to shortest
                if(arrayIn[i][j] < shortest && arrayIn[i][j] != 0){
                    shortest = arrayIn[i][j];
                }
                //if current index is 0
                if(arrayIn[i][j] == 0){
                    //loop through column
                    for (int k = 0; k < arrayIn.length; k++){
                        //if current index is smaller than shortest then set to shortest
                        if(arrayIn[k][i] < shortest && arrayIn[k][i] != 0){
                            shortest = arrayIn[k][i];
                        }
                    }
                }
            }
            //add shortest to array
            shortestArray[i] = shortest;
        }
        //return shortest array
        return shortestArray;
    }

    //method that generates a random distance array for testing
    public static int[][] generateDistArray(int dimension){
        //initialise new empty array
        int[][] arrayOut = new int[dimension][dimension];

        //intialise random number generator
        Random randNum = new Random();

        //loop through the entire array
        for(int i = 0; i < arrayOut.length; i++){
            for(int j = 0; j < arrayOut.length; j++){
                //set current index to random number range 1 to 401
                arrayOut[i][j] = randNum.nextInt(400) + 1;
            }
        }
        //loop through entire array
        for(int i = 0; i < arrayOut.length; i++){
            for(int j = 0; j < arrayOut.length; j++){
                //mirror the array elements
                arrayOut[i][j] = arrayOut[j][i];
            }
        }

        //Set the diagonal zeros
        for(int i = 0; i < arrayOut.length; i++){
            arrayOut[i][i] = 0;
        }
        //return the random array
        return arrayOut;
    }

    //method used to check the shortestArray during testing
    public static void printShortest(int[] shortestArray){
        for(int i = 0; i < shortestArray.length; i++){
            System.out.println(shortestArray[i]);
        }
    }

    //method used to get timing results for a selected number of iterations of a chosen size
    public static void timeMatrix(int start, int iterSize, int numTests, int numIterations){
        //loop the number of chosen tests
        for(int i = 0; i < numTests; i++) {
            //intialise a long for the average for the current test
            long average = 0;

            //loop the number of iterations on this current test
            for(int j = 0; j < numIterations; j++){
                //create random array
                int[][] avgArray = generateDistArray(start + (iterSize * i));

                //time the findShortest method
                long startTime = System.nanoTime();
                findShortest(avgArray);
                long endTime = System.nanoTime();

                //add to the average
                average += (endTime - startTime)/numIterations;
            }
            //output the average
            System.out.println(average);
        }
    }

    //test harness
    public static void main(String[] args){
        timeMatrix(200, 100, 10, 100);
    }
}
