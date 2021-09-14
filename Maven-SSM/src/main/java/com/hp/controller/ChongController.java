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

import com.hp.entity.ChongEntity;
import com.hp.entity.MemberEntity;
import com.hp.entity.UserEntity;
import com.hp.service.ChongService;
import com.hp.service.MemberService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("chong.do")
public class ChongController {
	
	@Autowired
	private ChongService chongService;
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageCpType(ChongEntity pz){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<ChongEntity> ar = chongService.pageChong(pz);
		int count = chongService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addCpType(ChongEntity Chong,HttpServletRequest request){
		String gtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		UserEntity user = (UserEntity) request.getSession().getAttribute("user");
		Chong.setUid(user.getUid());
		Chong.setOtime(gtime);
		//添加充值记录数据
		chongService.addChong(Chong);
		//修改会员信息表的余额
		MemberEntity m = memberService.selMember(Chong.getRid());
		m.setRmoney(Chong.getOlastmoney()+m.getRmoney());
		memberService.updMember(m);
		
		return 1;
	}
	
	@RequestMapping(params="method=upd")
	@ResponseBody
	public int updCpType(ChongEntity Chong){
		chongService.updChong(Chong);
		return 1;
	}
	
	@RequestMapping(params="method=sel")
	@ResponseBody
	public ChongEntity selCpType(ChongEntity pz){
		ChongEntity selCarxl = chongService.selChong(pz.getYid());
		return selCarxl;
	}
	
	/*@RequestMapping(params="method=getCheckName")
	@ResponseBody
	public int getCheckName(ChongEntity CpType){
		int i=0;
		List<ChongEntity> ar = chongService.allChong();
		for (ChongEntity c : ar) {
			if (CpType.getYtitle().equalsIgnoreCase(c.getYtitle())) {
				i=1;
			}
		}
		return i;
	}*/
	
	
	
}
