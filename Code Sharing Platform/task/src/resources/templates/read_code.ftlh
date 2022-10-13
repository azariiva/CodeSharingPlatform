<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
<#--    <script type="text/javascript" src="/js/initSnippets.js"></script>-->
    <script>hljs.initHighlightingOnLoad()</script>
</head>
<body>
<div id="snippet">
    <div id="snippet_header">
        <span id="load_date">${code.getDateString()}</span>
<#--        <span id="language_name">language</span>-->
    </div>
    <#if code.viewsLeft??>
        <br>
        <span id="views_restriction"><u>${code.viewsLeft}</u> more views allowed</span>
    </#if>
    <#if code.timeLeft??>
        <br>
        <span id="time_restriction">The code will be available for <u>${code.timeLeft}</u> seconds</span>
    </#if>
    <pre id="code_snippet"><code>${code.code}</code></pre>
</div>
<script>initSnippets();</script>
</body>
</html>