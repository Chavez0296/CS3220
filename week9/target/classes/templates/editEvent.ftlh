<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Event</title>
</head>
<body>
	<form  method='post'>
	Name: <@spring.formInput "event.name"/> <br>
	Date: <input type="date" name="date" value="${event.date}"><br>
	Event Name: <@spring.formInput "event.event"/><br>
	<button>Save</button>
	</form>
</body>
</html>