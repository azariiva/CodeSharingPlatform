<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
    <link rel="stylesheet" href="/css/style.css">
    <script type="text/javascript" src="/js/send.js"></script>
</head>
<body>
<form>
    <textarea id="code_snippet">// write your code here</textarea>
    <br>
    <div>
        <span>Time restriction:</span>
        <input id="time_restriction" type="text"/>
    </div>
    <br>
    <div>
        <span>Views restriction:</span>
        <input id="views_restriction" type="text"/>
    </div>
    <br>
    <button id="send_snippet" type="submit" onclick=send()>Submit</button>
</form>
</body>
</html>