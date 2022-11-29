import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Update
{

    private static ArrayList<String> IDs = new ArrayList<>(Arrays.asList(""));

    private static String currentID = "1";

    Scanner scanner = new Scanner(System.in);

    private static Integer incomming;

    private static String incommingStr;

    static HashMap<String, Part> hashMap = new HashMap<>();


    public static void next() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            incommingStr = scanner.next();

            try {
                incomming = Integer.parseInt(incommingStr);

                if (incomming <= hashMap.get(currentID).getCountOfAnswers() && incomming > 0) {
                    if (hashMap.get(currentID).getAnswer(incomming).getArmOfAnswer().contains("-")) {
                        currentID += hashMap.get(currentID).getAnswer(incomming).getArmOfAnswer().replace("-", "");
                    }
                    else {
                        currentID = hashMap.get(currentID).getAnswer(incomming).getArmOfAnswer();
                    }
                    IDs.add(currentID);
                    break;
                }

                else {
                    System.out.println("Еблан, цифру, соответсвующую одному из ответов");
                }
            } catch (Exception exception) {

                if (incommingStr.equals("//"))
                {
                    if (IDs.size() != 1)
                    {
                        IDs.remove(IDs.size() - 1);
                        currentID = IDs.get(IDs.size() - 1);
                        break;
                    }
                    else
                    {
                        System.out.println("Вы в начале");
                    }
                }

                else
                {
                    System.out.println("Еблан, введи цифру");
                }
            }
        }
    }

    public static void loadNext()
    {
        Part thisPart = hashMap.get(currentID);

        System.out.println(thisPart.getTextOfPart());

        for (Integer i = 1; i <= thisPart.getCountOfAnswers(); i++)
        {
            System.out.println(i + ")  " + thisPart.getAnswer(i).getTextOfAnswer());
        }
    }

    public static String getCurrentID() {
        return currentID;
    }

    public static void HashMap() throws IOException, FileNotFoundException {

        String parth = "F:\\JavaProjects\\Engine\\Maker\\abobaJSON";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(parth));

        String bigLine = bufferedReader.readLine();
        bufferedReader.close();

        JSONObject jsonObject =new JSONObject(bigLine);
        JSONArray array = jsonObject.getJSONArray("data");
        JSONObject object = new JSONObject();

        for (int i = 0; i < array.length(); i++)
        {
            object = array.getJSONObject(i);

            Part newPart = new Part(object.getString("Text"),
                    object.getInt("countOfAnswers"));

            for (int i1 = 0; i1 < object.getInt("countOfAnswers"); i1++)
            {
                newPart.setAnswer((i1 + 1), new Answer
                        (object.getJSONArray("answerID").getString(i1),
                                object.getJSONArray("answerText").getString(i1)));
            }

            hashMap.put(object.getString("ID"), newPart);
        }
    }
}
