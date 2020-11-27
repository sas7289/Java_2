package Lesson_5;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    static final int H = SIZE / 2;
    static final int DEFAULT_ARR_VAL = 1;

    public static void main(String[] args) {
        fullArr();
        halfArr();
    }


    public static void fullArr() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, DEFAULT_ARR_VAL);
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = calcVal(arr[i], i);
        }
        System.out.println("fullArray's time: " + (System.currentTimeMillis() - a));
    }

    public static void halfArr() {
        long begin = System.currentTimeMillis();

        float[] arr = new float[SIZE];
        Arrays.fill(arr, DEFAULT_ARR_VAL);
        float[] arrFirstHalf = new float[H];
        float[] arrSecondHalf = new float[H];

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arrFirstHalf, 0, H);
        System.arraycopy(arr, H, arrSecondHalf, 0, H);
        System.out.println("Array division time: " + (System.currentTimeMillis() - a));

        Thread firstHalfThread = new Thread(() -> {
            long b = System.currentTimeMillis();
            for (int i = 0; i < arrFirstHalf.length; i++) {
                arrFirstHalf[i] = calcVal(arrFirstHalf[i], i);
            }
            System.out.println("time for calculating the first half: " + (System.currentTimeMillis() - b));
            b = System.currentTimeMillis();
            synchronized (arr) {
                System.arraycopy(arrFirstHalf, 0, arr, 0, H);
            }
            System.out.println("Copy time of the first half: " + (System.currentTimeMillis() - b));
        });

        Thread secondHalfThread = new Thread(() -> {
            long c = System.currentTimeMillis();
            for (int i = 0; i < arrSecondHalf.length; i++) {
                arrSecondHalf[i] = calcVal(arrSecondHalf[i], i + H);
            }
            System.out.println("time for calculating the second half: " + (System.currentTimeMillis() - c));
            c = System.currentTimeMillis();
            synchronized (arr) {
                System.arraycopy(arrSecondHalf, 0, arr, H, H);
            }
            System.out.println("Copy time of the second half: " + (System.currentTimeMillis() - c));
        });
        firstHalfThread.start();
        secondHalfThread.start();

        try {
            firstHalfThread.join();
            secondHalfThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Full time of halfArr method: " + (System.currentTimeMillis() - begin));
    }




    public static float calcVal(float num, int i) {
        return (float)(num * Math.sin(0.2 + i/5f) * Math.cos(0.2 + i/5f) * Math.cos(0.4 + i/2f));
    }
}
