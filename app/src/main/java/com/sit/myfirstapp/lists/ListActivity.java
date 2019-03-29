package com.sit.myfirstapp.lists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.sit.myfirstapp.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ArrayList<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        data = new ArrayList<Student>() {{
            add(new Student(13, "Jack"));
            add(new Student(14, "John"));
            add(new Student(15, "Will"));
            add(new Student(16, "Dustin"));
            add(new Student(17, "Mike"));
            add(new Student(18, "Jane"));
            add(new Student(13, "Jack"));
            add(new Student(14, "John"));
            add(new Student(15, "Will"));
            add(new Student(16, "Dustin"));
            add(new Student(17, "Mike"));
            add(new Student(18, "Jane"));
            add(new Student(13, "Jack"));
            add(new Student(14, "John"));
            add(new Student(15, "Will"));
            add(new Student(16, "Dustin"));
            add(new Student(17, "Mike"));
            add(new Student(18, "Jane"));
            add(new Student(13, "Jack"));
            add(new Student(14, "John"));
            add(new Student(15, "Will"));
            add(new Student(16, "Dustin"));
            add(new Student(17, "Mike"));
            add(new Student(18, "Jane"));
        }};

        recyclerView = findViewById(R.id.recycler_view);

        StudentListAdapter adapter = new StudentListAdapter(data);
        adapter.setOnStudentClickListener(student -> Toast.makeText(this, student.name + " - " + student.age, Toast.LENGTH_SHORT).show());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }
}
