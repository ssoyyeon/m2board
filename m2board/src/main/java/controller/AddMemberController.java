package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;


@WebServlet("/addMember") // WEB-INF/view/addMember.jsp랑 이름 통일시키기
public class AddMemberController extends HttpServlet {
	private MemberService memberService;
	private Member member;

	// addForm
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // forwarding
      request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
    }


	// 추가 액션
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 1) 요청을 받아서 분석
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String memberPhoneNumber = request.getParameter("memberPhoneNumber");
		String memberAddr = request.getParameter("addr");
		String detailAddr = request.getParameter("detailAddr");
		String memeberEmail = request.getParameter("memeberEmail");
		// 디버깅
		System.out.println("memberId : " + memberId);
		System.out.println("memberPw : " + memberPw);
		System.out.println("memberName : " + memberName);
		System.out.println("memberPhoneNumber : " + memberPhoneNumber);
		System.out.println("memberAddr : " + memberAddr);
		System.out.println("detailAddr : " + detailAddr);
		System.out.println("memeberEmail : " + memeberEmail);
		
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
		
		// 2) 서비스 레이어를 요청(메서드 호출) -> 모델값(자료구조) 구하기 위함
		// new 리턴한 값을 받아 올 객체 생성
		int insertMember = 0;
		// 회원가입 메서드 호출할 객체 생성
		this.memberService = new MemberService();
		// 회원가입 메서드 호출
		insertMember = memberService.addMember(member);
		// 디버깅
		if(insertMember != 0) {
			System.out.println("회원가입 성공!");
		}
		
		// 3) view forwarding
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
		
	}
	

}
