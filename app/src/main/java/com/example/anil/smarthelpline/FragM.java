package com.example.anil.smarthelpline;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anil.smarthelpline.Navigation_Elements.clinic_Fragment;
import com.example.anil.smarthelpline.Navigation_Elements.hospital_Fragment;

public class FragM extends AppCompatActivity {
Button add,replace;
FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_m);
        add=(Button)findViewById(R.id.add);
        replace=(Button)findViewById(R.id.replace);
        fragmentManager=getSupportFragmentManager();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               fragmentManager.beginTransaction()
                       .add(R.id.container,new hospital_Fragment())
                       .addToBackStack(null)
                       .commit();

            }
        });
        replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.container,new clinic_Fragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
