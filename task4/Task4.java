import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Task4 {

    /**
     * Дан массив целых чисел nums. Напишите программу, выводящую минимальное количество ходов,
     * требуемых для приведения всех элементов к одному числу. За один ход можно уменьшить или
     * увеличить число массива на 1.
     * Пример:
     * nums = [1, 2, 3]
     * Решение: [1, 2, 3] => [2, 2, 3] => [2, 2, 2]
     * Минимальное количество ходов: 2
     **/

    public static void main(String[] args) {
        String fileNameIn = args[0];
        //  "/Users/idrsv/Desktop/Test/src/main/resources/task_4_input.txt"
        ArrayList<Integer> list = new ArrayList<>();

        readFromFile(fileNameIn, list);

        int[] nums = new int[list.size()];

        generateToArray(list, nums);

        int[] array = Arrays.stream(nums).sorted().toArray();

        int k = (array.length) / 2;
        int med = array[k];
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != med) {
                if (med > nums[i]) {
                    nums[i] += 1;
                } else {
                    nums[i] -= 1;
                }
                n++;
            }
        }
        System.out.println(n);
    }

    private static void readFromFile(String fileNameIn, ArrayList<Integer> list) {
        File file = new File(fileNameIn);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.valueOf(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] generateToArray(ArrayList<Integer> list, int[] nums) {
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}