package data;

import java.util.HashMap;

public class LoginList {
	public static HashMap<String, LoginVO> userlist = new HashMap<String,LoginVO>();
	
	public LoginList() {
	
	}
	public static void userData() {
		LoginList.userlist.put("kj343", new LoginVO("kj343","12343","ȫ�浿","010-4540-2320"));//��ȭ��ȣ int���� 
		LoginList.userlist.put("dfefs", new LoginVO("dfefs","5678","���","010-2342-7654"));
		LoginList.userlist.put("somee99", new LoginVO("somee99","111341","�̼���","010-0000-0000"));
		LoginList.userlist.put("kuil", new LoginVO("kuil","0000","�念��","010-3453-9687"));
		LoginList.userlist.put("1234", new LoginVO("1234","1234","�趯��","010-2420-1234"));
		
	}

}
