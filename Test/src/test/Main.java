package test;


import java.util.Scanner;

public class Main{
	static int sum=0;
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			dfs(i,i,n,a);
		}
		System.out.println(sum);
	}
	public static void dfs(int l,int r,int n,int a[]) {
		while(l>=0&&r<=n-1&&(r-l)%2==0) {
			if(r==l) {
				sum+=a[l];
			}else {
				int mid=(r-l)/2;
				sum+=a[mid];
			}
		}
	}
}


