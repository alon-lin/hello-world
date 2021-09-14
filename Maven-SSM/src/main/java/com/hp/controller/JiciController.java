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

import com.hp.entity.JiciEntity;
import com.hp.entity.MemberEntity;
import com.hp.entity.UserEntity;
import com.hp.service.JiciService;
import com.hp.service.MemberService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("jici.do")
public class JiciController {
	
	@Autowired
	private JiciService JiciService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageCpType(JiciEntity pz){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<JiciEntity> ar = JiciService.pageJici(pz);
		int count = JiciService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addCpType(JiciEntity Jici,HttpServletRequest request){
		//修改金额
		MemberEntity rcard = memberService.getRcard(Jici.getRcard());
		rcard.setRjf((int)Jici.getJmoney()/10+rcard.getRjf());
		rcard.setRmoney(rcard.getRmoney()-Jici.getJmoney());
		memberService.updMember(rcard);
		//添加计次消费记录数据
		UserEntity user = (UserEntity) request.getSession().getAttribute("user");
		String jtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Jici.setRid(rcard.getRid());
		Jici.setUid(user.getUid());
		Jici.setJtime(jtime);
		JiciService.addJici(Jici);
		
		return 1;
	}
	
	@RequestMapping(params="method=allp")
	@ResponseBody
	public List<JiciEntity> allp(){
		int i=0;
		List<JiciEntity> ar = JiciService.allJici();
		return ar;
	}
	
	
	
}
