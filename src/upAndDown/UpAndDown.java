package upAndDown;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class UpAndDown {
    public void run() {

        int select;
        int count = 0;
        int score = 0;

        while (true) {
            select = showMenu();

            switch (select) {
                case 1:
                    count = start();
                    if (count < score || score == 0) {
                        score = count;
                    }
                    break;
                case 2:
                    if (score != 0) {
                        System.out.println("현재 최고 기록은 " + score + "회 입니다.");
                        System.out.println();
                    } else {
                        System.out.println("아직 기록이 없습니다.");
                        System.out.println();
                    }
                    break;
                case 3:
                    break;
            }

            if (select == 3)
                break;
        }
    }

    private int showMenu() {
        Scanner sc = new Scanner(System.in);

        int select;

        System.out.println("===== Up & Down Game =====");
        System.out.println("1. Game Start");
        System.out.println("2. Game Score");
        System.out.println("3. End Game");

        while (true) {
            System.out.print("선택 > ");

            try {
                select = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println();
                System.out.println("잘못입력하셨습니다.");
                System.out.println();
                continue;
            }

            if (select == 1 || select == 2 || select == 3) {
                break;
            } else {
                System.out.println();
                System.out.println("잘못 입력하셨습니다.");
                System.out.println();
            }
        }
        System.out.println();

        return select;
    }

    private int start() {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int me, cpu;
        int count = 0;

        cpu = r.nextInt(99) + 1;
        System.out.println("<< Game Start >>");

        while (true) {
            count++;

            while (true) {
                System.out.print(count + "회차 번호 입력 : ");
                me = sc.nextInt();

                if (me > 0 && me < 100) {
                    break;
                } else {
                    System.out.println("입력 범위 오류 ");
                    System.out.println();
                }
            }

            if (me < cpu) {
                System.out.println("<< UP >>");
                System.out.println();
            } else if (me > cpu) {
                System.out.println("<< DOWN >>");
                System.out.println();
            } else {
                System.out.println("<< 정답 >>");
                System.out.println();
                break;
            }
        }

        return count;
    }
}
