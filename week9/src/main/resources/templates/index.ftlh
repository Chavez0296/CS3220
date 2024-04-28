<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Week 9</title>
</head>
<body>
	<h2>Events</h2>
	<p><a href=/addEvent>Add Event</a></p>
	<ul>
		<#list events>
			<#items as event>
				<li><a href="/view/${event.id}">${event.name}</a> - ${event.date} - ${event.event} <a href="/editEvent/${event.id}">Edit Event</a></li>
			</#items>
		</#list>
	</ul>
</body>
</html>