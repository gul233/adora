package action;

import java.util.Scanner;

import bbs.BbsDAO;
import user.User;
import user.UserDAO;

public class DeleteAction {

	public void delete(int bbsID, String userID) {
		Scanner sc = new Scanner(System.in);

		User user = new User();
		UserDAO userDAO = new UserDAO();
		BbsDAO bbsDAO = new BbsDAO();

		System.out.println("정말 삭제하시겠습니까?[Y/N]");
		String check = sc.next();

		if (check.equals("Y") || check.equals("N") || check.equals("y") || check.equals("n")) {
			if(check.equals("N") || check.equals("n")) {
				return;
			} 
			
			int result = bbsDAO.delete(bbsID, userID);
			if (result > 0) {
				System.out.println("삭제 성공!");
			} else {
				System.out.println("작성자 본인만 삭제 가능합니다.");
			}
		} else {
			System.out.println("Y 또는 N으로만 입력해주세요.");
		}

	}

}
