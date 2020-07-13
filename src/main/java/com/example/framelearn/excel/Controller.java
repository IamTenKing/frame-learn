package com.example.framelearn.excel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jt
 * @date 2020-7-11
 */
@RestController
@RequestMapping("/")
public class Controller {



    @GetMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {


        ExcelGenerator.output3(response);





    }


}
