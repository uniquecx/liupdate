package com.ct.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import com.ct.vo.ResultMsgVo;
import com.ct.vo.ResultVo;
import com.ct.vo.UtilDate;

@Controller
@RequestMapping("/book")
public class BookAction {
	@Autowired
	private BookService bookService;
	@Autowired
	private TypeService typeService;
	
	@RequestMapping("/book")
	public String book(){
		
		return "book";
	}
	@RequestMapping("/getBook")
	@ResponseBody
		public ResultMsgVo selectAllBook(Integer page,Integer rows,String bname,String type,String mindate,String maxdate,HttpServletRequest request,String sts) throws ParseException, UnsupportedEncodingException{
		
		ResultMsgVo vo=new ResultMsgVo();
			BookExample example=new BookExample();
			
	  	  if(!(page!=null&&!page.equals("")&&page!=0)){
			  page=1;
		  }
		  if(!(rows!=null&&!rows.toString().equals("")&&!rows.toString().equals("0"))){
			  rows=10;
		  }
		  if(bname!=null&&!bname.toString().equals("")){
			  String bookname=new String(bname.getBytes("ISO8859-1"), "UTF-8");
			  example.setBname("%"+bookname+"%");
		  }
		  
       
		  if(type!=null&&!type.toString().equals("")){
			  String typename=new String(type.getBytes("ISO8859-1"), "UTF-8");
			  example.setType(typename);;
		  }
		  if(sts!=null&&!sts.toString().equals("")){
			  String status=new String(sts.getBytes("ISO8859-1"), "UTF-8");
			  example.setSts(status);
		  }
		  
		  if(mindate!=null&&!mindate.toString().equals("")){
			  example.setMindate(new UtilDate().Date2(mindate));
		  }
		  if(maxdate!=null&&!maxdate.toString().equals("")){
			  example.setMaxdate(new UtilDate().Date2(maxdate));
		  }
		  
		  example.setPageNow(page);
	      example.setPageSize(rows);
	      int total=bookService.countByExample(example);
	      example.setTotal(total);
	      System.out.println("偏移量"+example.getOffset()+example.getPageSize());
	      List<Book> list=bookService.selectForPage(example);
	      /*if(list!=null){
	      for (Book book : list) {
	    	  if(book.getPressdate()!=null){
			book.setPressdate(new UtilDate().Date1(book.getPressdate()));
	    	  }
		  }
	      }*/
	      vo.setTotal(total);
	      vo.setRows(list);
	      return vo;
		}
	
	//获取图书类别
	@RequestMapping("/getBookClass")
	@ResponseBody
	public  List<ResultVo> getBookClass(){
		List<ResultVo> list2=new ArrayList<ResultVo>();
	TypeExample example=new TypeExample();
		List<Type> list=typeService.selectByExample(example);
		for (Type type : list) {
			ResultVo vo=new ResultVo();
			vo.setId(type.getTypenumber());
			vo.setText(type.getBooktype());
			list2.add(vo);
		}
		return list2;
		
	}
	//addbook
		@RequestMapping("/addBook")
		@ResponseBody
		public int addBook(String bookname,String typeclass,String author,String press,String pressdate,String price,String isbn,String place) throws ParseException{
			Book book=new Book();
			int i=0;
			book.setBookname(bookname);
			book.setType(typeclass);;
			book.setAuthor(author);
			book.setPress(press);
			book.setPressdate(new UtilDate().Date2(pressdate));
			book.setPrice(new BigDecimal(price));
			book.setIsbn(Integer.parseInt(isbn));
			book.setStatus("在库");
			book.setPlace(place);
			i=bookService.insert(book);
			return i;
			
		}
		//updateBook
		@RequestMapping("/updateBook")
		@ResponseBody	
		public int updateBook(String bookid,String bookname,String type,String author,String press,String pressdate,String price,String isbn,String place ) throws ParseException{
			Book book=new Book();
			book.setBookid(Integer.parseInt(bookid));
			book.setBookname(bookname);
			book.setType(type);
			book.setAuthor(author);
			book.setPress(press);
			book.setPressdate(new UtilDate().Date2(pressdate));
			book.setPrice(new BigDecimal(price));
			book.setIsbn(Integer.parseInt(isbn));
			book.setPlace(place);
			int i=bookService.updateByPrimaryKeySelective(book);
		
			return i;
		}
		
