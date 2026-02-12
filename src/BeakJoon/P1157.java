package BeakJoon;

/** Problem. 1157
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 *
 * [입력데이터]
 * Mississipi
 * zZa
 *
 * [출력데이터]
 * ?
 * Z
 */
public class P1157 {

    public void solve() throws Exception {

        int[] alphabet = new int[26];
        String sentence = CommonReader.nextString();

        sentence = sentence.toUpperCase();
        for(int i=0; i<sentence.length(); i++){
            int position = sentence.charAt(i)-65;
            // A: 65, a: 97

            alphabet[position]++;
        }

        int idx = 0;
        boolean isDup = false;
        for(int i=1; i<26; i++){
            int max = alphabet[idx];
            int cur = alphabet[i];

            if(max < cur){
                idx = i;
                isDup = false;
            } else if (max == cur){
                isDup = true;
            }
        }

        System.out.print((isDup) ? "?" : (char)(idx+65));
    }
}
