package com.example.tuan05;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.tuan05.pojo.Student;

import java.util.ArrayList;

public class Fragment1 extends Fragment implements FragmentCallBack {

    MainActivity main;
    Context context;

    protected TextView txtChooseActive;
    protected ListView listViewItem;
    protected ArrayList<Student> listItem;
    protected ListItemAdapter listItemAdapter;

    int indexCurrent = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            context = getActivity(); // use this reference to invoke main callbacks
            main = (MainActivity) getActivity();
        } catch (Exception e) {
            throw new IllegalStateException("MainActivitymust implement callbacks");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout layoutFr2 = (LinearLayout) inflater.inflate(R.layout.fragment1, null);

        //text view choose active
        txtChooseActive = layoutFr2.findViewById(R.id.txtChooseActive);
        //list view
        listViewItem = layoutFr2.findViewById(R.id.listViewItem);
        listViewItem.setChoiceMode(ListView.CHOICE_MODE_NONE);

        //prepare data
        listItem = this.makeData();
        //set data into adapter
        listItemAdapter = new ListItemAdapter(listItem);
        //set adapter into view
        listViewItem.setAdapter(listItemAdapter);

        this.clickItem();

        setForcCusOnlistView(indexCurrent);
        return layoutFr2;
    }

    @Override
    public void onStart() {
        super.onStart();
        setInitDataForFragment2();
    }

    public void setForcCusOnlistView(final int index) {

        if (listViewItem != null) {
            listViewItem.clearFocus();
            listViewItem.requestDisallowInterceptTouchEvent(true);
            listViewItem.requestFocusFromTouch();
            listViewItem.requestFocus();
            listViewItem.setSelected(true);
            listViewItem.setItemChecked(index,true);
            listViewItem.setSelection(index);

           

        }
    }

    void setInitDataForFragment2(){
        Student item = (Student) listItem.get(indexCurrent);
        txtChooseActive.setText(String.valueOf(item.getId()));
        sendData(indexCurrent);
    }

    protected void clickItem() {
        listViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                indexCurrent = i;
                Student item = (Student) listItemAdapter.getItem(indexCurrent);
                txtChooseActive.setText(String.valueOf(item.getId()));
                sendData(indexCurrent);


            }
        });

        listViewItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indexCurrent = i;
                Student item = (Student) listItem.get(indexCurrent);
                txtChooseActive.setText(String.valueOf(item.getId()));
                sendData(indexCurrent);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    void sendData(int i) {
        main.onStudentFromFragToMain(listItem.get(i), i, listItem.size());
    }

    @Override
    public void onStudentMainToFragment(Student a, int index, int maxSizeList) {
        indexCurrent = index;
        main.onStudentFromFragToMain(a, indexCurrent, maxSizeList);
        setForcCusOnlistView(indexCurrent);
    }

    @Override
    public void onStudentMainToFragment(int index) {
        // receive index from main , get data send to main
        onStudentMainToFragment(listItem.get(index), index, listItem.size());

    }

    protected ArrayList<Student> makeData() {
        listItem = new ArrayList<>();
        listItem.add(new Student(18201, "Nguyen Van A", "A", 3, R.drawable.woman));
        listItem.add(new Student(18202, "Nguyen Van B", "D", 4, R.drawable.man));
        listItem.add(new Student(18003, "Nguyen Van C", "G", 7, R.drawable.bsn));
        listItem.add(new Student(18004, "Nguyen Van D", "R", 5, R.drawable.man));
        listItem.add(new Student(18205, "Nguyen Van E", "R", 6, R.drawable.woman));
        listItem.add(new Student(18206, "Nguyen Van F", "W", 7, R.drawable.bsn));
        listItem.add(new Student(18207, "Nguyen Van G", "3", 8, R.drawable.man));
        listItem.add(new Student(18008, "Nguyen Van D", "R", 5, R.drawable.man));
        listItem.add(new Student(18209, "Nguyen Van E", "R", 6, R.drawable.woman));
        listItem.add(new Student(18236, "Nguyen Van F", "W", 7, R.drawable.bsn));
        listItem.add(new Student(18247, "Nguyen Van G", "3", 8, R.drawable.man));
        listItem.add(new Student(18223, "Nguyen Van E", "R", 6, R.drawable.woman));
        listItem.add(new Student(18656, "Nguyen Van F", "W", 7, R.drawable.bsn));
        listItem.add(new Student(66654, "Nguyen Van G", "3", 8, R.drawable.man));

        return listItem;
    }
}
