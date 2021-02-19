package com.lucas.blog.myblog.utils;/**
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog.utils
 * @ClassName: MarkdownUtils
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/11/29 17:51
 * @Version: 1.0
 */

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

/**
 * @program: myblog
 *
 * @ClassName: MarkdownUtils

 *
 * @author: Lucas
 *
 * @create: 2019-11-29 17:51
 **/


public class MarkdownUtils {



	public static String markdownToHtml(String markdown){
		Parser parser = Parser.builder().build();
		Node document = parser.parse(markdown);
		HtmlRenderer renderer = HtmlRenderer.builder().build();
		return  renderer.render(document);
	}




	public static String  markdownToHtmlExtension(){

		return null;
	}
}
