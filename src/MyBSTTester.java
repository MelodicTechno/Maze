import java.io.*;

public class MyBSTTester {
    // prepare for the input
    public static void main(String[] args) throws IOException {
        FileReader fis = new FileReader("homework3_testcases.txt");
        BufferedReader br = new BufferedReader(fis);
        StreamTokenizer st = new StreamTokenizer(br);
        // print writer setup
        PrintWriter pw = new PrintWriter("my_result.txt");
        pw.flush();

        MyBST<String, String> vocabulary = new MyBST<>();
        while (st.ttype != StreamTokenizer.TT_EOF) {
            char command = (char)st.ttype;
            if (command == '+') {
                // jump to the key
                st.nextToken();
                st.nextToken();
                String key = st.sval;
                // jump to the value
                st.nextToken();
                st.nextToken();
                String value = st.sval;
                vocabulary.insert(key, value);
            }
            else if (command == '-') {
                st.nextToken();
                st.nextToken();
                String key = st.sval;
                String value = vocabulary.remove(key);
                if (value == null) {
                    pw.printf("remove unsuccessfully: ---%s\n", key);
                }
                else {
                    pw.printf("remove successfully: ---%s\n", value);
                }
            }
            else if (command == '?') {
                st.nextToken();
                st.nextToken();
                String key = st.sval;
                String value = vocabulary.search(key);
                if (value == null) {
                    pw.printf("search unsuccessfully: ---%s\n", key);
                }
                else {
                    pw.printf("search successfully: ---%s\n", value);
                }
            }
            else if (command == '=') {
                // jump to the key
                st.nextToken();
                st.nextToken();
                String key = st.sval;
                // jump to the value
                st.nextToken();
                st.nextToken();
                String value = st.sval;
                if (vocabulary.update(key, value)) {
                    pw.printf("update successfully: ---%s %s\n", value, key);
                }
                else {
                    pw.printf("update unsuccessfully: ---%s %s\n", value, key);
                }
            }
            else if (command == '#') {
                vocabulary.showStructure(pw);
            }
            st.nextToken();
        }
        vocabulary.isEmpty();
        vocabulary.printInOrder(pw);
        fis.close();
        br.close();
        pw.close();
    }

}
