package repository;

import java.sql.Connection;
import java.sql.SQLException;

import vo.Member;

public interface IMemberDao {
	
	// 회원가입
	public int insertMember(Connection conn, Member paramember) throws ClassNotFoundException, SQLException;
	
	// 회원 상세보기
	public Member MemberOne(Connection conn, String memberId) throws SQLException, ClassNotFoundException;
	
}
