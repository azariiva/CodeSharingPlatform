package platform.presentation.freemarker;

import freemarker.core.Environment;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import freemarker.template.Version;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import platform.businesslayer.entity.Code;
import platform.businesslayer.exception.CodeNotFoundException;
import platform.businesslayer.service.CodeSharingService;
import platform.presentation.entity.ApiErrorResponseJBean;
import platform.presentation.entity.CodeJBean;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class CodeSharingHtmlControllerImpl implements CodeSharingHtmlController {

    private final CodeSharingService codeSharingService;
    private final ConversionService conversionService;

    public CodeSharingHtmlControllerImpl(CodeSharingService codeSharingService, ConversionService conversionService) {
        this.codeSharingService = codeSharingService;
        this.conversionService = conversionService;
    }

    @ExceptionHandler(CodeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponseJBean codeNotFoundExceptionHandler(final CodeNotFoundException exception) {
        return conversionService.convert(exception, ApiErrorResponseJBean.class);
    }

    @Override
    public String getReadCodePage(Model model, UUID id)  {
        var code = codeSharingService.readCode(id);

        model.addAttribute("code", code);
        model.addAttribute("statics", new DefaultObjectWrapper(new Version("2.3.29")).getStaticModels());
        return "read_code";
    }

    @Override
    public String getCreateCodePage() {
        return "create_code";
    }

    @Override
    public String getReadLatestCodePage(Model model)  {
        Collection<Code> latestCode = codeSharingService.readLatestCode();

        model.addAttribute("latestCode", latestCode);
        model.addAttribute("statics", new DefaultObjectWrapper(new Version("2.3.29")).getStaticModels());
        return "read_latest_code";
    }
}
