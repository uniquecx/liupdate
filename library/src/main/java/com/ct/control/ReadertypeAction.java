package com.ct.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ct.entity.Readertype;
import com.ct.entity.ReadertypeExample;
import com.ct.service.ReaderService;
import com.ct.service.ReadertypeService;

@Controller
@RequestMapping("/readertype")
public class ReadertypeAction {
	@Autowired
	private ReadertypeService readertypeService;
	
	@RequestMapping("/type")
	public String type(){
		return "readertype";
	}
	
	@RequestMapping("/getType")
	@ResponseBody
	public List<Readertype> getType(){
		ReadertypeExample example=new ReadertypeExample();
	return 	readertypeService.selectByExample(example);
	}
 
}
