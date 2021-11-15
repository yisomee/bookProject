import java.util.Scanner;
import data.LoginList;
import data.LoginVO;

public class Login {
	Scanner scan = new Scanner(System.in);
	//관리자 아이디/패스워드
	private final String ADMINID = "admin";
	private final String ADMINPWD = "1234";

	public Login() {
		
	}
	//관리자 로그인
	public boolean adminLogin(String adminid, String adminpwd) {
		
		if(adminid.equals(ADMINID) && adminpwd.equals(ADMINPWD)) {
			//로그인성공
			System.out.println("---로그인 성공---");
			return true;
		}else {
			System.out.println("일치하지 않습니다.다시 입력하여 주세요.");
			return false;
			//로그인실패
		}
	}
	
	//일반사용자로그인	
	public boolean userLogin(String userid, String userpwd) {
		LoginList.userData();//회원정보 세팅
		boolean exist = LoginList.userlist.containsKey(userid);//존재하는 아이디인지 확인
		LoginVO vo = LoginList.userlist.get(userid);//
		
		    if(exist){
		            if (vo.getUserpwd().equals(userpwd)) {
		                System.out.println("---로그인 성공---");
		                return true;
		            } else {
		                System.out.println("비밀번호를 잘못 입력하셨습니다.");
		                return false;
		            }
		    }else{
		    	System.out.println("존재하지 않는 아이디입니다.");
		    	System.out.println("아이디를 다시 입력해주세요.");
		    	return false;	
			}

	}
		
	//회원가입
	public String joinId() {
		String joinid;
		while(true){
			System.out.println("3글자 이상의 아이디를 입력하세요.");
			joinid = scan.nextLine();			
			if(joinid.length()<3) {
				System.out.println("아이디는 3글자 이상이어야 합니다.");				
			}else if(LoginList.userlist.containsKey(joinid)) {
				System.out.println("이미 존재하는 아이디입니다.");
			}else {
				System.out.println("사용가능한 아이디 입니다.");
				break;
			}
		}
			return joinid;		
	}
	public String joinPwd() {
		String joinpwd;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("4글자 이상의 패스워드를 입력하세요.");
			joinpwd = scan.nextLine();					
			if(joinpwd.length()<4) {
				System.out.println("패스워드는 4글자 이상이어야 합니다.");		
			}else {
				System.out.println("패스워드가 입력되었습니다.");
				break;		
			}
		}while(true);
		return joinpwd;
	}
	public String joinName() {
		String joinname;
		do {
			System.out.println("이름을 입력하세요.");
			joinname = scan.nextLine();
			if(joinname.length()<2) {
				System.out.println("이름을 잘못 입력하였습니다.");
			}else {
				System.out.println("이름이 등록되었습니다.");
				break;				
			}
		}while(true);
		return joinname;
	}
	public String joinTel() {
		String jointel;
		do {
			System.out.println("'-'를 포함한 연락처를 입력하세요.");
			jointel = scan.nextLine();
			if(jointel.length()<13) {
				System.out.println("번호를 잘못 입력하였습니다.");
			}else {
				System.out.println("회원가입이 완료되었습니다.");
				break;				
			}
		}while(true);
		return jointel;
	}

}
