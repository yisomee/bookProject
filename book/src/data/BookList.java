package data;

import java.util.HashMap;

public class BookList {
	public static HashMap<String,BookVO> bl = new HashMap<String,BookVO>();

	public BookList() {
		
	}
	public static void bookData() {
		bl.put("����", new BookVO("040-1", "����", "������ �ƿ췼���콺", "��������", "���Ⱑ��"));
		bl.put("���� �ó�����", new BookVO("100-4", "���� �ó�����", "���ǿ�", "������2�Ͻ�", "���Ⱑ��"));
		bl.put("�˴ٸ�Ÿ", new BookVO("051-7", "�˴ٸ�Ÿ", "�츣�� �켼", "������", "���Ⱑ��"));
		bl.put("���̾�", new BookVO("108-9", "���̾�", "�츣�� �켼", "������", "���Ⱑ��"));
		bl.put("������ ����", new BookVO("604-8", "������ ����", "�迵��", "���е���", "���Ⱑ��"));
		bl.put("����ì���� ��", new BookVO("067-3", "����ì���� ��", "����ȭ(����)", "��������", "���Ⱑ��"));
		bl.put("�ΰ��ǰ�", new BookVO("305-9", "�ΰ��ǰ�", "������ ���繫", "������", "���Ⱑ��"));
	}

}
