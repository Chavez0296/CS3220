<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Week 8</title>
</head>
<body>
	<ul>
		<#list events as event>
			<li>${event.name} - ${event.date} - ${event.event}</li>
		</#list>
	</ul>
</body>
</html>