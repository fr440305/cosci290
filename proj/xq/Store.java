// Weishu Tan
//
// Data Storekeeper

// hello
// pgrs
// attr

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Store {
    public static String storeHelloWorld() {
        try {
            BufferedWriter hello = new BufferedWriter(new FileWriter("dat/hello.txt"));
            hello.write("hello, world");
            hello.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

