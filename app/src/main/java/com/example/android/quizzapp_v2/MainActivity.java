package com.example.android.quizzapp_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int[] correctAnswersIndexes = {0,3,2,1,3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Question> questions = new ArrayList<>();
        for (int i = 0; i < getResources().getStringArray(R.array.questions).length; i++){
            int id = getResources().getIdentifier("answers_" + i, "array", getPackageName());
            questions.add(new Question(getResources().getStringArray(R.array.questions)[i],
                    getResources().getStringArray(id), correctAnswersIndexes[i]));
        }

        QuestionAdapter adapter = new QuestionAdapter(this, questions);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
