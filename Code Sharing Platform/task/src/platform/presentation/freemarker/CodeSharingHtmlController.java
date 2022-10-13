package platform.presentation.freemarker;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/code")
public interface CodeSharingHtmlController {

    @GetMapping(path ="/{id}", produces = MediaType.TEXT_HTML_VALUE)
    String getReadCodePage(Model model, @PathVariable("id") UUID id) ;

    @GetMapping(path = "/new", produces = MediaType.TEXT_HTML_VALUE)
    String getCreateCodePage();

    @GetMapping(path = "/latest", produces = MediaType.TEXT_HTML_VALUE)
    String getReadLatestCodePage(Model model) ;
}
