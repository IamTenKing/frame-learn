package com.example.framelearn.excel;

import ch.qos.logback.core.joran.event.BodyEvent;
import com.example.framelearn.excel.bean.BodyContent;
import com.example.framelearn.excel.bean.Row;
import com.example.framelearn.excel.bean.Worksheet;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 类功能描述：generator big data Excel
 *
 * @author WangXueXing create at 19-4-13 下午10:23
 * @version 1.0.0
 */
public class ExcelGenerator {
    public static void main(String[] args) throws FileNotFoundException{
        ExcelGenerator template = new ExcelGenerator();
//        template.output2();
    }

    /**
     * 生成数据量大的时候，该方法会出现内存溢出
     * @throws FileNotFoundException
     */
    public void output1() throws FileNotFoundException{
        StringTemplateGroup stGroup = new StringTemplateGroup("stringTemplate");
        StringTemplate st4 =  stGroup.getInstanceOf("test");
        List<Worksheet> worksheets = new ArrayList<>();

        File file = new File("D:\\output.xls");
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)));

        for(int i=0;i<30;i++){
            Worksheet worksheet = new Worksheet();
            worksheet.setSheet("第"+(i+1)+"页");
            List<Row> rows = new ArrayList<>();
            for(int j=0;j<6000;j++){
                Row row = new Row();
                row.setName1("zhangzehao");
                row.setName2(""+j);
                row.setName3(i+" "+j);
                rows.add(row);
            }
            worksheet.setRows(rows);
            worksheets.add(worksheet);
        }

        st4.setAttribute("worksheets", worksheets);
        writer.write(st4.toString());
        writer.flush();
        writer.close();
        System.out.println("生成excel完成");
    }

    /**
     * 单纯一个sheet写入100万数据还是可能会溢出
     *
     *
     * @throws FileNotFoundException
     */
    public static void output2(HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();


        long startTimne = System.currentTimeMillis();
        StringTemplateGroup stGroup = new StringTemplateGroup("stringTemplate");
        //写入excel文件头部信息
        StringTemplate head =  stGroup.getInstanceOf("template/head");
//        File file = new File("D:\\output3.xls");
//        PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)));
//        writer.print(head.toString());
//        writer.flush();

        //往硬盘文件上写，改为往response里面写
        response.addHeader("Content-Disposition","attachment;filename="+ new String("下载测试.xls".getBytes(),"iso-8859-1"));
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        toClient.write(head.toString().getBytes());
        //先flush把数据刷出去，就可以清除缓存占用内存
        toClient.flush();

        int sheets = 1;
        //excel单表最大行数是65535
        //单纯一个sheet写入100万数据还是可能会溢出
        int maxRowNum = 2;

        //写入excel文件数据信息
        for(int i=0;i<sheets;i++){
            StringTemplate body =  stGroup.getInstanceOf("template/body");
            Worksheet worksheet = new Worksheet();
            worksheet.setSheet(" "+(i+1)+" ");
            worksheet.setColumnNum(3);
            worksheet.setRowNum(maxRowNum);
            List<Row> rows = new ArrayList<>();
            for(int j=0;j<maxRowNum;j++){
                Row row = new Row();
                row.setName1(""+new Random().nextInt(100000));
                row.setName2(""+j);
                row.setName3(i+""+j);
                row.setName4(i+""+j);
                row.setName5(i+""+j);
                row.setName6(i+""+j);
                row.setName7(i+""+j);
                rows.add(row);
            }
            worksheet.setRows(rows);
            body.setAttribute("worksheet", worksheet);
//            writer.print(body.toString());
//            writer.flush();

            /**
             * ﻿
             *  <Worksheet ss:Name=" 1 ">
             *   <Table ss:ExpandedColumnCount="3" ss:ExpandedRowCount="2" x:FullColumns="1"
             *    x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="14.25">
             *
             *     <Row>
             *      <Cell><Data ss:Type="String">89108</Data></Cell>
             *      <Cell><Data ss:Type="String">0</Data></Cell>
             *      <Cell><Data ss:Type="String">00</Data></Cell>
             *     </Row>
             *
             *     <Row>
             *      <Cell><Data ss:Type="String">45252</Data></Cell>
             *      <Cell><Data ss:Type="String">1</Data></Cell>
             *      <Cell><Data ss:Type="String">01</Data></Cell>
             *     </Row>
             *
             *   </Table>
             *  </Worksheet>
             */

            toClient.write(body.toString().getBytes());
            toClient.flush();
            rows.clear();
            rows = null;
            worksheet = null;
            body = null;
            Runtime.getRuntime().gc();
            System.out.println("正在生成excel文件的 sheet"+(i+1));
        }

        //写入excel文件尾部
        toClient.write("</Workbook>".getBytes());
        toClient.flush();
        toClient.close();
        System.out.println("生成excel文件完成");
        long endTime = System.currentTimeMillis();
        System.out.println("用时="+((endTime-startTimne)/1000)+"秒");
    }


    /**
     *
     * 拼接xml的方法，生成文件太大了，远不如easyexcel导出的快速，而且文件小
     *
     *
     * @param response
     * @throws IOException
     */
    public static void output3(HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();


        long startTimne = System.currentTimeMillis();
        StringTemplateGroup stGroup = new StringTemplateGroup("stringTemplate");
        //写入excel文件头部信息
        StringTemplate head =  stGroup.getInstanceOf("template/head");
//        File file = new File("D:\\output3.xls");
//        PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)));
//        writer.print(head.toString());
//        writer.flush();

        //往硬盘文件上写，改为往response里面写
        response.addHeader("Content-Disposition","attachment;filename="+ new String("下载测试.xls".getBytes(),"iso-8859-1"));
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        toClient.write(head.toString().getBytes());
        //先flush把数据刷出去，就可以清除缓存占用内存
        toClient.flush();

        int sheets = 2;
        //excel单表最大行数是65535
        //单纯一个sheet写入100万数据还是可能会溢出
        int maxRowNum = 1000000;

        //写入excel文件数据信息
        for(int i=0;i<sheets;i++){
            //一个body一个sheet
            //先写sheet头
            StringTemplate bodyHead =  stGroup.getInstanceOf("template/bodyHead");

            Worksheet worksheet = new Worksheet();
            worksheet.setSheet(" "+(i+1)+" ");
            worksheet.setColumnNum(3);
            worksheet.setRowNum(maxRowNum);

            bodyHead.setAttribute("worksheet", worksheet);

            toClient.write(bodyHead.toString().getBytes());
            toClient.flush();


            //sheet 内容
            List<Row> rows = new ArrayList<>();
            for(int j=0;j<maxRowNum;j++){
                Row row = new Row();
                row.setName1(""+new Random().nextInt(100000));
                row.setName2(""+j);
                row.setName3(i+""+j);
                row.setName4(i+""+j);
                row.setName5(i+""+j);
                row.setName6(i+""+j);
                row.setName7(i+""+j);
                rows.add(row);
                if(j!=0 && j%10000==0){
                    System.out.println("写入数据："+rows.size());
                    BodyContent bodyContent = new BodyContent();
                    bodyContent.setRows(rows);
                    StringTemplate content =  stGroup.getInstanceOf("template/bodyContent");
                    content.setAttribute("bodyContent", bodyContent);
                    toClient.write(content.toString().getBytes());
                    toClient.flush();
                    //及时清空list，释放
                    rows.clear();
                }

            }

            if((maxRowNum-1)%10000!=0){
                BodyContent bodyContent = new BodyContent();
                bodyContent.setRows(rows);
                StringTemplate content =  stGroup.getInstanceOf("template/bodyContent");
                content.setAttribute("bodyContent", bodyContent);
                toClient.write(content.toString().getBytes());
                toClient.flush();
                rows.clear();
            }

            //sheet 尾部
            toClient.write(" </Table></Worksheet>".toString().getBytes());
            toClient.flush();
            rows.clear();
            rows = null;
            worksheet = null;
            System.out.println("正在生成excel文件的 sheet"+(i+1));
        }

        //写入excel文件尾部
        toClient.write("</Workbook>".getBytes());
        toClient.flush();
        toClient.close();
        System.out.println("生成excel文件完成");
        long endTime = System.currentTimeMillis();
        System.out.println("用时="+((endTime-startTimne)/1000)+"秒");
    }
}