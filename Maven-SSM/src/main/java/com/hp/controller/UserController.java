package com.hp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.entity.UserEntity;
import com.hp.service.UserService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("user.do")
public class UserController {

	@Autowired 
	private UserService userService;
	
	
	//登录
	@RequestMapping(params="method=login")
	@ResponseBody
	public int userLogin(UserEntity user,HttpServletRequest request){
		int result=0;
		int login = userService.userLogin(user);
		if(login>0){
			//登录成功
			UserEntity userEntity = userService.getUser(user);
			request.getSession().setAttribute("user", userEntity);
			result=1;
		}else{
			//登录失败
			result=0;
		}
		return result;
	}
	@RequestMapping(params="method=getCheckName")
	@ResponseBody
	public int getCheckName(UserEntity user){
		int name = userService.getCheckName(user);
		return name;
	}
	
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageCpType(UserEntity pz){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<UserEntity> ar = userService.pageUser(pz);
		for (UserEntity u : ar) {
			if (u.getUsex()==1) {
				u.setSex("男");
			} else {
				u.setSex("女");
			}
		}
		int count = userService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addCpType(UserEntity Servicetype){
		userService.addUser(Servicetype);
		return 1;
	}
	
	@RequestMapping(params="method=upd")
	@ResponseBody
	public int updCpType(UserEntity pz){
		userService.updUser(pz);
		return 1;
	}
	
	@RequestMapping(params="method=sel")
	@ResponseBody
	public UserEntity selCpType(UserEntity pz){
		UserEntity selCpType = userService.selUser(pz.getUid());
		return selCpType;
	}
	
	/*@RequestMapping(params="method=getCheckName")
	@ResponseBody
	public int getCheckName(UserEntity CpType){
		int i=0;
		List<UserEntity> ar = userService.allCartype();
		for (UserEntity c : ar) {
			if (c.getAname().equalsIgnoreCase(CpType.getAname())) {
				i=1;
			}
		}
		return i;
	}*/
	
	
}
