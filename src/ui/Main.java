package ui;

import java.util.Scanner;

import action.DeleteAction;
import action.JoinAction;
import action.UpdateAction;
import action.ViewAction;
import action.WriteAction;
import action.bbsAction;
import action.loginAction;
import bbs.Bbs;
import bbs.BbsDAO;
import user.User;
import user.UserDAO;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		boolean run1 = true;
		boolean check1 = true;
		boolean check2 = false;
		boolean check3 = false;
		boolean check4 = false;
		String id = null;

		BbsDAO bbsDAO = new BbsDAO();
		Bbs bbsDTO = new Bbs();

		loginAction login = new loginAction();
		JoinAction join = new JoinAction();
		bbsAction bbs = new bbsAction();
		WriteAction write = new WriteAction();
		UpdateAction update = new UpdateAction();
		DeleteAction delete = new DeleteAction();
		ViewAction view = new ViewAction();

		int pageNumber = 1;

		while (run1) {

			// 로그인&회원가입 페이지 시작
			if (check1) {
				System.out.println("\n===========================");
				System.out.println("1. 로그인    2. 회원가입   3. 종료");
				System.out.println("===========================\n");
				System.out.print("메뉴를 입력하세요 >> ");
				int menu1 = sc.nextInt();

				switch (menu1) {
				case 1:
					// 로그인
					id = login.login();
					if (id != null) {
						check1 = false;
						check2 = true;
					}

					break;

				case 2:
					// 회원가입
					join.join();
					break;

				case 3:
					// 종료
					System.out.println("시스템을 종료합니다.");
					run1 = false;
					break;

				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
				}
			}
			// 로그인&회원가입 페이지 끝

			// 게시판 목록보기&쓰기,수정,삭제 페이지
			if (check2 && !check3) {
				System.out.println("\n==============================================================================");
				System.out.println("1. 게시판 목록보기    2. 게시글 쓰기    3. 게시글 수정    4. 게시글 삭제    5. 로그아웃    6. 종료");
				System.out.println("==============================================================================\n");
				System.out.print("메뉴를 입력하세요 >> ");
				int menu2 = sc.nextInt();

				switch (menu2) {

				case 1:
					// 게시판 목록보기

					check3 = true;
					break;

				case 2:
					// 글쓰기
					
					write.write(id);
					break;

				case 3:
					// 수정하기

					System.out.print("수정할 게시글 번호 >> ");
					int bbsID1 = sc.nextInt();

					if (bbsDAO.bbsIDCheck(bbsID1) == -1) {
						System.out.println("\n입력하신 게시글 번호가 존재하지 않습니다.\n");
						break;
					}

					update.update(bbsID1, id);

					break;
				case 4:
					// 삭제하기

					System.out.print("삭제할 게시글 번호 >> ");
					int bbsID2 = sc.nextInt();

					if (bbsDAO.bbsIDCheck(bbsID2) == -1) {
						System.out.println("\n입력하신 게시글 번호가 존재하지 않습니다.\n");
						break;
					}

					delete.delete(bbsID2, id);

					break;
					
				case 5:
					// 로그아웃
					
					id = null;
					check1 = true;
					check2= false;
					break;

				case 6:
					System.out.println("시스템을 종료합니다.");
					run1 = false;
					break;

				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
				}
			}

			// 게시판 목록보기 페이지
			if (check3 && !check4) {
				bbs.bbs(pageNumber);
				System.out.println();
				System.out.println("1.[이전 페이지]  2.[다음 페이지] 3.[게시글 보기] 4.[이전 메뉴로 돌아가기]");
				System.out.print("메뉴 선택 >> ");
				int menu3 = sc.nextInt();

				switch (menu3) {
				case 1:
					// 이전 페이지

					if (pageNumber != 1) {
						pageNumber -= 1;
					} else {
						System.out.println("\n[이전 페이지가 없습니다.]\n");
					}
					break;

				case 2:
					// 다음 페이지
					if (bbsDAO.nextPage(pageNumber + 1)) {
						pageNumber += 1;
					} else {
						System.out.println("\n[다음 페이지가 없습니다.]\n");
					}
					break;

				case 3:
					// 게시글 보기
					
					System.out.print("보기를 원하는 게시글 번호 >> ");
					int bbsID3 = sc.nextInt();

					if (bbsDAO.bbsIDCheck(bbsID3) == -1) {
						System.out.println("\n입력하신 게시글 번호가 존재하지 않습니다.\n");
						break;
					}

					view.view(bbsDAO.getBbs(bbsID3));
					check4 = true;
					break;

				case 4:
					check3 = false;
					break;

				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
				}
			}

			// 게시판 자세히 보기 페이지
			if (check4) {
				System.out.println("\n1. [목록으로 돌아가기]\n");
				System.out.print("메뉴 선택 >> ");
				int num2 = sc.nextInt();

				switch (num2) {
				// 목록보기
				case 1:
					check4 = false;
					break;

				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
				}
			}
		}
	}
}
