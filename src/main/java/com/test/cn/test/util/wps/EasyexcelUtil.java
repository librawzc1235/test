package com.test.cn.test.util.wps;

import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;

public class EasyexcelUtil {

	private final static Logger logger = LoggerFactory.getLogger(EasyexcelUtil.class);
	 
    /**
     * 
     * @param response
     * @param totalRowCount  查询数据的总条数
     * @param fileName   	 excel的名称
     * @param titles
     * @param writeExcelDataDelegated
     * @throws IOException 
     */
    public static void exportExcel(HttpServletResponse response, Integer totalRowCount, String fileName,String sheetName,Table table, WriteExcelDataDelegated writeExcelDataDelegated) throws IOException {
    	ServletOutputStream out = response.getOutputStream();
    	ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
    	
    	//excel需要多少个sheet
        Integer sheetCount = totalRowCount % ExcelConstant.PER_SHEET_ROW_COUNT == 0 ? 
        		(totalRowCount / ExcelConstant.PER_SHEET_ROW_COUNT) : 
        		(totalRowCount / ExcelConstant.PER_SHEET_ROW_COUNT + 1);
        
        //需要循环写入的最大次数
        Integer previousSheetWriteCount = ExcelConstant.PER_SHEET_WRITE_COUNT;
        
        Integer lastSheetWriteCount = totalRowCount % ExcelConstant.PER_SHEET_ROW_COUNT == 0 ?
        		ExcelConstant.PER_SHEET_WRITE_COUNT :
                (totalRowCount % ExcelConstant.PER_SHEET_ROW_COUNT % ExcelConstant.PER_WRITE_ROW_COUNT == 0 ? 
                		totalRowCount % ExcelConstant.PER_SHEET_ROW_COUNT / ExcelConstant.PER_WRITE_ROW_COUNT : 
                		(totalRowCount % ExcelConstant.PER_SHEET_ROW_COUNT / ExcelConstant.PER_WRITE_ROW_COUNT + 1));

        for (int i = 0; i < sheetCount; i++) {
            // 创建SHEET
            Sheet sheet = new Sheet(i, 0);
            sheet.setSheetName(sheetName + i);
            for (int j = 0; j < (i != sheetCount - 1 ? previousSheetWriteCount : lastSheetWriteCount); j++) {
            	
//            	Integer startRowCount = ExcelConstant.PER_SHEET_WRITE_COUNT * (j+previousSheetWriteCount * i);
//            	writeExcelDataDelegated.writeExcelData(ExcelConstant.PER_SHEET_WRITE_COUNT,ExcelConstant.PER_WRITE_ROW_COUNT,startRowCount,writer,sheet,table);
            	
            	Integer startPage = (j + 1 + previousSheetWriteCount * i);
            	writeExcelDataDelegated.writeExcelDataPage(totalRowCount, startPage, ExcelConstant.PER_WRITE_ROW_COUNT, writer, sheet, table);
            }
        }
        // 下载EXCEL
        downLoadExcel(out, writer, fileName, response);
    }
    
	/**
	 * 下载EXCEL到浏览器
	 * 
	 * @param out
	 * @param writer
	 * @param fileName
	 * @param response
	 * @throws IOException
	 */
	public static void downLoadExcel(ServletOutputStream out, ExcelWriter writer, String fileName,
			HttpServletResponse response) throws IOException {

		try {
			// 下载EXCEL
			response.setHeader("Content-disposition",
					"attachment; filename=" + new String((fileName + ".xlsx").getBytes("utf-8"), "ISO8859-1"));// 设置下载的文件名
			response.setContentType("multipart/form-data");
			response.setCharacterEncoding("utf-8");
			writer.finish();
			out.flush();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
