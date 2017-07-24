package top.pengcheng789.java.penblog.helper;

import org.junit.Test;
import top.pengcheng789.java.penblog.bean.Handler;
import top.pengcheng789.java.penblog.bean.Request;

import java.util.Map;

/**
 * CreateDate:2017-07-24
 *
 * @author pen
 */

public class ControllerHelperTest {
    @Test
    public void showRequestMapping(){
        Map<Request, Handler> map = ControllerHelper.getActionMap();

        for (Map.Entry<Request, Handler> entry : map.entrySet()) {
            System.out.println(entry.getKey().getRequestMethod());
            System.out.println(entry.getKey().getRequestPath());
            System.out.println(entry.getValue().getActionMethod().getName());
            System.out.println("");
        }
    }
}
