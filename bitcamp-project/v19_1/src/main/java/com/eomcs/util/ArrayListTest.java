package com.eomcs.util;

public class ArrayListTest {
  public static void main(String[] args) {
    ArrayList1<String> a1 = new ArrayList1<>();
    
    a1.add("aaaaaa");
    a1.add("bbbbbb");
    a1.add("cccccc");
    a1.add("dddddd");
    a1.add("eeeeee");
    a1.add("ffffff");
    //a1.add(new Member()); //컴파일 오류!
    
    
   /* String value =(String) a1.get(0);
    System.out.println(value);
    
    System.out.println(a2.get(0));
    */
    
    System.out.println(a1.get(-1));
    System.out.println(a1.get(6));
    
    String oldValue = (String) a1.set(0,"xxxx");
    a1.set(0, "xxxxx");
    System.out.printf("%s ===> %s\n", oldValue, a1.get(0));
    
    a1.set(-1, "yyyyy");
    a1.set(6, "zzzz");
    System.out.println("----------------------------");
    
    print(a1);
    a1.remove(-1); // 
    
    oldValue =(String) a1.remove(5);
    System.out.printf("삭제 전(%s) ==> 삭제 후(%s)\n", oldValue, a1.get(0));
    
    System.out.println("----------------------------");
    
    print(a1);
  }
  
  // 여기 부분 확인 하기 
  static void print(ArrayList1<String> arr) {
   // String[] list = new String[arr.size()];
    String[] list = arr.toArray(new String[] {});
     for (String e : list) {
       System.out.println(e);
     }
  }
}
