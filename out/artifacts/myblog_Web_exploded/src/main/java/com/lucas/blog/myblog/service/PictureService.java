package com.lucas.blog.myblog.service;

import com.lucas.blog.myblog.entity.Picture;


import java.util.List;

/**
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog.service
 * @ClassName: PictureService
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/10/13 14:08
 * @Version: 1.0
 */

public interface PictureService {
	public Integer  addPicture(Picture picture);
	public List<Picture> getPictures();
	public Picture getPicture(Integer id);
	public Integer deletePicture(Integer id);
}
