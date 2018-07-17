package com.ct.control;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ct.dao.BookDao;
import com.ct.entity.Book;
import com.ct.service.BookService;



@Controller
@RequestMapping("/photo")
public class PhotoAction {
	@Autowired
	private BookService bookService;
	@RequestMapping("/")
	public String Photo(){
		return "photo";
	}
	@RequestMapping("/uploadPhoto")
	@ResponseBody
	public int  uploadPhoto(@RequestParam(value="file",required=false )CommonsMultipartFile file) throws IOException{
/*		
			//从request中获取输入流信息  
	        InputStream fileSource =  file.getInputStream();
	        //创建存储在服务器的路径信息  
	        String tempFileName = "H:/tempFile";  
	        //指向临时文件  
	        File tempFile = new File(tempFileName);  
	        //outPutStream输出流指向临时文件  
	        FileOutputStream outputStream = new FileOutputStream(tempFile);   
	        //每次读取文件字节  
	        byte b[] = new byte[1024];  
	        int n;  
	        while((n=fileSource.read(b))!=-1){  
	            outputStream.write(b,0,n);  
	        }  
	          
	        //关闭输出输入流  
	        fileSource.close();  
	        outputStream.close();  
	        file.transferTo(new File(tempFileName));*/
		try{
        //图片上传成功后，将图片的地址写到数据库
        String filePath = "E:\\upload\\images";//保存图片的路径
        //获取原始图片的拓展名
        String originalFilename = file.getOriginalFilename();
        //新的文件名字
        String newFileName = UUID.randomUUID()+originalFilename;
        //封装上传文件位置的全路径
        File targetFile = new File(filePath,newFileName); 
        //把本地文件上传到封装上传文件位置的全路径
        file.transferTo(targetFile);
        Book book=new Book();
        book.setBookname("计算机网络");
        book.setPhoto("images/"+newFileName);
        bookService.insert(book);
	     
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
		
	}
	@RequestMapping("/getImage")
	@ResponseBody
	public String  getImage(int bookid){
		bookService.selectByPrimaryKey(bookid).getPhoto();
		return bookService.selectByPrimaryKey(bookid).getPhoto();
		
		
		
	}
	

}
