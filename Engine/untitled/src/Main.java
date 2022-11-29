import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Update.HashMap();

        while (true) {

            try
            {
                Update.loadNext();

                Update.next();
            }
            catch (Exception exception)
            {
                System.out.println("Ура, конец!");
                break;
            }


        }
    }
}