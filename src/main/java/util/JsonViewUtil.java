package util;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/6/17.
 */
public class JsonViewUtil {

    public static void suc(HttpServletResponse response, String desc, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", 0);
        exec(result, desc, data, response);
    }

    public static void fail(HttpServletResponse response, String desc, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", 1);
        exec(result, desc, data, response);
    }

    private static void exec(Map<String, Object> result, String desc, Object data, HttpServletResponse response) {
        result.put("desc", desc);
        result.put("data", data);

        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        MediaType jsonMimeType = MediaType.APPLICATION_JSON;
        try {
            jsonConverter.write(result, jsonMimeType, new ServletServerHttpResponse(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
