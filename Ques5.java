

//record is just like a class but this is more defined by the compiler like the constructor getter setter etc.
record Student(String name, int id , int age){
    static int count=0;

    public Student{
        count++;
    }
}
public class Ques5 {
    public static void main(String[] args) {
        Student s1 = new Student("Aishwarya ", 1, 23);
        Student s2 = new Student("Aishwarya ", 1, 23);
        Student s3 = new Student("Ram", 2, 21);

        //it give true only if all three parameters which are given are same
        System.out.println(s1.equals(s2));

        System.out.println("Total Object created =" + Student.count);


    }
}