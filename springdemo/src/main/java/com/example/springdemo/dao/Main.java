package com.example.springdemo.dao;

import java.util.Arrays;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String t1=sc.nextLine();
        int t=Integer.parseInt(t1);

        for(int i=0;i<t;i++){
            String n=sc.nextLine();
            String s=sc.nextLine();
            System.out.println(check(s));

        }
    }

    private static String check(String s) {
        String s1[]=s.split(" ");
        int []a=new int[s1.length];
        int sum=0;
        for(int i=0;i<s1.length;i++){
            a[i]=Integer.parseInt(s1[i]);

            sum+=a[i];
        }
        Arrays.sort(a);
        if(sum%3!=0){
            return "NO";
        }
        int av=sum/3;

        int p1=av,p2=av,p3=av;
        int l=0,r=a.length-1;
        while(l<r&&sum>av){
            if(p1>0){
                if(p1>=a[r]){
                    p1-=a[r];
                    l--;
                }else {
                    p1-=a[l];
                    l++;
                }
            }else if(p2>0){
                if(p2>=a[r]){
                    p2-=a[r];
                    l--;
                }else {
                    p2-=a[l];
                    l++;
                }
            }else{
                break;
            }
        }
        return sum-p1-p2==av?"YES":"NO";
    }

}