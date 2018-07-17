package com.ct.control;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.formula.functions.Rows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ct.entity.Book;
import com.ct.entity.BookExample;
import com.ct.entity.Borrow;
import com.ct.entity.BorrowExample;
import com.ct.entity.Reader;
import com.ct.entity.ReaderExample;
import com.ct.service.BookService;
import com.ct.service.BorrowService;
import com.ct.service.ReaderService;
import com.ct.vo.ResultMsgVo;
import com.ct.vo.UtilDate;

@Controller
@RequestMapping("/borrow")
public class BorrowAction {
	@Autowired
	private BookService bookService;
	@Autowired
	private ReaderService readerService;
	@Autowired
	private BorrowService borrowService;
	@RequestMapping("/borrow")
	public String borrow(){
		return "borrow";
	}
	
	@RequestMapping("/getBook")
	@ResponseBody
	public ResultMsgVo getBook(String bookid){
		System.out.println(bookid);
		BookExample example=new BookExample();
	    ResultMsgVo vo=new ResultMsgVo();
		List<Book> list=new ArrayList<Book>();
		if(bookid!=null&&!bookid.trim().equals("")&&!bookid.equals("null")){
		  Book book= bookService.selectByPrimaryKey(Integer.parseInt(bookid));
		  example.setBookid(Integer.parseInt(bookid));
		  int total=bookService.countByExample(example);
		    list.add(book);
		    vo.setTotal(total);
		    vo.setRows(list);
		    return vo;
		}else{
		List<Book>	 list2=bookService.selectByExample(example);
		int total =bookService.countByExample(example);
	   vo.setRows(list2);
	    vo.setTotal(total);
			return vo;
		}
		
	}
	@RequestMapping("/getReader")
	@ResponseBody
	public ResultMsgVo getReader(String readerid){
		ReaderExample example=new ReaderExample();
	    ResultMsgVo vo=new ResultMsgVo();
		List<Reader> list=new ArrayList<Reader>();
		if(readerid!=null&&!readerid.trim().equals("")&&!readerid.equals("null")){
		  Reader reader= readerService.selectByPrimaryKey(Integer.parseInt(readerid));
	
		  example.setReaderid(Integer.parseInt(readerid));
		  int total=readerService.countByExample(example);
		    list.add(reader);
		    vo.setTotal(total);
		    vo.setRows(list);
		    return vo;
		}else{
		List<Reader>	 list2=readerService.selectByExample(example);
		int total =readerService.countByExample(example);
	   vo.setRows(list2);
	    vo.setTotal(total);
			return vo;
		}
		
	}
	@RequestMapping("/getBorrow")
	@ResponseBody
	public ResultMsgVo getBorrow(Integer rows,Integer page) throws Exception{
		ResultMsgVo vo=new ResultMsgVo();
		BorrowExample example=new BorrowExample();
		  if(!(page!=null&&!page.equals("")&&page!=0)){
			  page=1;
		  }
		  if(!(rows!=null&&!rows.toString().equals("")&&!rows.toString().equals("0"))){
			  rows=10;
		  }
		  example.setPageSize(rows);
		  example.setPageNow(page);
		  int total=borrowService.countByExample(example);
		  List<Borrow> list=borrowService.selectForPage(example);
		  for (Borrow borrow : list) {
			if(borrow.getJdate()!=null&&!borrow.getJdate().equals("")){
				borrow.setJdate(new UtilDate().Date1(borrow.getJdate()));
			}
			if(borrow.getYdate()!=null&&!borrow.getYdate().equals("")){
				borrow.setYdate(new UtilDate().Date1(borrow.getYdate()));
			}
			if(borrow.getGdate()!=null&&!borrow.getGdate().equals("")){
				borrow.setGdate(new UtilDate().Date1(borrow.getGdate()));
			}
		}
		  vo.setRows(list);
		  vo.setTotal(total);
		return vo;
		
	}
	
	@RequestMapping("/borrowBook")
	@ResponseBody
	public int borrowBook(String bookid,String bookname,String readerid,String rname,String phone ,HttpServletRequest request){
		try{
		HttpSession session=request.getSession();
		int jadmin=(int) session.getAttribute("managerid");
		Borrow borrow=new Borrow();
		borrow.setReaderid(Integer.parseInt(readerid));
		borrow.setBookid(Integer.parseInt(bookid));
		borrow.setBookname(bookname);
		borrow.setCount(0);
		borrow.setBack(0);
		borrow.setPhone(Integer.parseInt(phone));
		borrow.setJdate(new UtilDate().Date3());
		borrow.setJadmin(jadmin);
		borrow.setRname(rname);
		borrow.setYdate(new UtilDate().Date6());
		int i=borrowService.insertSelective(borrow);
		
		Book book=new Book();
		book.setStatus("不在库");
		book.setBookid(Integer.parseInt(bookid));
		bookService.updateByPrimaryKeySelective(book);
		Reader reader=new Reader();
		int number=readerService.selectByPrimaryKey(Integer.parseInt(readerid)).getNumber()+1;
		reader.setReaderid(Integer.parseInt(readerid));
		reader.setNumber(number);
		readerService.updateByPrimaryKeySelective(reader);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	
		
	}
	@RequestMapping("/renew")
	@ResponseBody
	public int renew(String readerid,String bookid) throws Exception{
		int i=0;
BorrowExample example=new BorrowExample();
example.setBookid(Integer.parseInt(bookid));
example.setReaderid(Integer.parseInt(readerid));
	List<Borrow> list=borrowService.selectByExample(example);
	if(list!=null){
		Borrow borrow=list.get(0);
		borrow.setCount(borrow.getCount()+1);
		borrow.setYdate(new UtilDate().Date7(borrow.getYdate()));
		i=borrowService.updateByPrimaryKeySelective(borrow);	
	}
	
	return i;
	
	}
}
