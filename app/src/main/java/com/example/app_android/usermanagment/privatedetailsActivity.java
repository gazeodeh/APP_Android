package com.example.app_android.usermanagment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

import com.example.app_android.MainFragment;
import com.example.app_android.R;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class privatedetailsActivity extends AppCompatActivity {


    private EditText username;
    private EditText phonenumber;

    private ImageView imageView;
    private String onselctspinner;
    private Button adddata;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privatedetails);
        func();
    }

   /* public void imageChooser(){



}
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==RESULT_OK&&data!=null){
            Uri selectedimage=data.getData();
            imageView.setImageURI(selectedimage);
        }
    }*/
    // this function is triggered when user
    // selects the image from the imageChooser


    public void func() {
        String usernamme, phonenum;
        username = findViewById(R.id.namebenefactor);
        phonenumber = findViewById(R.id.phonebenefactor);

        imageView = findViewById(R.id.perphoto);
        adddata = findViewById(R.id.finishbtn);

        usernamme = username.getText().toString();
        phonenum = phonenumber.getText().toString();


//

        adddata.setOnClickListener(new View.OnClickListener() {
            //نقل من كلاس الى فراجمنت ؟؟
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .add(android.R.id.content, new MainFragment()).commit();
            }


               /* FragmentTransaction ft=getSupportFragmentManager().beginTransaction
                        ();
                ft.replace(R.id.frameLayout,new MainFragment());
                ft.commit();
            //    try {
                  /*  per per = new personaldetailspenefactor(usernamme, phonenum);
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
                }*/




         }

         
}

