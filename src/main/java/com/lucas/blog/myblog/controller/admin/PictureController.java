package com.lucas.blog.myblog.controller.admin;/**
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog.controller.admin
 * @ClassName: PictureController
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/10/13 14:20
 * @Version: 1.0
 */


import com.lucas.blog.myblog.aop.ActionType;
import com.lucas.blog.myblog.aop.SystemLog;
import com.lucas.blog.myblog.entity.Category;
import com.lucas.blog.myblog.entity.Picture;
import com.lucas.blog.myblog.service.CategoryService;
import com.lucas.blog.myblog.service.PictureService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: myblog
 * @ClassName: PictureController
 * @author: Lucas
 * @create: 2019-10-13 14:20
 **/


@Controller
@RequestMapping("/admin")
public class PictureController {


	//private static  String FILE_PATH="src/main/resources/static/images";

	private static String FILE_PATH = "/target/classes/static/images";


	@Autowired
	private PictureService pictureServiceImpl;

	@Autowired
	private CategoryService categoryServiceImpl;

	@GetMapping("/pictureUp")
	public String pictureUp(Model model) {
		List<Picture> pictures = pictureServiceImpl.getPictures();
		model.addAttribute("pictures", pictures);
		return "admin/pictureUp";
	}


	@RequiresRoles(value = "root")
	@SystemLog(description = "添加图片:", actionType = ActionType.INSERT)
	@PostMapping("/uploadFile")
	public String uploadFile(@RequestParam("files") MultipartFile[] files) {
		//文件不为空
		if (files != null && files.length >= 1) {
			for (MultipartFile file : files) {
				try {
					//处理文件路径
					String path = new File(ResourceUtils.getURL("").getPath()).getAbsolutePath();
					String path1 = path.replace("%20", " ").replace("\\", "/");
					System.out.println(path1);
					String filePath = path1 + FILE_PATH;
					String fileName = file.getOriginalFilename();
					//处理后缀，文件名，
					String prefix = fileName.substring(0, fileName.lastIndexOf("."));
					String sufix = fileName.substring(fileName.lastIndexOf(".") + 1);
					String realFileName = prefix + System.currentTimeMillis() + "." + sufix;
					//文件上传
					File dest = new File(filePath + realFileName);
					file.transferTo(dest);

					//将图片的信息写入数据库
					Picture pic = new Picture(realFileName, filePath);
					Integer integer = pictureServiceImpl.addPicture(pic);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:/admin/pictureUp";
	}


	@RequiresRoles(value = "root")
	@SystemLog(description = "删除图片:", actionType = ActionType.DELETE)
	@PostMapping("/picture/deleteFile")
	public String deleteFile(Integer id) {
		if (id != null) {
			Integer integer = pictureServiceImpl.deletePicture(id);
			System.out.println(integer);
		}
		return "redirect:/admin/pictureUp";
	}


	@GetMapping("/picture{id}/getPictureById")
	public String getPictureById(Integer id, Model model) {
		if (id != null) {
			Picture picture = pictureServiceImpl.getPicture(id);
			model.addAttribute("picture", picture);
		}
		return "/admin/pictureUp";
	}


}




