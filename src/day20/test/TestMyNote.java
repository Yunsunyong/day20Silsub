package day20.test;

import java.util.Scanner;
import day20.silsub1.MyNote;

public class TestMyNote {
	public static void menu() {
		MyNote mn = new MyNote();
		Scanner sc = new Scanner(System.in);
		
		int num;
		do {
			System.out.println("******    MyNote     ******");
			System.out.println();
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 노트 열어서 수정하기");
			System.out.println("4. 끝내기");
			System.out.print(" 메뉴선택 : ");
			 num = sc.nextInt();
			 switch(num) {
			 case 1 : mn.fileSave(); break;
			 case 2 : mn.fileOpen(); break;
			 case 3 : mn.fileEdit(); break;
			 case 4 : System.out.println("끝내기."); return;
			 default : System.out.println("번호 선택이 잘못되었습니다.");
			 			System.out.println("다시 선택하십시오.\n");
			 }
		}while(num != 4);
	}
	public static void main(String[] args) {
		menu();
	}
}