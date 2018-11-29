package Arreglos;

import java.util.ArrayList;
import clases.BoxMesa;
import java.io.*;

public class ArregloBoxMesa {
	
	private ArrayList <BoxMesa> bm;
	
	public ArregloBoxMesa(){
		bm=new ArrayList<BoxMesa>();
		cargarbm();
	}
	public void adicionar(BoxMesa b){
		bm.add(b);
	}
	public void eliminar(BoxMesa b){
		bm.remove(b);
	}
	public void reservar(BoxMesa b){
		bm.add(b);
	}
	public BoxMesa buscarMesa(int numero){
		BoxMesa b;
		for(int i=0;i<tamaño();i++)
		{
			b=obtener(i);
			if(numero==b.getNumeroMesa())
				return b;
		}
		return null;
	}
	public int tamaño(){
		return bm.size();
	}
	public BoxMesa obtener(int pos){
		return bm.get(pos);
	}
	
	public void grabarbm(){
		try{
			PrintWriter pw;
			String linea;
			BoxMesa b;
			pw = new PrintWriter(new FileWriter("BoxMesa.txt"));
			for (int i=0; i<tamaño(); i++)
			{
				b = obtener(i);
				linea=	b.getNumeroMesa()+";"+
						b.getNumeroBox()+";"+
						b.getEstado()+";"+
						b.getSona();
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e){
			
		}
	}
	void cargarbm(){
		try{
			BufferedReader br;
			String linea;
			String []s;
			int numeromesa;
			int numerobox;
			int estado;
			int sona;
			br = new BufferedReader(new FileReader("BoxMesa.txt"));
			while((linea=br.readLine())!=null){
				s=linea.split(";");
				numeromesa=Integer.parseInt(s[0].trim());
				numerobox=Integer.parseInt(s[1].trim());
				estado=Integer.parseInt(s[2].trim());
				sona=Integer.parseInt(s[3].trim());
				adicionar(new BoxMesa(numeromesa,numerobox,estado,sona));
			}
			br.close();
		}
		catch(Exception e){
			
		}
	}
	
}
