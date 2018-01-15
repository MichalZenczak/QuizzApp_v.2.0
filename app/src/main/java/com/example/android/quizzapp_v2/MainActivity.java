package com.example.android.quizzapp_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.quizzapp_v2.Question.CardType.CHECKBOXES;
import static com.example.android.quizzapp_v2.Question.CardType.RADIOBUTTONS;

public class MainActivity extends AppCompatActivity {

    final int[] rbCorrectAnswersIndexes = {0,3,2,1,3};
    final int[] chbCorrectAnswersIndexes = {1,3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Question> questions = new ArrayList<>();
        for (int i = 0; i < getResources().getStringArray(R.array.rb_questions).length; i++){
            int id = getResources().getIdentifier("rb_answers_" + i, "array", getPackageName());
            questions.add(new Question(getResources().getStringArray(R.array.rb_questions)[i],
                            getResources().getStringArray(id),
                            rbCorrectAnswersIndexes[i],
                            RADIOBUTTONS));
        }
        for (int i = 0; i < getResources().getStringArray(R.array.chb_questions).length; i++){
            int id = getResources().getIdentifier("chb_answers_" + i, "array", getPackageName());
            questions.add(new Question(getResources().getStringArray(R.array.chb_questions)[i],
                    getResources().getStringArray(id),
                    chbCorrectAnswersIndexes[i],
                    CHECKBOXES));
        }

        QuestionAdapter adapter = new QuestionAdapter(this, questions);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
