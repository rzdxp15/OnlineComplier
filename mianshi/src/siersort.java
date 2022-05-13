public class siersort {
    static void siersort(int nums[]){
        for(int d=nums.length/2;d>0;d=d/2){
           for(int i=d;d<nums.length;i++){
               if(i>=10)break;

              int num=nums[i];
               int k;
               for(k=i-d;k>=0&&num<nums[k];k-=d ){
                   nums[k+d]=nums[k];
               }
               nums[k+d]=num;
           }
        }
    }
    public static void shellSort(int[] nums) {
        for (int d = nums.length / 2; d > 0 ; d /= 2) {
            for (int i = d; i < nums.length; i++) {
                int insertNum = nums[i];

                int insertIndex;
                for (insertIndex = i - d; insertIndex >= 0 && nums[insertIndex] > insertNum; insertIndex -= d) {
                    nums[insertIndex + d] = nums[insertIndex]; }
                nums[insertIndex + d] = insertNum;
            } } }
    public static void qsort(int nums[],int l,int r){
        if(l<r){
            int p=quisort(nums,l,r);
            qsort(nums,l,p-1);
            qsort(nums,p+1,r);
        }
    }

    private static int quisort(int[] nums, int l, int r) {
        int p=nums[l];
        int i=l,j=r;
        while(i<j){
            while(i<=j&&nums[j]>=p)j--;
            while(i<=j&&nums[i]<p)i++;
            if(i<j){
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
            }
        }
        nums[i]=p;
        return i;
    }

    public static  void main(String[]args){
        int nums[]={2,9,8,3,5,6,7,1,2,4};
        //shellSort(nums);
       // siersort(nums);
        qsort(nums,0,nums.length-1);
        for(int i:nums)System.out.print(i);
    }
}
