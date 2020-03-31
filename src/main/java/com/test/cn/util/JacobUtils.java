package com.test.cn.util;

import java.io.File;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class JacobUtils {

	static final int wdFormatPDF = 17;// word转PDF 格式 
	
	public static void word2pdf(String source, String target) {
		long startTime = System.currentTimeMillis();
        ComThread.InitSTA();
        ActiveXComponent app = null; 
        try { 
            app = new ActiveXComponent("Word.Application"); 
            app.setProperty("Visible", false); 
            Dispatch docs = app.getProperty("Documents").toDispatch(); 
            Dispatch doc = Dispatch.call(docs, "Open", source, false, true).toDispatch(); 
            File tofile = new File(target); 
            if (tofile.exists()) { 
                tofile.delete(); 
            } 
            Dispatch.call(doc, "SaveAs", target, wdFormatPDF); 
            Dispatch.call(doc, "Close", false); 
        } catch (Exception e) { 
            System.out.println(e); 
        } finally { 
            if (app != null) { 
                app.invoke("Quit", 0); 
            } 
            ComThread.Release();
            long endTime = System.currentTimeMillis();
            System.out.println("共用时："+(endTime-startTime)+"ms");
        } 
    }
	
	
    public static void word2pdf2(String sfileName, String toFileName) {
    	System.out.println("启动Word...");      
        long start = System.currentTimeMillis();   
        ActiveXComponent app = null;  
        Dispatch doc = null;  
        try {      
        	//调用office word
            app = new ActiveXComponent("Word.Application");      
            app.setProperty("Visible", new Variant(true));  
            Dispatch docs = app.getProperty("Documents").toDispatch();    
            doc = Dispatch.call(docs,  "Open" , sfileName).toDispatch();  
            System.out.println("打开文档..." + sfileName);  
            System.out.println("转换文档到PDF..." + toFileName);      
            File tofile = new File(toFileName);      
            if (tofile.exists()) {      
                tofile.delete();      
            }      
            Dispatch.call(doc,      
                          "SaveAs",      
                          toFileName, // FileName      
                          wdFormatPDF);      
            long end = System.currentTimeMillis();      
            System.out.println("转换完成..用时：" + (end - start) + "ms.");  
              
                
        } catch (Exception e) {      
            System.out.println("========Error:文档转换失败：" + e.getMessage());      
        } finally {  
            Dispatch.call(doc,"Close",true);  
            System.out.println("关闭文档");  
            if (app != null)      
                app.invoke("Quit", new Variant[] {});      
            }  
          //如果没有这句话,winword.exe进程将不会关闭  
           ComThread.Release();
    }
}
