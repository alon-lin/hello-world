package com.hp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.entity.ServicetypeEntity;
import com.hp.service.ServiceTypeService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("servicetype.do")
public class ServicetypeController {
	
	@Autowired
	private ServiceTypeService serviceTypeService;
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageCpType(ServicetypeEntity cp){
		cp.setPage((cp.getPage()-1)*cp.getLimit());
		List<ServicetypeEntity> ar = serviceTypeService.pageServiceType(cp);
		int count = serviceTypeService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addCpType(ServicetypeEntity Servicetype){
		serviceTypeService.addServiceType(Servicetype);
		return 1;
	}
	
	@RequestMapping(params="method=upd")
	@ResponseBody
	public int updCpType(ServicetypeEntity Servicetype){
		serviceTypeService.updServiceType(Servicetype);
		return 1;
	}
	
	@RequestMapping(params="method=sel")
	@ResponseBody
	public ServicetypeEntity selCpType(ServicetypeEntity CpType){
		ServicetypeEntity selCpType = serviceTypeService.selServiceType(CpType.getSid());
		return selCpType;
	}
	
	@RequestMapping(params="method=getCheckName")
	@ResponseBody
	public int getCheckName(ServicetypeEntity CpType){
		int i=0;
		List<ServicetypeEntity> ar = serviceTypeService.allServiceType();
		for (ServicetypeEntity c : ar) {
			if(CpType.getSname().equalsIgnoreCase(c.getSname())){
				i=1;
			}
		}
		return i;
	}
	
	
	@RequestMapping(params="method=allp")
	@ResponseBody
	public List<ServicetypeEntity> allp(ServicetypeEntity CpType){
		List<ServicetypeEntity> allServiceType = serviceTypeService.allServiceType();
		return allServiceType;
	}
	
	
	
}
