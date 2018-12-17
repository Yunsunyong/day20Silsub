package day20.silsub2;

import java.util.*;
import java.io.*;

public class SungiukProcess {
	private Scanner sc = new Scanner(System.in);
	
	public void sungjukSave() {
		try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("score.dat"));){
			
			do{
				System.out.print("국어 점수 : ");
				int kor = sc.nextInt();
				System.out.print("영어 점수 : ");
				int eng = sc.nextInt();
				System.out.print("수학 점수 : ");
				int mat = sc.nextInt();
				
				int sum = kor + eng + mat;
				double avg = sum / 3.0;
				
				dout.writeInt(kor);
				dout.writeInt(eng);
				dout.writeInt(mat);
				dout.writeInt(sum);
				dout.writeDouble(avg);
				dout.flush();
				
				System.out.print("계속 저장 하시겠습니까? (y/n) : ");
			}while(Character.toUpperCase(sc.next().charAt(0)) == 'Y');
			System.out.println("score.dat 에 저장 완료.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void scoreRead() {
		int totalSum = 0, count = 0;
		double totalAvg = 0;
		try(DataInputStream din = new DataInputStream(new FileInputStream("score.dat"));){
		
			while(true) {	
				int kor = din.readInt();
				int eng = din.readInt();
				int mat = din.readInt();
				int tot = din.readInt();
				double avg = din.readDouble();
									
			System.out.println("국어 점수 : " +kor +
					" 영어 점수 : " + eng +
					" 수학 점수 : " + mat +
					" 총점 : " + tot+
					"평균 : " + ((int)(avg*100)/100.0));
			
				totalSum += tot;
				totalAvg += avg;
				count++;
			}
					
		}catch(EOFException e) {
			System.out.println("전체 총점 : " + totalSum +
					"\n전체 평균 : " + ((int)(totalAvg*100)/100.0) +
					"\n전체 총점과 전체 평균을 읽어온 횟수 : " + count);
			System.out.println("score.dat 파일 읽기 완료.");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// 입출력 실습문제2
		SungiukProcess test = new SungiukProcess();
		test.sungjukSave();
		test.scoreRead();
	}

}
