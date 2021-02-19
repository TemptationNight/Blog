package com.lucas.blog.myblog.utils;/**
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog.utils
 * @ClassName: MarkdownUtils
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/11/29 17:51
 * @Version: 1.0
 */

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.*;

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

		//h  标题生成id
		Set<Extension> headAnchorExtensions= Collections.singleton(HeadingAnchorExtension.create());
		//转换table的HTML
		List<Extension> tableExtension=Arrays.asList(TablesExtension.create());
		Parser parser = Parser.builder().extensions(tableExtension).build();
		Node document = parser.parse(markdown);
		HtmlRenderer renderer = HtmlRenderer.builder().
				extensions(headAnchorExtensions).
				extensions(tableExtension).attributeProviderFactory(new AttributeProviderFactory() {
			@Override
			public AttributeProvider create(AttributeProviderContext attributeProviderContext) {
				return new CustomAttributeProvider();
			}
		}).build();
		return renderer.render(document);

		//最基本的用法
		/*Parser parser = Parser.builder().build();
		Node document = parser.parse(markdown);
		HtmlRenderer renderer = HtmlRenderer.builder().build();
		return  renderer.render(document);*/
	}

	//处理标签的属性
	static  class CustomAttributeProvider implements  AttributeProvider{
		@Override
		public void setAttributes(Node node, String s, Map<String, String> map) {
			if(node instanceof Link){
				map.put("target","_blank");
			}
			if(node instanceof TableBlock){
				map.put("class","ui celled table");
			}
		}
	}
}

