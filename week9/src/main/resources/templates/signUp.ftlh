<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Sign Up for Item</h1>
    <form action="/signUp/${eventId}/${itemId}" method="post">
        <label for="person">Your Name:</label>
        <input type="text" id="person" name="person" required>
        <input type="submit" value="Submit">
    </form>
</body>
</html>