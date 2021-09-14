package com.hp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.entity.CartypeEntity;
import com.hp.entity.YouhuiEntity;
import com.hp.service.CartypeService;
import com.hp.service.YouhuiService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("youhui.do")
public class YouhuiController {
	
	@Autowired
	private YouhuiService youhuiService;
	
	
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageCpType(YouhuiEntity pz){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<YouhuiEntity> ar = youhuiService.pageYouhui(pz);
		int count = youhuiService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addCpType(YouhuiEntity Youhui){
		youhuiService.addYouhui(Youhui);
		return 1;
	}
	
	@RequestMapping(params="method=upd")
	@ResponseBody
	public int updCpType(YouhuiEntity Youhui){
		youhuiService.updYouhui(Youhui);
		return 1;
	}
	
	@RequestMapping(params="method=sel")
	@ResponseBody
	public YouhuiEntity selCpType(YouhuiEntity pz){
		YouhuiEntity selCarxl = youhuiService.selYouhui(pz.getYid());
		return selCarxl;
	}
	
	@RequestMapping(params="method=getCheckName")
	@ResponseBody
	public int getCheckName(YouhuiEntity CpType){
		int i=0;
		List<YouhuiEntity> ar = youhuiService.allYouhui();
		for (YouhuiEntity c : ar) {
			if (CpType.getYtitle().equalsIgnoreCase(c.getYtitle())) {
				i=1;
			}
		}
		return i;
	}
	@RequestMapping(params="method=allp")
	@ResponseBody
	public List<YouhuiEntity> allp(){
		int i=0;
		List<YouhuiEntity> ar = youhuiService.allYouhui();
		return ar;
	}
	
	
	
}
