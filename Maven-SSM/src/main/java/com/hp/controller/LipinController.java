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

import com.hp.entity.DuihuanEntity;
import com.hp.entity.LipinEntity;
import com.hp.service.DuihuanService;
import com.hp.service.LipinService;
import com.hp.util.MyUpload;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("lipin.do")
public class LipinController {

	@Autowired
	private LipinService lipinService;

	@Autowired
	private DuihuanService duihuanService;
	
	@RequestMapping(params = "method=all")
	@ResponseBody
	public String pageLipin(LipinEntity pz) {
		pz.setPage((pz.getPage() - 1) * pz.getLimit());
		List<LipinEntity> ar = lipinService.pageLipin(pz);
		int count = lipinService.getCount();

		JSONObject obj = new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);

		return obj.toString();
	}

	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addLipin(LipinEntity Lipin,HttpServletRequest request) {

		// 要上传文件
		// 第一小步：得到原文件上传对象的名称
		String imgname = Lipin.getImg().getOriginalFilename();
		// 第二小步：改名
		String myfilename = MyUpload.getNewName(imgname);
		// 第三步：上传
		String path = request.getSession().getServletContext().getRealPath("/upload/");
		String oldpath = path + "/" + myfilename;
		File f = new File(oldpath);
		try {
			FileUtils.copyInputStreamToFile(Lipin.getImg().getInputStream(), f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 第四步：存库
		Lipin.setNimg("upload/" + myfilename);
		Lipin.setNncount(Lipin.getNcount());
		lipinService.addLipin(Lipin);
		return 1;
	}

	@RequestMapping(params = "method=upd")
	@ResponseBody
	public int updLipin(LipinEntity Lipin,HttpServletRequest request) {
		// 要上传文件
		// 第一小步：得到原文件上传对象的名称
		String imgname = Lipin.getImg().getOriginalFilename();
		// 第二小步：改名
		String myfilename = MyUpload.getNewName(imgname);
		// 第三步：上传
		String path = request.getSession().getServletContext().getRealPath("/upload/");
		String oldpath = path + "/" + myfilename;
		File f = new File(oldpath);
		try {
			FileUtils.copyInputStreamToFile(Lipin.getImg().getInputStream(), f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 第四步：存库
		Lipin.setNimg("upload/" + myfilename);
		Lipin.setNncount(Lipin.getNcount());
		lipinService.updLipin(Lipin);
		return 1;
	}

	@RequestMapping(params = "method=sel")
	@ResponseBody
	public LipinEntity selLipin(LipinEntity pz) {
		LipinEntity selCarxl = lipinService.selLipin(pz.getNid());
		return selCarxl;
	}

	@RequestMapping(params = "method=getCheckName")
	@ResponseBody
	public int getCheckName(LipinEntity Lipin) {
		int i = 0;
		List<LipinEntity> ar = lipinService.allLipin();
		for (LipinEntity c : ar) {
			if (Lipin.getNname().equalsIgnoreCase(c.getNname())) {
				i = 1;
			}
		}
		return i;
	}

	@RequestMapping(params = "method=allp")
	@ResponseBody
	public List<LipinEntity> allp() {
		List<LipinEntity> ar = lipinService.allLipin();
		return ar;
	}
	
	@RequestMapping(params="method=px")
	@ResponseBody
	public List px(){
		List<DuihuanEntity> allDuihuan = duihuanService.getByName();
		List<String> str=new ArrayList<String>();
		List<Integer> in=new ArrayList<Integer>();
		
		List<DuihuanEntity> ar=new ArrayList<DuihuanEntity>();
		for (DuihuanEntity li : allDuihuan) {
			str.add(li.getNname());
			in.add(li.getCount());
		}
		
		DuihuanEntity c=new DuihuanEntity();
		c.setName("礼品兑换数量");
		c.setData(in);
		
		ar.add(c);
		
		List arr=new ArrayList();
		arr.add(str);
		arr.add(ar);
		
		return arr;
	}
	

}
