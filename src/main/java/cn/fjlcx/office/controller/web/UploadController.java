package cn.fjlcx.office.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fjlcx.office.utils.FileUtil;


@Controller
public class UploadController {
	//接收上传文件
	@RequestMapping(value="uploadFile",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	@ResponseBody
	public String uploadFile(@RequestParam("myfile")CommonsMultipartFile myfile,HttpServletRequest req,HttpServletResponse response) throws IOException{
	//设置文件保存的本地路径
	String filePath = req.getSession().getServletContext().getRealPath("/uploadFiles");
	String fileName = myfile.getOriginalFilename();
	String fileType = fileName.split("[.]")[1];
	//为了避免文件名重复，在文件名前加UUID
	//String uuid = UUID.randomUUID().toString().replace("-","");
	String uuidFileName =  fileName;
	File f = new File(filePath+"/"+fileName+"."+fileType);
	//将文件保存到服务器
	FileUtil.upFile(myfile.getInputStream(), uuidFileName, filePath);
	//将视频路径存入数据库
	//news.setNvideo("upload/"+uuidFileName);
	return uuidFileName;
	}
}
