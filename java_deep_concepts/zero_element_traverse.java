//write program to move all non zero elements to the start to the array.



public class zero_element_traverse {
    public static void main(String[] args) {



        // List<Integer> list = new ArrayList<>();
        // list.add(10);
        // list.add(20);
        // list.add(30);
        // Integer [] a = list.toArray(new Integer[0]);
        // for(int i=0;i<a.length;i++){
        //     System.out.println(a[i]);
        // }



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
        if(arr[i]!=0){
            newArr[i]=arr[i];
            j++;
            }
      }
      for(int i=0;i<arr.length;i++){
        if(arr[i]==0){
            newArr[j]=arr[i];
            j++;
        }
      }

    }
}