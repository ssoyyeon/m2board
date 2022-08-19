package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commons.DBUtil;
import repository.BoardDao;
import repository.IBoardDao;
import vo.Board;

public class BoardService implements IBoardService {
	   private DBUtil dbUtil;
	   private IBoardDao boardDao;
	   
	@Override
	public Map<String, Object> getBoardList(int ROW_PER_PAGE, int currentPage){
		// 리턴값 반환할 객체 생성
		Map<String, Object> map =  new HashMap<>();
		// 마지막 페이지 변수
		int lastPage = 0;
		// 시작하는 행 변수
		int beginRow = 0;
		// DB 연결 객체 생성
		Connection conn = null;
		dbUtil = new DBUtil();
		
		try {
			conn = dbUtil.getconection();
			// 디버깅 
			System.out.println("BoardService- getBoardList DB 연결 성공!!!!!!!!!!!!!");
			
			beginRow = (currentPage -1) * ROW_PER_PAGE;
			
			// 메서드 호출하기 위한 객체 생성
			boardDao = new BoardDao();
			
			// BoardList 메서드 호출
			List<Board> list = boardDao.selectBoardListByPage(conn, ROW_PER_PAGE, beginRow); 
			// 호출한 값 넣어주기
			map.put("list", list);
			
			// lastPage메서드 호출
			lastPage = boardDao.selectBoardCnt(conn);
			// 호출한 값 넣어주기
			map.put("lastPage", lastPage);
			// 마지막 페이지가 현재 페이지보다 작다면 마지막 페이지는 현재 페이지로 설정
			if(lastPage < currentPage) {
				lastPage = currentPage;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// DB 연결 해제
			try {if(conn != null) conn.close(); }catch(Exception e) { e.printStackTrace();}
		}		
		return map;
	} // end getBoardList

}
