<!DOCTYPE html>
<html>
<head>
	<title>Lyrics</title>
	<link rel="stylesheet" type="text/css" href="main.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div id="topline"></div>
	<div id="page_container">
		<header id="header">
					<div id="logo"><a href="index.jsp"><img src="logo.png"/></a></div>
					<div id="header_content">
						<div id="menu_content">
							<!-- TÖBB GOMB KELL !!!!!!!!!!!!!!!-->
							<a class="menubar" href="toplist.html">Toplist</a>
							<a class="menubar" href="ranking.html" >Ranking</a>
						</div>
						<!--TODO HA KI X-ELI A LOGINT/SIGNUPOT AKKOR TÖRÖLJE KI A LABELEKET-->
						<!--TODO FORMOK KÖZÉPRE IGAZÍTÁSA-->
						<button id="header_login" onclick="document.getElementById('loginForm').style.display='block'">Log in</button>
							<!--BEJELENTKEZŐ PANEL-->
							<div id="loginForm" class="modalLogin">
							  <form class="modal-content" action="/action_page.php">
							    <div class="container">
							      <span onclick="document.getElementById('loginForm').style.display='none'; clearLogin()" class="close" title="Close Login">&times;</span>
							      <h1 class="titleForm">Log in</h1>

							      <label for="username"><b>Username</b></label>
							      <input id="usernameLogin" type="text" placeholder="Enter Username" name="username" required>

							      <label for="psw"><b>Password</b></label>
							      <input id="passwordLogin" type="password" placeholder="Enter Password" name="psw" required>

							      <div class="clearfix">
							        <button type="button" onclick="document.getElementById('loginForm').style.display='none'; clearLogin()" class="cancelbtn">Cancel</button>
							        <button type="submit" class="signupbtn">Log In</button>
							      </div>
							    </div>
							  </form>
							</div>

						<button id="header_reg" onclick="document.getElementById('registerForm').style.display='block'">Sign Up</button>
							<!--REGISZTRÁCIÓS PANEL-->
							<div id="registerForm" class="modalReg">
							  <form id="modalContent"class="modal-content" action="/action_page.php">
							    <div id="modalContainer" class="container">
							      <span onclick="document.getElementById('registerForm').style.display='none';clearReg()" class="close" title="Close Register">&times;</span>
							      <h1 class="titleForm">Sign Up</h1>

							      <label for="username"><b>Username</b></label>
							      <input id="usernameReg"type="text" placeholder="Enter Username" name="username" required>

							      <label for="email"><b>Email</b></label>
							      <input id="emailReg" type="text" placeholder="Enter Email" name="email" required>

							      <label for="psw"><b>Password</b></label>
							      <input id="passwordReg" type="password" placeholder="Enter Password" name="psw" required>

							      <label for="psw-repeat"><b>Repeat Password</b></label>
							      <input id="passwordRepeatReg" type="password" placeholder="Repeat Password" name="psw-repeat" required>
							      
							      <div class="clearfix">
							        <button type="button" onclick="document.getElementById('registerForm').style.display='none';clearReg()" class="cancelbtn">Cancel</button>
							        <button type="submit" class="signupbtn">Sign Up</button>
							      </div>
							    </div>
							  </form>
							</div>
					</div>
		</header>
		<div id="searchbar">
			<div id="searchbar_content">
				<input id="search" type="text" name="search" autocomplete="off" placeholder="Search for lyrics or artist...">
				<div id="radio_buttons">
					<div>
						<label class="radio_button_style">
							<input type="radio" name="qtype" id="radio1" value="1" checked="checked">
							<span>Artist</span>
						</label>
					</div>
					<div>
						<label class="radio_button_style">
							<input type="radio" name="qtype" id="radio2" value="2">
							<span>Lyrics</span>
						</label>
					</div>
					<div>
						<label class="radio_button_style">
							<input type="radio" name="qtype" id="radio3" value="3">
							<span>Album</span>
						</label>
					</div>
				</div>
			</div>
			<!--searchbar, radio buttons ... -->
		</div>
		<div id="welcome">
<h2 id="welcome_h1">Welcome here!</h2>
Lyrics.com is a huge collection of song lyrics, album information and featured video clips from endless number of artists — collaboratively assembled by contributing editors.

Browse our lyrics and artists database alphabetically or simply search by keywords. Lyrics can be rated, heard using song videos and even translated to many common and not so common languages.
		</div>
		<div id="main_content">
			MAIN CONTENT
		</div>

	</div>
<script src="javascript.js" type="text/javascript"></script>
</body>

</html>