package com.example.app_android;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.app_android.usermanagment.LoginFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

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

    private ImageButton fire;
     private ImageButton tent;
     private ImageButton googlemap;
     private ImageButton food;
     private ImageButton list;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {

        fire=getView().findViewById(R.id.Fire);
        tent=getView().findViewById(R.id.tent);
        googlemap=getView().findViewById(R.id.googlemap);
        food=getView().findViewById(R.id.food);
        list=getView().findViewById(R.id.list);

fire.setOnClickListener(new View.OnClickListener() {

                            public void onClick(View view) {
                                FireFragment fireFragment = new FireFragment();
                                FragmentManager manager = getFragmentManager();
                                manager.beginTransaction().replace(R.id.frameLayout, fireFragment, fireFragment.getTag()).commit();


                            }
                        });


tent.setOnClickListener(new View.OnClickListener()

    {

        public void onClick (View view)
        {
            TentFragment tentFragment = new TentFragment();
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.frameLayout, tentFragment, tentFragment.getTag()).commit();


        }

    });

food.setOnClickListener(new View.OnClickListener() {

    public void onClick(View view) {
        FoodFragment foodFragment = new FoodFragment();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.frameLayout, foodFragment, foodFragment.getTag()).commit();


    }

});


googlemap.setOnClickListener(new View.OnClickListener()

    {
        public void onClick (View view)
        {
            GooglemapFragment googlemapFragment = new GooglemapFragment();
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.frameLayout, googlemapFragment, googlemapFragment.getTag()).commit();


        }

    });
list.setOnClickListener(new View.OnClickListener()

    {

        public void onClick (View view){
            thingtheuserneedFragment thingtheuserneedFragment = new thingtheuserneedFragment();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.frameLayout, thingtheuserneedFragment, thingtheuserneedFragment.getTag()).commit();


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

}