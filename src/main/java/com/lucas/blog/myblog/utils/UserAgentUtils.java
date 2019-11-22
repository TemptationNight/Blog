package com.lucas.blog.myblog.utils;


import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.*;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

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

	private static final String FILE_PATH = "/src/main/resources/GeoLite2-City.mmdb";


	//获取ip
	public static String getIp(HttpServletRequest request) {
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




		String[] str=new String[]{
				"101.226.33.201",
				"101.226.33.202",
				"101.226.33.203",
				"101.226.33.204",
				"101.226.33.206",
				"101.226.33.216",
				"101.226.33.217",
				"101.226.33.219",
				"101.226.33.220",
				"101.226.33.221",
				"101.226.33.225",
				"101.226.33.227",
				"101.226.33.228",
				"101.226.33.237",
				"101.226.33.238",
				"101.226.33.239",
				"101.226.51.226",
				"101.226.51.227",
				"101.226.51.228",
				"101.226.51.229",
				"101.226.51.230",
				"101.226.65.104",
				"101.226.65.105",
				"101.226.65.106",
				"101.226.65.107",
				"101.226.66.172",
				"101.226.66.177",
				"101.226.66.179",
				"101.226.66.180",
				"101.226.66.181",
				"101.226.66.193",
				"101.226.89.117",
				"101.226.89.119",
				"101.226.89.122",
				"112.64.235.246",
				"112.64.235.247",
				"112.64.235.251",
				"112.64.235.254",
				"112.64.235.87",
				"112.64.235.89",
				"112.64.235.90",
				"112.65.193.13",
				"112.65.193.14",
				"112.65.193.15",
				"114.95.250.97",
				"122.245.145.127",
				"124.74.10.30",
				"180.153.114.199",
				"180.153.114.200",
				"180.153.163.187",
				"180.153.163.190",
				"180.153.163.191",
				"180.153.163.206",
				"180.153.163.208",
				"180.153.163.209",
				"180.153.163.211",
				"180.153.201.15",
				"180.153.201.214",
				"180.153.201.64",
				"180.153.201.66",
				"180.153.201.79",
				"180.153.205.252",
				"180.153.205.253",
				"180.153.205.254",
				"180.153.206.16",
				"180.153.206.17",
				"180.153.206.19",
				"180.153.206.20",
				"180.153.206.21",
				"180.153.206.22",
				"180.153.206.23",
				"180.153.206.24",
				"180.153.206.26",
				"180.153.206.27",
				"180.153.206.31",
				"180.153.206.34",
				"180.153.206.35",
				"180.153.206.36",
				"180.153.206.37",
				"180.153.206.38",
				"180.153.211.190",
				"180.153.214.176",
				"180.153.214.180",
				"180.153.214.181",
				"180.153.214.182",
				"180.153.214.189",
				"180.153.214.190",
				"180.153.214.191",
				"180.153.214.192",
				"180.153.214.197",
				"180.153.214.200",
				"222.73.77.54",
				"101.226.102.9,7",
				"101.226.33.200",
				"101.226.33.202",
				"101.226.33.220",
				"101.226.33.223",
				"101.226.33.227",
				"101.226.33.228",
				"101.226.33.238",
				"101.226.51.226",
				"101.226.51.228",
				"101.226.65.104",
				"101.226.66.173",
				"101.226.66.180",
				"101.226.66.187",
				"101.226.66.192",
				"101.226.89.116",
				"101.226.89.119",
				"101.226.89.123",
				"101.226.89.64",
				"101.226.89.69",
				"112.64.235.247",
				"112.64.235.253",
				"112.64.235.254",
				"112.64.235.86",
				"112.64.235.91",
				"180.153.114.199",
				"180.153.114.200",
				"180.153.163.187",
				"180.153.163.209",
				"180.153.201.212",
				"180.153.201.66",
				"180.153.205.253",
				"180.153.205.254",
				"180.153.206.16",
				"180.153.206.17",
				"180.153.206.21",
				"180.153.206.23",
				"180.153.206.31",
				"180.153.206.38",
				"180.153.214.178",
				"180.153.214.180",
				"180.153.214.181",
				"180.153.214.182",
				"180.153.214.188",
				"180.153.214.190",
				"180.153.214.191",
				"222.73.77.54",
				"22.73.77.55"};
		Random random=new Random();

		//(数据类型)(最小值+Math.random()*(最大值-最小值+1))
		int i=(int)(0+Math.random()*(str.length));

		return str[i];
		//return "210.74.226.2";
		/*






		*/



	}


	//获取浏览器名称
	public static String getBrowserName(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		UserAgent userAgent = UserAgent.parseUserAgentString(header);
		Browser browser = userAgent.getBrowser();
		return browser.getName();

	}

	//获取浏览器版本
	public static String getBrowserVersion(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		UserAgent userAgent = UserAgent.parseUserAgentString(header);
		//获取浏览器信息
		Browser browser = userAgent.getBrowser();
		//获取浏览器版本号
		Version version = browser.getVersion(header);
		return version.getVersion();
	}


	//获取操做系统
	public static String getOsName(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		UserAgent userAgent = UserAgent.parseUserAgentString(header);
		OperatingSystem operatingSystem = userAgent.getOperatingSystem();
		return operatingSystem.getName();

	}


	//获取请求全路径
	public static String getUrl(HttpServletRequest request) {
		return request.getRequestURI();
	}


	public static String getCity(HttpServletRequest request, String ip) throws IOException, GeoIp2Exception {
		// 创建 GeoLite2 数据库

		String path = new File(ResourceUtils.getURL("").getPath()).getAbsolutePath();
		String path1 = path.replace("%20", " ").replace("\\", "/");

		String filePath = path1 + FILE_PATH;


		System.out.println(filePath);

		File database = new File(filePath);
		// 读取数据库内容
		DatabaseReader reader = new DatabaseReader.Builder(database).build();
		ip = getIp(request);
		InetAddress ipAddress = InetAddress.getByName(ip);
		// 获取查询结果
		CityResponse response = reader.city(ipAddress);
		// 获取国家信息
		Country country = response.getCountry();
		String countryName = country.getNames().get("zh-CN");
		if (countryName == null) {
			countryName = "未知";
		}
		// 获取省份
		Subdivision subdivision = response.getMostSpecificSubdivision();
		String subdivisionName = subdivision.getNames().get("zh-CN");
		if (subdivisionName == null) {
			subdivisionName = "";
		}
		// 获取城市
		City city = response.getCity();
		String cityName = city.getNames().get("zh-CN");
		if (cityName == null) {
			cityName = "";
		}
		String locationInfo = countryName + subdivisionName + cityName;
		return locationInfo;
	}
}
