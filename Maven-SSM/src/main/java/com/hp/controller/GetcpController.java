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
import com.hp.entity.GetcpEntity;
import com.hp.entity.UserEntity;
import com.hp.service.CpinfoService;
import com.hp.service.GetcpService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("getcp.do")
public class GetcpController {
	
	@Autowired
	private GetcpService getcpService;
	
	@Autowired
	private CpinfoService cpinfoService;
	
	@RequestMapping(params="method=selAll")
	@ResponseBody
	public String selAll(GetcpEntity pz){
		List<GetcpEntity> ar = getcpService.selAll(pz.getFid());
		int count = getcpService.getCount1(pz.getFid());
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageCpType(GetcpEntity pz){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<GetcpEntity> ar = getcpService.pageGetcp(pz);
		int count = getcpService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addCpType(GetcpEntity Getcp,HttpServletRequest request){
		String gtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		UserEntity user = (UserEntity) request.getSession().getAttribute("user");
		Getcp.setGtime(gtime);
		Getcp.setUid(user.getUid());
		getcpService.addGetcp(Getcp);
		
		CpinfoEntity cpinfo = cpinfoService.selCpinfo(Getcp.getFid());
		cpinfo.setFcount(Getcp.getGcount()+cpinfo.getFcount());
		cpinfoService.updCpinfo(cpinfo);
		
		return 1;
	}
	
	@RequestMapping(params="method=upd")
	@ResponseBody
	public int updCpType(GetcpEntity Getcp){
		getcpService.updGetcp(Getcp);
		return 1;
	}
	
	@RequestMapping(params="method=sel")
	@ResponseBody
	public GetcpEntity selCpType(GetcpEntity pz){
		GetcpEntity selCarxl = getcpService.selGetcp(pz.getGid());
		return selCarxl;
	}
	
	/*@RequestMapping(params="method=selAll")
	@ResponseBody
	public List<GetcpEntity> selAll(GetcpEntity pz){
		List<GetcpEntity> ar = getcpService.selAll(pz.getFid());
		return ar;
	}*/
	
	/*@RequestMapping(params="method=getCheckName")
	@ResponseBody
	public int getCheckName(GetcpEntity CpType){
		int i=0;
		List<GetcpEntity> ar = getcpService.allGetcp();
		for (GetcpEntity c : ar) {
			if (CpType.getYtitle().equalsIgnoreCase(c.getYtitle())) {
				i=1;
			}
		}
		return i;
	}*/
	
	
	
}
