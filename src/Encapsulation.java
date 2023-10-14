import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int roll;
    private int age;

    public Student() {
        /*this.name = getName();
        this.age = getAge();
        this.roll = getRoll();*/
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
    public void setRoll(int roll) {
        this.roll = roll;
    }
    public int getRoll() {
        return this.roll;
    }
    public void studentInfo(){
        System.out.printf("\nDetails:\nStudent Name: %s\nStudent Roll Number: %d\nStudent Age: %d\n\n",name,roll,age);
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        ArrayList<Integer> l1=new ArrayList<>();
        Scanner input=new Scanner(System.in);

        System.out.print("Enter no of entries: ");
        int n=input.nextInt();
	input.nextLine();
	Student[] students = new Student[n];
	
        for (int i = 0; i < n; i++) {
	    students[i] = new Student();

            System.out.print("Enter name: ");
            String name=input.nextLine();

            System.out.print("Enter roll number: ");
            int rolln=input.nextInt();

            System.out.print("Enter age: ");
            int age=input.nextInt();

	    if(l1.contains(rolln)){
		System.out.println("Roll number repeated");
		continue;
	    }

	    l1.add(rolln);

            int count=0;
            students[i].setName(name);
            students[i].setAge(age);
            students[i].setRoll(rolln);

            students[i].studentInfo();
        }
        input.close();
    }
}