package com.hp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.entity.CpinfoEntity;
import com.hp.entity.Outcp1Entity;
import com.hp.entity.UserEntity;
import com.hp.service.CpinfoService;
import com.hp.service.Outcp1Service;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("outcp1.do")
public class Outcp1Controller {

	@Autowired
	private Outcp1Service outcp1Service;

	@Autowired
	private CpinfoService cpinfoService;
	
	@RequestMapping(params = "method=all")
	@ResponseBody
	public String pageCpType(Outcp1Entity pz) {
		pz.setPage((pz.getPage() - 1) * pz.getLimit());
		List<Outcp1Entity> ar = outcp1Service.pageOutcp1(pz);
		for (Outcp1Entity out : ar) {
			out.setPrice(out.getFoutprice()*out.getWcount());
		}
		int count = outcp1Service.getCount();
		JSONObject obj = new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);

		return obj.toString();
	}

	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addCpType(Outcp1Entity o,HttpServletRequest request) {
		//修改库存数量
		CpinfoEntity selCpinfo = cpinfoService.selCpinfo(o.getFid());
		selCpinfo.setFcount(selCpinfo.getFcount()-o.getWcount());
		cpinfoService.updCpinfo(selCpinfo);
		
		//添加散客消费记录
		UserEntity user = (UserEntity) request.getSession().getAttribute("user");
		String wtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		o.setWtime(wtime);
		o.setUid(user.getUid());
		outcp1Service.addOutcp1(o);
		
		
		
		return 1;
	}

	@RequestMapping(params = "method=upd")
	@ResponseBody
	public int updCpType(Outcp1Entity Outcp1) {
		outcp1Service.updOutcp1(Outcp1);
		return 1;
	}

	@RequestMapping(params = "method=sel")
	@ResponseBody
	public Outcp1Entity selCpType(Outcp1Entity pz) {
		Outcp1Entity selCarxl = outcp1Service.selOutcp1(pz.getWid());
		return selCarxl;
	}
	
	@RequestMapping(params = "method=allx")
	@ResponseBody
	public String allx(Outcp1Entity pz) {
		pz.setPage((pz.getPage() - 1) * pz.getLimit());
		List<Outcp1Entity> ar = outcp1Service.page(pz);
		for (Outcp1Entity out : ar) {
			out.setPrice(out.getFoutprice()*out.getWcount());
		}
		int count = outcp1Service.getCount1(pz.getFid());
		JSONObject obj = new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);

		return obj.toString();
	}

	

}
