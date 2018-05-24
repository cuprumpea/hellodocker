package com.docker.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.docker.entity.User;

@Controller
public class DockerAction {
	@RequestMapping("/init.action")
	public String init(ModelMap model, HttpServletRequest request, HttpServletResponse rs) throws IOException, Exception {
		ResourceBundle congigProperties = ResourceBundle.getBundle("db");
		String url = congigProperties.getString("url");
		String username = congigProperties.getString("username");
		String password = congigProperties.getString("password");
		String sql = "select * from user;";
		Class.forName("com.mysql.jdbc.Driver");
		Connection  conn = DriverManager.getConnection(url, username, password);//获取连接  
		PreparedStatement pst = conn.prepareStatement(sql);//准备执行语句  
		ResultSet ret = pst.executeQuery();
		ResultSetMetaData rsmd = ret.getMetaData();
		List<User> userList = new ArrayList<User>();
		User user = null;
		while (ret.next()) {
			user = new User();
			user.setId(ret.getString("id"));
			user.setName(ret.getString("name"));
			user.setAge(ret.getString("age"));
			userList.add(user);
			System.out.println("name:" + user.getName() + ", age:" + user.getAge());
		}
		model.addAttribute("userList", userList);
		model.addAttribute("aa", "aaaaaa");
		return "list";
	}
}
