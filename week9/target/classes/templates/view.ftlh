<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>${event.event}</h1>
<h2>${event.name}</h2>
<h2>Date: ${event.date}</h2>
<h2><a href="/addItem/${event.id}">Add Item</a></h2>
<#list event.items as item>
	<h3>${item.itemName} 
		<#if item.quantity??> 
					- ${item.quantity} -
		 </#if> 
		<#if item.person?has_content> 
			${item.person} 
		<#else><a href="/signUp/${event.id}/${item.id}">Sign Up</a>
		</#if>
		<form action="/deleteItem/${event.id}/${item.id}" method="get">
                    <input type="submit" value="Delete">
        </form>
	</h3>
</#list>
</body>
</html>