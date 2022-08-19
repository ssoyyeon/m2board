package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import commons.DBUtil;
import vo.Member;

public class MemberDao implements IMemberDao {

	// 회원가입
	public int insertMember(Connection conn, Member paramember) throws ClassNotFoundException, SQLException {
		// 리턴값 반환할 변수
		int member = 0;
		// DB 연결 메서드 객체 생성
		DBUtil dbUtil = new DBUtil();
		// 쿼리 객체 생성
		PreparedStatement stmt = null;
		// 쿼리
		String sql = "insert into member (member_id, member_pw, member_name, member_email, member_addr, member_detailAddr, member_phoneNumber, create_date) values"
				+ " (?, password(?), ?, ?, ?, ?, ?, now());";
		
		// conn은 MemberService Connection conn을 	받아옴
		conn = dbUtil.getconection();
		// 디버깅
		System.out.println("MemberDao - insertMember DB- 연결");

		try {
			// 쿼리값 설정
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, paramember.getMemberId());
			stmt.setString(2, paramember.getMemberPw());
			stmt.setString(3, paramember.getMemberName());
			stmt.setString(4, paramember.getMemberEmail());
			stmt.setString(5, paramember.getMemberAddr());
			stmt.setString(6, paramember.getMemberDatailAddr());
			stmt.setString(7, paramember.getMemberPhoneNumber());
			// 디버깅
			System.out.println("MemberDao - insertMember - stmt : " + stmt);
			
			// 쿼리 실행
			member = stmt.executeUpdate();
			// 디버깅
			if (member != 0) {
				System.out.println("MemberDao - insertEmployee - EmployeeDao 쿼리 성공!");
			}
		} finally {
			// DB 자원해제
			if (stmt != null) {
				stmt.close();
			}
		}
		return member;
	}

	// 회원 상세보기
	public Member MemberOne(Connection conn, String memberId) throws SQLException, ClassNotFoundException {
		// 리턴값 반환할 변수
		Member member = null;
		// DB 연결 메서드 객체 생성
		DBUtil dbUtil = new DBUtil();
		// 쿼리 객체 생성
		PreparedStatement stmt = null;
		// 쿼리 실행할 객체 생성
		ResultSet rs = null;
		// 쿼리
		String sql = "SELECT member_id, member_pw, member_name, member_email, member_addr, member_detailAddr, member_phoneNumber, create_date FROM member WHERE member_id = ?";
		
		// conn은 MemberService Connection conn을 받아옴
		conn = dbUtil.getconection();
		// 디버깅
		System.out.println("MemberDao - MemberOne DB- 연결");

		try {
			// 쿼리값 설정
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			// 디버깅
			System.out.println("MemberDao - MemberOne - stmt : " + stmt);
			
			// 쿼리 실행
			rs = stmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setCreateDate(rs.getString("create_date"));
				member.setMemberAddr(rs.getString("member_addr"));
				member.setMemberDatailAddr(rs.getString("member_detailAddr"));
				member.setMemberEmail(rs.getString("member_email"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPhoneNumber(rs.getString("member_phoneNumber"));
				member.setMemberPw(rs.getString("member_pw"));
				// 디버깅
				System.out.println("member");
			}
			// 디버깅
			if (member != null) {
				System.out.println("MemberDao - MemberOne - EmployeeDao 쿼리 성공!");
			}
		} finally {
			// DB 자원해제
			if (stmt != null) {
				stmt.close();
			}
		}
		
		
		return member;
	}

}
