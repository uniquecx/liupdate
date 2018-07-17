package com.ct.control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ct.entity.Manager;
import com.ct.entity.Menu;
import com.ct.service.ManagerService;
import com.ct.service.MenuService;
import com.ct.vo.MenuVo;

@Controller
@RequestMapping("/login")
public class LoginAction {
 @Autowired
 private ManagerService managerService;
 @Autowired
 private MenuService menuService;

	@RequestMapping("/")
	public String view(){
		return "login";
	}
	//获取验证码
	@RequestMapping("/getcode")
    public void generate(HttpServletResponse response, HttpSession session) {  
        ByteArrayOutputStream output = new ByteArrayOutputStream();  
        String verifyCodeValue = drawImg(output);  
  
        session.setAttribute("CodeValue", verifyCodeValue);  
  
        try {  
            ServletOutputStream out = response.getOutputStream();  
            output.writeTo(out);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
	//画验证码
	private String drawImg(ByteArrayOutputStream output) {  
        String code = "";  
        // �������4���ַ�  
        for (int i = 0; i < 4; i++) {  
            code += randomChar();  
        }  
        int width = 70;  
        int height = 25;  
        BufferedImage bi = new BufferedImage(width, height,  
                BufferedImage.TYPE_3BYTE_BGR);  
        Font font = new Font("Times New Roman", Font.PLAIN, 20);  
        // ����Graphics2D�滭��֤��  
        Graphics2D g = bi.createGraphics();  
        g.setFont(font);  
        Color color = new Color(66, 2, 82);  
        g.setColor(color);  
        g.setBackground(new Color(226, 226, 240));  
        g.clearRect(0, 0, width, height);  
        FontRenderContext context = g.getFontRenderContext();  
        Rectangle2D bounds = font.getStringBounds(code, context);  
        double x = (width - bounds.getWidth()) / 2;  
        double y = (height - bounds.getHeight()) / 2;  
        double ascent = bounds.getY();  
        double baseY = y - ascent;  
        g.drawString(code, (int) x, (int) baseY);  
        g.dispose();  
        try {  
            ImageIO.write(bi, "jpg", output);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return code;  
    } 
	
    private char randomChar() {  
        Random r = new Random();  
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";  
        return s.charAt(r.nextInt(s.length()));  
    }
    
    @RequestMapping("/login")
	public String login(String username,String password,String code,HttpServletRequest request){
		HttpSession session=request.getSession();
		String codevalue=(String) session.getAttribute("CodeValue");
		
		if(code.toUpperCase().equals(codevalue)){
			Manager manager=managerService.selectByPrimaryKey(Integer.parseInt(username));
			if(manager==null){
				System.out.println("用户名不存在");
				return "login";
			}else{
				
				if(manager.getPassword().equals(password)){
					session.setAttribute("name", manager.getName());
					session.setAttribute("password", password);
					session.setAttribute("managerid", manager.getManagerid());
					System.out.println("登陆成功");
				            return "main";
				
				}else{
					System.out.println("密码错误");
					return "login";
				}
			}
			
		}else{
			System.out.println("验证码错误");
			return "login";
		}
		
	}
    //创建菜单
    @RequestMapping("/loadMenuTree")
    @ResponseBody
    public List<MenuVo> loadMenuTree(HttpServletRequest request){
    	menuService.selectRootMenuVoTree();
    	List<MenuVo> list=menuService.createMenuTree();
    	return list;
 
    }
    
    //
    @RequestMapping("/password")
    public String password(){
    	return "updatepassword";
    	
    }
    
    //修改密码
    @RequestMapping("/updatePwd")
    public String updatePwd(HttpServletRequest request,String npassword){
    	HttpSession session=request.getSession();
    	try{
    	
    	int managerid=(int) session.getAttribute("managerid");
    	Manager manager=new Manager();
    	manager.setManagerid(managerid);
    	manager.setPassword(npassword);
    	managerService.updateByPrimaryKey(manager);
    	}catch(Exception e){
    		e.printStackTrace();
    		return "updatepassword";
    	}
    	
    	return "login";
    	
    }
    
    
}
