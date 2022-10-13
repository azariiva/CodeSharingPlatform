package platform.support.springconverter;

import com.sun.istack.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import platform.presentation.entity.ApiErrorResponseJBean;
import platform.support.formatter.DefaultDateFormatter;

import java.time.LocalDateTime;

@Component
public class RuntimeExceptionToApiErrorResponseJBeanConverter implements Converter<RuntimeException, ApiErrorResponseJBean> {

    @Override
    public ApiErrorResponseJBean convert(@NotNull RuntimeException source) {
        var errorMessage = source.getMessage();

        var apiErrorResponse = new ApiErrorResponseJBean();
        apiErrorResponse.setMessage(errorMessage);
        apiErrorResponse.setDate(DefaultDateFormatter.format(LocalDateTime.now()));

        return apiErrorResponse;
    }
}
