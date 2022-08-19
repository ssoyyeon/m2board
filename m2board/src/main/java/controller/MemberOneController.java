package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;

@WebServlet("/memberOne")
public class MemberOneController extends HttpServlet {
	private MemberService memberService;
	private Member member;

	// Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // forwarding
	     request.getRequestDispatcher("/WEB-INF/view/memberOnde.jsp").forward(request, response);
	     
	} // end doGet

	// Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 1) 요청을 받아서 분석
		String memberId = request.getParameter("memberId");
		// 2) 서비스 레이어를 요청(메서드 호출) -> 모델값(자료구조) 구하기 위함
		this.member = new Member();
		this.memberService = new MemberService();
		
		// setter
		// 객체 생성
		this.member = new Member();
		// 값 설정
		member.setMemberAddr(memberAddr);
		member.setMemberDatailAddr(detailAddr);
		member.setMemberEmail(memeberEmail);
		member.setMemberId(memberId);
		member.setMemberName(memberName);
		member.setMemberPhoneNumber(memberPhoneNumber);
		member.setMemberPw(memberPw);
		// 디버깅
		System.out.println("member : " + member);
		
		member =  memberService.MemberOne(memberId);
		member.setCreateDate(memberId);
				
		// 3) view forwarding

		
	} // end doPost

} // end MemberOne
