package com.example.android.quizzapp_v2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.ArrayList;

public class QuestionAdapter extends ArrayAdapter<Question> {

    private TextView rbTv, chbTv;
    private RadioButton rbAnswerOne, rbAnswerTwo, rbAnswerThree, rbAnswerFour;
    private CheckBox chbAnswerOne, chbAnswerTwo, chbAnswerThree, chbAnswerFour;

    public QuestionAdapter(Context context, ArrayList<Question> questions) {
        super(context, 0, questions);
    }

    // Return an integer representing the type by fetching the enum type ordinal
    @Override
    public int getItemViewType(int position){
        return getItem(position).getCardType().ordinal();
    }

    // Total number of types is the number of enum values
    @Override
    public int getViewTypeCount(){
        return Question.CardType.values().length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        // Get the data item for this position
        Question currentQuestion = getItem(position);
        // Get the data item type for this position
        int type = getItemViewType(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            // Inflate XML layout based on the type
            convertView = getInflatedLayoutForType(type);
        }

         if (type == Question.CardType.RADIOBUTTONS.ordinal()){
            // Lookup view for data population
            rbTv = convertView.findViewById(R.id.rb_question_text);
            rbAnswerOne = convertView.findViewById(R.id.rb_answer_1);
            rbAnswerTwo = convertView.findViewById(R.id.rb_answer_2);
            rbAnswerThree = convertView.findViewById(R.id.rb_answer_3);
            rbAnswerFour = convertView.findViewById(R.id.rb_answer_4);
            // Populate the data into the template view using the data object
            rbTv.setText(currentQuestion.getQuestionText());
            rbAnswerOne.setText(currentQuestion.getAnswers()[0]);
            rbAnswerTwo.setText(currentQuestion.getAnswers()[1]);
            rbAnswerThree.setText(currentQuestion.getAnswers()[2]);
            rbAnswerFour.setText(currentQuestion.getAnswers()[3]);
        }

        if (type == Question.CardType.CHECKBOXES.ordinal()) {
            // Lookup view for data population
            chbTv = convertView.findViewById(R.id.chb_question_text);
            chbAnswerOne = convertView.findViewById(R.id.chb_answer_1);
            chbAnswerTwo = convertView.findViewById(R.id.chb_answer_2);
            chbAnswerThree = convertView.findViewById(R.id.chb_answer_3);
            chbAnswerFour = convertView.findViewById(R.id.chb_answer_4);
            // Populate the data into the template view using the data object
            chbTv.setText(currentQuestion.getQuestionText());
            chbAnswerOne.setText(currentQuestion.getAnswers()[0]);
            chbAnswerTwo.setText(currentQuestion.getAnswers()[1]);
            chbAnswerThree.setText(currentQuestion.getAnswers()[2]);
            chbAnswerFour.setText(currentQuestion.getAnswers()[3]);
        }
        // Return the completed view to render on screen
        return convertView;
    }

    // Given the item type, responsible for returning the correct inflated XML layout file
    private View getInflatedLayoutForType(int type){
        if (type == Question.CardType.RADIOBUTTONS.ordinal()){
            return LayoutInflater.from(getContext()).inflate(R.layout.card_with_radiogroup, null);
        }else if (type == Question.CardType.CHECKBOXES.ordinal()){
            return LayoutInflater.from(getContext()).inflate(R.layout.card_with_checkbox, null);
        }
        return null;
    }
}
