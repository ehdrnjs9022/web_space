<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<br/><br/>

	<jsp:include page="../include/header.jsp" />
	
	<div class="outer">
		<div class="container">
		
		<div class="row">
		  <div class="offset-lg-2 col-lg-8">
		    <div class="card">
		      <div class="card-header text-white" style="background-color: #52b1ff;">10번 게시물 내용</div>
		      <div class="card-body"> 
		
		          <div class="form-group">
		            <label>카테고리</label><br>
		            <span>${board.boardCategory }</span>
		          </div>      
		        
		          <div class="form-group">
		            <label>작성자</label>
		            <input type="text" class="form-control" name='writer' value="${board.boardWriter }" readonly>
		          </div>
		          
		          <div class="form-group">
		            <label>제목</label>
		            <input type="text" class="form-control" name='title' value="${board.boardTitle }" readonly>
		          </div>
		
		          <div class="form-group">
		            <label>내용</label>
		            <textarea class="form-control" rows="5" name='content' readonly style="resize:none;">원본 게시글 내용</textarea>
		          </div>
		
		          <div class="form-group">
		            <label>첨부파일</label>

			            


			            	<!-- 첨부파일은 없을수도있음 -->
			            	&nbsp;&nbsp;<span>첨부파일이 존재하지 않습니다.</span>
		          </div>
		         
		          <a class="btn" href="boards?currentPage=1"
		             style="background-color: #52b1ff; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8"
		          >목록</a>&nbsp;&nbsp;
		          
		          
			          <a 
			            class="btn" 
			            href="수정요청 매핑값"
			      		style="background-color: orange; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8"
			      		>수정</a>&nbsp;&nbsp;
			          
			          <a 
			            class="btn" 
			            href="삭제하기" onclick="return confirm('정말로 삭제하시겠습니까?')"
			      		style="background-color: red; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8"
			      		>삭제</a>&nbsp;&nbsp;

		      </div>
		    </div>
		  </div>
		</div>
		</div>
		<div id="reply-area">
			
			<table class="form-group" align="center">
				<thead>
					<tr>
						<th>댓글작성</th>
							<td>
								<textarea id="replyContent" cols="50" rows="3" style="resize:none;" class="form-control"></textarea>
							</td>
							<td><button onclick="insertReply();" class="btn" style="width : 100%; height : 100%; background-color: #52b1ff; color : white;">댓글등록</button></td>
						
							<td>
								<textarea readonly cols="50" rows="3" style="resize:none;" class="form-control">로그인 후 이용가능한 서비스입니다.</textarea>
							</td>
							<td><button class="btn" style="width : 100%; height : 100%; background-color: #52b1ff; color : white;">댓글등록</button></td>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
			<br><br><br><br>
	    </div>

	</div>
	
	<jsp:include page="../include/footer.jsp" />
	
	
	
	
	
</body>
</html>