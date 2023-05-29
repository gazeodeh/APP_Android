package com.example.app_android;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.app_android.usermanagment.thingtheuserneedFragment;

import mainpackage.FireFragment;
import mainpackage.FoodFragment;
import mainpackage.GooglemapFragment;
import mainpackage.TentFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageButton firee;
    private ImageButton tentt;
    private ImageButton googlemapp;
    private ImageButton foodd;
    private ImageButton listt;

    public MainFragment() {}
    public void func(){

        firee=getView().findViewById(R.id.Firee);
        tentt=getView().findViewById(R.id.tent);
        googlemapp=getView().findViewById(R.id.googlemap);
        foodd=getView().findViewById(R.id.food);
        listt=getView().findViewById(R.id.list);

        firee.setOnClickListener(new View.OnClickListener() {

     public void onClick(View view) {
       FireFragment fireFragment = new FireFragment();
       FragmentManager manager = getFragmentManager();
       manager.beginTransaction().replace(R.id.frameLayout, fireFragment, fireFragment.getTag()).commit();


     }
        });


tentt.setOnClickListener(new View.OnClickListener()

    {

        public void onClick (View view)
        {
            TentFragment tentFragment = new TentFragment();
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.frameLayout, tentFragment, tentFragment.getTag()).commit();


        }

    });

foodd.setOnClickListener(new View.OnClickListener() {

    public void onClick(View view) {
        FoodFragment foodFragment = new FoodFragment();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.frameLayout, foodFragment, foodFragment.getTag()).commit();


    }

});


googlemapp.setOnClickListener(new View.OnClickListener()

    {
        public void onClick (View view)
        {
            GooglemapFragment googlemapFragment = new GooglemapFragment();
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.frameLayout, googlemapFragment, googlemapFragment.getTag()).commit();


        }

    });
listt.setOnClickListener(new View.OnClickListener()

    {

        public void onClick (View view){
        thingsuserneedpresentationFragment thingsuserneedpresentationFragment = new thingsuserneedpresentationFragment();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.frameLayout, thingsuserneedpresentationFragment, thingsuserneedpresentationFragment.getTag()).commit();


    }

    });

                        }


        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        func();
    }
}