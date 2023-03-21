package com.song.Controller;

import com.song.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {
    @Value("${file-path.path}")
    private String basePath;

    @PostMapping("/upload")
    public Result<String> upload( MultipartFile file) {
        log.info("接收到文件上传请求");
        //获取原始文件名
        if (file.isEmpty()){
            return Result.errorResult(800,"不能上传空的图片");
        }
        String originalFilename = file.getOriginalFilename();
        //获取当前文件后缀
        log.info(originalFilename);
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        //使用uuid生成随机文件名
        String fileName = UUID.randomUUID() + substring;
        //创建目录对象进行判断目录是否存在
        File dir = new File(basePath);
        if (!dir.exists()) {
            //不存在，创建
            dir.mkdirs();
        }
        try {
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.okResult(fileName);
    }

    /**
     * 文件下载
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){
        try {
            //输入流，通过输入流读取文件内容
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));

            //输出流，通过输出流将文件写回浏览器
            ServletOutputStream outputStream = response.getOutputStream();

            response.setContentType("image/jpeg");

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }

            //关闭资源
            outputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
