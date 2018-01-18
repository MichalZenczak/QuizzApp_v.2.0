package com.example.android.quizzapp_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.quizzapp_v2.Question.CardType.CHECKBOXES;
import static com.example.android.quizzapp_v2.Question.CardType.RADIOBUTTONS;

public class MainActivity extends AppCompatActivity {

    final int[] rbCorrectAnswersIndexes = {0,3,2,1,3};
    final int[] chbCorrectAnswersIndexes = {1,3};

    ArrayList<Question> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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



        Button submitButton = findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int results = checkAnswers();
                Toast toast = Toast.makeText(getApplicationContext(), "Correct answers: " + results, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });

    }

    /**
     * Method that checks the correct answers in the question list
     *
     */
    public int checkAnswers() {
        int correctAnswersCount = 0;
        // iterate through elements in the question list
        for (int i = 0; i < questions.size(); i++){
            // if element is of type RADIOBUTTONS
            if (questions.get(i).getCardType() == RADIOBUTTONS){
                RadioGroup radioGroup = findViewById(R.id.radio_group);
                // check which radiobutton is checked within the radiogroup
                if (radioGroup.getCheckedRadioButtonId() == questions.get(i).getCorrectAnswer()){
                    correctAnswersCount += 1;
                }

            }
        }

        return correctAnswersCount;
    }

}
