package cc.mrbird.admin.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author tqj
 * @Description
 * @create 2019/6/3 17:19
 **/
@Mapper
public interface BlogMapper {

//    查找所有博客
    List<Map<String,Object>> findAllBlogContext();

    int findCount();
}
