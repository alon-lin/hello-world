package com.hp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.entity.DjEntity;
import com.hp.service.DjService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("dj.do")
public class DjController {
	
	@Autowired
	private DjService djService;
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageDj(DjEntity djEntity){
		djEntity.setPage((djEntity.getPage()-1)*djEntity.getLimit());
		List<DjEntity> ar = djService.pageDj(djEntity);
		int count = djService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addDj(DjEntity dj){
		djService.addDj(dj);
		return 1;
	}
	
	@RequestMapping(params="method=upd")
	@ResponseBody
	public int updDj(DjEntity dj){
		djService.updDj(dj);
		return 1;
	}
	
	@RequestMapping(params="method=sel")
	@ResponseBody
	public DjEntity selDj(DjEntity dj){
		DjEntity selDj = djService.selDj(dj.getDid());
		return selDj;
	}
	
	
	
	@RequestMapping(params="method=getCheckName")
	@ResponseBody
	public int getCheckName(DjEntity dj){
		int i = djService.getCheckName(dj.getDname());
		return i;
	}
	
	@RequestMapping(params="method=getCheckAll")
	@ResponseBody
	public int getCheckAll(DjEntity dj){
		int i=0;
		List<DjEntity> ar = djService.allDj();
		for (DjEntity d : ar) {
			if(d.getDjf()==dj.getDjf()){
				i=1;
			}
			if(d.getDmoneyBl()==dj.getDmoneyBl()){
				i=2;
			}
			if(d.getDzk()==dj.getDzk()){
				i=3;
			}
		}
		return i;
	}
	
	@RequestMapping(params="method=allp")
	@ResponseBody
	public List<DjEntity> allp(){
		List<DjEntity> ar = djService.allDj();
		return ar;
	}
	
	
	
	
	
}
