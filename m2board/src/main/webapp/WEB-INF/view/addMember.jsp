<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Sign Up</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/startbootstrap/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="bs-Yellow">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-7">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">Create Account</h3>
								</div>
								<div class="card-body">
									<form>
										<div class="row mb-3">
											<div class="col-md-6">
												<div class="form-floating mb-3 mb-md-0">
													<input class="form-control" id="memberId" type="text" placeholder="Create a ID" />
													<label for="memberId">ID</label>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-floating">
													<input class="form-control" id="memberPw" type="password" placeholder="Create a Password" />
													<label for="memberPw">PW</label>
												</div>
											</div>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" id="memberName" type="text" placeholder="Enter your Name" />
											<label for="memberName">Name</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" id="memberPhoneNumber" type="text" placeholder="Enter your PhoneNumber" />
											<label for="memberPhoneNumber">PhoneNumber</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" id="memeberEmail" type="email" placeholder="Enter your Email address" />
											<label for="memeberEmail">Email address</label>
										</div>
										<div class="row mb-3">
											<div class="col-md-10">
												<div class="form-floating mb-3 mb-md-0">
													<input class="form-control" id="addr" type="text" placeholder="Enter your Password" />
													<label for="addr">Addr</label>
												</div>
											</div>
											<div class="col-md-2">
												<div class="form-floating mb-3 mb-md-0">
													<button type="button" id="addrBtn" style="margin-top: 15%;">????????????</button>
												</div>
											</div>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" id="detailAddr" type="text" placeholder="Confirm password" />
											<label for="detailAddr">DetailAddr</label>
										</div>
										<div class="mt-4 mb-0">
											<div class="d-grid">
												<button class="btn btn-primary btn-block" id="addMemberBtn">Create Account</button>
											</div>
										</div>
									</form>
								</div>
								<div class="card-footer text-center py-3">
									<div class="small">
										<a href="login.html">Have an account? Go to login</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<!-- footer -->
	<!-- footer -->
	<!-- footer -->
	<div id="layoutAuthentication_footer">
		<footer class="py-4 bg-light mt-auto">
			<div class="container-fluid px-4">
				<div class="d-flex align-items-center justify-content-between small">
					<div class="text-muted">Copyright &copy; Your Website 2022</div>
					<div>
						<a href="#">Privacy Policy</a> &middot; <a href="#">Terms &amp; Conditions</a>
					</div>
				</div>
			</div>
		</footer>
	</div>
	<!--  end footer -->
	<!--  end footer -->
	<!--  end footer -->


	<!-- iOS????????? position:fixed ????????? ??????, ???????????? ???????????? ?????? position:absolute ?????? ???????????? top,left??? ?????? ?????? -->
	<div id="layer" style="display: none; position: fixed; overflow: hidden; z-index: 1; -webkit-overflow-scrolling: touch;">
		<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor: pointer; position: absolute; right: -3px; top: -3px; z-index: 1" onclick="closeDaumPostcode()" alt="?????? ??????">
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
	<script>
		// ????????? ?????? -> ???????????? ??????
		// $(addrBtn).click(sample2_execDaumPostcode(){
		$(addrBtn).click(function() {
			sample2_execDaumPostcode();
		});
	</script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		// ???????????? ?????? ????????? ?????? element
		var element_layer = document.getElementById('layer');

		function closeDaumPostcode() {
			// iframe??? ?????? element??? ???????????? ??????.
			element_layer.style.display = 'none';
		}

		function sample2_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// ???????????? ????????? ??????????????? ????????? ????????? ???????????? ??????.

							// ??? ????????? ?????? ????????? ?????? ????????? ????????????.
							// ???????????? ????????? ?????? ?????? ????????? ??????('')?????? ????????????, ?????? ???????????? ?????? ??????.
							var addr = ''; // ?????? ??????
							var extraAddr = ''; // ???????????? ??????

							//???????????? ????????? ?????? ????????? ?????? ?????? ?????? ?????? ????????????.
							if (data.userSelectedType === 'R') { // ???????????? ????????? ????????? ???????????? ??????
								addr = data.roadAddress;
							} else { // ???????????? ?????? ????????? ???????????? ??????(J)
								addr = data.jibunAddress;
							}

							// ???????????? ????????? ????????? ????????? ???????????? ??????????????? ????????????.
							if (data.userSelectedType === 'R') {
								// ??????????????? ?????? ?????? ????????????. (???????????? ??????)
								// ???????????? ?????? ????????? ????????? "???/???/???"??? ?????????.
								if (data.bname !== ''
										&& /[???|???|???]$/g.test(data.bname)) {
									extraAddr += data.bname;
								}
								// ???????????? ??????, ??????????????? ?????? ????????????.
								if (data.buildingName !== ''
										&& data.apartment === 'Y') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// ????????? ??????????????? ?????? ??????, ???????????? ????????? ?????? ???????????? ?????????.
								if (extraAddr !== '') {
									extraAddr = ' (' + extraAddr + ')';
								}
								// ????????? ??????????????? ?????? ????????? ?????????.
								// document.getElementById("sample2_extraAddress").value = extraAddr;

							} else {
								// document.getElementById("sample2_extraAddress").value = '';
							}

							// ??????????????? ?????? ????????? ?????? ????????? ?????????.
							// document.getElementById('sample2_postcode').value = data.zonecode;
							// document.getElementById("sample2_address").value = addr;

							// $('#addr').val(data.zonecode + ' ' + addr);
							document.getElementById('addr').value = data.zonecode
									+ ' ' + addr;

							// ????????? ???????????? ????????? ????????????.
							// document.getElementById("sample2_detailAddress").focus();

							// iframe??? ?????? element??? ???????????? ??????.
							// (autoClose:false ????????? ???????????????, ?????? ????????? ???????????? ???????????? ???????????? ?????????.)
							element_layer.style.display = 'none';
						},
						width : '100%',
						height : '100%',
						maxSuggestItems : 5
					}).embed(element_layer);

			// iframe??? ?????? element??? ????????? ??????.
			element_layer.style.display = 'block';

			// iframe??? ?????? element??? ????????? ????????? ???????????? ???????????????.
			initLayerPosition();
		}

		// ??????????????? ?????? ????????? ?????? ???????????? ???????????? ?????????????????? ???????????????
		// resize????????????, orientationchange???????????? ???????????? ?????? ?????????????????? ?????? ????????? ?????? ?????? ????????????,
		// ?????? element_layer??? top,left?????? ????????? ????????? ?????????.
		function initLayerPosition() {
			var width = 300; //???????????????????????? ????????? element??? width
			var height = 400; //???????????????????????? ????????? element??? height
			var borderWidth = 5; //???????????? ???????????? border??? ??????

			// ????????? ????????? ????????? ?????? element??? ?????????.
			element_layer.style.width = width + 'px';
			element_layer.style.height = height + 'px';
			element_layer.style.border = borderWidth + 'px solid';
			// ???????????? ????????? ?????? ????????? ?????? ?????? ???????????? ????????? ??? ??? ????????? ????????? ????????????.
			element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width) / 2 - borderWidth)
					+ 'px';
			element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height) / 2 - borderWidth)
					+ 'px';
		}
	</script>
	<script>
		// ?????? ??????
		$('#addMemberBtn').click(function() {
			if ($('#memberId').val() < 1) {
				alert('???????????? ???????????????');
			} else {
				$('#addMemberForm').submit();
			} // if???		
		}); // end click
	</script>
</body>
</html>
