package com.personnel.action.home;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

import com.personnel.action.mysupport.MyActionSupport;

/**
 * 用于上传头像的Action
 * @author zhouzhenjiang
 *
 */
public class UploadImageAction extends MyActionSupport {
    
    private File image;
    
    private String imageFileName;//struts2框架自动生成的变量

    public File getImage() {
        return image;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    @Override
    public String execute() throws Exception {
        String savePath = ServletActionContext.getRequest().getRealPath("");
        
        savePath = savePath+"\\upload\\";
        
        String exName = "";//扩展名
        String newFileName = "";//新文件名
        
        if(imageFileName.lastIndexOf(".") >-1){
            exName = imageFileName.substring(imageFileName.lastIndexOf("."));
            
        }
        
        String nowTime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());//当前时间 
        newFileName = nowTime + exName;   
        System.out.println("保存的文件名称：" + savePath + newFileName); 

        image.renameTo(new File(savePath + newFileName)); 
        
        JSONObject jsonObject = new JSONObject();
        
        jsonObject.put("imagePath", newFileName);
        
        response.getWriter().write(jsonObject.toString());
        
        return null;
    }
}