		//deletebook
		@RequestMapping("/deleteBook")
		@ResponseBody
		public int deleteBook(HttpServletRequest request){
			try{
			String ids = request.getParameter("ids");
			JSONArray idsList = JSONArray.fromObject(ids);
			for(int i=0;i<idsList.size();i++){
			 int bookid=(int) idsList.get(i);
			 if(bookService.selectByPrimaryKey(bookid).getStatus().equals("在库")){
			 bookService.deleteByPrimaryKey(bookid);
			 }
			}
			}catch(Exception e){
				e.printStackTrace();
				return 0;
			}
		
			
			return 1;
			
		}
		//importBook
		@RequestMapping("/importBook")
		public String  importBook(String uploadname,HttpServletRequest request, HttpServletResponse response) throws ParseException{
			System.out.println("上传的文件名"+uploadname);
			Workbook workbook=null;
			Sheet sheet=null;
			Row row=null;
			 String cellData = null;
			 List<Map<String,String>> list = null;
			 String columns[] = {"书名","类别","作者","出版社","出版时间","价格","isbn","位置"};
			workbook=readExcel(uploadname);
			if(workbook!=null){
			
				 //用来存放表中数据
	            list = new ArrayList<Map<String,String>>();
				//获取第一个sheet
	            sheet = workbook.getSheetAt(0);
	            //获取最大行数
	            int rownum = sheet.getPhysicalNumberOfRows();
	            //获取第一行
	            row = sheet.getRow(0);
	            //获取最大列数
	            int colnum = row.getPhysicalNumberOfCells();
	            for (int i = 1; i<rownum; i++) {
	                Map<String,String> map = new LinkedHashMap<String,String>();
	                row = sheet.getRow(i);
	                if(row !=null){
	                    for (int j=0;j<colnum;j++){
	                        cellData = (String) getCellFormatValue(row.getCell(j));
	                        map.put(columns[j], cellData);
	                    }
	                }else{
	                    break;
	                }
	                list.add(map);
	            }
	       
	            for (Map<String,String> map : list) {
	            	 Set<String> k = map.keySet(); 
	            	 Iterator<String> it = k.iterator();
	                 
	                 while(it.hasNext()){
	                     String key = it.next();
	                     //有了键，就可以通过map集合的get方法获取对应的值
	                     String value =map.get(key);
	                     System.out.println("key:"+key+"---value:"+value);
	                 }
	                 Book book=new Book();
	                
					     
	                    String bookname=map.get("书名");
	                    String type=map.get("类别");
	                    String author=map.get("作者");
	                    String press=map.get("出版社");
	                    String pressdate=new UtilDate().Date2(map.get("出版时间"));
	                    String price=map.get("价格");
	                    String isbn=map.get("isbn");
	                    String place=map.get("位置");
	                    book.setBookname(bookname);                  
	        			book.setType(type);;
	        			book.setAuthor(author);
	        			book.setPress(press);
	        			book.setPressdate(pressdate);
	        			book.setPrice(new BigDecimal(price));
	        			book.setIsbn(Integer.parseInt(isbn));
	        			book.setPlace(place);
	            		bookService.insert(book);
	              }
	              
			}
	            
	            return "book"; 
	            

			}

