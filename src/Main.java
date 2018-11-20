public class Main
{
    public static int[] findShortest(int[][] arrayIn)
    {
        int[] shortestArray = new int[6];

        for(int i = 0; i < arrayIn.length; i++)
        {
            int shortest = arrayIn[i][0];

            if(shortest == 0)
            {
                shortest = arrayIn[i][1];
            }

            for(int j = 0; j < arrayIn[i].length; j++)
            {
                if(arrayIn[i][j] < shortest && arrayIn[i][j] != 0)
                {
                    shortest = arrayIn[i][j];
                }
            }
            shortestArray[i] = shortest;
        }
        return shortestArray;
    }

    public static int[][] generateDistArray()
    {
        int[][] arrayOut =
                {{0, 58, 184, 271, 378, 379},
                 {58, 0, 167, 199, 351, 382},
                 {184, 167, 0, 43, 374, 370},
                 {271, 199, 43, 0, 394, 390},
                 {378, 351, 374, 394, 0, 47},
                 {379, 382, 370, 390, 47, 0}};
        return arrayOut;
    }

    public static void printShortest(int[] shortestArray)
    {
        for(int i = 0; i < shortestArray.length; i++)
        {
            System.out.println(shortestArray[i]);
        }
    }

    public static void main(String[] args)
    {
        printShortest(findShortest(generateDistArray()));
    }
}
