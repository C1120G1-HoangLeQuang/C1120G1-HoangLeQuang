package ngay_4_OOP.bai_tap;

import java.util.Scanner;

public class TestStopWatch {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(stopWatch.getStarTime());
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();
        stopWatch.stop();
        System.out.println(stopWatch.getEndTime());
        System.out.println(stopWatch.getElapsedTime());
    }
}
