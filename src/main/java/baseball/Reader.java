package baseball;

import java.util.Scanner;

public class Reader {

    public String read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        return sc.nextLine();
    }
}
