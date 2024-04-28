<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Poll</title>
</head>
<body>
<form method="post">
Question: <@spring.formInput "poll.question" /><br>
<@spring.formCheckbox "poll.singleChoice" /> Single-Choice<br>
<button>Create</button>
</form>
</body>
</html>