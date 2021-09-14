package com.hp.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.entity.CpinfoEntity;
import com.hp.entity.MemberEntity;
import com.hp.entity.OutcpEntity;
import com.hp.entity.ShopCar;
import com.hp.entity.UserEntity;
import com.hp.service.CpinfoService;
import com.hp.service.DjService;
import com.hp.service.MemberService;
import com.hp.service.OutcpService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("outcp.do")
public class OutcpController {
	
	@Autowired
	private OutcpService outcpService;
	
	@Autowired
	private CpinfoService cpinfoService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(params="method=sub")
	@ResponseBody
	public int sub(ShopCar car,HttpServletRequest request){
		HttpSession session = request.getSession();
		Object obj=session.getAttribute("shop");
		List<ShopCar> ar=new ArrayList<ShopCar>();
		if(obj==null){
			ar.add(car);
		}else{
			ar = (List<ShopCar>) session.getAttribute("shop");
			ar.add(car);
		}
		session.setAttribute("shop", ar);
		this.xll(car,request);
		return 1;
	}
	
	@RequestMapping(params="method=xll")
	@ResponseBody
	public int xll(ShopCar car,HttpServletRequest request){
		float pr=0;
		float oor=0;
		List<ShopCar> all = (List<ShopCar>) request.getSession().getAttribute("shop");
		List<CpinfoEntity> arr=new ArrayList<CpinfoEntity>();
		if(all!=null){
				for (int i = 0; i < all.size(); i++) {
					all.get(i).setId(i+1);
					CpinfoEntity cpinfo = cpinfoService.selCpinfo(all.get(i).getFid());
					MemberEntity member = memberService.getRcard(all.get(i).getRcard());
					cpinfo.setId(i+1);
					cpinfo.setPrice(cpinfo.getFoutprice()*member.getDzk());
					cpinfo.setCount(all.get(i).getXcount());
					cpinfo.setAllPrice(all.get(i).getXcount()*cpinfo.getFoutprice()*member.getDzk());
					pr+=(cpinfo.getAllPrice());
					oor+=(cpinfo.getFoutprice()*all.get(i).getXcount());
					arr.add(cpinfo);
					request.getSession().setAttribute("d", member.getDzk());
					request.getSession().setAttribute("dname", member.getDname());
				}
				
				request.getSession().setAttribute("oor", oor);
				request.getSession().setAttribute("pr", pr);
			}
		request.getSession().setAttribute("arr", arr);
		return 1;
	}
	
	
	/*@RequestMapping(params="method=bll")
	@ResponseBody
	public String pageCpType(ShopCar car,OutcpEntity pz,HttpServletRequest request){
		List<ShopCar> all = (List<ShopCar>) request.getSession().getAttribute("shop");
		JSONObject obj=new JSONObject();
		if(all!=null){
				List<CpinfoEntity> arr=new ArrayList<CpinfoEntity>();
				for (ShopCar s : all) {
						CpinfoEntity cpinfo = cpinfoService.selCpinfo(s.getFid());
						MemberEntity member = memberService.getRcard(car.getRcard());
						cpinfo.setPrice((cpinfo.getFoutprice()*member.getDzk()));
						cpinfo.setCount(s.getXcount());
						cpinfo.setAllPrice(s.getXcount()*cpinfo.getFoutprice()*member.getDzk());
						arr.add(cpinfo);
				}
				obj.put("code", 0);
				obj.put("msg", "查询成功");
				obj.put("count", 1000);
				obj.put("data", arr);
			}
		
		return obj.toString();
	}*/
	
	
	
	@RequestMapping(params="method=all")
	@ResponseBody
	public String pageCpType(OutcpEntity pz,HttpServletRequest request){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<OutcpEntity> ar = outcpService.pageOutcp(pz);
		for (OutcpEntity out : ar) {
			out.setAllPrice(out.getFoutprice()*out.getXcount());
			out.setPrice(out.getFoutprice()*out.getXcount()*out.getDzk());
		}
		int count = outcpService.getCount();
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=allpp")
	@ResponseBody
	public String allp(OutcpEntity pz,HttpServletRequest request){
		pz.setPage((pz.getPage()-1)*pz.getLimit());
		List<OutcpEntity> ar = outcpService.page(pz);
		for (OutcpEntity out : ar) {
			out.setAllPrice(out.getFoutprice()*out.getXcount());
			out.setPrice(out.getFoutprice()*out.getXcount()*out.getDzk());
		}
		int count = outcpService.getCount1(pz.getFid());
		
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "查询成功");
		obj.put("count", count);
		obj.put("data", ar);
		
		return obj.toString();
	}
	
