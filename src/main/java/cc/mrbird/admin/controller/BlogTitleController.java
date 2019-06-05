package cc.mrbird.admin.controller;

import cc.mrbird.admin.service.BlogService;
import cc.mrbird.until.Respone;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author tqj
 * @Description 博客管理
 * @create 2019/6/3 16:21
 **/
@Controller
@RequestMapping("/BlogTitleController")
public class BlogTitleController {

    @Autowired
    BlogService blogService;

    @RequestMapping("/list")
    public String list(){
        return "add_now/admin/blog_title_add";
    }

    @RequestMapping("/datagrid")
    public void datagrid(HttpServletResponse response, HttpServletRequest request)throws Exception{
        JSONObject result = new JSONObject();
        List<Map<String,Object>> blog_msg = blogService.findAllContext(Integer.valueOf(request.getParameter("page")),Integer.valueOf(request.getParameter("limit")));
        result.put("code","0");
        result.put("data",blog_msg);
        result.put("limit",Integer.valueOf(request.getParameter("page")));
        result.put("page",Integer.valueOf(request.getParameter("page")));
        result.put("count",blogService.findCount());
        Respone.printf(response,result);
    }
}
