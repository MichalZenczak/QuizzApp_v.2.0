package com.example.android.quizzapp_v2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.ArrayList;

public class QuestionAdapter extends ArrayAdapter<Question> {
    public QuestionAdapter(Context context, ArrayList<Question> questions) {
        super(context, 0, questions);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        // Get the data item for this position
        Question question = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_with_radiogroup, parent, false);
        }
        // Lookup view for data population
        TextView tvQuestion = convertView.findViewById(R.id.question_text);
        RadioButton rbAnswerOne = convertView.findViewById(R.id.answer_1);
        RadioButton rbAnswerTwo = convertView.findViewById(R.id.answer_2);
        RadioButton rbAnswerThree = convertView.findViewById(R.id.answer_3);
        RadioButton rbAnswerFour = convertView.findViewById(R.id.answer_4);
        // Populate the data into the template view using the data object
        tvQuestion.setText(question.getQuestionText());
        rbAnswerOne.setText(question.getAnswers()[0]);
        rbAnswerTwo.setText(question.getAnswers()[1]);
        rbAnswerThree.setText(question.getAnswers()[2]);
        rbAnswerFour.setText(question.getAnswers()[3]);
        // Return the completed view to render on screen
        return convertView;
    }
}
