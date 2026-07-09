public class SL {
    public static void main(String[] args) {


        
        
        int arr[]={1,2,4,3,5};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int n=arr[i];
            if(n>largest){
                secondLargest=largest;
                largest=n;
            }
            if(n>secondLargest && n!=largest){
                secondLargest=n;
            }
        }
            System.out.println(secondLargest);


        }

        }

    