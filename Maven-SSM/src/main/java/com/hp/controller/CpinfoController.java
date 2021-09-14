package com.hp.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.entity.CartypeEntity;
import com.hp.entity.CpinfoEntity;
import com.hp.service.CartypeService;
import com.hp.service.CpinfoService;
import com.hp.util.MyUpload;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("cpinfo.do")
public class CpinfoController {
	
	@Autowired
	private CpinfoService cpinfoService;
	
	
	@RequestMapping(params="method=cp")
	@ResponseBody
	public List<CpinfoEntity> cp(CpinfoEntity pz){
		List<CpinfoEntity> all=new ArrayList<CpinfoEntity>();
		List<CpinfoEntity> ar = cpinfoService.allCpinfo();
		for (CpinfoEntity c : ar) {
			if(c.getCid()==pz.getCid()){
				all.add(c);
			}
		}
		return all;
	}
	
	
	
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageCpType(CpinfoEntity pz){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<CpinfoEntity> ar = cpinfoService.pageCpinfo(pz);
		int count = cpinfoService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addCpType(CpinfoEntity user,HttpServletRequest request){
		if (user.getImg().getOriginalFilename().length() != 0) {
			// 第一小步：和到原文件上传对象的名称
			String imgname = user.getImg().getOriginalFilename();
			// 第二小步：改名
			String myfilename = MyUpload.getNewName(imgname);
			// 第三步：上传
			String path = request.getSession().getServletContext().getRealPath("/upload/");
			String oldpath = path + "/" + myfilename;
			File f = new File(oldpath);
			try {
				FileUtils.copyInputStreamToFile(user.getImg().getInputStream(), f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//存库
			user.setFimg("upload/"+myfilename);
			cpinfoService.addCpinfo(user);
		} else {
			System.out.println("我不上传文件！");
		}
		return 1;
	}
	
	@RequestMapping(params="method=upd")
	@ResponseBody
	public int updCpType(CpinfoEntity user,HttpServletRequest request){
		if (user.getImg().getOriginalFilename().length() != 0) {
			// 第一小步：和到原文件上传对象的名称
			String imgname = user.getImg().getOriginalFilename();
			// 第二小步：改名
			String myfilename = MyUpload.getNewName(imgname);
			// 第三步：上传
			String path = request.getSession().getServletContext().getRealPath("/upload/");
			String oldpath = path + "/" + myfilename;
			File f = new File(oldpath);
			try {
				FileUtils.copyInputStreamToFile(user.getImg().getInputStream(), f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//存库
			user.setFimg("upload/"+myfilename);
			CpinfoEntity selCpinfo = cpinfoService.selCpinfo(user.getFid());
			user.setFcount(selCpinfo.getFcount()+user.getFcount());
			cpinfoService.updCpinfo(user);
		} else {
			System.out.println("我不上传文件！");
		}
		return 1;
	}
	
	@RequestMapping(params="method=sel")
	@ResponseBody
	public CpinfoEntity selCpType(CpinfoEntity pz){
		CpinfoEntity selCarxl = cpinfoService.selCpinfo(pz.getFid());
		return selCarxl;
	}
	
	@RequestMapping(params="method=getCheckName")
	@ResponseBody
	public int getCheckName(CpinfoEntity CpType){
		int i=0;
		List<CpinfoEntity> ar = cpinfoService.allCpinfo();
		for (CpinfoEntity c : ar) {
			if (CpType.getFname().equalsIgnoreCase(c.getFname())) {
				i=1;
			}
		}
		return i;
	}
	
	@RequestMapping(params="method=allp")
	@ResponseBody
	public List<CpinfoEntity> allp(){
		List<CpinfoEntity> ar = cpinfoService.allCpinfo();
		return ar;
	}
	
	@RequestMapping(params="method=px")
	@ResponseBody
	public List px(){
		List op=new ArrayList();
		//得到销售数量
		List<CpinfoEntity> list = cpinfoService.allCpinfo();
		
		List<Integer> in=new ArrayList<Integer>();
		List<String> str=new ArrayList<String>();
		
		for (CpinfoEntity cp : list) {
			str.add(cp.getFname());
			CpinfoEntity byName = cpinfoService.getByName(cp.getFid());
			in.add((int) byName.getXcount());
		}
		CpinfoEntity c=new CpinfoEntity();
		c.setName("产品销售额");
		c.setData(in);
		List<CpinfoEntity> ar=new ArrayList<CpinfoEntity>();
		ar.add(c);
		
		op.add(str);
		op.add(ar);
		return op;
	}
	
	
	@RequestMapping(params="method=pll")
	@ResponseBody
	public String pll(CpinfoEntity pz){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<CpinfoEntity> ar = cpinfoService.pageCpinfo(pz);
		for (CpinfoEntity c : ar) {
			CpinfoEntity byName = cpinfoService.getByName(c.getFid());
			c.setXcount(byName.getXcount());
		}
		int count = cpinfoService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	@RequestMapping(params="method=msg")
	@ResponseBody
	public int getMsg(){
		int msg = cpinfoService.getMsg();
		return msg;
	}
	
	@RequestMapping(params="method=allMsg")
	@ResponseBody
	public String allMsg(){
		List<CpinfoEntity> countMsg = cpinfoService.getCountMsg();
		int msg = cpinfoService.getMsg();
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", msg);
		obj.put("data", countMsg);
		return obj.toString();
	}
	
}
