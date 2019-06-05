package cc.mrbird.until;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author tqj
 * @Description
 * @create 2019/6/3 17:26
 **/
public class Respone {
    /**
     * 防跨域返回数据
     * @param response
     * @param obj
     */
    public static void printf(HttpServletResponse response, Object obj) {

        response.setHeader("Access-Control-Allow-Credentials", "false");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        try {
            PrintWriter out = response.getWriter();
            out.println(obj);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
