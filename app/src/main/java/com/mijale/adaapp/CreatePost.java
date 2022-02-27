package com.mijale.adaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mijale.adaapp.Fragments.Post;

public class CreatePost extends AppCompatActivity {

    private Button btEnviarPost;
    private ImageButton Volver;
    private EditText etPost;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fStore;
    String message, useruid, userID, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getInstance("https://adaapp-f73d9-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("Messages");
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        btEnviarPost = findViewById(R.id.btEnviarPost);
        Volver = findViewById(R.id.Volver);
        etPost = findViewById(R.id.etPost);


        btEnviarPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DocumentReference docRef = fStore.collection("users").document(mAuth.getCurrentUser().getUid());
                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                useruid = document.getString("username").toString();
                                image = document.getString("image").toString();
                                message = etPost.getText().toString();
                                SendPost sendPost = new SendPost(useruid, message, image);
                                databaseReference.push().setValue(sendPost);
                            } else {
                                useruid = "NOTFOUND";
                                message = etPost.getText().toString();
                                SendPost sendPost = new SendPost(useruid, message, image);
                                databaseReference.push().setValue(sendPost);
                            }
                        } else {
                            useruid = "NOTFOUND";
                            message = etPost.getText().toString();
                            SendPost sendPost = new SendPost(useruid, message, image);
                            databaseReference.push().setValue(sendPost);
                        }
                    }
                });
                Toast.makeText(CreatePost.this, "Post creado", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}