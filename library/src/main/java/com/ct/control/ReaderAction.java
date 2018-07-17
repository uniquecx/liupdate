package com.ct.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ct.entity.Reader;
import com.ct.entity.ReaderExample;
import com.ct.entity.Readertype;
import com.ct.entity.ReadertypeExample;
import com.ct.service.ReaderService;
import com.ct.service.ReadertypeService;
import com.ct.vo.ResultMsgVo;
import com.ct.vo.ResultVo;

@Controller
@RequestMapping("/reader")
public class ReaderAction {
	@Autowired
	private ReaderService readerService;
	@Autowired
	private ReadertypeService readertypeService;
	
	@RequestMapping("/reader")
	public String reader(){
		return "reader";
	}
	
	@RequestMapping("/getReader")
	@ResponseBody
	public ResultMsgVo getReader(Integer page,Integer rows){
		ResultMsgVo vo=new ResultMsgVo();
		 if(!(page!=null&&!page.equals("")&&page!=0)){
			  page=1;
		  }
		  if(!(rows!=null&&!rows.toString().equals("")&&!rows.toString().equals("0"))){
			  rows=10;
		  }
		ReaderExample example=new ReaderExample();
		example.setPageNow(page);
		example.setPageSize(rows);
		int total=readerService.countByExample(example);
		example.setTotal(total);
		List<Reader> list=readerService.selectForPage(example);
		vo.setTotal(total);
		vo.setRows(list);
		return vo;
	}
	
	@RequestMapping("/addReader")
	@ResponseBody
	public int addReader(String rname,String sex,String phone,String readertype,String file) throws IOException{
	 
		//图片上传成功后，将图片的地址写到数据库
        String filePath = "E:\\upload\\images";//保存图片的路径
        //获取原始图片的拓展名
        String originalFilename = file.substring(file.lastIndexOf(".")+1);
        //新的文件名字
        String newFileName = UUID.randomUUID()+originalFilename;
        System.out.println(newFileName);
        //把本地文件上传到封装上传文件位置的全路径
        Reader reader=new  Reader();
        reader.setPhone(Integer.parseInt(phone));
        reader.setRname(rname);
        reader.setReadertype(readertype);
        reader.setSex(sex);
        reader.setPhoto(newFileName);
        reader.setNumber(0);
        int i=readerService.insert(reader);
         copyFile(file, filePath+"\\"+newFileName);
		return i;
		
	}
	//update
	@RequestMapping("/updateReader")
	@ResponseBody
	public int updateReader(String rname,String sex,String phone,String readertype,String file,String readerid){
		Reader reader=new Reader();
		reader.setReaderid(Integer.parseInt(readerid));
		reader.setSex(sex);
		reader.setReadertype(readertype);
		reader.setRname(rname);
		 reader.setPhone(Integer.parseInt(phone));
		 if(file!=null&&!file.trim().equals("")){
		//图片上传成功后，将图片的地址写到数据库
        String filePath = "E:\\upload\\images";//保存图片的路径
        //获取原始图片的拓展名
        String originalFilename = file.substring(file.lastIndexOf(".")+1);
        //新的文件名字
        String newFileName = UUID.randomUUID()+originalFilename;
        System.out.println(newFileName);
        //把本地文件上传到封装上传文件位置的全路径
        copyFile(file, filePath+"\\"+newFileName);
        reader.setPhoto(newFileName);
		 }
       int i= readerService.updateByPrimaryKeySelective(reader);
       return i;
		
		
	}
	 public static void copyFile(String src,String target)  
     {     
         File srcFile = new File(src);    
            File targetFile = new File(target);    
            try {    
                InputStream in = new FileInputStream(srcFile);     
                OutputStream out = new FileOutputStream(targetFile);    
                byte[] bytes = new byte[1024];    
                int len = -1;    
                while((len=in.read(bytes))!=-1)  
                {    
                    out.write(bytes, 0, len);    
                }    
                in.close();    
                out.close();    
            } catch (FileNotFoundException e) {    
                e.printStackTrace();    
            } catch (IOException e) {    
                e.printStackTrace();    
            }    
            System.out.println("文件复制成功");   


     }  
	 //getType
	 @RequestMapping("/getType")
	 @ResponseBody
	 public List<ResultVo> getType(){
		 List<ResultVo> list2=new ArrayList<ResultVo>();
		 ReadertypeExample example=new ReadertypeExample();
		 List<Readertype> list=readertypeService.selectByExample(example);
	for (Readertype readertype : list) {
		ResultVo vo=new ResultVo();
		vo.setId(readertype.getRid());
		vo.setText(readertype.getType());
		list2.add(vo);
	}
	return list2;
	 }
	 
	 //deleteReader
	 @RequestMapping("/deleteReader")
	 @ResponseBody
	 public int deleteReader(HttpServletRequest request){
		 try{
				String ids = request.getParameter("ids");
				JSONArray idsList = JSONArray.fromObject(ids);
				for(int i=0;i<idsList.size();i++){
				 int readerid=(int) idsList.get(i);
				 readerService.deleteByPrimaryKey(readerid);
				}
				}catch(Exception e){
					e.printStackTrace();
					return 0;
				}
			
				
				return 1;
		 
	 }

}
