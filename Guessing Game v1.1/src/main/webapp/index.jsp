<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="page">
<head>
<meta charset="UTF-8">
<title>Guessing Game</title>
<link rel="stylesheet" href="/styles/styles.css" type="text/css" />
</head>
<body>
	<div id="basePage" class="basePage">
		<h1>Welcome to the Guessing Game!</h1>

		<div id="guessingGame" class="guessingGame">
			<p>I am thinking of a number from 1 to 10.</p>
			<p>You must guess what it is in three tries.</p>
			<form method="post">
				<p for="number">Enter a guess:</p>
				<input type="number" id="guessValue" required name="guessValue" min="1"
					max="10"> <input type="submit" value="Guess it"
					class="form-submit-button" formaction="processGuess"> <br />
			</form>
		</div>
		<div id="responseMessage" class="responseMessage">
			<p>${responseMessage}</p>
		</div>
	</div>
</body>
</html>