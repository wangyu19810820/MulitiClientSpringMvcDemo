package util;

import org.springframework.web.servlet.ModelAndView;
import static util.ResultModel.ResultStatus;

/**
 * Created by admin on 2017/6/18.
 */
public class SelfModelAndView extends ModelAndView {
    protected ResultModel resultModel;

    public SelfModelAndView(String viewName) {
        super(viewName);
        resultModel = new ResultModel(ResultStatus.RESULT_STATUS_SUC, "suc");
        addObject(ResultModel.RESULT_BEAN_NAME, resultModel);
    }

    public void setStatusAndDesc(ResultStatus status, String desc) {
        resultModel.setStatus(status);
        resultModel.setDesc(desc);
    }

    public void setDesc(String desc) {
        resultModel.setDesc(desc);
    }

    public void addJsonAndViewData(String name, Object data) {
        resultModel.put(name, data);
        addObject(name, data);
    }
}
