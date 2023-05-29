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
import android.widget.Toast;

import com.example.app_android.MainFragment;
import com.example.app_android.R;
import com.example.app_android.thingsuserneedclass;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link thingtheuserneedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class thingtheuserneedFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText First;
    private EditText second;
    private EditText third;
    private EditText fourth;
    private Button remidbtn;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void func(){
        String etfirst,etsecond,etthird,etfourth;
        First=getView().findViewById(R.id.firstthing);
        second=getView().findViewById(R.id.secindthing);
        third=getView().findViewById(R.id.thirdthing);
        fourth=getView().findViewById(R.id.fourththing);
        remidbtn=getView().findViewById(R.id.remindmebtn);

           etfirst=First.getText().toString();
           etsecond=second.getText().toString();
           etthird=third.getText().toString();
           etfourth=fourth.getText().toString();

           if (etfirst==null&&etsecond==null&&etthird==null&&etfourth==null){
               Toast.makeText(getContext(), "somthing null!!", Toast.LENGTH_SHORT).show();
           }
           else {


               thingsuserneedclass thingsuserneed=new thingsuserneedclass(etfirst,etsecond,etthird,etfourth);

               db.collection("users")
                       .add(thingsuserneed).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                           @Override
                           public void onSuccess(DocumentReference documentReference) {
                               Toast.makeText(getContext(), "data was saved", Toast.LENGTH_SHORT).show();

                               MainFragment MainFragment=new MainFragment();
                               FragmentManager manager=getFragmentManager();
                               manager.beginTransaction().replace(R.id.frameLayout,MainFragment,MainFragment.getTag()).commit();

                           }
                       }).addOnFailureListener(new OnFailureListener() {
                           @Override
                           public void onFailure(@NonNull Exception e) {

                               Toast.makeText(getContext(), "data not saved try another data", Toast.LENGTH_SHORT).show();
                               //try to save
                               Log.e("",e.getMessage());
                           }
                       });

           }



    }






    public thingtheuserneedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment thingtheuserneedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static thingtheuserneedFragment newInstance(String param1, String param2) {
        thingtheuserneedFragment fragment = new thingtheuserneedFragment();
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
        return inflater.inflate(R.layout.fragment_thingtheuserneed, container, false);
    }
}