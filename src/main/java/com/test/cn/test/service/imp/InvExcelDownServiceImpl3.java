package com.test.cn.test.service.imp;
//package com.test.cn.test.service.imp;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.collections4.CollectionUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.alibaba.excel.ExcelWriter;
//import com.alibaba.excel.metadata.Sheet;
//import com.alibaba.excel.metadata.Table;
//import com.test.cn.test.entity.InvExcelDown;
//import com.test.cn.test.mapper.InvExcelDownMapper;
//import com.test.cn.test.service.InvExcelDownService;
//import com.test.cn.test.util.DateUtil;
//import com.test.cn.test.util.wps.EasyexcelUtil;
//import com.test.cn.test.util.wps.WriteExcelDataDelegated;
//
//
//@Service
//public class InvExcelDownServiceImpl implements InvExcelDownService {
//
//	private static Logger log = LoggerFactory.getLogger(InvExcelDownServiceImpl.class);
//	
//	@Autowired
//	private InvExcelDownMapper invExcelDownMapper;
//	@Override
//	public void downExcel(InvExcelDown invExcelDown, HttpServletResponse response) throws Exception {
//		long startTime = System.currentTimeMillis();
//		// 总记录数
//		Integer totalRowCount = invExcelDownMapper.queryCount();
//		
//		// 导出EXCEL文件名称
//		String fileName = "Excel下载";
//		
//		// 设置SHEET名称
//		String sheetName = "job日志下载";
//		
//		// 设置标题
//		Table table = new Table(1);
//		List<List<String>> titles = new ArrayList<List<String>>();
//		titles.add(Arrays.asList("ID编号"));
//		titles.add(Arrays.asList("执行器主键ID"));
//		titles.add(Arrays.asList("任务主键ID"));
//		titles.add(Arrays.asList("执行器地址"));
//		titles.add(Arrays.asList("执行器任务handler"));
//		titles.add(Arrays.asList("执行器任务参数"));
//		titles.add(Arrays.asList("执行器任务分片参数"));
//		titles.add(Arrays.asList("失败重试次数"));
//		titles.add(Arrays.asList("调度-时间"));
//		titles.add(Arrays.asList("调度-结果"));
//		titles.add(Arrays.asList("调度-日志"));
//		titles.add(Arrays.asList("执行-时间"));
//		titles.add(Arrays.asList("执行-状态"));
//		titles.add(Arrays.asList("执行-日志"));
//		titles.add(Arrays.asList("告警状态"));
//		table.setHead(titles);
//		
//		EasyexcelUtil.exportExcel(response, totalRowCount, fileName,sheetName, table, new WriteExcelDataDelegated() {
//
//			@Override
//			public void writeExcelData(Integer countSql, Integer pageSize, Integer startRowCount,ExcelWriter writer, Sheet sheet, Table table) {
//				  List<List<String>> dataList = new ArrayList<>();
//                  //limit startRows,size
//				  invExcelDown.setStartRow(startRowCount);
//				  invExcelDown.setPageSize(pageSize);
//                  List<InvExcelDown> result = invExcelDownMapper.downInvExcelDownList(invExcelDown);
//                  if (!CollectionUtils.isEmpty(result)) {
//                  	result.forEach(entity -> {
//                          dataList.add(Arrays.asList(
//                          		entity.getId().toString(),
//                          		entity.getJobGroup() == null ? null:entity.getJobGroup().toString(),
//                          		entity.getJobId() == null ? null:entity.getJobId().toString(),
//                          		entity.getExecutorAddress(),
//                          		entity.getExecutorHandler(),
//                          		entity.getExecutorParam(),
//                          		entity.getExecutorParam(),
//                          		entity.getExecutorFailRetryCount() == null ? null:entity.getExecutorFailRetryCount().toString(),
//                          		entity.getTriggerTime() == null ? null:DateUtil.format(entity.getTriggerTime(),DateUtil.DATEFORMATSECOND),
//                          		entity.getTriggerCode() == null ? null:entity.getTriggerCode().toString(),
//                          		entity.getTriggerMsg(),
//                          		entity.getHandleTime() == null ? null:DateUtil.format(entity.getHandleTime(),DateUtil.DATEFORMATSECOND),
//                          		entity.getHandleCode() == null ? null:entity.getTriggerCode().toString(),
//                          		entity.getHandleMsg(),
//                          		entity.getAlarmStatus() == null ? null:entity.getAlarmStatus().toString()
//                          	));
//                      });
//                  }
//                  writer.write0(dataList, sheet, table);
//			}
//		});
//		log.info("线下订单列表下载总耗时："+(System.currentTimeMillis() - startTime));
//	}
//
//}
