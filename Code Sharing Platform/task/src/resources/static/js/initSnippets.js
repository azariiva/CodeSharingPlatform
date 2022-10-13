function initSnippets() {
    let snippets = document.querySelectorAll("#snippet")
    snippets.forEach((snippet) => {
        let codeSnippet = snippet.querySelector("#code_snippet code");
        let highlightedCode = hljs.highlightAuto(codeSnippet.textContent);
        codeSnippet.innerHTML = highlightedCode.value;
        snippet.querySelector("#language_name").innerText = "language: " + highlightedCode.language;
    })
}