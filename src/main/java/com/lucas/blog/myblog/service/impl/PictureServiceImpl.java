package com.lucas.blog.myblog.service.impl;/**
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog.service.impl
 * @ClassName: PictureServiceImpl
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/10/13 14:12
 * @Version: 1.0
 */

import com.lucas.blog.myblog.entity.Picture;
import com.lucas.blog.myblog.mapper.PictureMapper;
import com.lucas.blog.myblog.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: myblog
 *
 * @ClassName: PictureServiceImpl

 *
 * @author: Lucas
 *
 * @create: 2019-10-13 14:12
 **/

@Service
public class PictureServiceImpl  implements PictureService{

	@Autowired
	private PictureMapper pictureMapper;



	/**
	 * Description:     添加图片
	 * @author: Lucas
	 * @date: 2019/10/14 15:58
	 * @param:     图片实体
	 * @return:     Integer
	 */
	@Override
	public Integer addPicture(Picture picture) {
		return  pictureMapper.insert(picture);
	}

	/**
	 * Description:  获取所有的图片
	 * @author: Lucas
	 * @date: 2019/10/14 15:59
	 * @param:
	 * @return:      List<Picture>
	 */
	@Override
	public List<Picture> getPictures() {
		return pictureMapper.selectAll();
	}

	/**
	 * Description:      根据主键获取图片信息
	 * @author: Lucas
	 * @date: 2019/10/14 15:59
	 * @param:    id
	 * @return:   Picture
	 */
	@Override
	public Picture getPicture(Integer id) {
		Example example=new Example(Picture.class);
		example.createCriteria().andEqualTo("id",id);
		return  pictureMapper.selectOneByExample(example);
	}

	/**
	 * Description:     根据主键删除图片
	 * @author: Lucas
	 * @date: 2019/10/14 15:59
	 * @param:     id
	 * @return:  Integer
	 */
	@Override
	public Integer deletePicture(Integer id) {
		Example example=new Example(Picture.class);
		example.createCriteria().andEqualTo("id",id);
		return pictureMapper.deleteByExample(example);
	}


}
