package platform.support.springconverter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import platform.presentation.entity.CodeJBean;
import platform.businesslayer.entity.Code;

import java.time.LocalDateTime;

@Component
public class CodeJBeanToCodeConverter implements Converter<CodeJBean, Code> {

    @Override
    public Code convert(CodeJBean source) {
        var now = LocalDateTime.now();
        var sourceTime = source.getTime();
        var sourceViews = source.getViews();

        return new Code(null, source.getCode(), now,
                sourceTime > 0 ? sourceTime : null,
                sourceViews > 0 ? sourceViews : null,
                0);
    }
}
