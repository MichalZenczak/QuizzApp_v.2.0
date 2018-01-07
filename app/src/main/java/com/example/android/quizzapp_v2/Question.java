package com.example.android.quizzapp_v2;


public class Question {

    private String mQuestionText;
    private String[] mAnswers = new String[4];
    private int mCorrectAnswer;


    public Question(String QuestionText, String[] Answers, int correctAnswer){
        mQuestionText = QuestionText;
        mAnswers[0] = Answers[0];
        mAnswers[1] = Answers[1];
        mAnswers[2] = Answers[2];
        mAnswers[3] = Answers[3];
        mCorrectAnswer = correctAnswer;
    }


    public String getQuestionText(){return mQuestionText;}
    public String[] getAnswers(){return mAnswers;}
}
