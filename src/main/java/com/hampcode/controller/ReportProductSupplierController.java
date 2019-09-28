package com.hampcode.controller;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.chart.PieChartModel;

import com.hampcode.business.IProductBusiness;
import com.hampcode.dto.ReportProductSupplierDto;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Named
@ViewScoped
public class ReportProductSupplierController implements Serializable {

	@Inject
	private IProductBusiness productBusiness;
	
	private List<ReportProductSupplierDto> reportProductSuppliers;
	private PieChartModel pieModel1;
	
	
	@PostConstruct
	public void init() {
		this.listarProductSupplier();
		this.createPieModel1();
	}

	private void createPieModel1() {
		pieModel1 = new PieChartModel();

		for (ReportProductSupplierDto x : this.reportProductSuppliers) {
			pieModel1.set(x.getSupplier(), x.getQuantityproducts());
		}

		pieModel1.setTitle("Cantidad de Productos Por Proveedor");
		pieModel1.setLegendPosition("w");
		pieModel1.setShowDataLabels(true);
	}

	
	public void listarProductSupplier() {
		try {
			reportProductSuppliers = productBusiness.reportProductForSupplier();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void generatedReport() {

		try {

			Map<String, Object> parametros = new HashMap<String, Object>();
			// parametros.put("", "");
			File jasper = new File(FacesContext.getCurrentInstance().getExternalContext()
					.getRealPath("/resources/reports/reportproductsupplier.jasper"));
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros,
					new JRBeanCollectionDataSource(this.reportProductSuppliers));

			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			response.addHeader("Content-disposition", "attachment; filename=productossupplier.pdf");
			ServletOutputStream stream = response.getOutputStream();

			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public List<ReportProductSupplierDto> getReportProductSuppliers() {
		return reportProductSuppliers;
	}

	public void setReportProductSuppliers(List<ReportProductSupplierDto> reportProductSuppliers) {
		this.reportProductSuppliers = reportProductSuppliers;
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	
	
}
