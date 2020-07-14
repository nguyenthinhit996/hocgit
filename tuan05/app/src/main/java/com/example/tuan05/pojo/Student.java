package com.example.tuan05.pojo;


public class Student
{
    private int id;
    private String name;
    private String classOfstudent;
    private float pointAVG;
    private int imgAvt;

    public Student(int id, String name, String lop, float point, int ima) {
        this.id=id;
        this.name=name;
        this.classOfstudent=lop;
        this.pointAVG=point;
        this.imgAvt=ima;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassOfstudent() {
        return classOfstudent;
    }

    public void setClassOfstudent(String classOfstudent) {
        this.classOfstudent = classOfstudent;
    }

    public float getPointAVG() {
        return pointAVG;
    }

    public void setPointAVG(float pointAVG) {
        this.pointAVG = pointAVG;
    }

    public int getImgAvt() {
        return imgAvt;
    }

    public void setImgAvt(int imgAvt) {
        this.imgAvt = imgAvt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
