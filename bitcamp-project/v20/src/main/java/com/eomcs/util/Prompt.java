package com.eomcs.util;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {
  
  Scanner input;
  
  public Prompt(Scanner input) {
    this.input = input;
  }
  
  public String inputString(String label) {
    System.out.print(label);
    return input.nextLine();
  }

  // 오버로딩 
  public String inputString(String label, String defaultValue) {
    System.out.print(label);
    String value =  input.nextLine();
    if (value.length() == 0 ) {
      return defaultValue;
    }
    return value;
  }

  public int inputInt(String label) {
    System.out.print(label);
    return Integer.parseInt(input.nextLine());
  }

  // 디폴트 값은 사용자가 빈 문자열일때
  public int inputInt(String label, int defaultValue) {
    System.out.print(label);
    String value =  input.nextLine();
    if (value.length() == 0 ) {
      return defaultValue;
    }
    return Integer.parseInt(value);
  }


  public Date inputDate(String label) {
    System.out.print(label);
    return Date.valueOf(input.nextLine());
  }

  public Date inputDate(String label, Date defaultValue) {
    System.out.print(label);
    String value =  input.nextLine();
    if (value.length() == 0 ) {
      return defaultValue;
    }
    return Date.valueOf(value);
  }


}
