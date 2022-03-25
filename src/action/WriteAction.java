package action;

import java.util.Scanner;

import bbs.BbsDAO;
import user.User;
import user.UserDAO;

public class WriteAction {
	
	public void write(String id) {
		
		Scanner sc = new Scanner(System.in);

		User user = new User();
		UserDAO userDAO = new UserDAO();
		BbsDAO bbsDAO = new BbsDAO();
		
		System.out.print("제목을 입력해주세요 >> ");
		String title = sc.next();
		System.out.print("내용을 입력해주세요 >> ");
		sc.nextLine();
		String content = sc.nextLine();
		
		int result = bbsDAO.write(title, id, content);
		if (result == -1) {
			System.out.println("글쓰기 실패!");
		}	
		else {
			System.out.println("글쓰기 성공!");
		}
	}
}
