package day0329;

import java.util.Scanner;

public class ComparisonOperator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age;
		System.out.print("나이를 입력하세요 ==> ");
		age = sc.nextInt();
		if(age >= 20) {
			System.out.println("입장가능");
			
		}else {
			System.out.println("입장불가능");
		}
	}
}
