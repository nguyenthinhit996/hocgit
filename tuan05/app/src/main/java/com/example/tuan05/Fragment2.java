package com.example.tuan05;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.tuan05.pojo.Student;


public class Fragment2 extends Fragment implements FragmentCallBack {

    TextView txtID;
    TextView txtName;
    TextView txtPoint;
    TextView txtCLass;
    Button btnFirst;
    Button btnPrevious;
    Button btnNext;
    Button btnLast;

    int index = 0;
    int maxSizeList = 0;

    MainActivity main;
    Context context;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ConstraintLayout layoutFr2 = (ConstraintLayout) inflater.inflate(R.layout.fragment2, null);
        mappingWithLayout(layoutFr2);
        addButtonsClickListener();
        return layoutFr2;
    }

    void mappingWithLayout(ConstraintLayout layoutFr2) {
        txtID = layoutFr2.findViewById(R.id.txtViewIdStudent);
        txtName = layoutFr2.findViewById(R.id.txtViewName);
        txtPoint = layoutFr2.findViewById(R.id.txtViewPoint);
        txtCLass = layoutFr2.findViewById(R.id.txtViewClass);
        btnFirst = layoutFr2.findViewById(R.id.btnFirst);
        btnPrevious = layoutFr2.findViewById(R.id.btnPrevious);
        btnNext = layoutFr2.findViewById(R.id.btnNext);
        btnLast = layoutFr2.findViewById(R.id.btnLast);

    }

    void addButtonsClickListener() {
        // send index to main, main send index to fragment 1
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = 0;
                btnFirst.requestFocus();
                main.onStudentFromFragToMain(index);

            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = index - 1;
                btnPrevious.requestFocus();
                main.onStudentFromFragToMain(index);

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNext.requestFocus();
                index = index + 1;
                main.onStudentFromFragToMain(index);

            }
        });

        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = maxSizeList - 1;
                btnLast.requestFocus();
                main.onStudentFromFragToMain(index);

            }
        });
    }


    @Override
    public void onStudentMainToFragment(Student a, int index, int maxSizeList) {
        // receive data from main
        txtID.setText(String.valueOf(a.getId()));
        txtName.setText(String.valueOf(a.getName()));
        txtPoint.setText(String.valueOf(a.getPointAVG()));
        txtCLass.setText(String.valueOf(a.getClassOfstudent()));
        this.index = index;
        this.maxSizeList = maxSizeList;
        setConditionForButton();
    }

    void setConditionForButton() {
        int max = this.maxSizeList - 1;
        if (this.index == 0) {
            btnFirst.setEnabled(false);
            btnPrevious.setEnabled(false);
        } else {
            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true);
        }
        if (this.index == (this.maxSizeList - 1)) {
            btnNext.setEnabled(false);
            btnLast.setEnabled(false);
        } else {
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
        }
    }

    @Override
    public void onStudentMainToFragment(int index) {

    }
}
