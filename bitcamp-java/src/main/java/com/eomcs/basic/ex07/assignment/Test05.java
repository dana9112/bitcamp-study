package com.eomcs.basic.ex07.assignment;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("입력> ");
		int width = keyboard.nextInt();
		
		for (int i = 0; i < width; i++) {
			System.out.print("*");
		}
		
		
		
		keyboard.close();
		
	}
}
