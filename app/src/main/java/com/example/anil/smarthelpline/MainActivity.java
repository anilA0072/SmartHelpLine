package com.example.anil.smarthelpline;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.anil.smarthelpline.Navigation_Elements.Settings_Fragment;
import com.example.anil.smarthelpline.Navigation_Elements.about_us_Fragment;
import com.example.anil.smarthelpline.Navigation_Elements.ambulance_Fragment;
import com.example.anil.smarthelpline.Navigation_Elements.bmi_Calculator_Fragment;
import com.example.anil.smarthelpline.Navigation_Elements.clinic_Fragment;
import com.example.anil.smarthelpline.Navigation_Elements.doctor_Fragment;
import com.example.anil.smarthelpline.Navigation_Elements.feedback_Fragment;
import com.example.anil.smarthelpline.Navigation_Elements.funeral_Vehicle_Fragment;
import com.example.anil.smarthelpline.Navigation_Elements.hospital_Fragment;
import com.example.anil.smarthelpline.Navigation_Elements.medicine_Tracker_Fragment;
import com.example.anil.smarthelpline.Navigation_Elements.specialization_Fragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private Session session;
    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToggle;
    private FragmentTransaction fragmentTransaction;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Smart HelpLine");


        //TobLayout
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("FirstAid"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




        toolbar=(Toolbar)findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);

        nDrawerLayout = (DrawerLayout) findViewById(R.id.main_page);
        nToggle = new ActionBarDrawerToggle(this, nDrawerLayout, R.string.open, R.string.close);
        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

/*
        session = new Session(this);
        if (!session.loggedin()) {
            logout();
        }
*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (nToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

 /*   private void logout() {
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }*/

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();
            Fragment fragment=null;
            if (id == R.id.nav_hospitals) {
                Toast.makeText(getApplicationContext(), "hospitals ", Toast.LENGTH_LONG).show();
                fragment=new hospital_Fragment();
                getSupportActionBar().setTitle("Hospital");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_container,fragment)
                            .addToBackStack(null)
                            .commit();

                } else if (id == R.id.nav_clinics) {
                Toast.makeText(getApplicationContext(), "clinics ", Toast.LENGTH_LONG).show();
                fragment=new clinic_Fragment();
                setTitle("Clinic");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container,fragment)
                        .addToBackStack(null)
                        .commit();
            } else if (id == R.id.nav_Doctors) {
                Toast.makeText(getApplicationContext(), "doctors ", Toast.LENGTH_LONG).show();
                fragment=new doctor_Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container,fragment)
                        .addToBackStack(null)
                        .commit();
            } else if (id == R.id.nav_specialization) {
                Toast.makeText(getApplicationContext(), "specialization ", Toast.LENGTH_LONG).show();
                fragment = new specialization_Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, fragment)
                        .addToBackStack(null)
                        .commit();
            } else if (id == R.id.nav_medicineTracker) {
                Toast.makeText(getApplicationContext(), "medicine Tracker ", Toast.LENGTH_LONG).show();
                fragment=new medicine_Tracker_Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container,fragment)
                        .addToBackStack(null)
                        .commit();
            } else if (id == R.id.nav_ambulance) {
                Toast.makeText(getApplicationContext(), "ambulance ", Toast.LENGTH_LONG).show();
                fragment=new ambulance_Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container,fragment)
                        .addToBackStack(null)
                        .commit();
            } else if (id == R.id.nav_funeralVehicle) {
                Toast.makeText(getApplicationContext(), "funeral Vehicle ", Toast.LENGTH_LONG).show();
                fragment=new funeral_Vehicle_Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container,fragment)
                        .addToBackStack(null)
                        .commit();
            } else if (id == R.id.nav_feedback) {
                Toast.makeText(getApplicationContext(), "feedback ", Toast.LENGTH_LONG).show();
                fragment=new feedback_Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container,fragment)
                        .addToBackStack(null)
                        .commit();
            } else if (id == R.id.nav_Settings) {
                Toast.makeText(getApplicationContext(), "settings ", Toast.LENGTH_LONG).show();
                fragment=new Settings_Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container,fragment)
                        .addToBackStack(null)
                        .commit();
            } else if (id == R.id.nav_aboutUs) {
                Toast.makeText(getApplicationContext(), "about us ", Toast.LENGTH_LONG).show();
                fragment=new about_us_Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container,fragment)
                        .addToBackStack(null)
                        .commit();
            } else if (id == R.id.nav_bmiCalculator) {
                Toast.makeText(getApplicationContext(), "BMI Calculator ", Toast.LENGTH_LONG).show();
                fragment=new bmi_Calculator_Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container,fragment)
                        .addToBackStack(null)
                        .commit();
            }
            else if (fragment!=null){
                android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container,fragment);
                fragmentTransaction.commit();
            }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_page);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

}
