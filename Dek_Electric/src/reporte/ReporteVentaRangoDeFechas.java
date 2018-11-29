package reporte;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import utils.MySqlConexion;

public class ReporteVentaRangoDeFechas {
	private static JasperReport report;
	private static JasperPrint reportFilled;
	private static JasperViewer viewer;
	
	public static void createReport(String path, Date valor1, Date valor2){
		try {
			Connection con=MySqlConexion.getConexion();
			Map parametro=new HashMap();
			parametro.put("ini", valor1);
			parametro.put("fin", valor2);
			report=(JasperReport) JRLoader.loadObjectFromFile(path);
			reportFilled=JasperFillManager.fillReport(report, parametro,con);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void showViewer(){
		viewer=new JasperViewer(reportFilled);
		viewer.setVisible(true);
	}
	

}
