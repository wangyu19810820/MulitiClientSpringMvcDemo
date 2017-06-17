package util;

/**
 * Created by admin on 2017/6/18.
 */
public class ResultModel {
    public static final String RESULT_BEAN_NAME = "result";
    public static final int RESULT_STATUS_SUC = 0;
    public static final int RESULT_STATUS_FAIL = 1;

    protected int status;
    protected String desc;
    protected Object data;

    public ResultModel() {
    }

    public ResultModel(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public ResultModel(int status, String desc, Object data) {
        this.status = status;
        this.desc = desc;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "status=" + status +
                ", desc='" + desc + '\'' +
                ", data=" + data +
                '}';
    }
}
