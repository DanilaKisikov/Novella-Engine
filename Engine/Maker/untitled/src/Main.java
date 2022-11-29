import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {

        writer();

    }

    public static void writer()
    {
        JSONObject MAMA = new JSONObject();
        JSONArray data = new JSONArray();


        String partID;
        String partText;
        String countOfAnswers;

        String answerID;
        String answerText;

        System.out.println("Вы запустили генератор ветвей для гениальной новеллы.\n" +
                "Всё записывается в формате:\n" +
                "1)ID (ID первого должно быть равен 1)\n" +
                "2)Текст данной части\n" +
                "3)Количество ответов\n" +
                "4)ID ответа\n" +
                "ID ответа может быть записано с приставкой \"-\" в начале, если хотите ввести продолжение ветки.\n" +
                "Чтобы отсановить запись напишите //");

        while (true)
        {
            JSONObject object = new JSONObject();
            JSONArray answersID = new JSONArray();
            JSONArray answersText = new JSONArray();
            print("Введите ID части");
            while (true)
            {
                while (true)
                {
                    partID = input();

                    if (partID.matches("[1-4]+"))
                    {
                        break;
                    }
                    else {
                        print("Формат нарушен!!!!!");
                    }
                }

                print("Подтвердите выбор (y/n)");
                if (input().equals("y"))
                {
                    object.put("ID", partID);
                    print("ID подтверждён");
                    break;
                }
                else
                {
                    print("Новое ID");
                }
            }

            print("Введите текст части");
            while (true)
            {
                partText = input();

                print("Подтвердите выбор (y/n)");
                if (input().equals("y"))
                {
                    object.put("Text", partText);
                    print("Текст подтверждён");
                    break;
                }
                else
                {
                    print("Новый текст");
                }
            }

            print("Введите количество ответов");
            while (true)
            {
                while (true)
                {
                    countOfAnswers = input();

                    if (countOfAnswers.matches("[1-4]"))
                    {
                        break;
                    }
                    else {
                        print("Формат нарушен!!!!!");
                    }
                }

                print("Подтвердите выбор (y/n)");
                if (input().equals("y"))
                {
                    object.put("countOfAnswers", Integer.parseInt(countOfAnswers));
                    print("Количество ответов подтверждёно");
                    break;
                }
                else
                {
                    print("Новое количество ответов");
                }
            }



            for (int i = 0; i < Integer.parseInt(countOfAnswers); i++)
            {
                print("Введите ID ответа " + (i + 1));
                while (true)
                {
                    while (true)
                    {
                        answerID = input();

                        if (answerID.matches("[0-4,-]+"))
                        {
                            break;
                        }
                        else {
                            print("Формат нарушен!!!!!");
                        }
                    }

                    print("Подтвердите выбор (y/n)");
                    if (input().equals("y"))
                    {
                        answersID.put(answerID);
                        print("ID подтверждён");
                        break;
                    }
                    else
                    {
                        print("Новое ID");
                    }
                }

                print("Введите текст ответа " + (i + 1));
                while (true)
                {
                    answerText = input();

                    print("Подтвердите выбор (y/n)");
                    if (input().equals("y"))
                    {
                        answersText.put(answerText);
                        print("Текст подтверждён");
                        break;
                    }
                    else
                    {
                        print("Новый текст");
                    }
                }
            }
            object.put("answerID", answersID);
            object.put("answerText", answersText);

            print("Вы подтверждаете запись части(y/n)?");
            if (input().equals("y"))
            {
                data.put(object);
                print("Часть успешно записана!");
            }
            else
            {
                print("Вы точно хотите удалить написанное?");
                if (!input().equals("y"))
                {
                    data.put(object);
                    print("Часть успешно записана!");
                }
                else
                {
                    print("Запись удалена");
                }
            }

            print("Для сохранения файла и завершения программы напишите \"//\".\n" +
                    "Для продолжения напишите люой другой символ.");
            if (input().equals("//"))
            {
                print("Запись завершена");
                MAMA.put("data", data);
                print(data.toString());

                try
                {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abobaJSON"));

                    bufferedWriter.write(MAMA.toString());

                    bufferedWriter.close();
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                break;
            }
        }
    }

    public static void print(String string)
    {
        System.out.println(string);
    }

    public static String input()
    {
        Scanner scanner = new Scanner(System.in);

        return scanner.next();
    }
}
