package com.hp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.entity.CptypeEntity;
import com.hp.service.CpTypeService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("Cptype.do")
public class CpTypeController {
	
	@Autowired
	private CpTypeService cpTypeService;
	
	
	@RequestMapping(params="method=allp")
	@ResponseBody
	public List<CptypeEntity> allp(){
		List<CptypeEntity> ar = cpTypeService.allCptype();
		return ar;
	}
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageCpType(CptypeEntity cp){
		cp.setPage((cp.getPage()-1)*cp.getLimit());
		List<CptypeEntity> ar = cpTypeService.pageCptype(cp);
		int count = cpTypeService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addCpType(CptypeEntity CpType){
		cpTypeService.addCptype(CpType);
		return 1;
	}
	
	@RequestMapping(params="method=upd")
	@ResponseBody
	public int updCpType(CptypeEntity CpType){
		cpTypeService.updCptype(CpType);
		return 1;
	}
	
	@RequestMapping(params="method=sel")
	@ResponseBody
	public CptypeEntity selCpType(CptypeEntity CpType){
		CptypeEntity selCpType = cpTypeService.selCptype(CpType.getCid());
		return selCpType;
	}
	
	@RequestMapping(params="method=getCheckName")
	@ResponseBody
	public int getCheckName(CptypeEntity CpType){
		int i=0;
		List<CptypeEntity> ar = cpTypeService.allCptype();
		for (CptypeEntity c : ar) {
			if(CpType.getCname().equalsIgnoreCase(c.getCname())){
				i=1;
			}
		}
		return i;
	}
	
	
	
}
