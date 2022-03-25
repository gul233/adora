package action;

import java.util.Scanner;

import user.User;
import user.UserDAO;

public class JoinAction {

	public void join() {

		Scanner sc = new Scanner(System.in);

		User user = new User();
		UserDAO userDAO = new UserDAO();

		System.out.print("아이디 >> ");
		String userId = sc.next();

		if (userDAO.idCheck(userId) == 1) {
			System.out.println("이미 존재하는 아이디 입니다.");
			return;
		}

		System.out.print("패스워드 >> ");
		String userPassword = sc.next();
		System.out.print("패스워드 확인 >> ");
		String ConfirmPassword = sc.next();

		System.out.print("이름 >> ");
		String userName = sc.next();
		System.out.print("이메일 >> ");
		String userEmail = sc.next();

		if (!userEmail.contains("@")) {
			System.out.println("정확한 이메일 형식으로 입력해주세요.");
			return;
		}

		System.out.print("성별 >> ");
		String userGender = sc.next();
		if (!userGender.equals("남자") && !userGender.equals("여자")) {
			System.out.println("정확한 성별을 입력해주세요.(남자, 여자)");
			return;
		}

		user.setUserID(userId);
		user.setUserPassword(userPassword);
		user.setConfirmPassword(ConfirmPassword);
		user.setUserName(userName);
		user.setUserEmail(userEmail);
		user.setUserGender(userGender);

		if (user.getUserID() == null || user.getUserPassword() == null || user.getUserName() == null
				|| user.getUserGender() == null || user.getUserEmail() == null || user.getConfirmPassword() == null) {
			System.out.println("입력이 안 된 사항이 있습니다.");
		} else if (!user.getUserPassword().equals(user.getConfirmPassword())) {
			System.out.println("패스워드가 일치하지 않습니다.");

		}

		else {
			int result = userDAO.join(user);
			if (result == -1) {
				System.out.println("데이터 베이스 오류");
			} else {
				System.out.println("회원가입 성공!");
			}
		}
	}

}
