package day0329;

import java.util.Scanner;

public class AgeComparison {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age1, age2;
		System.out.print("ù ��° ����� ���̸� �Է��ϼ��� ==> ");
		age1 = sc.nextInt();
		
		System.out.print("�� ��° ����� ���̸� �Է��ϼ��� ==> ");
		age2 = sc.nextInt();
		
		if(age1 == age2) {
			System.out.println("�� ����� ���̴� �����ϴ�.");
		}else {
			System.out.println("�� ����� ���̴� ���� �ʽ��ϴ�.");
		}

	}

}