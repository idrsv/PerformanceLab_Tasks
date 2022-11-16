import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {

    /**
     * Напишите программу, которая рассчитывает положение точки относительно окружности.
     * Координаты центра окружности и его радиус считываются из файла1.
     * Координаты точек считываются из файла2.
     **/

    //Для окружности
    private static float x0 = 0;
    private static float y0 = 0;
    private static int R = 0;

    //(x - x0)^2 + (y - y0)^2 <= R^2
    public static void main(String[] args) {

        //Для окружности
        String fileNameOne = args[0];
        //Для точек
        String fileNameTwo = args[1];

        File file = new File(fileNameOne);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            {
                String lineOne;
                while ((lineOne = br.readLine()) != null) {
                    if (lineOne.matches("\\d++"))
                        R = Integer.parseInt(lineOne);
                    else {
                        String[] parts = lineOne.split("\s");
                        x0 = Integer.parseInt(parts[0]);
                        y0 = Integer.parseInt(parts[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file2 = new File(fileNameTwo);
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
                String lineTwo;
                while ((lineTwo = br.readLine()) != null) {
                    String[] parts = lineTwo.split("\s");
                    //Для точки
                    float x = Integer.parseInt(parts[0]);
                    float y = Integer.parseInt(parts[1]);

                    test(x, y,x0,y0,R);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test(float x, float y, float x0, float y0, int R) {
        float a = x - x0;
        float b = y - y0;

        double v = Math.pow(a, 2) + (Math.pow(b, 2));
        if ((v < (Math.pow(R, 2)))) {
            System.out.println("1");
        } else if ((v > (Math.pow(R, 2)))) {
            System.out.println("2");
        } else {
            System.out.println("0");
        }
    }
}
