package mainpackage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.app_android.MainFragment;
import com.example.app_android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView tv1,tv2;

    private Button bt;
    public TentFragment() {
        tv1=getView().findViewById(R.id.textView2);
        tv2=getView().findViewById(R.id.textView5);
        bt=getView().findViewById(R.id.bt);

bt.setOnClickListener(new View.OnClickListener()

    {

        public void onClick (View view){
        MainFragment mainFragment = new MainFragment();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.frameLayout, mainFragment, mainFragment.getTag()).commit();

    }
    });
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TentFragment newInstance(String param1, String param2) {
        TentFragment fragment = new TentFragment();
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
        return inflater.inflate(R.layout.fragment_tent, container, false);
    }
}