package com.www.wstore.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/img")
public class ImgController {

    // 从配置文件中读取图片存储路径
    @Value("${img.storage.path}")
    private String imageStoragePath;

    /**
     * 通过图片名称获取图片
     * @param fileName 图片文件名（包含扩展名，如test.jpg）
     * @return 图片文件的响应体
     */
    @GetMapping("/{fileName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
        System.out.println("ok");
        try {
            // 构建图片文件的完整路径
            Path imagePath = Paths.get(imageStoragePath).resolve(fileName);
            File imageFile = imagePath.toFile();

            // 检查文件是否存在
            if (!imageFile.exists()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            // 读取图片文件内容
            byte[] imageBytes = Files.readAllBytes(imagePath);

            // 设置响应头（根据文件扩展名设置正确的Content-Type）
            String contentType = getContentType(fileName);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(contentType));
            headers.setContentLength(imageBytes.length);
            System.err.println("cg");
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);

        } catch (IOException e) {
            // 处理文件读取异常
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * 根据文件名获取对应的Content-Type
     */
    private String getContentType(String fileName) {
        if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
            return "image/jpeg";
        } else if (fileName.endsWith(".png")) {
            return "image/png";
        } else if (fileName.endsWith(".gif")) {
            return "image/gif";
        } else if (fileName.endsWith(".webp")) {
            return "image/webp";
        } else {
            // 默认返回二进制流类型
            return "application/octet-stream";
        }
    }
}
