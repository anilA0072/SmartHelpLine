package com.example.anil.smarthelpline.Navigation_Elements;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anil.smarthelpline.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ambulance_Fragment extends Fragment {


    public ambulance_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ambulance, container, false);
    }

}
