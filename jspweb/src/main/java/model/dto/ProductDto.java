package model.dto;

import java.util.HashMap;
import java.util.Map;

public class ProductDto {
	//제품 카테고리
	private int pcno;
	private String pcname;
	
	//제품
	private int pno;
	private String pname;
	private String pcontent;
	private int pprice;
	private int pstate;
	private String pdate;
	private String plat;
	private String plng;
	
	//작성자 번호
	private int mno;
	
	// 제품사진
	// 한 필드에 여러개 저장할수 있게 Map 사용
	// 키 : 이미지 번호 / 값 : 이미지 이름
	private Map<Integer, String> imgList = new HashMap<>();
	
	//제품 등록한 회원 아이디
	private String mid;
	
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	// 제품등록용 생성자
	public ProductDto(int pcno, String pname, String pcontent, int pprice, String plat, String plng, int mno,
			Map<Integer, String> imgList) {
		super();
		this.pcno = pcno;
		this.pname = pname;
		this.pcontent = pcontent;
		this.pprice = pprice;
		this.plat = plat;
		this.plng = plng;
		this.mno = mno;
		this.imgList = imgList;
	}



	public ProductDto(int pcno, String pcname, int pno, String pname, String pcontent, int pprice, int pstate,
			String pdate, String plat, String plng, int mno, Map<Integer, String> imgList, String mid) {
		super();
		this.pcno = pcno;
		this.pcname = pcname;
		this.pno = pno;
		this.pname = pname;
		this.pcontent = pcontent;
		this.pprice = pprice;
		this.pstate = pstate;
		this.pdate = pdate;
		this.plat = plat;
		this.plng = plng;
		this.mno = mno;
		this.imgList = imgList;
		this.mid = mid;
	}

	
	//메소드 ( getter and setter )
	public int getPcno() {
		return pcno;
	}

	public void setPcno(int pcno) {
		this.pcno = pcno;
	}

	public String getPcname() {
		return pcname;
	}

	public void setPcname(String pcname) {
		this.pcname = pcname;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getPstate() {
		return pstate;
	}

	public void setPstate(int pstate) {
		this.pstate = pstate;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public String getPlat() {
		return plat;
	}

	public void setPlat(String plat) {
		this.plat = plat;
	}

	public String getPlng() {
		return plng;
	}

	public void setPlng(String plng) {
		this.plng = plng;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public Map<Integer, String> getImgList() {
		return imgList;
	}

	public void setImgList(Map<Integer, String> imgList) {
		this.imgList = imgList;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
	//toString ( 확인용 )
	@Override
	public String toString() {
		return "ProductDto [pcno=" + pcno + ", pcname=" + pcname + ", pno=" + pno + ", pname=" + pname + ", pcontent="
				+ pcontent + ", pprice=" + pprice + ", pstate=" + pstate + ", pdate=" + pdate + ", plat=" + plat
				+ ", plng=" + plng + ", mno=" + mno + ", imgList=" + imgList + ", mid=" + mid + "]";
	}
	
}
