package com.ct.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ct.entity.Book;
import com.ct.entity.BookExample;
import com.ct.entity.Type;
import com.ct.entity.TypeExample;
import com.ct.service.BookService;
import com.ct.service.TypeService;

@Controller
@RequestMapping("/type")
public class TypeAction {
	@Autowired
	private TypeService typeService;
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/type")
	public String type(){
		return "type";
	}
	
	@RequestMapping("/getType")
	@ResponseBody
	public List<Type> getType(){
		TypeExample example=new TypeExample();
		List<Type> list=typeService.selectByExample(example);
		return list;
	}
	
	@RequestMapping("/addType")
	@ResponseBody
	public int addType(String booktype){
		Type type=new Type();
		type.setBooktype(booktype);
		int i=typeService.insert(type);
		return i;
	}
	
	@RequestMapping("/updateType")
	@ResponseBody
	public int updateType(String booktype,String typenumber){
		try{
		String oldbooktype=typeService.selectByPrimaryKey(Integer.parseInt(typenumber)).getBooktype();
		Type type=new Type();
		type.setBooktype(booktype);
		type.setTypenumber(Integer.parseInt(typenumber));
		typeService.updateByPrimaryKey(type);
		BookExample example=new BookExample();
		example.setType(oldbooktype);
		List<Book> list=bookService.selectByExample(example);
		if(list!=null){
		for (Book book : list) {
				book.setType(booktype);
				bookService.updateByPrimaryKey(book);
		}
		}
		
	
	}catch(Exception e){
		e.printStackTrace();
		return 0;
	}
		return 1;
	}
	
	@RequestMapping("/deleteType")
	@ResponseBody
	public int deleteType(String typenumber){
		try{
		
		
			 String booktype=typeService.selectByPrimaryKey(Integer.parseInt(typenumber)).getBooktype();
			 BookExample example=new BookExample();
			 example.setType(booktype);
			 List<Book> list=bookService.selectByExample(example);
			 System.out.println(list);
			 if(list!=null&&list.size()>0){
				 return 0;
			 }else{
				 typeService.deleteByPrimaryKey(Integer.parseInt(typenumber));
			 }
			
			
			}catch(Exception e){
				e.printStackTrace();
				return 0;
			}
		
			
			return 1;
	}
}
