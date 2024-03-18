package baseball;

import java.util.Scanner;

public class Reader {

    private final int INPUT_SIZE = 3;

    public String read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        final String input = sc.nextLine();
        validateInput(input);
        return input;
    }

    private void validateInput(final String input) {
        if (input.length() != INPUT_SIZE) {
            throw new IllegalStateException("숫자 입력은 반드시 3자리여야합니다.");
        }
    }
}
