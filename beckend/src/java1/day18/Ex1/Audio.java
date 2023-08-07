package java1.day18.Ex1;

public class Audio implements RemoteControl {

	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}
	
	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
	}
	
	@Override
	public void setVolume(int volume) {

		if(volume > RemoteControl.MAX_VOLUME) {
			//만약에 볼륨이 최대볼륨보다 크면
			this.volume = RemoteControl.MAX_VOLUME;
		}else if( volume < RemoteControl.MIN_VOLUME ){
			//만약에 볼륨이 최소볼륨보다 작으면 해당 객체의 소음을ㄹ 최소 볼륨으로 대입/설정
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}

	}
	
}

