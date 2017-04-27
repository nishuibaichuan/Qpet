package com.qpet.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.qpet.entity.Picture;
import com.qpet.service.PictureService;
import com.qpet.util.FileUploadUtil;
import com.qpet.vo.Result;

/** 
 * @Desc: (图片管理：查看，后期可以考虑增加，删除和修改功能)
 * @author: 张瑞
 * @date: 2017年1月14日 下午4:34:22  
 * @email:2411685663@qq.com 
 */
@Controller
@RequestMapping("/admin")
public class ImageController {
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping("/iamge/uploadHeadPic")
	@ResponseBody
    public String uploadHeadPic(@RequestParam("file")MultipartFile file,HttpServletRequest request,HttpServletResponse response){
		String saveName = null;
		String dateStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String destDir = "/upload/user/" + dateStr +"/";
		try {
            // 判断文件的MIMEtype
    		if (file != null) {
				String type = file.getContentType();
				if (type == null || !FileUploadUtil.allowUpload(type))
					throw new Exception("请上传允许格式的文件");
			}
    		String fileName = FileUploadUtil.rename(file.getOriginalFilename());
    		int end = fileName.lastIndexOf(".");
    		saveName = fileName.substring(0, end);
            String realPath = request.getSession().getServletContext().getRealPath("/");
            File destFile = new File(realPath+destDir);
            if(!destFile.exists()){
                destFile.mkdirs();
            }
            File f = new File(destFile,saveName + "_src.jpg");
            file.transferTo(f);
            f.createNewFile();
         } catch (Exception e) {
             e.printStackTrace();
         }
		String resourceUrl = request.getSession().getServletContext().getContextPath()+destDir+saveName+ "_src.jpg";
		Picture picture = new Picture();
		picture.setPictureurl(resourceUrl);
		picture.setCreatetime(new Date());
		picture.setCreator("管理员");
		this.pictureService.save(picture);
		return JSON.toJSONString(new Result(resourceUrl, "上传成功!",null));
    }
	
}
