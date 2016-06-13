<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Social Score</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="/css/main.css" />
</head>
<body>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<div class="left">
				<img th:if="${profile}" th:src="${profile}" />
			</div>
			<div class="fontsize1">
				<strong>Cheers ! Your cocktail score is </strong>
			</div>
			<div class="padding avatar">
				<span class="fontsize2 bold" th:text="${sm.score}"></span>
			</div>

			<div style="margin-left: 18%;">
				<div style="margin-right: 5%;" class="padding avatar">
					<span class="fontsize2 bold" th:text="${sm.geographicScore}">15</span>
				</div>
				<div style="margin-right: 5%;" class="padding avatar">
					<span class="fontsize2 bold" th:text="${sm.demographicScore}">24</span>
				</div>
				<div class="padding avatar">
					<span class="fontsize2 bold" th:text="${sm.sychographicScore}">33</span>
				</div>
			</div>
			<!-- <ul class="icons">
							<li><a href="#" class="icon style2 fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon style2 fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon style2 fa-instagram"><span class="label">Instagram</span></a></li>
							<li><a href="#" class="icon style2 fa-500px"><span class="label">500px</span></a></li>
							<li><a href="#" class="icon style2 fa-envelope-o"><span class="label">Email</span></a></li>
						</ul>-->
			<span class="scores"> <span class="colorScore">Geographic
					score</span> &nbsp;&nbsp;&nbsp; <span class="colorScore">
					Demographic score </span> &nbsp;&nbsp;&nbsp; <span class="colorScore">Psychographic
					score </span>
			</span>

		</header>

		<!-- Main -->
		<section id="main">

         
      <table>
      	<tr>
      		<td class="widthFifty">
     			 <div class="widthThirty"><h2><b>Positive traits </b></h2></div>
				<table class="table" th:each="msg:${sm.listPositive}">
					<tr>
						<td class="td"><h3 class="positive" th:text="${msg}">Positive traits of profile.</h3></td>
					</tr>
				</table>
			</td>
			<td class="widthFifty">
				<div class="widthThirty"><h2><b>Negative traits </b></h2></div>
				<table class="table" th:each="msg:${sm.listNegative}">
					<tr>
						<td class="td"><h3 class="negative"  th:text="${msg}">Negative traits of profile.</h3></td>
					</tr>
				</table>
			</td>
		</tr>
</table>
		</section>
		<!-- Footer -->
		<footer id="footer">
			<p>Cocktail &copy; 2016. All rights reserved.</p>
		</footer>
	</div>

	<!-- Scripts -->
	<script src="/js/jquery.min.js"></script>
	<script src="/js/jquery.poptrox.min.js"></script>
	<script src="js/skel.min.js"></script>
	<script src="/js/main.js"></script>

</body>
</html>