	@RequestMapping(params="method=add")
	@ResponseBody
	public int addCpType(OutcpEntity Outcp,HttpServletRequest request){
		int did=0;
		HttpSession session = request.getSession();
		//购物车数据fid cid xcount
		List<ShopCar> all = (List<ShopCar>) request.getSession().getAttribute("shop");
		String rcard = (String) session.getAttribute("rcard");
		UserEntity user = (UserEntity) session.getAttribute("user");
		float pr = (Float) session.getAttribute("pr");
		String gtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		for (ShopCar s : all) {
			//修改数量
			CpinfoEntity selCpinfo = cpinfoService.selCpinfo(s.getFid());
			selCpinfo.setFcount(selCpinfo.getFcount()-s.getXcount());
			
			cpinfoService.updCpinfo(selCpinfo);
			//修改余额 会员积分
			MemberEntity memberEntity = memberService.getRcard(rcard);
			memberEntity.setRmoney(memberEntity.getRmoney()-pr);
			int jf= (int) ((int) (pr/10)+memberEntity.getRjf());
			memberEntity.setRjf(jf);
			memberService.updMember(memberEntity);
			
			
			
			
			OutcpEntity out=new OutcpEntity();
			out.setRid(memberEntity.getRid());
			out.setFid(selCpinfo.getFid());
			out.setXcount(s.getXcount());
			out.setUid(user.getUid());
			out.setTtime(gtime);
			out.setTflag(1);
			outcpService.addOutcp(out);
			
			session.removeAttribute("shop");
			session.removeAttribute("arr");
			
		}
		return 1;
	}
	
	@RequestMapping(params="method=upd")
	@ResponseBody
	public int updCpType(OutcpEntity Outcp){
		outcpService.updOutcp(Outcp);
		return 1;
	}
	
	@RequestMapping(params="method=sel")
	@ResponseBody
	public OutcpEntity selCpType(OutcpEntity pz){
		OutcpEntity selCarxl = outcpService.selOutcp(pz.getTid());
		return selCarxl;
	}
	@RequestMapping(params="method=allp")
	@ResponseBody
	public List<OutcpEntity> allp(){
		List<OutcpEntity> ar = outcpService.allOutcp();
		return ar;
	}
	
	@RequestMapping(params="method=del")
	public String  del(CpinfoEntity id,HttpServletRequest request){
		List<CpinfoEntity>  a = (List<CpinfoEntity>) request.getSession().getAttribute("arr");
		
		List<CpinfoEntity> cp=new ArrayList<CpinfoEntity>();
 		for (int i = 0; i < a.size(); i++) {
			if(id.getId()==a.get(i).getId()){
				cp.add(a.get(i));
			}
		}
		a.removeAll(cp);
		List<ShopCar> s = (List<ShopCar>) request.getSession().getAttribute("shop");
		List<ShopCar> shopCars=new ArrayList<ShopCar>();
		for (ShopCar shopCar : s) {
			if(shopCar.getId()==id.getId()){
				shopCars.add(shopCar);
			}
		}
		s.removeAll(shopCars);
		return "outcp/add";
		
	}
	
	/*@RequestMapping(params="method=selx")
	public String selx(CpinfoEntity id,HttpServletRequest request){
		List<CpinfoEntity>  arr = (List<CpinfoEntity>) request.getSession().getAttribute("arr");
		CpinfoEntity cpinfo=new CpinfoEntity();
		for (CpinfoEntity c : arr) {
			if(c.getId()==id.getId()){
				cpinfo=c;
			}
		}
		return "outcp/sel";
	}*/
	
	
}
