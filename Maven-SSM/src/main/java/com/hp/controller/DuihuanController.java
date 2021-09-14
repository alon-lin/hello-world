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
import com.hp.entity.DuihuanEntity;
import com.hp.entity.LipinEntity;
import com.hp.entity.MemberEntity;
import com.hp.entity.UserEntity;
import com.hp.service.CartypeService;
import com.hp.service.DuihuanService;
import com.hp.service.LipinService;
import com.hp.service.MemberService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("duihuan.do")
public class DuihuanController {
	
	@Autowired
	private DuihuanService DuihuanService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private LipinService lipinService;
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageCpType(DuihuanEntity pz){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<DuihuanEntity> ar = DuihuanService.pageDuihuan(pz);
		int count = DuihuanService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=allx")
	@ResponseBody
	public String allx(DuihuanEntity pz){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<DuihuanEntity> ar = DuihuanService.page(pz);
		int count = DuihuanService.getCount1(pz.getNid());
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addCpType(DuihuanEntity d,HttpServletRequest request){
		//添加兑换记录
		UserEntity user = (UserEntity) request.getSession().getAttribute("user");
		MemberEntity member = memberService.getRcard(d.getRcard());
		String htime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		d.setRid(member.getRid());
		d.setHtime(htime);
		d.setUid(user.getUid());
		//修改礼品信息表中的剩余数量
		LipinEntity lipin = lipinService.selLipin(d.getNid());
		lipin.setNncount(d.getCount());
		lipinService.updLipin(lipin);
		//修改会员的积分
		member.setRjf(d.getJf());
		memberService.updMember(member);
		
		
		DuihuanService.addDuihuan(d);
		return 1;
	}
	
	@RequestMapping(params="method=upd")
	@ResponseBody
	public int updCpType(DuihuanEntity Duihuan){
		DuihuanService.updDuihuan(Duihuan);
		return 1;
	}
	
	@RequestMapping(params="method=sel")
	@ResponseBody
	public DuihuanEntity selCpType(DuihuanEntity pz){
		DuihuanEntity selCarxl = DuihuanService.selDuihuan(pz.getHid());
		return selCarxl;
	}
	
	/*@RequestMapping(params="method=getCheckName")
	@ResponseBody
	public int getCheckName(DuihuanEntity CpType){
		int i=0;
		List<DuihuanEntity> ar = DuihuanService.allDuihuan();
		for (DuihuanEntity c : ar) {
			if (CpType.getYtitle().equalsIgnoreCase(c.getYtitle())) {
				i=1;
			}
		}
		return i;
	}*/
	@RequestMapping(params="method=allp")
	@ResponseBody
	public List<DuihuanEntity> allp(){
		int i=0;
		List<DuihuanEntity> ar = DuihuanService.allDuihuan();
		return ar;
	}
	
	
	
}
