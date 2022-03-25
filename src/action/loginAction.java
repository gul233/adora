package action;

import java.util.Scanner;

import user.User;
import user.UserDAO;

public class loginAction {
	
	public String login() {
		
		Scanner sc = new Scanner(System.in);

		User user = new User();
		UserDAO userDAO = new UserDAO();

		System.out.print("아이디 >> ");
		String userId = sc.next();

		System.out.print("패스워드 >> ");
		String userPassword = sc.next();

		user.setUserID(userId);
		user.setUserPassword(userPassword);

		int result = userDAO.login(user.getUserID(), user.getUserPassword());
		if (result == 1) {
			System.out.println("로그인 성공!");
			return user.getUserID();
		} 
		if (result == 0) {
			System.out.println("패스워드가 불일치 합니다.");
		}
		if (result == -1) {
			 System.out.println("아이디가 존재하지 않습니다.");
		}
		if (result == -2) {
			System.out.println("데이터 베이스 오류");
		} 
		
		return null;
	}
}
