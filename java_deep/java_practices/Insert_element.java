//insert element at in array at specific position.

import java.util.Scanner;

import javax.xml.validation.Schema;

public class Insert_element {
    public static void main(String[] args) {

        int[] arr1 = new int[5];
        System.out.println("enter the elements");
        Scanner sc1 = new Scanner(System.in);
        for(int i=0;i>arr1.length-1;i++){
            arr1[i]=sc1.nextInt();
        }

        for(int x1:arr1){
            System.out.println(x1);
        
        }
        System.out.println("enter the location where element want to store");{
            int location =
        }


        }





    





        int arr[]=new int[5];
        System.out.println("enter the elements");        
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<arr.length-1;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("printing elements before insert");
        for(int i:arr){
            System.out.println(i);
        }
        System.out.println("enter the location at which we want to insert");
        int location=sc.nextInt();
        System.out.println("enter the value at which we want to insert");
        int value=sc.nextInt();
        for(int i=arr.length-1;i>location;i--){
            arr[i]=arr[i-1];
        }

        arr[location]=value;
        for(int i:arr){
            System.out.println(i);
        }

    }
    
}
