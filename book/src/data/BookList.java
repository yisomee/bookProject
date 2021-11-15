package data;

import java.util.HashMap;

public class BookList {
	public static HashMap<String,BookVO> bl = new HashMap<String,BookVO>();

	public BookList() {
		
	}
	public static void bookData() {
		bl.put("명상록", new BookVO("040-1", "명상록", "마르쿠스 아우렐리우스", "현대지성", "대출가능"));
		bl.put("부의 시나리오", new BookVO("100-4", "부의 시나리오", "오건영", "페이지2북스", "대출가능"));
		bl.put("싯다르타", new BookVO("051-7", "싯다르타", "헤르만 헤세", "민음사", "대출가능"));
		bl.put("데미안", new BookVO("108-9", "데미안", "헤르만 헤세", "민음사", "대출가능"));
		bl.put("여행의 이유", new BookVO("604-8", "여행의 이유", "김영하", "문학동네", "대출가능"));
		bl.put("마음챙김의 시", new BookVO("067-3", "마음챙김의 시", "류시화(엮음)", "수오서재", "대출가능"));
		bl.put("인간실격", new BookVO("305-9", "인간실격", "다자이 오사무", "민음사", "대출가능"));
	}

}
