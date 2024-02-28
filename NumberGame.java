import java.util.Random;
import java.util.Scanner;
public class NumberGame{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random r= new Random();
        boolean Play =true;
        while (Play){
            int attempts =3;
            int score=0;
            int secret =r.nextInt(100)+1;
            System.out.println("Welcome to the Guessing Game!");
            System.out.println("Guess a number between 1 and 100...");
            while(attempts>0){
                int guess =sc.nextInt();
//                check the guess
                if(guess==secret ){
                    score += 100-attempts;
                    System.out.println("Congratulation ,You win!!...");
                    break;
                }else if (guess>secret){
                    attempts--;
                    System.out.println("Too High !!!");
                }else{
                    attempts --;
                    System.out.println("Too Low !!!");
                }
            }
            if (attempts== 0){
                System.out.println("Sorry , You ran out of attempts  " + " Your Secret number is : " + secret);
            }
            System.out.println("Your Score is :" + score);
            System.out.println(" Do you want to play Again (y/n) :-" );
            Play = sc.next().toLowerCase().charAt(0)== 'y';
        }
        System.out.println(" Thank you for playing ! ... ");
        sc.close();
    }
}