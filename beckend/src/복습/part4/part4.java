package 복습.part4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class part4 {
	
	public static void main(String[] args) throws IOException {
	
		while (true) {
			
			Scanner scanner = new Scanner(System.in);
			String filePath = "./src/복습/part4/재고파일";
			FileOutputStream fileOutputStream = new FileOutputStream(filePath , true);
			FileInputStream fileInputStream = new FileInputStream(filePath);
			File file = new File(filePath);
			
			byte[] inbyteArray = new byte[(int)file.length()];
			fileInputStream.read(inbyteArray);
			String fileInfo = new String( inbyteArray);
			
			String[] 재고관리 = fileInfo.split("\n");
			
			System.out.println("--------------메뉴--------------");
			System.out.println("-1:제품등록 0:결제");
			
			for(int i=0; i<재고관리.length; i++) {
				if(!재고관리[i].equals("")) {
					String name = 재고관리[i].split(",")[0];
					int stock = Integer.parseInt(재고관리[i].split(",")[1]);
					int price = Integer.parseInt(재고관리[i].split(",")[2]);
					int basket = Integer.parseInt(재고관리[i].split(",")[3]);
					if(stock == 0) {
						System.out.println((i+1)+":"+name+"[재고없음]");
					}
					else {
						System.out.println((i+1)+":"+name+"["+price+ "]");
					}
				}
			}
			
			System.out.println(">>>>선택"); int ch = scanner.nextInt();
			
			if(ch==-1) {
				System.out.println("제품명 : "); String name = scanner.next();
				System.out.println("초기재고 : "); int stock = sc
			}
			else if(ch>0 && ch<=재고관리.length) {
				
			}
			else if(ch==0) {
				
			}
		}
			
	}//main end
	
}//class end
