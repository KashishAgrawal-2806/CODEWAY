import java.util.Scanner;
public class Student_Grade_Calculator {
    public  static  String grading (double mark){
        String grade ;
        if      (mark>=90)   grade= "A";
        else if (mark>=80)   grade ="B";
        else if (mark>=70)   grade ="C";
        else if (mark>=60)   grade ="D";
        else                 grade ="E";
        return grade;
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
//       number of subjects
        System.out.println("Enter numbers of subjects :- ");
       int n=sc.nextInt();
       int total =0;
       int []marks = new int [n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the marks for subject "+(i+1)+" :- ");
            marks[i]=sc.nextInt();
//            add marks in total
              total += marks[i];
        }

        double  average_Marks = (double)total/n;
        String grade = grading(average_Marks);
//      Displaying Results :--
        System.out.println("The Totals Marks :- "+total);
        System.out.println("Average Marks Obtained :- "+average_Marks+"%");
        System.out.println("Grade :- "+ grade);

    }
}
