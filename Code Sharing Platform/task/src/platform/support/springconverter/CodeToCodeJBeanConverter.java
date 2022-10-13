package platform.support.springconverter;

import com.sun.istack.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import platform.businesslayer.entity.Code;
import platform.presentation.entity.CodeJBean;

@Component
public class CodeToCodeJBeanConverter implements Converter<Code, CodeJBean> {

    @Override
    public CodeJBean convert(@NotNull Code source) {
        var timeLeft = source.getTimeLeft();
        var viewsLeft = source.getViewsLeft();

        var readCode = new CodeJBean();
        readCode.setDate(source.getDateString());
        readCode.setCode(source.getCode());
        readCode.setTime(timeLeft == null ? 0 : timeLeft);
        readCode.setViews(viewsLeft == null ? 0 : viewsLeft);

        return readCode;
    }
}
