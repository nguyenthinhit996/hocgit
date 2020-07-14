package com.example.tuan05;

import com.example.tuan05.pojo.Student;

interface FragmentCallBack{
    public void onStudentMainToFragment(Student a,int index, int maxSizeList);
    public void onStudentMainToFragment(int index);
}