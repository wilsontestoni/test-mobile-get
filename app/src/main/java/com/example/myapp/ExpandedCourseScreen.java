package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ExpandedCourseScreen extends AppCompatActivity {

    ImageView courseImgExpandend;

    TextView descriptionExpandend, courseTitleExpanded, courseOpenSlotsExpanded, maxCapacityExpanded, courseCategoryExpandend, courseAdressExpanded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_course_screen);

        Curso curso = (Curso) getIntent().getSerializableExtra("curso");

        filledWithTheData(curso);
    }


    void filledWithTheData(Curso curso) {
        courseImgExpandend = findViewById(R.id.courseImgExpandend);
        courseTitleExpanded = findViewById(R.id.courseTitleExpanded);
        courseOpenSlotsExpanded = findViewById(R.id.courseOpenSlotsExpanded);
        maxCapacityExpanded = findViewById(R.id.maxCapacityExpanded);
        courseCategoryExpandend = findViewById(R.id.courseCategoryExpandend);
        courseAdressExpanded = findViewById(R.id.courseAdressExpanded);
        descriptionExpandend = findViewById(R.id.descriptionExpandend);

        // Supondo que você tenha uma variável 'curso' que contém os dados do curso
        // Você deve configurar os elementos da UI com os dados do curso aqui
        // Por exemplo:

        String baseUrl = "http://10.0.2.2:3000";
        String imagePath = curso.getImg();
        String imageUrl = baseUrl + imagePath;
        Picasso.get().load(imageUrl).into(courseImgExpandend);

        courseTitleExpanded.setText(curso.getTitle());
        courseOpenSlotsExpanded.setText(String.valueOf(curso.getOccupiedSlots()));
        maxCapacityExpanded.setText(String.valueOf(curso.getMaxCapacity()));
        courseCategoryExpandend.setText(curso.getCategory());
        courseAdressExpanded.setText(curso.getAddress());
        descriptionExpandend.setText(curso.getDescription());

        System.out.println(curso.getId());
    }
}