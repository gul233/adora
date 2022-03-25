package action;

import java.util.Scanner;

import bbs.BbsDAO;
import user.User;
import user.UserDAO;

public class UpdateAction {
	
	public void update(int bbsID, String userID) {
		Scanner sc = new Scanner(System.in);

		User user = new User();
		UserDAO userDAO = new UserDAO();
		BbsDAO bbsDAO = new BbsDAO();
		
		System.out.println("제목을 입력해주세요 >> ");
		String title = sc.next();
		System.out.println("내용을 입력해주세요 >> ");
		sc.nextLine();
		String content = sc.nextLine();
		
		int result = bbsDAO.update(bbsID, userID, title, content);
		if (result > 0) {
			System.out.println("수정 성공!");
		} else {
			System.out.println("작성자 본인만 수정 가능합니다.");
		}
	}
	
	
}
