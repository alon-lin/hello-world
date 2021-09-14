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

import com.hp.entity.CartypeEntity;
import com.hp.entity.LookEntity;
import com.hp.entity.MemberEntity;
import com.hp.entity.UserEntity;
import com.hp.service.CartypeService;
import com.hp.service.LookService;
import com.hp.service.MemberService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("look.do")
public class LookController {
	
	@Autowired
	private LookService LookService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageCpType(LookEntity pz){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<LookEntity> ar = LookService.pageLook(pz);
		int count = LookService.getCount(pz);
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addCpType(LookEntity look,HttpServletRequest request){
		//添加兑换记录
		UserEntity user = (UserEntity) request.getSession().getAttribute("user");
		MemberEntity member = memberService.getRcard(look.getRcard());
		String htime=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		look.setRid(member.getRid());
		look.setUid(user.getUid());
		look.setKtime(htime);
		LookService.addLook(look);
		return 1;
	}
	
	@RequestMapping(params="method=upd")
	@ResponseBody
	public int updCpType(LookEntity Look){
		LookService.updLook(Look);
		return 1;
	}
	
	@RequestMapping(params="method=sel")
	@ResponseBody
	public LookEntity selCpType(LookEntity pz){
		LookEntity selCarxl = LookService.selLook(pz.getKid());
		return selCarxl;
	}
	
	/*@RequestMapping(params="method=getCheckName")
	@ResponseBody
	public int getCheckName(LookEntity CpType){
		int i=0;
		List<LookEntity> ar = LookService.allLook();
		for (LookEntity c : ar) {
			if (CpType.getYtitle().equalsIgnoreCase(c.getYtitle())) {
				i=1;
			}
		}
		return i;
	}*/
	@RequestMapping(params="method=allp")
	@ResponseBody
	public List<LookEntity> allp(){
		List<LookEntity> ar = LookService.allLook();
		return ar;
	}
	
	
	
}
