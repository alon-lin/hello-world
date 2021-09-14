package com.hp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.entity.PzEntity;
import com.hp.service.PzService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("pz.do")
public class PzController {
	
	@Autowired
	private PzService pzService;
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageCpType(PzEntity pz){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<PzEntity> ar = pzService.pagePz(pz);
		int count = pzService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addCpType(PzEntity Servicetype){
		pzService.addPz(Servicetype);
		return 1;
	}
	
	@RequestMapping(params="method=upd")
	@ResponseBody
	public int updCpType(PzEntity pz){
		pzService.updPz(pz);
		return 1;
	}
	
	@RequestMapping(params="method=sel")
	@ResponseBody
	public PzEntity selCpType(PzEntity pz){
		PzEntity selCpType = pzService.selPz(pz.getZid());
		return selCpType;
	}
	
	@RequestMapping(params="method=getCheckName")
	@ResponseBody
	public int getCheckName(PzEntity CpType){
		int i=0;
		List<PzEntity> ar = pzService.allPz();
		for (PzEntity c : ar) {
			if(CpType.getZname().equalsIgnoreCase(c.getZname())){
				i=1;
			}
		}
		return i;
	}
	
	@RequestMapping(params="method=allp")
	@ResponseBody
	public List<PzEntity> all(){
		List<PzEntity> ar = pzService.allPz();
		return ar;
	}
	
	
	
}
