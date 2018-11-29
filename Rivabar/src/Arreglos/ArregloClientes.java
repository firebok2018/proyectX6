package Arreglos;

import java.io.*;
import clases.Cliente;
import java.util.ArrayList;

public class ArregloClientes {
	
	private ArrayList <Cliente> cli;
	public ArregloClientes(){
		cli = new ArrayList<Cliente>();
		cargarClientes();
	}
	public int tamaño(){
		return cli.size();
	}
	public void eliminar(Cliente c){
		cli.remove(c);
	}
	public Cliente obtener(int pos){
		return cli.get(pos);
	}
	public void adicionar(Cliente c){
		cli.add(c);
	}
	public Cliente buscar(String dni){
		Cliente c;
		for(int i=0;i<tamaño();i++)
		{
			c=obtener(i);
			if(c.getDni().equals(dni))
				return c;
		}
		return null;
	}
	public void grabarClientes(){
		try{
			PrintWriter pw;
			String linea;
			Cliente c;
			pw = new PrintWriter(new FileWriter("Cliente.txt"));
			for (int i=0; i<tamaño(); i++)
			{
				c=obtener(i);
				linea=	c.getDni()+";"+
						c.getNombre()+";"+
						c.getApellido()+";"+
						c.getTelefono();
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e){
			
		}
	}
	public void cargarClientes(){
		try{
			BufferedReader br;
			String linea,dni,nombre,apellido,telefono;
			String s[];
			
			br = new BufferedReader(new FileReader("Cliente.txt"));
			while((linea=br.readLine()) != null){
				s = linea.split(";");
				dni=s[0].trim();
				nombre=s[1].trim();
				apellido=s[2].trim();
				telefono=s[3].trim();
				adicionar(new Cliente(dni,nombre,apellido,telefono));
			}
			br.close();
		}
		catch(Exception e){
			
		}
	}
}
