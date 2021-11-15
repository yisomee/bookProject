package data;

import java.util.HashMap;

public class LoginList {
	public static HashMap<String, LoginVO> userlist = new HashMap<String,LoginVO>();
	
	public LoginList() {
	
	}
	public static void userData() {
		LoginList.userlist.put("kj343", new LoginVO("kj343","12343","È«±æµ¿","010-4540-2320"));//ÀüÈ­¹øÈ£ int¹üÀ§ 
		LoginList.userlist.put("dfefs", new LoginVO("dfefs","5678","±è»ñ°«","010-2342-7654"));
		LoginList.userlist.put("somee99", new LoginVO("somee99","111341","ÀÌ¼ø½Å","010-0000-0000"));
		LoginList.userlist.put("kuil", new LoginVO("kuil","0000","Àå¿µ½Ç","010-3453-9687"));
		LoginList.userlist.put("1234", new LoginVO("1234","1234","±è¶¯¶¯","010-2420-1234"));
		
	}

}
