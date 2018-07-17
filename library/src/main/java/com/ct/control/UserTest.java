package com.ct.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ct.entity.Type;
import com.ct.entity.TypeExample;
import com.ct.entity.User;
import com.ct.entity.UserExample;
import com.ct.service.UserService;
import com.ct.vo.ResultVo;




@Controller
@RequestMapping("/test")
public class UserTest {
	@Autowired
	UserService userService;
	
	@RequestMapping("/login")
	public  String userlogin(String username,String password,HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		HashMap<String, Object> map=new HashMap<>();
		map.put("username",username);
		map.put("password",password);
		User user=userService.selectByuser(map);
		if(user==null){
			System.out.println("用户名不存在");
			return "login";
		}else{
			session.setAttribute("password", password);
			session.setAttribute("userid", user.getId());
			session.setAttribute("username", username);	
			
			return "testsuccess";
		}
	}
	@RequestMapping("/getuser")
	@ResponseBody
	public  List<User> getuser(String username,HttpServletRequest request){
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(username);
		UserExample example=new UserExample();
		 if(username!=null&&!username.toString().equals("")){
			  List<User> list=userService.selectByname(username);
				List<User> list2=new ArrayList<>();
				if(list!=null){
				      for (User user : list) {
				    	  if(user.getCreateAt()!=null){
				    			String date1=sDateFormat.format(user.getCreateAt());
				    			user.setDate1(date1);
				    			list2.add(user); 
				    	  }
						
				    	  }
					  }
				return list2;
		  }
		List<User> list=userService.selectByExample(example);
		List<User> list2=new ArrayList<>();
		if(list!=null){
		      for (User user : list) {
		    	  if(user.getCreateAt()!=null){
		    		  
		    			String date1=sDateFormat.format(user.getCreateAt());
		    			user.setDate1(date1);
		    			list2.add(user); 
		    			
		    	  }
				
		    	  }
			  }
		return list2;
	}
	@RequestMapping("/add")
	@ResponseBody
	public int add(String gender,String username,String password,String date) throws Exception{
		User user=new User();
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		int i=0;
		Date date1=sDateFormat.parse(date);
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setCreateAt(date1);
		i=userService.insert(user);
		return i;
		
	}
	
}
