//write program to sort names in an array.

import java.util.Scanner;

public class Sort_names {
    public static void main(String[] args) {

        int n;
        String temp;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of names you want to sort");
        n=sc.nextInt();
        String name[]=new String[n];
        Scanner sc1=new Scanner(System.in);
        System.out.println("enter all the names you want to sort");
        for(int i=0;i<n;i++){
            name[i]=sc1.nextLine();
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(name[i].compareTo(name[j])>0){
                    temp=name[i];
                    name[i]=name[j];
                    name[j]=temp;
                }
            }
        }

        for(String s1:name){
            System.out.println("Sorted Arrays=");
            System.out.println(s1);
        }

        }

        

    }
    

