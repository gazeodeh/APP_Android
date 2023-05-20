package com.example.app_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class privatedetailsActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText username;
    private EditText phonenumber;

    private ImageView imageView;
    private String onselctspinner;
    private Button adddata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privatedetails);

            func();
        }

        public void imageChooser () {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 3);
            onActivityResult(3, 3, intent);
        }
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (resultCode == RESULT_OK && data != null) {
                Uri selectedimage = data.getData();
                imageView.setImageURI(selectedimage);
            }
        }
        // this function is triggered when user
        // selects the image from the imageChooser

    }
        public void func() {
            String usernamme, phonenum;
            username = findViewById(R.id.namebenefactor);
            phonenumber = findViewById(R.id.phonebenefactor);

            imageView = findViewById(R.id.perphoto);
            adddata = findViewById(R.id.finishbtn);

            usernamme = username.getText().toString();
            phonenum = phonenumber.getText().toString();


//
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageChooser();
                }
            });
            adddata.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        personaldetailspenefactor per = new personaldetailspenefactor(usernamme, phonenum, onselctspinner);
                        db.collection("users")
                                .add(per).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Toast.makeText(privatedatabenefactotactivity.this, "data was saved", Toast.LENGTH_SHORT).show();

                                        //go to projects
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        Toast.makeText(privatedatabenefactotactivity.this, "data not saved try another data", Toast.LENGTH_SHORT).show();
                                        //try to save
                                        Log.e("",e.getMessage());
                                    }
                                });


                    }
                    catch (Exception ex){

                        Log.e("",ex.getMessage());
                    }


                    Intent intent = new Intent(privatedetailsActivity.this, framelayoutActivity.class);
                    startActivity(intent);

                }
            });
        }
    }
