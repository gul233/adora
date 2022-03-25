package action;

import java.util.ArrayList;

import bbs.Bbs;
import bbs.BbsDAO;

public class bbsAction {
		
	public void bbs(int pageNumber) {
		
		BbsDAO bbsDAO = new BbsDAO();
		ArrayList<Bbs> list = bbsDAO.getList(pageNumber);
		
		System.out.println("번호" + "   " + "제목" + "   " + "작성자" + "   " + "작성일");
		System.out.println("=".repeat(30));
		
		for (int i = 0; i < list.size(); i++) {
			Bbs n = list.get(i);			
			System.out.println(n.getBbsID() + "   " + n.getBbsTitle() + "   " + n.getUserID() + "   " + n.getBbsDate());
		}
		System.out.println("=".repeat(30));
	}
}
