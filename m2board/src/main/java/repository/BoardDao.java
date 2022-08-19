package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import commons.DBUtil;
import vo.Board;

public class BoardDao implements IBoardDao {

	
	// 반환값 = List<Board>, int lastPage
	@Override
	public List<Board> selectBoardListByPage(Connection conn, int ROW_PER_PAGE, int beginRow) throws ClassNotFoundException, SQLException {
		// 리턴값 반환할 객체 생성
		List<Board> list =  new ArrayList<>();
		Board b = null;
		DBUtil dbUtil = new DBUtil();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT board_no boardNo, board_title boardTitle, board_writer boardWriter, create_date createDate, "
				  + "board_views boardViews, board_nice boardNice from board ORDER By board_no limit ?,?";
		/*
		  작성자별 공지사항 조회
		  String sql ="SELECT board_no boardNo, board_title boardTitle, board_writer boardWriter, create_date createDate, "
		  + "board_views boardViews, board_nice boardNice from board ORDER By board_no limit ?,? WHERE board_writer= ?"
		 * ;
		 */
		conn = dbUtil.getconection();
		// 디버깅
		System.out.println("BoardDao - selectBoardListByPage DB 연결 성공!!!!!!!!!!!");
		
		try {
			stmt = conn.prepareStatement(sql);
			// ?값 설정
			stmt.setInt(1, beginRow);
			stmt.setInt(2, ROW_PER_PAGE);
			// 디버깅
			System.out.println("BoardDao - selectBoardListByPage stmt : " + stmt);
			
			// 쿼리 실행
			rs = stmt.executeQuery();
			while(rs.next()){
				//Board 객체 생성
	            b = new Board();
	            // 값 설정
	            b.setBoardNo(rs.getInt("boardNo"));
	            b.setBoardTitle(rs.getString("boardTitle"));
	            b.setBoardWriter(rs.getString("boardWriter"));
	            b.setCreateDate(rs.getString("createDate"));
	            b.setBoardViews(rs.getInt("boardViews"));
	            b.setBoardNice(rs.getInt("boardNice"));
	            // list에 설정한 값 넣기
	            list.add(b);
			}
		}finally {
			// DB 자원해제
			try {if(rs != null) {rs.close();} }catch(Exception e ) {e.printStackTrace();}
			try {if(stmt != null) {stmt.close();} }catch(Exception e ) {e.printStackTrace();}
		}
		return list;
	} // end 

	@Override
	public int selectBoardCnt(Connection conn) throws SQLException, ClassNotFoundException {
		// 리턴값 반환할 객체 생성
		int boardCnt = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT count(*) from board";
		
		try {
			stmt = conn.prepareStatement(sql);
			System.out.println("BoardDao - selectBoardCnt DB 연결 성공!!!!!!!!!!!");
			
			// 쿼리 실행
			rs = stmt.executeQuery();
			if(rs.next()) {
				boardCnt = rs.getInt("count(*)");
				System.out.println(boardCnt);
			}
		}finally {
			// DB 자원해제
			try {if(rs != null) {rs.close();} }catch(Exception e ) {e.printStackTrace();}
			try {if(stmt != null) {stmt.close();} }catch(Exception e ) {e.printStackTrace();}
		}		
		return boardCnt;
	} // end selectBoardCnt

}
