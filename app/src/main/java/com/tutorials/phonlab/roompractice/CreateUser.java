package com.tutorials.phonlab.roompractice;


import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateUser extends AppCompatActivity{

    EditText firstName;
    EditText lastName;
    EditText email;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_book_editor);

        firstName = findViewById(R.id.titleInput);
        lastName = findViewById(R.id.authorInput);
        email = findViewById(R.id.pageCountInput);
        button = findViewById(R.id.add_book);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries() //CHANGE THIS SO ITS ON BACKGROUND THREAD (THIS IS BAD PRACTICE)
                .build();

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                db.userDao().insertAll(new User("Daniel", "Malone", "email1"));
                startActivity(new Intent(CreateUser.this, MainActivity.class));
            }
        });

    }
}
