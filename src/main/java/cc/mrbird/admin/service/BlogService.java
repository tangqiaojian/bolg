package cc.mrbird.admin.service;

import java.util.List;
import java.util.Map;

/**
 * @author tqj
 * @Description
 * @create 2019/6/3 20:41
 **/
public interface BlogService {

    public List<Map<String,Object>> findAllContext(int currentPage,int pageSize)throws Exception;

    public  int findCount() throws Exception;
}
