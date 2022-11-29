public class Part
{
    private String textOfPart;

    private Answer answer1;
    private Answer answer2;
    private Answer answer3;
    private Answer answer4;

    private Integer countOfAnswers;


    public Part(String textOfPart, Answer answer1, Answer answer2, Answer answer3, Answer answer4)
    {
        this.textOfPart = textOfPart;

        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.countOfAnswers = 4;
    }

    public Part(String textOfPart, Answer answer1, Answer answer2, Answer answer3)
    {
        this.textOfPart = textOfPart;

        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.countOfAnswers = 3;
    }

    public Part(String textOfPart, Answer answer1, Answer answer2)
    {
        this.textOfPart = textOfPart;

        this.answer1 = answer1;
        this.answer2 = answer2;
        this.countOfAnswers = 2;
    }

    public Part(String textOfPart, Answer answer1)
    {
        this.textOfPart = textOfPart;

        this.answer1 = answer1;
        this.countOfAnswers = 1;
    }

    public Part(String textOfPart, Integer countOfAnswers)
    {
        this.textOfPart = textOfPart;
        this.countOfAnswers = countOfAnswers;
    }



    public Answer getAnswer(Integer integer) {

        if (integer == 1)
        {
            return answer1;
        }
        else if (integer == 2)
        {
            return answer2;
        }
        else if (integer == 3)
        {
            return answer3;
        }
        else if (integer == 4)
        {
            return answer4;
        }
        return null;
    }

    public void setAnswer(Integer i, Answer answer)
    {
        if (i == 1)
        {
            answer1 = answer;
        }
        else if ( i == 2)
        {
            answer2 = answer;
        }
        else if (i == 3)
        {
            answer3 = answer;
        }
        else  if (i == 4)
        {
            answer4 = answer;
        }
    }


    public String getTextOfPart() {
        return textOfPart;
    }

    public Integer getCountOfAnswers() {
        return countOfAnswers;
    }
}
