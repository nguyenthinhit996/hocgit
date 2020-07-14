package com.example.tuan05;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tuan05.pojo.Student;

import java.util.ArrayList;


public class MainActivity extends Activity implements MainCallback {

    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    Fragment1 fragment1;
    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new Fragment1();
        fragmentTransaction.replace(R.id.main_fragment1, fragment1);

        fragment2 = new Fragment2();
        fragmentTransaction.replace(R.id.main_fragment2, fragment2);

        fragmentTransaction.commit();
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onStudentFromFragToMain(Student a, int index, int maxSizeList) {
        // send data to fragment 2
        fragment2.onStudentMainToFragment(a, index, maxSizeList);
    }

    @Override
    public void onStudentFromFragToMain(int index) {
        // fragment 2 to main , main to fragment 1
        fragment1.onStudentMainToFragment(index);
    }


}