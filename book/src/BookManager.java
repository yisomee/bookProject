import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import data.*;


public class BookManager {
	Scanner scan = new Scanner(System.in);
	String userid;

	public BookManager() {	
	}
	
	public void start() {
		BookList.bookData();//도서목록 세팅
		LoginList.userData();//회원정보 세팅
		program();
		
	}
	//메뉴 틀
	public void program() {
		//사용자 선택 메뉴
		System.out.println("환영합니다:)사용자를 선택하세요.");
		do {
			String data = inData("[1.관리자 2.일반사용자 3.종료]");
			Login log = new Login();
			if(data.equals("1")) {
				//관리자로그인
				System.out.println("로그인이 필요한 서비스입니다.");
				boolean login = false;
				do {
					String adminid = inData("아이디->");
					String adminpwd = inData("비밀번호->");
					login = log.adminLogin(adminid,adminpwd);
									
				}while(!login);
				
				adminMenu();
								
			}else if(data.equals("2")) {
				//일반사용자 메뉴선택		
				String num = inData("메뉴[1.로그인 2. 회원가입]");
				if(num.equals("1")) {
					//사용자로그인
					userLogin();//사용자 로그인					
					userMenu();//사용자 메뉴
					
				}else if(num.equals("2")) {
					//사용자 회원가입					
					LoginVO vo = new LoginVO();
					String joinid = log.joinId();
					vo.setUserid(joinid);
					String joinpwd = log.joinPwd();
					vo.setUserpwd(joinpwd);
					String joinname = log.joinName();
					vo.setUsername(joinname);
					String jointel = log.joinTel();
					vo.setUsertel(jointel);
					LoginList.userlist.put(vo.getUserid(), vo);
					userLogin();//로그인
					userMenu();//사용자 메뉴
										
				}else {
					System.out.println("메뉴를 잘못 입력하였습니다.");
				}
				
			}else if(data.equals("3")) {
				System.out.println("이용해주셔서 감사합니다:)");
				System.exit(0);
			}else {
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		}while(true);
	}
	//사용자 로그인
	public void userLogin() {
		Login log = new Login();
		boolean flag = false;
		do {
			userid = inData("아이디->");
			String userpwd = inData("비밀번호->");
			flag = log.userLogin(userid, userpwd);
		}while(!flag);
	}

	//도서검색
	public void searchBook() {
		do {
			try {
				String title = inData("검색하실 도서를 입력하세요.");	
				BookVO value = BookList.bl.get(title);
				System.out.println(value.toString());
				break;
			}catch(Exception e) {
				System.out.println("목록에 없는 도서입니다.");
			}
		}while(true);
	}

	//도서대여
	public void borrowBook(String userid) {

		boolean result = true;
		do {
			
			String title = inData("대여하실 책 제목을 입력하여 주세요.");
			BookVO vo = BookList.bl.get(title);	
			if(!BookList.bl.containsKey(title)) {
				System.out.println("목록에 없는 도서입니다.");
			}else if(vo.getState().equals("대출불가")) {//대출불가일때
				System.out.println("현재 다른 이용자가 대출중입니다.");
			}else {
				System.out.println("대출이 완료 되었습니다.");			
				vo.setState("대출불가");		
				result = false;
			}
				
		}while(result);
			
	}
	//도서반납
	public void returnBook() {
		
		do {
			String title = inData("반납하실 책 제목을 입력하여 주세요.");
			BookVO vo = BookList.bl.get(title);
			if(!BookList.bl.containsKey(title)) {
				System.out.println("목록에 없는 도서입니다.");			
			}else if(vo.getState().equals("대출가능")){
				System.out.println("대출하신 도서가 아닙니다.");
			}else {
				System.out.println("반납이 완료 되었습니다.");
				vo.setState("대출가능");		
				break;
			}
				
		}while(true);
			
	}
	//일반사용자메뉴
	public void userMenu() {
		do {
			String num = inData("메뉴[1.도서 목록 조회 2.대출 3.반납 4.도서검색 5.첫 화면으로 돌아가기 6.종료]");
			if(num.equals("1")) {
				//도서목록조회
				bookList();
			}else if(num.equals("2")) {
				//대출하기
				borrowBook(userid);
			}else if(num.equals("3")) {
				//반납하기
				returnBook();
			}else if(num.equals("4")) {
				//도서검색
				searchBook();
			}else if(num.equals("5")) {
				//첫화면으로 돌아가기
				program();
			}else if(num.equals("6")) {
				//종료
				System.out.println("이용해주셔서 감사합니다:)");
				System.exit(0);
			
			}else {
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		}while(true);
	}
	//관리자메뉴
	public void adminMenu() {
		do {
			String data = inData("메뉴[1.회원 목록 조회 2.도서 목록 조회 3.도서 추가 4.도서 삭제 5.첫 화면으로 돌아가기 6.종료]");
			if(data.equals("1")) {
				//회원목록조회
				allMemberList();				
			}else if(data.equals("2")) {
				//도서목록조회
				bookList();
			}else if(data.equals("3")) {
				//도서 추가
				addBook();
			}else if(data.equals("4")) {
				//도서 삭제
				removeBook();
			}else if(data.equals("5")) {
				//첫화면
				program();
			}else if(data.equals("6")) {
				//종료
				System.out.println("이용해주셔서 감사합니다:)");
				System.exit(0);
			}else {
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		}while(true);
		
	}
	//회원목록조회
	public void allMemberList() {
		LoginList.userData();
		LoginVO.printTitle();
		Collection<LoginVO> list = LoginList.userlist.values();
		Iterator<LoginVO> ii = list.iterator();
		while(ii.hasNext()) {
			LoginVO vo = ii.next();
			vo.memberPrint();
		}
		
	}	
	//도서목록조회
	public void bookList() {		
		BookVO.printTitle();
		Collection<BookVO> list = BookList.bl.values();
		Iterator<BookVO> ii = list.iterator();
		while(ii.hasNext()) {
			BookVO vo = ii.next();
			vo.bookPrint();
		}
	}
	//도서추가
	public void addBook() {
		BookVO vo = new BookVO();
		vo.setNum(inData("번호->"));
		vo.setTitle(inData("제목->"));
		vo.setAuthor(inData("작가->"));
		vo.setPublisher(inData("출판사->"));
		vo.setState(inData("대출상태->"));
		System.out.println("도서가 추가되었습니다.");
		BookList.bl.put(vo.getTitle(), vo);
		
	}
	//관리자 도서삭제
	public void removeBook() {
		do {
			String booktitle = inData("삭제하실 도서 제목을 입력하세요.");
			if(BookList.bl.containsKey(booktitle)) {
				BookList.bl.remove(booktitle);
				System.out.println("삭제되었습니다.");
				break;
			}else {	
				System.out.println("목록에 없는 도서입니다.");
			}
		}while(true);
		
	}
	
	public String inData(String data) {
		System.out.print(data);
		return scan.nextLine();
	}
	

}
