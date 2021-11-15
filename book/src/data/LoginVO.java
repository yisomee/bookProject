package data;

public class LoginVO {
	private String userid;
	private String userpwd;	
	private String username;
	private String usertel;

	public LoginVO() {
		
	}
	public LoginVO(String userid, String userpwd, String username, String usertel) {
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.usertel = usertel;
	}
	public static void printTitle() {
		System.out.println("================================회원목록================================");
		System.out.printf("%8s %10s %10s %12s\n", "아이디", "패스워드", "이름", "연락처");
		System.out.println("========================================================================");
	}
	public void memberPrint() {
		System.out.printf("%10s %12s %13s %18s\n", userid, userpwd, username, usertel);
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	

}
