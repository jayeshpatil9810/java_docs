import java.util.Scanner;



public class Palindrom {
    public static void main(String[] args) {

        
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number");
        int number = sc.nextInt();
        sc.close();
        if(isPalindrom(number)){
            System.out.println("number is palindrom"+number);
        }
        else{
            System.out.println("number is not palindrom"+number);
        }
        }
        public static boolean isPalindrom(int number){
            int original=number;
            int reverse=0;
            while(number!=0){
                int digit=number%10; 
                reverse=reverse*10+digit; 

                number=number/10;
            }
            return original==reverse;


        }
    }
    

