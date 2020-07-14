package com.example.tuan05;

import com.example.tuan05.pojo.Student;

interface MainCallback{
    public void onStudentFromFragToMain(Student a,int index, int maxSizeList);
    public void onStudentFromFragToMain(int index);
}