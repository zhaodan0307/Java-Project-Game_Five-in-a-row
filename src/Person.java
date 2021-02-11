/**Purpose:
 * the class named Person has two String type states.
 * This class has one constructor with 2 states.
 * This class has setters and getters for both states.
 * Name:Dan Zhao
 * Date:Dec 16th 2020
 * */


public class Person {
    //two states
    private  String name;
    private  String color;

    //constructor with 2 parameters
    Person(String theName,String theColor){
        name=theName;
        color=theColor;
    }
    //getter and setter for all states
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



}
