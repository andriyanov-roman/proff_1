package university_get_set;

import java.util.ArrayList;

public class Student {
    private String name;
    private String secondName;
    private ArrayList<Integer> marks;

    public String getName(){
        return name;
    }
    public void setName (String name){
        this.name = name;
    }
    public String getSecondName(){
        return secondName;
    }
    public void setSecondName (String secondName){
        this.secondName = secondName;
    }
    public ArrayList<Integer> getMarks (){
        return marks;
    }
    public  void setMarks (ArrayList<Integer> marks){
        this.marks = marks;
    }


}
