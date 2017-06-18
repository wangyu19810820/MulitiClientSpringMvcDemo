package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

/**
 * Created by admin on 2017/6/18.
 */
public class ResultModel extends HashMap<String, Object> {
    public static enum ResultStatus {
        RESULT_STATUS_SUC, RESULT_STATUS_FAIL
    }

    public static final String RESULT_BEAN_NAME = "result";


    private static final String STATUS_KEY = "status";
    private static final String DESC_KEY = "desc";

    public ResultModel() {
    }

    public ResultModel(ResultStatus status, String desc) {
        super();
        put(STATUS_KEY, status.ordinal());
        put(DESC_KEY, desc);
    }

    public ResultStatus getStatus() {
        return ResultStatus.values()[(Integer)get(STATUS_KEY)];
    }

    public void setStatus(ResultStatus status) {
        put(STATUS_KEY, status.ordinal());
    }

    public String getDesc() {
        return (String)get(DESC_KEY);
    }

    public void setDesc(String desc) {
        put(DESC_KEY, desc);
    }

    public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s= objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
            return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public String toString() {
        return toJson();
    }
}
