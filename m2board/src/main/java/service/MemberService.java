package service;

import java.sql.Connection;
import java.sql.SQLException;

import commons.DBUtil;
import repository.MemberDao;
import vo.Member;

public class MemberService implements IMemberService{

	// 회원가입
	@Override
	public int addMember(Member paramember) {
		// 리턴값 반환할 변수
		int member = 0;
		// DB 연결 메서드 객체 생성
		DBUtil dbUtil = new DBUtil();
		// DB 연결 객체 생성
		Connection conn = null;
		
		try {
			// DB 연결
			conn = dbUtil.getconection();
			// 디버깅
			System.out.println("MemberService - addMember DB 연결 성공");
			
			// 자동 커밋 방지
			conn.setAutoCommit(false);
			
			// 회원가입 메서드 호출할 객체 생성
			MemberDao memberDao = new MemberDao();
			// 회원가입 메서드 호출
			member = memberDao.insertMember(conn, paramember);
			
			// 회원가입 실패시 오류 생성
			if(member == 0) {
				throw new Exception();
			}
			
			// commit
			conn.commit();
		}catch(Exception e) {
			// 오류 발생시 rollback
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}finally {
			// DB 자원 해제
			try {if(conn != null) conn.close(); }catch(Exception e) {e.printStackTrace();}
		}
		return member;
	} // end addMember

	// 회원 상세보기
		public Member MemberOne(String memberId) throws SQLException, ClassNotFoundException {
			// 리턴값 반환할 변수
			Member member = null;
			// DB 연결 메서드 객체 생성
			DBUtil dbUtil = new DBUtil();
			// DB 연결 객체 생성
			Connection conn = null;
			
			try {
				// DB 연결
				conn = dbUtil.getconection();
				// 디버깅
				System.out.println("MemberService - MemberOne DB 연결 성공");
				
				// 회원정보 상세보기 메서드 호출할 객체 생성
				MemberDao memberDao = new MemberDao();
				// 회원정보 상세보기 메서드 호출
				member = memberDao.MemberOne(conn, memberId);
				
				// 회원정보 상세보기 실패시 오류 생성
				if(member == null) {
					throw new Exception();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {	
				// DB 자원 해제
				try {if(conn != null) conn.close(); }catch(Exception e) {e.printStackTrace();}
			}
			return member;
		} // end MemberOne
} // end MemberService
