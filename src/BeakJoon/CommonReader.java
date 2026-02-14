package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CommonReader {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static String nextLine() throws IOException {
        return br.readLine();
    }

    public static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException("EOF");
            }

            st = new StringTokenizer(line);
        }
        return Integer.parseInt(st.nextToken());
    }

    public static String nextString() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException("EOF");
            }

            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public static char nextChar() throws IOException {
        return (char) br.read();
    }
}