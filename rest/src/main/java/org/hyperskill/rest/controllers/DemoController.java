package org.hyperskill.rest.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@RestController
public class DemoController {
    private static final Map<String, BufferedImage> images = Map.of(
            "green", createImage(Color.GREEN),
            "MAGENTA", createImage(Color.MAGENTA)
    );
    
    @GetMapping(path = "/hello")
    public void hello(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/plain");
        response.getWriter().write("Hello World");
    }
    
    @GetMapping("/image")
    public ResponseEntity<BufferedImage> getImage(@RequestParam String name,
                                                  @RequestParam String mediaType) {
        BufferedImage image = images.get(name);
        if (image == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mediaType))
                .body(image);
    }
    
    private static BufferedImage createImage(Color color) {
        BufferedImage image = 
                new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.createGraphics();
        graphics.setColor(color);
        graphics.fillRect(0, 0, 20, 20);
        graphics.dispose();
        
        return image;
    }
}
