class Person{
    String name;
    int age;
    Person(String name,int age){
        this.name=name;
        this.age=age;
    }
}
class Empl extends Person{
    int salary;
    Empl(String name, int age,int salary) {
        super(name, age);
        this.salary=salary;
    }
    void display(){
        System.out.println(super.name+" "+super.age+" "+this.salary);
    }
}
public class Super_this{
    public static void main(String[] args) {
        Empl obj=new Empl("Ram",15,20000);
        obj.display();
    }
}