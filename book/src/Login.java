import java.util.Scanner;
import data.LoginList;
import data.LoginVO;

public class Login {
	Scanner scan = new Scanner(System.in);
	//������ ���̵�/�н�����
	private final String ADMINID = "admin";
	private final String ADMINPWD = "1234";

	public Login() {
		
	}
	//������ �α���
	public boolean adminLogin(String adminid, String adminpwd) {
		
		if(adminid.equals(ADMINID) && adminpwd.equals(ADMINPWD)) {
			//�α��μ���
			System.out.println("---�α��� ����---");
			return true;
		}else {
			System.out.println("��ġ���� �ʽ��ϴ�.�ٽ� �Է��Ͽ� �ּ���.");
			return false;
			//�α��ν���
		}
	}
	
	//�Ϲݻ���ڷα���	
	public boolean userLogin(String userid, String userpwd) {
		LoginList.userData();//ȸ������ ����
		boolean exist = LoginList.userlist.containsKey(userid);//�����ϴ� ���̵����� Ȯ��
		LoginVO vo = LoginList.userlist.get(userid);//
		
		    if(exist){
		            if (vo.getUserpwd().equals(userpwd)) {
		                System.out.println("---�α��� ����---");
		                return true;
		            } else {
		                System.out.println("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
		                return false;
		            }
		    }else{
		    	System.out.println("�������� �ʴ� ���̵��Դϴ�.");
		    	System.out.println("���̵� �ٽ� �Է����ּ���.");
		    	return false;	
			}

	}
		
	//ȸ������
	public String joinId() {
		String joinid;
		while(true){
			System.out.println("3���� �̻��� ���̵� �Է��ϼ���.");
			joinid = scan.nextLine();			
			if(joinid.length()<3) {
				System.out.println("���̵�� 3���� �̻��̾�� �մϴ�.");				
			}else if(LoginList.userlist.containsKey(joinid)) {
				System.out.println("�̹� �����ϴ� ���̵��Դϴ�.");
			}else {
				System.out.println("��밡���� ���̵� �Դϴ�.");
				break;
			}
		}
			return joinid;		
	}
	public String joinPwd() {
		String joinpwd;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("4���� �̻��� �н����带 �Է��ϼ���.");
			joinpwd = scan.nextLine();					
			if(joinpwd.length()<4) {
				System.out.println("�н������ 4���� �̻��̾�� �մϴ�.");		
			}else {
				System.out.println("�н����尡 �ԷµǾ����ϴ�.");
				break;		
			}
		}while(true);
		return joinpwd;
	}
	public String joinName() {
		String joinname;
		do {
			System.out.println("�̸��� �Է��ϼ���.");
			joinname = scan.nextLine();
			if(joinname.length()<2) {
				System.out.println("�̸��� �߸� �Է��Ͽ����ϴ�.");
			}else {
				System.out.println("�̸��� ��ϵǾ����ϴ�.");
				break;				
			}
		}while(true);
		return joinname;
	}
	public String joinTel() {
		String jointel;
		do {
			System.out.println("'-'�� ������ ����ó�� �Է��ϼ���.");
			jointel = scan.nextLine();
			if(jointel.length()<13) {
				System.out.println("��ȣ�� �߸� �Է��Ͽ����ϴ�.");
			}else {
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
				break;				
			}
		}while(true);
		return jointel;
	}

}
