package day20.silsub3;

import java.util.*;
import java.io.*;

public class BookManager {
	private Scanner sc = new Scanner(System.in);
	
	public BookManager() {}
	
	public void fileSave() {
		Book[] bar = {
				new Book("자바의정석","남궁성",30000,new GregorianCalendar(1991,1,12),0.1),
				new Book("오라클","남씨",25000,new GregorianCalendar(1992,2,15),0.2),
				new Book("jsp","길씨",28000,new GregorianCalendar(1993,3,15),0.3),
				new Book("oop","오씨",20000,new GregorianCalendar(1994,4,15),0.4),
				new Book("doot","두씨",15000,new GregorianCalendar(1995,5,15),0.5)
		};
		
		try(ObjectOutputStream objOut = new ObjectOutputStream
				(new FileOutputStream("books.dat"));){
				//대상 파일이 없으면 자동으로 파일을 만든다
			//대상 파일이 있으면 , 파일 안의 내용을 지우고
			//새로쓰기 상태로 파일을 연다.
			//파일출력스트림 생성시에 추가쓰기(append)모드
			//를 true로 하면 대상파일이 있을때
			//기존 내용은 그대로 두고
			//내용 뒤에 추가쓰기가 됨
			for(int i = 0; i < bar.length; i++) {
				objOut.writeObject(bar[i]);
			}
			System.out.println("books.dat에 저장 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}					
	
	public void fileRead() {
		int count = 0;
		Book[] bar = new Book[10];
		try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("books.dat"));){
			while(true) {
				bar[count] = (Book)objIn.readObject();
				count++;
			}
			
		}catch(EOFException e) {
			for(int i = 0; i < count; i++) {
				System.out.println(bar[i]);
			}
			System.out.println("읽기 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
