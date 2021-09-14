package com.hp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.entity.CartypeEntity;
import com.hp.service.CartypeService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("cartype.do")
public class CartypeController {
	
	@Autowired
	private CartypeService cartypeService;
	
	
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageCpType(CartypeEntity pz){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<CartypeEntity> ar = cartypeService.pageCartype(pz);
		int count = cartypeService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addCpType(CartypeEntity Servicetype){
		cartypeService.addCartype(Servicetype);
		return 1;
	}
	
	@RequestMapping(params="method=upd")
	@ResponseBody
	public int updCpType(CartypeEntity pz){
		cartypeService.updCartype(pz);
		return 1;
	}
	
	@RequestMapping(params="method=sel")
	@ResponseBody
	public CartypeEntity selCpType(CartypeEntity pz){
		CartypeEntity selCpType = cartypeService.selCartype(pz.getAid());
		return selCpType;
	}
	
	@RequestMapping(params="method=getCheckName")
	@ResponseBody
	public int getCheckName(CartypeEntity CpType){
		int i=0;
		List<CartypeEntity> ar = cartypeService.allCartype();
		for (CartypeEntity c : ar) {
			if (c.getAname().equalsIgnoreCase(CpType.getAname())) {
				i=1;
			}
		}
		return i;
	}
	
	
	@RequestMapping(params="method=allp")
	@ResponseBody
	public List<CartypeEntity> allp(){
		List<CartypeEntity> ar = cartypeService.allCartype();
		return ar;
	}
	
	
	
}
