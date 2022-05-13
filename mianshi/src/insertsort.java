public class insertsort {
    public static void sort(int arr[]){
       for(int i=1;i<arr.length;i++){
           int num=arr[i];
           int j;
           for(j=i-1;j>=0 && num<arr[j];j--){
               arr[j+1]=arr[j];
           }
           arr[j+1]=num;
       }
    }
    public static  void main(String[]args){
        int nums[]={2,9,8,3,5,6,7,1,2,4};
        sort(nums);
        for(int i:nums)System.out.print(i);
    }
}
