package com.lucas.blog.myblog.utils;



import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.*;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.utils
 * @ClassName: UserAgentUtils
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/3 22:06
 * @Version: 1.0
 */
public class UserAgentUtils {

	//获取ip
	public static String getIp(HttpServletRequest request){
		String ip = null;
		ip = request.getHeader("x-forwarded-for");
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getRemoteAddr();
			if (ip.equals("127.0.0.1")) {
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ip = inet.getHostAddress();
			}
		}
		if ((ip != null) && (ip.length() > 15)) {
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}
		return ip;
	}


	//获取浏览器名称
	public static String getBrowserName(HttpServletRequest request){
		String header = request.getHeader("User-Agent");
		UserAgent userAgent = UserAgent.parseUserAgentString(header);
		Browser browser = userAgent.getBrowser();
		return browser.getName();

	}

	//获取浏览器版本
	public static String getBrowserVersion(HttpServletRequest request){
		String header = request.getHeader("User-Agent");
		UserAgent userAgent = UserAgent.parseUserAgentString(header);
		//获取浏览器信息
		Browser browser = userAgent.getBrowser();
		//获取浏览器版本号
		Version version = browser.getVersion(header);
		return version.getVersion();
	}


	//获取操做系统
	public static String getOsName(HttpServletRequest request){
		String header = request.getHeader("User-Agent");
		UserAgent userAgent = UserAgent.parseUserAgentString(header);
		OperatingSystem operatingSystem = userAgent.getOperatingSystem();
		return operatingSystem.getName();

	}


	//获取请求全路径
	public static String getUrl(HttpServletRequest request){
		return request.getRequestURI();
	}



	public static String getCity(HttpServletRequest request,String ip) throws IOException, GeoIp2Exception {
		// 创建 GeoLite2 数据库
		File database = new File("E:/IntelliJ IDEA Project/myblog/src/main/resources/GeoLite2-City.mmdb");
		// 读取数据库内容
		DatabaseReader reader = new DatabaseReader.Builder(database).build();


		ip="180.84.26.212";
		System.out.println("ip="+ip);














		InetAddress ipAddress = InetAddress.getByName(ip);
		System.out.println("ipAddress="+ipAddress);
		// 获取查询结果
		CityResponse response = reader.city(ipAddress);
		// 获取国家信息
		Country country = response.getCountry();
		String countryName=country.getNames().get("zh-CN");
		// 获取省份
		Subdivision subdivision = response.getMostSpecificSubdivision();
		String subdivisionName=subdivision.getNames().get("zh-CN");
		// 获取城市
		City city = response.getCity();
		String cityName=city.getNames().get("zh-CN");
		String locationInfo=countryName+subdivisionName+cityName;
		return locationInfo;
	}
}
