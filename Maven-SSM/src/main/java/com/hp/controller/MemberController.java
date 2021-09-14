package com.hp.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.entity.DjEntity;
import com.hp.entity.MemberEntity;
import com.hp.service.DjService;
import com.hp.service.MemberService;
import com.hp.util.MyUpload;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("member.do")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private DjService djService;
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageCpType(MemberEntity pz){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<MemberEntity> ar = memberService.pageMember(pz);
		for (MemberEntity m : ar) {
			if(m.getRsex()==0){
				m.setSex("女");
			}else{
				m.setSex("男");
			}
			if(m.getRstatus()==0){
				m.setStatus("破损");
			}else{
				m.setStatus("正常");
			}
		}
		int count = memberService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addCpType(MemberEntity user,HttpServletRequest request){
		if (user.getImg().getOriginalFilename().length() != 0) {
			// 第一小步：和到原文件上传对象的名称
			String imgname = user.getImg().getOriginalFilename();
			// 第二小步：改名
			String myfilename = MyUpload.getNewName(imgname);
			// 第三步：上传
			String path = request.getSession().getServletContext().getRealPath("/upload/");
			String oldpath = path + "/" + myfilename;
			File f = new File(oldpath);
			try {
				FileUtils.copyInputStreamToFile(user.getImg().getInputStream(), f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//存库
			user.setRimg("upload/"+myfilename);
			memberService.addMember(user);
		} else {
			System.out.println("我不上传文件！");
		}
		
		return 1;
	}
	
	@RequestMapping(params="method=upd")
	@ResponseBody
	public int updCpType(MemberEntity user,HttpServletRequest request){
		if (user.getImg().getOriginalFilename().length() != 0) {
			// 第一小步：和到原文件上传对象的名称
			String imgname = user.getImg().getOriginalFilename();
			// 第二小步：改名
			String myfilename = MyUpload.getNewName(imgname);
			// 第三步：上传
			String path = request.getSession().getServletContext().getRealPath("/upload/");
			String oldpath = path + "/" + myfilename;
			File f = new File(oldpath);
			try {
				FileUtils.copyInputStreamToFile(user.getImg().getInputStream(), f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//存库
			user.setRimg("upload/"+myfilename);
			memberService.updMember(user);
		} else {
			System.out.println("我不上传文件！");
		}
		return 1;
	}
	
	@RequestMapping(params="method=sel")
	@ResponseBody
	public MemberEntity selCpType(MemberEntity pz){
		MemberEntity m = memberService.selMember(pz.getRid());
		if(m.getRsex()==0){
			m.setSex("女");
		}else{
			m.setSex("男");
		}
		if(m.getRstatus()==0){
			m.setStatus("破损");
		}else{
			m.setStatus("正常");
		}
		return m;
	}
	
	
	@RequestMapping(params="method=getCheckName")
	@ResponseBody
	public int getCheckName(MemberEntity CpType){
		int i=0;
		List<MemberEntity> ar = memberService.allMember();
		for (MemberEntity c : ar) {
			if (c.getRcard().equalsIgnoreCase(CpType.getRcard())) {
				i=1;
			}
		}
		return i;
	}
	
	@RequestMapping(params="method=getRcard")
	@ResponseBody
	public MemberEntity getRcard(MemberEntity pz,HttpServletRequest request){
		HttpSession session = request.getSession();
		/*if(pz.getRsex()==1){
			
			Object obj = session.getAttribute("ar");
			if(obj!=null){
				session.removeAttribute("ar");
			}
		}*/
		/*String rcard = (String) session.getAttribute("rcard");
		if(!pz.getRcard().equalsIgnoreCase(rcard)){
			session.removeAttribute("shop");
			session.removeAttribute("arr");
		}*/
		
		MemberEntity m = memberService.getRcard(pz.getRcard());
		if(m.getRsex()==0){
			m.setSex("女");
		}else{
			m.setSex("男");
		}
		if(m.getRstatus()==0){
			m.setStatus("破损");
		}else{
			m.setStatus("正常");
		}
		session.setAttribute("rcard", pz.getRcard());
		return m;
	}
	
	@RequestMapping(params="method=grap")
	@ResponseBody
	public Object[][] grap(HttpServletRequest request){
		List<MemberEntity> group = memberService.group();
		Object[][] obj=new Object[group.size()][2];
		
		for (int i = 0; i < group.size(); i++) {
			obj[i][0]=group.get(i).getDname();//会员名称
			obj[i][1]=group.get(i).getCount();//会员数量
		}
		return obj;
	}
	
	@RequestMapping(params="method=pll")
	@ResponseBody
	public String pll(MemberEntity pz,HttpServletRequest request){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<MemberEntity> ar = memberService.getByDid(pz.getDid());
		for (MemberEntity m : ar) {
			if(m.getRsex()==0){
				m.setSex("女");
			}else{
				m.setSex("男");
			}
			if(m.getRstatus()==0){
				m.setStatus("破损");
			}else{
				m.setStatus("正常");
			}
		}
		
		int count = memberService.getCount1(pz.getDid());
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		getDname(pz.getDid(),request);
		
		return obj.toString();
		
	}
	
	public void getDname(int did,HttpServletRequest request){
		DjEntity selDj = djService.selDj(did);
		request.setAttribute("dname", selDj.getDname());
	}
	
	@RequestMapping(params="method=ok")
	public String getOk(HttpServletRequest request){
		List<DjEntity> allDj = djService.allDj();
		request.getSession().setAttribute("ar", allDj.size());
		return "member/utils";
	}
	
	
	@RequestMapping(params="method=jf")
	@ResponseBody
	public Object[][] jf(MemberEntity member){
		List<MemberEntity> allMember = memberService.allMember();
		Object[][] obj=new Object[allMember.size()][2];
		for (int i = 0; i < allMember.size(); i++) {
			obj[i][0]=allMember.get(i).getRname();
			obj[i][1]=allMember.get(i).getRjf();
		}
		return obj;
	}
	@RequestMapping(params = "method=jf1")
	@ResponseBody
	public Object[][] all(MemberEntity e) {
		Object obj[][] = null;
		if(e.getTt()==1){
			obj = new Object[2][2];
			obj[0][0]="积分大于等于"+e.getOnejf();
			obj[0][1]=this.memberService.getCouRjf(e);
			obj[1][0]="积分小于"+e.getOnejf();
			obj[1][1]=this.memberService.getCouTwo(e);
		}else if(e.getTt()==2){
			obj = new Object[3][2];
			obj[0][0]="积分小于等于"+e.getOnejf();
			MemberEntity m=new MemberEntity();
			m.setOnejf(e.getOnejf());
			obj[0][1]=this.memberService.getCouTwo(m);
			obj[1][0]=e.getOnejf()+"大于积分小于"+e.getTwojf();
			obj[1][1]=this.memberService.getCouRjf(e);
			obj[2][0]="积分大于"+e.getTwojf();
			e.setOnejf(0);
			obj[2][1]=this.memberService.getCouTwo(e);
		}else if(e.getTt()==3){
			obj = new Object[4][2];
			obj[0][0]="积分小于等于"+e.getOnejf();
			MemberEntity m=new MemberEntity();
			m.setOnejf(e.getOnejf());
			obj[0][1]=this.memberService.getCouTwo(m);
			
			obj[1][0]=e.getOnejf()+"大于积分小于"+e.getTwojf();
			obj[1][1]=this.memberService.getCouRjf(e);
			
			obj[2][0]=e.getTwojf()+"大于积分小于"+e.getThreejf();
			obj[2][1]=this.memberService.getCouOt(e);
			
			obj[3][0]="积分大于"+e.getThreejf();
			e.setOnejf(0);
			e.setTwojf(0);
			obj[3][1]=this.memberService.getCouTwo(e);
		}
		return obj;
	}
	
	@RequestMapping(params="method=dy")
	@ResponseBody
	public String getDy(MemberEntity member){
		//大于onejf的
		List<MemberEntity> allMember = memberService.getRjf(member);
		int count = memberService.getCouRjf(member);
		for (MemberEntity m : allMember) {
			if(m.getRsex()==0){
				m.setSex("女");
			}else{
				m.setSex("男");
			}
		}
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", allMember);
		return obj.toString();
	}
	
	@RequestMapping(params="method=xy")
	@ResponseBody
	public String getXy(MemberEntity member){
		//小于onejf的
		List<MemberEntity> allMember = memberService.getTwo(member);
		int count = memberService.getCouTwo(member);
		for (MemberEntity m : allMember) {
			if(m.getRsex()==0){
				m.setSex("女");
			}else{
				m.setSex("男");
			}
		}
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", allMember);
		return obj.toString();
	}
	
	@RequestMapping(params="method=dx")
	@ResponseBody
	public String getDx(MemberEntity member){
		//小于onejf的
		List<MemberEntity> allMember = memberService.getRjf(member);
		
		int count = memberService.getCouRjf(member);
		for (MemberEntity m : allMember) {
			if(m.getRsex()==0){
				m.setSex("女");
			}else{
				m.setSex("男");
			}
		}
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", allMember);
		return obj.toString();
	}
	
	@RequestMapping(params="method=xx")
	@ResponseBody
	public String getXx(MemberEntity member){
 
		List<MemberEntity> ot = memberService.getOt(member);
		
		int count = memberService.getCouOt(member);
		for (MemberEntity m : ot) {
			if(m.getRsex()==0){
				m.setSex("女");
			}else{
				m.setSex("男");
			}
		}
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ot);
		return obj.toString();
	}
	
	
}
