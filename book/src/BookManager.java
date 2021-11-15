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
		BookList.bookData();//������� ����
		LoginList.userData();//ȸ������ ����
		program();
		
	}
	//�޴� Ʋ
	public void program() {
		//����� ���� �޴�
		System.out.println("ȯ���մϴ�:)����ڸ� �����ϼ���.");
		do {
			String data = inData("[1.������ 2.�Ϲݻ���� 3.����]");
			Login log = new Login();
			if(data.equals("1")) {
				//�����ڷα���
				System.out.println("�α����� �ʿ��� �����Դϴ�.");
				boolean login = false;
				do {
					String adminid = inData("���̵�->");
					String adminpwd = inData("��й�ȣ->");
					login = log.adminLogin(adminid,adminpwd);
									
				}while(!login);
				
				adminMenu();
								
			}else if(data.equals("2")) {
				//�Ϲݻ���� �޴�����		
				String num = inData("�޴�[1.�α��� 2. ȸ������]");
				if(num.equals("1")) {
					//����ڷα���
					userLogin();//����� �α���					
					userMenu();//����� �޴�
					
				}else if(num.equals("2")) {
					//����� ȸ������					
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
					userLogin();//�α���
					userMenu();//����� �޴�
										
				}else {
					System.out.println("�޴��� �߸� �Է��Ͽ����ϴ�.");
				}
				
			}else if(data.equals("3")) {
				System.out.println("�̿����ּż� �����մϴ�:)");
				System.exit(0);
			}else {
				System.out.println("�޴��� �߸� �Է��Ͽ����ϴ�.");
			}
		}while(true);
	}
	//����� �α���
	public void userLogin() {
		Login log = new Login();
		boolean flag = false;
		do {
			userid = inData("���̵�->");
			String userpwd = inData("��й�ȣ->");
			flag = log.userLogin(userid, userpwd);
		}while(!flag);
	}

	//�����˻�
	public void searchBook() {
		do {
			try {
				String title = inData("�˻��Ͻ� ������ �Է��ϼ���.");	
				BookVO value = BookList.bl.get(title);
				System.out.println(value.toString());
				break;
			}catch(Exception e) {
				System.out.println("��Ͽ� ���� �����Դϴ�.");
			}
		}while(true);
	}

	//�����뿩
	public void borrowBook(String userid) {

		boolean result = true;
		do {
			
			String title = inData("�뿩�Ͻ� å ������ �Է��Ͽ� �ּ���.");
			BookVO vo = BookList.bl.get(title);	
			if(!BookList.bl.containsKey(title)) {
				System.out.println("��Ͽ� ���� �����Դϴ�.");
			}else if(vo.getState().equals("����Ұ�")) {//����Ұ��϶�
				System.out.println("���� �ٸ� �̿��ڰ� �������Դϴ�.");
			}else {
				System.out.println("������ �Ϸ� �Ǿ����ϴ�.");			
				vo.setState("����Ұ�");		
				result = false;
			}
				
		}while(result);
			
	}
	//�����ݳ�
	public void returnBook() {
		
		do {
			String title = inData("�ݳ��Ͻ� å ������ �Է��Ͽ� �ּ���.");
			BookVO vo = BookList.bl.get(title);
			if(!BookList.bl.containsKey(title)) {
				System.out.println("��Ͽ� ���� �����Դϴ�.");			
			}else if(vo.getState().equals("���Ⱑ��")){
				System.out.println("�����Ͻ� ������ �ƴմϴ�.");
			}else {
				System.out.println("�ݳ��� �Ϸ� �Ǿ����ϴ�.");
				vo.setState("���Ⱑ��");		
				break;
			}
				
		}while(true);
			
	}
	//�Ϲݻ���ڸ޴�
	public void userMenu() {
		do {
			String num = inData("�޴�[1.���� ��� ��ȸ 2.���� 3.�ݳ� 4.�����˻� 5.ù ȭ������ ���ư��� 6.����]");
			if(num.equals("1")) {
				//���������ȸ
				bookList();
			}else if(num.equals("2")) {
				//�����ϱ�
				borrowBook(userid);
			}else if(num.equals("3")) {
				//�ݳ��ϱ�
				returnBook();
			}else if(num.equals("4")) {
				//�����˻�
				searchBook();
			}else if(num.equals("5")) {
				//ùȭ������ ���ư���
				program();
			}else if(num.equals("6")) {
				//����
				System.out.println("�̿����ּż� �����մϴ�:)");
				System.exit(0);
			
			}else {
				System.out.println("�޴��� �߸� �Է��Ͽ����ϴ�.");
			}
		}while(true);
	}
	//�����ڸ޴�
	public void adminMenu() {
		do {
			String data = inData("�޴�[1.ȸ�� ��� ��ȸ 2.���� ��� ��ȸ 3.���� �߰� 4.���� ���� 5.ù ȭ������ ���ư��� 6.����]");
			if(data.equals("1")) {
				//ȸ�������ȸ
				allMemberList();				
			}else if(data.equals("2")) {
				//���������ȸ
				bookList();
			}else if(data.equals("3")) {
				//���� �߰�
				addBook();
			}else if(data.equals("4")) {
				//���� ����
				removeBook();
			}else if(data.equals("5")) {
				//ùȭ��
				program();
			}else if(data.equals("6")) {
				//����
				System.out.println("�̿����ּż� �����մϴ�:)");
				System.exit(0);
			}else {
				System.out.println("�޴��� �߸� �Է��Ͽ����ϴ�.");
			}
		}while(true);
		
	}
	//ȸ�������ȸ
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
	//���������ȸ
	public void bookList() {		
		BookVO.printTitle();
		Collection<BookVO> list = BookList.bl.values();
		Iterator<BookVO> ii = list.iterator();
		while(ii.hasNext()) {
			BookVO vo = ii.next();
			vo.bookPrint();
		}
	}
	//�����߰�
	public void addBook() {
		BookVO vo = new BookVO();
		vo.setNum(inData("��ȣ->"));
		vo.setTitle(inData("����->"));
		vo.setAuthor(inData("�۰�->"));
		vo.setPublisher(inData("���ǻ�->"));
		vo.setState(inData("�������->"));
		System.out.println("������ �߰��Ǿ����ϴ�.");
		BookList.bl.put(vo.getTitle(), vo);
		
	}
	//������ ��������
	public void removeBook() {
		do {
			String booktitle = inData("�����Ͻ� ���� ������ �Է��ϼ���.");
			if(BookList.bl.containsKey(booktitle)) {
				BookList.bl.remove(booktitle);
				System.out.println("�����Ǿ����ϴ�.");
				break;
			}else {	
				System.out.println("��Ͽ� ���� �����Դϴ�.");
			}
		}while(true);
		
	}
	
	public String inData(String data) {
		System.out.print(data);
		return scan.nextLine();
	}
	

}
