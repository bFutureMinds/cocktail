<html>
<head>
<title>Hello linkedin</title>
</head>
<body>
	<h3>Connect to linkedin</h3>

	<!-- 	<form action="/connect/facebook" method="POST"> -->
	<!-- 		<input type="hidden" name="scope" value="user_posts" /> -->
	<!-- 		<div class="formInfo"> -->
	<!-- 			<p>You aren't connected to Facebook yet. Click the button to -->
	<!-- 				connect this application with your Facebook account.</p> -->
	<!-- 		</div> -->
	<!-- 		<p> -->
	<!-- 			<button type="submit">Connect to Facebook</button> -->
	<!-- 		</p> -->
	<!-- 	</form> -->

	<form th:action="@{/connect/linkedin}" method="POST">
		 
		                           
		<input
			type="hidden" name="scope"
			value="r_basicprofile r_emailaddress r_network r_fullprofile" />
		<input type="hidden" name="redirect_uri" value="http://localhost:8080/linkedin" />	
			
		<div class="formInfo">
			<p>You haven't created any connections with LinkedIn yet. Click
				the button to connect Spring Social Showcase with your LinkedIn
				account. (You'll be redirected to LinkedIn where you'll be asked to
				authorize the connection.)</p>
		</div>
		<p>
			<button type="submit">Connect with LinkedIn</button>
		</p>
	</form>

</body>
</html>