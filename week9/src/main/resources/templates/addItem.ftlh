<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/addItem/${event.id}" method="post">
        <label for="itemName">Item Name:</label>
        <input type="text" id="itemName" name="itemName" required><br><br>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" value="1" min="1" required><br><br>
        <input type="submit" value="Add Item">
    </form>
</body>
</html>