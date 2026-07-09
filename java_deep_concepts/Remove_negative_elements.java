//write program to move all non negative elements to the start to the array.
//input - {-1,-20,30,40,50,8}
//output - {-1,-20,-8,30,40,50}

public class Remove_negative_elements {
    public static void main(String[] args) {

        int arr[]={-1,-20,30,40,50,-8};
        int newArr[] =new int[arr.length];
        rearrange(arr,newArr);
        print(newArr);
    }
    private static void print(int[] newArr){
        for(int i:newArr){
            System.out.println(i+"");
        }        
    }
    private static void rearrange(int[] arr,int[] newArr){
      int j=0;
      for(int i=0;i<arr.length;i++){
        if(arr[i]<0){
            newArr[i]=arr[i];
            j++;
            }
      }
      for(int i=0;i<arr.length;i++){
        if(arr[i]>=0){
            newArr[j]=arr[i];
            j++;
        }
      }

    }
}