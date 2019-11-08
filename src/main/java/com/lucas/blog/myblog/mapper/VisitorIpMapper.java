package com.lucas.blog.myblog.mapper;


import com.lucas.blog.myblog.entity.Visitor;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;

/**
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog
 * @ClassName: VisitorIpMapper
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/11/8 20:02
 * @Version: 1.0
 */


//example  构造方法中没有  group by方法   自定义group by方法


public interface VisitorIpMapper extends Mapper<Visitor>{
	@Select("select * from visitor group by ip")
	List<Visitor> getVisitorGroupByIp();
	@Select("select * from visitor where black=0 group by ip")
	List<Visitor> getBlackVisitorIp();
}



