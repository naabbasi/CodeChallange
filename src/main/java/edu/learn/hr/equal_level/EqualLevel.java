package edu.learn.hr.equal_level;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


class EqualLevelResult {

    /*
     * Complete the 'updateTimes' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY signalOne
     *  2. INTEGER_ARRAY signalTwo
     */

    public static int updateTimes(List<Integer> signalOne, List<Integer> signalTwo) {
        int maxEqual = 0;
        int lastFrequency = 0;

        for(int i = 0; i < signalOne.size(); i++){
            if(Objects.equals(signalOne.get(i), signalTwo.get(i))){
                if(signalOne.get(i) > lastFrequency){
                    maxEqual++;
                    lastFrequency = signalOne.get(i);
                }
            }
        }

        return maxEqual;
    }

}
public class EqualLevel {
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int signalOneCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> signalOne = IntStream.range(0, signalOneCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int signalTwoCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> signalTwo = IntStream.range(0, signalTwoCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());*/

        /*List<Integer> signalTwo = List.of(5, 5, 4, 3, 4, 1);
        List<Integer> signalOne = List.of(5, 1, 2, 3, 4, 1);*/

        //Answer is 2
        List<Integer> signalTwo = List.of(1, 2, 3, 4, 1);
        List<Integer> signalOne = List.of(5, 4, 3, 4, 1);

        //Answer is 1
        /*List<Integer> signalTwo = List.of(1, 2, 3, 4, 5);
        List<Integer> signalOne = List.of(5, 4, 3, 2, 1);*/

        int result = EqualLevelResult.updateTimes(signalOne, signalTwo);
        System.out.println("Result: " + result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
