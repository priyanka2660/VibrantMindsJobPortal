package com.techhub.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techhub.model.StudentLoginModel;
import com.techhub.model.StudentModel;
import com.techhub.model.StudentRegisterModel;
import com.techhub.service.StudProfileService;
import com.techhub.service.StudService;

@Controller
public class StudentController {

/*===========================================parameters=========================================*/
	
	@Autowired
	StudService studSer;
	String str;
    
	@Autowired
	StudProfileService studProfileSer; 
	
    String fileBasePath = "F://files//"; 
    String EXTERNAL_FILE_PATH="F://downloads//";
/*=====================================================================================*/
	

/*======================================= register =========================================================*/
	
	@PostMapping("/regsave")
	public String register( StudentRegisterModel d,Model m)
	{
		
		StudentRegisterModel s= studSer.save(d);
		if(s != null)
		{
			str="Registration Successfully";
		}	
		else
		{
			str="failed..";
		}	
		
	     	m.addAttribute("message",str);

		     	
	     	return "redirect:/studentlogin";
	}
	
	

		
		
	
/*===============================================================================================*/


	
/*======================================studentlogin=======================================================*/
	
	
	@GetMapping("/studentlogin")
	public String studlogin()
	{
		return "StudentLogin";
	}
	
	
	@PostMapping("/studlog")
	public String studlogvalidation(StudentLoginModel x, Model m)
	{
		StudentRegisterModel b=studSer.studValidation(x);
        m.addAttribute("student", b); 
		
		if(b != null)
		{
			return "StudentMaster";
		}	
		else
		{
			return "redirect:/";
		}	
		
	}
	

	
/*=============================================================================================*/	
	
	
/*============================================profile=================================================*/
	
	@GetMapping("/studprofile")
	public String getprofile()
	{
		return "StudentProfile";
	}
	
	@PostMapping("/studsave")
	public String saveProfile(StudentModel s , Model m,HttpServletRequest request, 
            HttpServletResponse response) throws IOException 
	{
		
		/*====================================file upload==================================*/
		MultipartFile n=s.getResume();
		String name=n.getOriginalFilename();
	    s.setFilename(name);
	    Path path = Paths.get(fileBasePath + name);
	    byte[] bytes = n.getBytes();
	    Files.write(path, bytes);
	    /*=======================================================================*/
	    /*========================================downloading==============================================*/
	    /*File file=new File(fileBasePath + name);
	    Path paths = Paths.get(EXTERNAL_FILE_PATH + name);
	    DiskFileItem fileItem = new DiskFileItem("file", "text/plain", false, file.getName(), (int) file.length() , file.getParentFile());
	    fileItem.getOutputStream();
	    MultipartFile  download = new CommonsMultipartFile(fileItem);
	    System.out.println("download file: name:"+download.getOriginalFilename());
	    byte[] b= download.getBytes();
	    Files.write(paths,b);*/		
	    /*==================================================================================================*/
	    System.out.println(name);
		
		StudentModel c=studProfileSer.Studsave(s);
		if(c != null)
		{
			str="Recored save Successfully" ;
			m.addAttribute("promsg",str);
		}	
		else
		{
			str="Recored save failed.."; 
			m.addAttribute("promsg",str);
		}	
		
		return "StudentProfile";
	}
	

	
/*=============================================================================================*/	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
