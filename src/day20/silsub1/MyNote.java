package day20.silsub1;

import java.util.*;
import java.io.*;

public class MyNote {
private Scanner sc = new Scanner(System.in);
	
	public MyNote() {}
	
	public void fileSave(){
		StringBuilder sb = new StringBuilder();
	
		String ss = "";
		
		System.out.println("파일에 저장할 내용을 입력하시오.");	
		while(!(ss = sc.nextLine()).equals("exit")) {
				sb.append(ss + "\n");
		}
		
		System.out.print("저장하시겠습니까? (y/n)");
		if(sc.next().toUpperCase().charAt(0) == 'Y') {
			System.out.print("저장할 파일명 : ");
			String fileName = sc.next();
					
		try (BufferedWriter bfw = new BufferedWriter(new FileWriter(fileName))){
			
			bfw.write(sb.toString());
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void fileOpen(){
		System.out.print("열기할 파일명 : ");
		String fileName = sc.next();
		
		try(BufferedReader bfr = new BufferedReader(new FileReader(fileName));){
			String line = null;
			while((line = bfr.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("읽기 완료.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void fileEdit(){
		StringBuilder sb = new StringBuilder();
		
		String ss1= "";
		System.out.print("수정할 파일명 : ");
		String fileName = sc.next();
		sc.nextLine();
		try(BufferedReader bfr = new BufferedReader(new FileReader(fileName));){
			String line = null;
			while((line = bfr.readLine()) != null) {
				sb.append(line + "\n");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(BufferedWriter bfw = new BufferedWriter(new FileWriter(fileName));){
		
		
		System.out.println("파일에 추가할 내용을 입력하시오.");
		while(!(ss1 = sc.nextLine()).equals("exit")) {
			sb.append(ss1 + "\n");
		}
		System.out.print("변경된 내용을 파일에 추가하시겠습니까?(y/n) : ");
		if(sc.next().toUpperCase().charAt(0) == 'Y') {
			bfw.write(sb.toString());
		}
		System.out.println(fileName + "파일의 내용이 변경되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}