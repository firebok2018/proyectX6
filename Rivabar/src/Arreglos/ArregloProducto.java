package Arreglos;

import clases.Producto;
import java.util.ArrayList;
import java.io.*;

public class ArregloProducto {
	private ArrayList<Producto> pro;
	
	public ArregloProducto(){
		pro = new ArrayList<Producto>();
		cargarProductos();
	}
	public int tamaño(){
		return pro.size();
	}
	public void eliminar(Producto p){
		 pro.remove(p);
	}
	public void adicionar(Producto p){
		pro.add(p);
	}
	public Producto obtener(int pos){
		return pro.get(pos);
	}
	public Producto buscar(int codigo){
		Producto p;
		for(int i=0;i<tamaño();i++){
			p=obtener(i);
			if(p.getCodigo()==codigo){
				return p;
			}
		}
		return null;
	}
	public void grabarProductos(){
		try{
			PrintWriter pw;
			String linea;
			Producto p;
			pw = new PrintWriter(new FileWriter("Productos.txt"));
			for (int i=0; i<tamaño(); i++){
				p=obtener(i);
				linea=	p.getCodigo()+";"+
						p.getNombre()+";"+
						p.getTipo()+";"+
						p.getStock()+";"+
						p.getPrecio_vaso()+";"+
						p.getPrecio_botella();
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e){
		}
	}
	public void cargarProductos(){
		try{
			BufferedReader br;
			int codigo;
			String linea,nombre,tipo;
			int stock;
			double preciovaso,preciobotella;
			String s[];
			
			br = new BufferedReader(new FileReader("Productos.txt"));
			while((linea=br.readLine())!=null){
				s = linea.split(";");
				codigo=Integer.parseInt(s[0].trim());
				nombre=s[1].trim();
				tipo=s[2].trim();
				stock=Integer.parseInt(s[3].trim());
				preciovaso=Double.parseDouble(s[4]);
				preciobotella=Double.parseDouble(s[5]);
				adicionar(new Producto(codigo,nombre,tipo,stock,preciovaso,preciobotella));
			}
			br.close();
		}
		catch(Exception e){
		}
	}
	//Metodos adicionales
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 10001;
		else
			return obtener(tamaño()-1).getCodigo() + 1;		
	}
}
