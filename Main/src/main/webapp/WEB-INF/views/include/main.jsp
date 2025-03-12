<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>OTT 서비스 - 로그인</title>

  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
      margin: 0;
      padding: 0;
    }
    header {
      background-color: #222;
      color: white;
      padding: 15px 20px;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    header h1 {
      margin: 0;
      font-size: 24px;
    }
    nav ul {
      list-style: none;
      margin: 0;
      padding: 0;
      display: flex;
      gap: 15px;
    }
    nav ul li a {
      color: white;
      text-decoration: none;
      font-size: 14px;
    }
    main {
      padding: 30px;
      text-align: center;
    }
    form input {
      margin: 10px;
      padding: 10px;
      width: 200px;
    }
    form button {
      padding: 10px 20px;
      background-color: #007bff;
      border: none;
      color: white;
      cursor: pointer;
    }
    form button:hover {
      background-color: #0056b3;
    }
    #welcome-section h2 {
      color: #333;
    }
  </style>
</head>
<body>
  <header>
    <h1>🎬 OTT Streaming</h1>
    <nav>
      <ul>
        <li><a href="#">홈</a></li>
        <li><a href="#">영화</a></li>
        <li><a href="#">시리즈</a></li>
        <li id="auth-area">
          <a href="#" id="loginBtn">로그인</a>
          <a href="#" id="logoutBtn" style="display:none;">로그아웃</a>
        </li>
      </ul>
    </nav>
  </header>

  <main>
    <section id="login-section">
      <h2>로그인</h2>
      <form id="loginForm" action="/login" method="post">
        <input type="text" placeholder="아이디" id="userId" name="userId" required><br>
        <input type="password" placeholder="비밀번호" id="userPw" name="userPw" required><br>
        <button type="submit">로그인</button>
      </form>
    </section>

    <section id="welcome-section" style="display:none;">
      <h2>환영합니다, <span id="username"></span> 님!</h2>
    </section>
  </main>

  <script>
    const loginForm = document.getElementById("loginForm");
    const loginSection = document.getElementById("login-section");
    const welcomeSection = document.getElementById("welcome-section");
    const loginBtn = document.getElementById("loginBtn");
    const logoutBtn = document.getElementById("logoutBtn");
    const usernameSpan = document.getElementById("username");

    loginForm.addEventListener("submit", function(e) {
      e.preventDefault();
      const id = document.getElementById("userId").value;
      const pw = document.getElementById("userPw").value;

      if(id && pw) {
        usernameSpan.textContent = id;
        loginSection.style.display = "none";
        welcomeSection.style.display = "block";
        loginBtn.style.display = "none";
        logoutBtn.style.display = "inline";
      }
    });

    logoutBtn.addEventListener("click", function() {
      loginSection.style.display = "block";
      welcomeSection.style.display = "none";
      loginBtn.style.display = "inline";
      logoutBtn.style.display = "none";
    });
  </script>
</body>
</html>

