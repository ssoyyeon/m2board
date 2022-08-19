package repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import vo.Board;

public interface IBoardDao {
	List<Board> selectBoardListByPage(Connection conn, int rowPerPage, int beginRow) throws ClassNotFoundException, SQLException;
	int selectBoardCnt(Connection conn) throws SQLException, ClassNotFoundException;
}
