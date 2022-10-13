package platform.presentation.api;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import platform.businesslayer.entity.Code;
import platform.businesslayer.exception.CodeNotFoundException;
import platform.businesslayer.service.CodeSharingService;
import platform.presentation.entity.ApiErrorResponseJBean;
import platform.presentation.entity.CodeJBean;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class CodeSharingAPIImpl implements CodeSharingAPI {

    private final CodeSharingService service;
    private final ConversionService conversionService;

    public CodeSharingAPIImpl(final CodeSharingService service, final ConversionService conversionService) {
        this.service = service;
        this.conversionService = conversionService;
    }

    @ExceptionHandler(CodeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponseJBean codeNotFoundExceptionHandler(final CodeNotFoundException exception) {
        return conversionService.convert(exception, ApiErrorResponseJBean.class);
    }

    @Override
    public Map<String, Object> createCode(final CodeJBean code)  {
        var convertedCode = conversionService.convert(code, Code.class);
        var id = service.createCode(convertedCode);
        var idString = Objects.requireNonNull(conversionService.convert(id, String.class));

        return Map.of("id", idString);
    }

    @Override
    public CodeJBean readCode(final UUID id)  {
        var code = service.readCode(id);

        return conversionService.convert(code, CodeJBean.class);
    }

    @Override
    public Collection<CodeJBean> readLatestCode()  {
        var latestCode = service.readLatestCode();

        return latestCode.stream()
                .map(code -> conversionService.convert(code, CodeJBean.class))
                .collect(Collectors.toList());
    }
}
