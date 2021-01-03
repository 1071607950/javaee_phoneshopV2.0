package com.city.shop.user.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.shop.utils.VerifyCode;

/**
 * 
 * @author 
 * @category 验证码前分发
 */
@WebServlet("/user/VerifyCodetologin.do")
public class VerifyCodeToLoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage(85, 23);// 设置验证码图片大小
		request.getSession().setAttribute("sessionverify", vc.getText());// 将验证码文本保存到session域
		VerifyCode.output(image, response.getOutputStream());
	}
}
