public class Answer
{
    private String armOfAnswer;
    private String textOfAnswer = "";

    public Answer(String armOfAnswer, String textOfAnswer)
    {
        this.armOfAnswer = armOfAnswer;
        this.textOfAnswer = textOfAnswer;
    }

    public String getArmOfAnswer() {
        return armOfAnswer;
    }

    public String getTextOfAnswer() {
        return textOfAnswer;
    }

}
