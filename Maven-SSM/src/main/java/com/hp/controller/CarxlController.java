package com.hp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.entity.CartypeEntity;
import com.hp.entity.CarxlEntity;
import com.hp.service.CartypeService;
import com.hp.service.CarxlService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("carxl.do")
public class CarxlController {
	
	@Autowired
	private CarxlService carxlService;
	
	@Autowired
	private CartypeService cartypeService;
	
	@RequestMapping(params="method=allType")
	@ResponseBody
	public List<CartypeEntity> allType(CartypeEntity pz){
		List<CartypeEntity> ar = cartypeService.allCartype();
		return ar;
	}
	
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageCpType(CarxlEntity pz){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<CarxlEntity> ar = carxlService.pageCarxl(pz);
		int count = carxlService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addCpType(CarxlEntity Carxl){
		carxlService.addCarxl(Carxl);
		return 1;
	}
	
	@RequestMapping(params="method=upd")
	@ResponseBody
	public int updCpType(CarxlEntity pz){
		carxlService.updCarxl(pz);
		return 1;
	}
	
	@RequestMapping(params="method=sel")
	@ResponseBody
	public CarxlEntity selCpType(CarxlEntity pz){
		CarxlEntity selCarxl = carxlService.selCarxl(pz.getXid());
		return selCarxl;
	}
	
	@RequestMapping(params="method=getCheckName")
	@ResponseBody
	public int getCheckName(CarxlEntity CpType){
		int i=0;
		List<CarxlEntity> ar = carxlService.allCarxl();
		for (CarxlEntity c : ar) {
			if(c.getAid()==CpType.getAid()){
				if (c.getXname().equalsIgnoreCase(CpType.getXname())) {
					i=1;
				}
			}
		}
		return i;
	}
	
	@RequestMapping(params="method=allp")
	@ResponseBody
	public List<CarxlEntity> allp(){
		List<CarxlEntity> ar = carxlService.allCarxl();
		return ar;
	}
	
	
	
}
