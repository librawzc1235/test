package com.test.cn.wps.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.cn.wps.service.ExcelService;

import lombok.extern.slf4j.Slf4j;


/**
 * 项目工作中遇到个数据下载的BUG,因为下载的数据量过于庞大,下载速度特慢,有时候不加任何条件的下载还有导致OOM的风险,
 * 然后网上查找资料最后决定使用【阿里的excel】处理方式进行下载,其采用分页的方式下载,下载速度更快,而且不会OOM
 * 现介绍代码如下
 * @author YQD-190211
 *
 */
@Controller
@RequestMapping("/excel")
@Slf4j
public class ExcelController {
	@Autowired
	private ExcelService excelService;
	
	@RequestMapping("/downExcelData")
	public void downExcelData() {
		excelService.
		long startTime = System.currentTimeMillis();
		try {
			// 总记录数
			Integer totalRowCount = offlineFeignBiz.downLoadExcelCount(offlineTransaction);
			
			// 导出EXCEL文件名称
			String fileName = "线下订单列表下载";
			
			// 设置SHEET名称
			String sheetName = "线下订单列表下载";
			
			  // 设置标题
			Table table = new Table(1);
			List<List<String>> titles = new ArrayList<List<String>>();//{"项目名称", "投资人姓名", "状态"};
			titles.add(Arrays.asList("预约ID"));
			titles.add(Arrays.asList("项目编号"));
			titles.add(Arrays.asList("项目名称"));
			table.setHead(titles);
			
			EasyexcelUtil.exportExcel(response, totalRowCount.getModel(), fileName,sheetName, table, new WriteExcelDataDelegated() {

				@Override
				public void writeExcelData(Integer countSql, Integer pageSize, Integer startRowCount,
						ExcelWriter writer, Sheet sheet, Table table) {
					  List<List<String>> dataList = new ArrayList<>();
	                  //limit startRows,size
	                  offlineTransaction.setBeginDigit(startRowCount);
	                  offlineTransaction.setPageSize(pageSize);
	                  ResultBean<List<OfflineTransaction>> result = offlineFeignBiz.downLoadExcelForOrder(offlineTransaction);
	                  if (ResultUtil.success(result) && !CollectionUtils.isEmpty(result.getModel())) {
	                  	result.getModel().forEach(entity -> {
	                          dataList.add(Arrays.asList(
	                          		entity.getId().toString(),
	                          		entity.getProductNo(),
	                          		entity.getProductTitle(),
	                          		entity.getProductPeriod()==null ? null:String.valueOf(entity.getProductPeriod()),
	                          		entity.getRate()==null ? null:String.valueOf(entity.getRate()),
	                          		entity.getDynamicRate()==null ? null:String.valueOf(entity.getDynamicRate()),
	                          		entity.getBuyDate()==null ? null:DateUtil.SDF_YYYY_MM_DD_HH_MM_SS.format(entity.getBuyDate()),
	                          		entity.getValueDate()==null ? null:DateUtil.SDF_YYYY_MM_DD_HH_MM_SS.format(entity.getValueDate()),
	                          		entity.getStopDate()==null ? null:DateUtil.SDF_YYYY_MM_DD_HH_MM_SS.format(entity.getStopDate()),
	                          		entity.getCreator(),
	                          		entity.getReferralEmployeeName(),
	                          		entity.getReferralEmployeeBarchCompanyName(),
	                          		entity.getReferralEmployeeBankCardName(),
	                          		entity.getBranchBankName(),
	                          		entity.getConfirmAmount()==null ? null:String.valueOf(entity.getConfirmAmount()),
	                          		entity.getCommission()==null ? null:String.valueOf(entity.getCommission()),
	                          		entity.getPayBankCardDecode(),
	                          		entity.getInvestorBankname(),
	                          		entity.getInvestorBranchBankname(),
	                          		entity.getPayBankName(),
	                          		entity.getInvestorUserName(),
	                          		entity.getInvestorName(),
	                          		entity.getPicStatus().getName(),
	                          		entity.getInvestorIdType(),
	                          		entity.getInvestorIdNumOrder(),
	                          		StringUtils.isBlank(entity.getInvestorPhoneDecode()) ? null:yanMa(entity.getInvestorPhoneDecode()),
	                          		entity.getContractId(),
	                          		entity.getCreateAgreementTime()==null ? null:DateUtil.SDF_YYYY_MM_DD_HH_MM_SS.format(entity.getCreateAgreementTime()),
	                          		entity.getSignTime()==null ? null:DateUtil.SDF_YYYY_MM_DD_HH_MM_SS.format(entity.getSignTime()),
	                          		entity.getStatus().getName(),
	                          		entity.getInitHoldStatus().getName(),
	                          		entity.getMakingFlagsTitle(),
	                          		entity.getCommissionFlagsTitle(),
	                          		"00".equals(entity.getPayStatus()) ? "未打款":"已打款"
	                          ));
	                      });
	                  }
	                  writer.write0(dataList, sheet, table);
				}
			});
		} catch (IOException e) {
			getLogger().error(e.getMessage(), e, false);
		}
		getLogger().info("线下订单列表下载总耗时："+(System.currentTimeMillis() - startTime), false);
	}

}
