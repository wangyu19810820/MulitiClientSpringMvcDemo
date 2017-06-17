package util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.List;

/**
 * Created by admin on 2017/6/17.
 */
public class ClientTypeUtil {

    public static boolean isAppClient(HttpHeaders headers) {
        List<MediaType> acceptList = headers.getAccept();
        return acceptList.contains(MediaType.APPLICATION_JSON);
    }
}
