package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.IBoardService;

@WebServlet("/boardList") /// WEB-INF/view/boardList.jsp랑 이름 통일시키기
public class BoardListController extends HttpServlet {
	private IBoardService boardService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Controller의 역할
		// 1) 요청을 받아서 분석
		
		// ROW_PER_PAGE 값을 변하지 않게 하기 위해 final 선언 
		final int ROW_PER_PAGE = 10;
		
		// 현재 페이지
		int currentPage = 1;
		// 전송받은 값이 있다면 현재 페이지를 전송받은 값으로 설정
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		// 2) 서비스 레이어를 요청(메서드 호출) -> 모델값(자료구조) 구하기 위함
		// new 리턴한 값을 받아 올 객체 생성
		Map<String, Object> map = new HashMap<>();
		boardService = new BoardService();
		
		// 값을 받아 올 메서드 호출
		map = boardService.getBoardList(ROW_PER_PAGE, currentPage);
		// 분해할 수 있는 값은 분해해서 넘겨주기
		request.setAttribute("lastPage", map.get("lastPage"));
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("list", map.get("list"));

		// 3) view forwarding
		request.getRequestDispatcher("/WEB-INF/view/boardList.jsp").forward(request, response);
	}
}