		   //读取excel
	    public static Workbook readExcel(String filePath){
	        Workbook wb = null;
	        if(filePath==null){
	            return null;
	        }
	        String extString = filePath.substring(filePath.lastIndexOf("."));
	        InputStream is = null;
	        try {
	            is = new FileInputStream(filePath);
	            if(".xls".equals(extString)){
	                return wb = new HSSFWorkbook(is);
	            }else if(".xlsx".equals(extString)){
	                return wb = new XSSFWorkbook(is);
	            }else{
	                return wb = null;
	            }
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return wb;
	    }
	    public static String  getCellFormatValue(Cell cell){
	    	String strCell = "";  
	        switch (cell.getCellType()) {  
	            case Cell.CELL_TYPE_STRING:  
	                strCell = cell.getStringCellValue();  
	                break;  
	            case Cell.CELL_TYPE_NUMERIC:  
	                if (DateUtil.isCellDateFormatted(cell)) {  
	                    //  如果是date类型则 ，获取该cell的date值  
	                    strCell = new SimpleDateFormat("yyyy-MM-dd").format(DateUtil.getJavaDate(cell.getNumericCellValue()));  
	                } else { // 纯数字  
	                    strCell = String.valueOf((int)cell.getNumericCellValue());  
	                }  
	                    break;  
	            case Cell.CELL_TYPE_BOOLEAN:  
	                strCell = String.valueOf(cell.getBooleanCellValue());  
	                break;  
	            case Cell.CELL_TYPE_BLANK:  
	                strCell = "";  
	                break;  
	            default:  
	                strCell = "";  
	                break;  
	        }  
	        if (strCell.equals("") || strCell == null) {  
	            return "";  
	        }  
	        if (cell == null) {  
	            return "";  
	        }  
	        return strCell;  
	    }
	  //导出excel 表，查询内容生成excel表
		@RequestMapping("/exportBook")
		@ResponseBody
		public int  exportBook(Integer page,Integer rows,String bname,String type,String mindate,String maxdate,HttpServletResponse response,String exportroad,String filename,String sts) throws Exception{
			try{
			//第一步，创建一个webbook，对应一个Excel文件  
	        HSSFWorkbook wb = new HSSFWorkbook();  
	        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
	        HSSFSheet sheet = wb.createSheet("table");  
	        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
	        HSSFRow row = sheet.createRow((int) 0);  
	        // 第四步，创建单元格，并设置值表头 设置表头居中  
	        HSSFCellStyle style = wb.createCellStyle();  
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  

	        HSSFCell cell = row.createCell((short) 0);  
	        cell.setCellValue("编号");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 1);  
	        cell.setCellValue("书名");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 2);  
	        cell.setCellValue("类别");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 3);  
	        cell.setCellValue("作者");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 4);  
	        cell.setCellValue("出版社");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 5);  
	        cell.setCellValue("出版时间");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 6);  
	        cell.setCellValue("价格");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 7);  
	        cell.setCellValue("isbn");  
	        cell.setCellStyle(style); 
	        cell = row.createCell((short) 8);  
	        cell.setCellValue("place");  
	   


	        //数据库取数据
			BookExample example=new BookExample();
			
			 if(!(page!=null&&!page.equals("")&&page!=0)){
				  page=1;
			  }
			
				  rows=6000;
			 
			  if(bname!=null&&!bname.toString().equals("")){
				  String bookname=new String(bname.getBytes("ISO8859-1"), "UTF-8");
				  example.setBname("%"+bookname+"%");
			  }
			  
	       
			  String typename=new String(type.getBytes("ISO8859-1"), "UTF-8");
			  if(typename!=null&&!typename.toString().equals("")&&!typename.toString().equals("--请选择--")){
				  example.setType(typename);;
			  }
			  if(sts!=null&&!sts.toString().equals("")){
				  String status=new String(sts.getBytes("ISO8859-1"), "UTF-8");
				  example.setSts(status);
			  }
			  if(mindate!=null&&!mindate.toString().equals("")){
				  example.setMindate(new UtilDate().Date2(mindate));
			  }
			  if(maxdate!=null&&!maxdate.toString().equals("")){
				  example.setMaxdate(new UtilDate().Date2(maxdate));
			  }
			  
			  
			  example.setPageNow(page);
		      example.setPageSize(rows);
		      int total=bookService.countByExample(example);
		      System.out.println("总量："+total);
		      example.setTotal(total);
		  
		      List<Book> list=bookService.selectForPage(example);
		      for (int i = 0; i < list.size(); i++)  
		        {  
		            row = sheet.createRow((int) i + 1);  
		            Book book = (Book) list.get(i);  
		            // 第四步，创建单元格，并设置值  
		            
		            row.createCell((short) 0).setCellValue((long) book.getBookid());  
		            row.createCell((short) 1).setCellValue(book.getBookname());  
		            row.createCell((short) 2).setCellValue( book.getType()); 
		            row.createCell((short) 3).setCellValue(book.getAuthor()); 
		            row.createCell((short) 4).setCellValue(book.getPress()); 
		            row.createCell((short) 5).setCellValue(new UtilDate().Date5(book.getPressdate()));
		            row.createCell((short) 6).setCellValue(book.getPrice().toString()); 
		            row.createCell((short) 7).setCellValue((int)book.getIsbn()); 
		           
		        }  
		   
		     
		      File filenew = new File(exportroad+"/"+filename+".xls");

	          FileOutputStream fout = new FileOutputStream(filenew);  
	          wb.write(fout);  
	          fout.close();  
			}catch( Exception e){
				return 0;
				
			}
	     

	         return 1;
	      


		      
			
		}


}
