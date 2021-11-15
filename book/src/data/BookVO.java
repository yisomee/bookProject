package data;

public class BookVO {
	private String num;
	private String title;
	private String author;
	private String publisher;
	private String state; //대출상태

	public BookVO() {
		
	}
	public BookVO(String num, String title, String author, String publisher, String state) {
		this.num = num;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.state = state;
		
	}
	public static void printTitle() {
		System.out.println("========================================도서목록========================================");
		System.out.printf("%-10s %-17s %-16s %-14s %-10s\n", "번호", "제목", "작가","출판사", "대출상태");
		System.out.println("========================================================================================");
	}
	//1권의 책 정보
	public void bookPrint() {
		System.out.printf("%-10s %-15s %-15s %-15s %-10s\n", num, title, author, publisher, state);
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String toString() {
		String bookData = num +"\t"+ title +"\t"+ author+"\t"+ publisher +"\t"+ state;
		return bookData;
	}

}
