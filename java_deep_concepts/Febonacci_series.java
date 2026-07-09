public class Febonacci_series {

    public static void main(String[] args) {



        int n=10;
        int firstNum=0;
        int secondNum=1;
        //System.out.println("the febonacci series"+n);
        for(int i=0;i<n;++i){
            System.out.println(firstNum);
        int nextterm = firstNum+secondNum;
        firstNum=secondNum;
        secondNum=nextterm;
        
        }
    }
}


    //     int n=10;
    //     int firstNum=0;
    //     int secNum=1;
    //     System.out.println("fibonacci series till"+n+"terms");
        
    //     for(int i=1;i<=n;++i){
    //         System.out.println(firstNum+"");
    //         int nextTerm=firstNum+secNum;
    //         firstNum=secNum;
    //         secNum=nextTerm;
            
    //     }
    //     }
        


    // }
    
