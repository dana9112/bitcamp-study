package com.eomcs.basic.ex07.assignment;

import java.util.Scanner;

public class Test04 {
	
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		int x = 0;
		int fac = 1;
		
		
		System.out.println("입력> ");
		x = keyboard.nextInt();
		
		for (int i = x; i >= 1; i--) {
			fac = fac * i;
		}
		
		System.out.print(fac);
		
		keyboard.close();
		
	

	} // main() end 

} // class() end
