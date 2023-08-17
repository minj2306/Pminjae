package java2.day22.Ex2;

public class 작업스레드2 extends Thread {// 상속

	@Override
	public void run() {

		try {
			int count = 1;
			while (true) {
				System.out.println( Thread.currentThread().getName() 
						+ "[작업2 Thread] output : " + count);
				Thread.sleep(10000); // 10초간 일시정지 [예외처리 필수]
				count++;
			}
		}catch (Exception e) { System.out.println(e); }
		
	

	}
}
