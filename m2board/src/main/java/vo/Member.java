package vo;

public class Member {
	// 멤버 변수
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhoneNumber;
	private String memberAddr;
	private String memberDatailAddr;
	private String memberEmail;
	private String createDate;
	
	// 생성자
	public Member() {
		super();
		
	}

	public Member(String memberId, String memberPw, String memberName, String memberPhoneNumber, String memberAddr,
			String memberDatailAddr, String memberEmail, String createDate) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;
		this.memberAddr = memberAddr;
		this.memberDatailAddr = memberDatailAddr;
		this.memberEmail = memberEmail;
		this.createDate = createDate;
	}
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberPhoneNumber=" + memberPhoneNumber + ", memberAddr=" + memberAddr + ", memberDatailAddr="
				+ memberDatailAddr + ", memberEmail=" + memberEmail + ", createDate=" + createDate + "]";
	}

	// 캡슐화 setter, getter
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}
	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getMemberDatailAddr() {
		return memberDatailAddr;
	}

	public void setMemberDatailAddr(String memberDatailAddr) {
		this.memberDatailAddr = memberDatailAddr;
	}
	
}
