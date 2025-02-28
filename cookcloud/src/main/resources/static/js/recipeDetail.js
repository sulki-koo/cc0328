$(document).ready(function() {
	const recipeId = $("#recipeId").val();

	// 좋아요 버튼 클릭
	$("#likeBtn").click(function() {
		$.post(`/recipes/like/${recipeId}`, function(response) {
			if (response.liked) {
				$("#likeIcon").removeClass("bi-heart").addClass("bi-heart-fill text-danger");
			} else {
				$("#likeIcon").removeClass("bi-heart-fill text-danger").addClass("bi-heart");
			}
		});
	});

	// 팔로우 버튼 클릭
	$("#followBtn").click(function() {
		$.post(`/recipes/follow/${recipeId}`, function(response) {
			if (response.followed) {
				$("#followIcon").removeClass("bi-bell").addClass("bi-bell-fill text-warning");
			} else {
				$("#followIcon").removeClass("bi-bell-fill text-warning").addClass("bi-bell");
			}
		});
	});

	// 신고 버튼 클릭
	$("#reportBtn").click(function() {
		if (confirm("이 레시피를 신고하시겠습니까?")) {
			$.post(`/recipes/report/${recipeId}`, function() {
				alert("신고가 접수되었습니다.");
			});
		}
	});

	// 리뷰 작성
	$("#reviewForm").submit(function(e) {
		e.preventDefault();
		const content = $("#reviewContent").val();

		$.post("/reviews/create", { recipeId, content }, function(response) {
			$("#reviewContent").val(""); // 입력창 비우기
			$("#reviews").prepend(`<p>${response.content} (새 리뷰)</p>`);
		});
	});
	
});
