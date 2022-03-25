package action;

import bbs.Bbs;
import bbs.BbsDAO;

public class ViewAction {

	public void view(Bbs bbs) {

		BbsDAO bbsDAO = new BbsDAO();

		System.out.println("=".repeat(30));
		System.out.println("제목    :" + "    " + bbs.getBbsTitle());
		System.out.println("작성자    :" + "    " + bbs.getUserID());
		System.out.println("작성일    :" + "    " + bbs.getBbsDate());
		System.out.println("내용    :" + "    " + bbs.getBbsContent());
		System.out.println("=".repeat(30));
	}

}
