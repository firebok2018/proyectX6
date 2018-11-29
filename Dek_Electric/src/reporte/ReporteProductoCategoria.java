package reporte;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import utils.MySqlConexion;

public class ReporteProductoCategoria {
	private static JasperReport report;
	private static JasperPrint reportFilled;
	private static JasperViewer viewer;
	
	public static void createReport(String path, String valor){
		try {
			Connection con=MySqlConexion.getConexion();
			Map parametro=new HashMap();
			parametro.put("des", valor);
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
