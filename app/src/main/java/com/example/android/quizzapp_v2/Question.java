package com.example.android.quizzapp_v2;


public class Question {

    public enum CardType {
        RADIOBUTTONS, CHECKBOXES
    }

    private String mQuestionText;
    private String[] mAnswers = new String[4];
    private int mCorrectAnswer;
    private CardType mCardType;


    public Question(String QuestionText, String[] Answers, int correctAnswer, CardType cardType){
        mQuestionText = QuestionText;
        mAnswers[0] = Answers[0];
        mAnswers[1] = Answers[1];
        mAnswers[2] = Answers[2];
        mAnswers[3] = Answers[3];
        mCorrectAnswer = correctAnswer;
        mCardType = cardType;
    }


    public String getQuestionText(){return mQuestionText;}
    public String[] getAnswers(){return mAnswers;}
    public int getCorrectAnswer() {return mCorrectAnswer;}
    public CardType getCardType() {return mCardType;}
}
