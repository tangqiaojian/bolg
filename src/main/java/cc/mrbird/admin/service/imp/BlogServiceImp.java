package cc.mrbird.admin.service.imp;

import cc.mrbird.admin.dao.BlogMapper;
import cc.mrbird.admin.service.BlogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author tqj
 * @Description
 * @create 2019/6/3 20:42
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class BlogServiceImp implements BlogService {
    @Autowired
    BlogMapper blogMapper;
    @Override
    public  List<Map<String,Object>> findAllContext(int currentPage,int pageSize) throws Exception{
        PageHelper.startPage(currentPage, pageSize);
        List<Map<String,Object>> result =  blogMapper.findAllBlogContext();
        return result;
    }

    @Override
    public  int findCount() throws Exception{
        int result =  blogMapper.findCount();
        return result;
    }

}
