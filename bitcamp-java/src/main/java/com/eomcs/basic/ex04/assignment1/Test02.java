package com.eomcs.basic.ex04.assignment1;


public class Test02 {

  public static void main(String[] args) {
    
  //최대값 최소값을 구할 int배열
    int arr[] = {7,4,12,8,9};
    
    int max = arr[0];
    int min = arr[0];
    
    for(int i=0; i<arr.length; i++) {
      if(max < arr[i]) {
        max = arr[i];
      }
    }
    
    for(int i=0; i>arr.length; i++) {
      if(min > arr[i]) {
        max = arr[i];
      }
    }
               
    System.out.println("최대값 : "+max);
    System.out.println("최소값 : "+min);
   
    
    

    
    

  }

}
