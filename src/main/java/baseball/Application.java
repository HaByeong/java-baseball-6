package baseball;
import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        /* 정답 및 유저 정답 배열 생성 */
        List<Integer> c_answer = new ArrayList<>();

        /* 정답 숫자 생성 */
        while (c_answer.size() < 3) {
            int random_num = Randoms.pickNumberInRange(1, 9);
            if (!c_answer.contains(random_num)) {
                c_answer.add(random_num);
            }
        }
        System.out.println("숫자 야구 게임을 시작합니다.");
        /* 유저 숫자 입력 (while) */
        while (true) {
            List<Integer> user_answer = new ArrayList<>();
            int strike_num = 0;
            int ball_num = 0;
            System.out.print("숫자를 입력해주세요 : ");
            /* 유저 입력 숫자 데이터형 변경 */
            String user_input = Console.readLine();
            for (int i = 0; i < user_input.length(); i++) {
                int integer_num = user_input.charAt(i) - '0';
                user_answer.add(integer_num);
            }

            /* 정답과 유저의 정답을 비교하는 코드 */
            for (int i = 0; i < user_answer.size(); i++)
                for (int a = 0; a < c_answer.size(); a++) {
                    if (user_answer.get(i).equals(c_answer.get(a)) && i == a)
                        strike_num++;
                    else if (user_answer.get(i).equals(c_answer.get(a)))
                        ball_num++;
                }

            /* 정답 도출 코드 */
            if (strike_num == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else if (strike_num > 0 && ball_num > 0)   //printf와 println의 차이
                System.out.printf("%d볼 %d스트라이크\n", strike_num, ball_num);
            else if (strike_num > 0)
                System.out.printf("%d스트라이크\n", strike_num);
            else if (ball_num > 0)
                System.out.printf("%d볼\n", ball_num);
            else
                System.out.println("낫싱");
        }
    }


    }

