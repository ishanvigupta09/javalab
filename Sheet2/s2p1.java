import java.util.Scanner;
class Student{
   
    int rollNo;
    String name;
    float marks1;
    float marks2;
    float marks3;
    public Student(int rollNo,String name,float marks1,float marks2, float marks3){
        this.rollNo= rollNo;
        this.name= name;
        this.marks1=marks1;
        this.marks2=marks2;
        this.marks3=marks3;
    
}
public int getrollNo(){
    return rollNo;
}
public String getname(){
    return name;
}
public float getmarks1(){
    return marks1;
}
public float getmarks2(){
    return marks2;
}
public float getmarks3(){
    return marks3;
}
public float calculateTotal(){
    return marks1+marks2+marks3;
}
public float calculatePercentage(){
    return calculateTotal()/3;
}
public char calculateGrade(){
    float percentage= calculatePercentage();
    if(percentage>=90)
    return 'A';
    else if(percentage>=75)
    return 'B';
    else if(percentage>=60)
    return 'C';
    else return'D';

    
}

public void displayDetails(){
    
    System.out.println("Roll Number: " + getrollNo());
    System.out.println("Marks in subject 1"+ getmarks1());
    System.out.println("Marks in subject 2"+ getmarks2());
    System.out.println("Marks in subject 3"+ getmarks3());
    System.out.println("Total marks: "+ calculateTotal());
    System.out.println("Percentage: "+ calculatePercentage());
    System.out.println("Grade: "+ calculateGrade());
    
}
}
public class s2p1{
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        
          System.out.print("Enter roll number: ");
          int rollNo= sc.nextInt();
          sc.nextLine();
           System.out.print("Enter name: ");
           String name= sc.nextLine();
            System.out.print("Enter marks in 3 subjects: ");
            float m1=sc.nextFloat();
            float m2=sc.nextFloat();
            float m3=sc.nextFloat();
            
            Student s= new Student(rollNo,name,m1,m2,m3);
            s.displayDetails();
            sc.close();
    }
}
    