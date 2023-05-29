package com.example.app_android.usermanagment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.app_android.MainFragment;
import com.example.app_android.Privatedetails;
import com.example.app_android.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link privatedtetailssFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class privatedtetailssFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText username;
    private EditText phonenumber;

    private ImageView imageView;
    private String onselctspinner;
    private Button adddata;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void func() {

        username = getView().findViewById(R.id.namebenefactor);
        phonenumber = getView().findViewById(R.id.phonebenefactor);

        imageView = getView().findViewById(R.id.Parephoto);
        adddata = getView().findViewById(R.id.finishbtn);

        adddata.setOnClickListener(new View.OnClickListener() {
            //نقل من كلاس الى فراجمنت ؟؟
            @Override
            public void onClick(View v) {

                try {
                    String usernamme, phonenum;

                    usernamme = username.getText().toString();
                    phonenum = phonenumber.getText().toString();
                    Privatedetails per = new Privatedetails(usernamme, phonenum);
                    db.collection("users")
                            .add(per).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getContext(), "data was saved", Toast.LENGTH_SHORT).show();

                                    thingtheuserneedFragment thingtheuserneedFragment=new thingtheuserneedFragment();
                                    FragmentManager manager=getFragmentManager();
                                    manager.beginTransaction().replace(R.id.frameLayout,thingtheuserneedFragment,thingtheuserneedFragment.getTag()).commit();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Toast.makeText(getContext(), "data not saved try another data", Toast.LENGTH_SHORT).show();
                                    //try to save
                                    Log.e("", e.getMessage());
                                }
                            });


                } catch (Exception ex) {

                    Log.e("", ex.getMessage());
                }


            }


        });

    }

    public privatedtetailssFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment privatedtetailssFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static privatedtetailssFragment newInstance(String param1, String param2) {
        privatedtetailssFragment fragment = new privatedtetailssFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_privatedtetailss, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        func();
    }
}