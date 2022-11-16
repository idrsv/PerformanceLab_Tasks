import java.io.*;
import java.util.*;

/**
 * Напишите программу, которая выводит путь, по которому, двигаясь интервалом длины m по
 * заданному массиву, концом будет являться первый элемент.
 * Началом одного интервала является конец предыдущего. Путь - массив из начальных элементов
 * полученных интервалов.
 * Пример 1:
 * n = 4, m = 3
 * Решение:
 * Круговой массив: 1234. При длине обхода 3 получаем интервалы: 123, 341.
 * Полученный путь: 13.
 **/
public class Task1 {

    private static ArrayList<Integer> firstList;
    private static ArrayList<StringBuilder> list;
    private static ArrayList<String> finalList;
    private static Object[] array;
    private static boolean end;
    private static int x;
    private static int start;

    public static void main(String[] args) {

        String fileNameIn = args[0];
        //  "/Users/idrsv/Desktop/Test/src/main/resources/task_1_input.txt"
        File file = new File(fileNameIn);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                defaultParam();
                String[] parts = line.split(",");
                int n = Integer.parseInt(parts[0].replaceAll("\\D", ""));
                int m = Integer.parseInt(parts[1].replaceAll("\\D", ""));
                getArray(n);
                check(m);
                addInFinalList(list, finalList);
                show();
                System.out.print("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void defaultParam() {
        firstList = new ArrayList<>();
        list = new ArrayList<>();
        finalList = new ArrayList<>();
        x = 0;
        start = 0;
        end = false;
        array = null;
    }

    private static void check(int m) {
        do {
            addInList(list, array, start, m);
            for (int i = 0; i < m - 1; i++) {
                start++;
            }
            if (list.size() >= 2) {
                x++;
                if (list.get(x).toString().startsWith("1,")) {
                    end = true;
                }
            }
        } while (!end);
    }

    private static void addInList(ArrayList<StringBuilder> list, Object[] array, int start, int m) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            stringBuilder.append(array[(start + i) % array.length]);
            stringBuilder.append(",");
        }
        list.add(stringBuilder);
    }

    private static void addInFinalList(ArrayList<StringBuilder> list, ArrayList<String> finalList) {
        for (int i = 0; i < list.size() - 1; i++) {
            String[] parts = list.get(i).toString().split(",");
            String one = parts[0];
            finalList.add(one);
        }
    }

    private static void show() {
        for (String str : finalList) {
            System.out.print(str);
        }
    }

    private static Object[] getArray(int n) {
        for (int i = 1; i < n + 1; i++) {
            firstList.add(i);
        }
        array = firstList.toArray();
        return array;
    }

    //При n = 1...9
    private static void first(int n, int m) {
        int i = 1;
        do {
            System.out.print(i);
            i = 1 + (i + m - 2) % n;
        } while (i != 1);
    }
}