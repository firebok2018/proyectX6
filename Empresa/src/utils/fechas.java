package utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class fechas {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			// TODO Auto-generated method stub
			Date d = new Date();
			
			DateFormat f1= DateFormat.getDateInstance();
			System.out.println(f1.format(d));
			
			DateFormat fh= DateFormat.getTimeInstance();
			System.out.println(fh.format(d));
			
			//tipo de fechas Short,medium.long
			
			DateFormat fs = DateFormat.getDateInstance(DateFormat.SHORT);
			System.out.println(fs.format(d));
			
			DateFormat fm = DateFormat.getDateInstance(DateFormat.MEDIUM);
			System.out.println(fm.format(d));
			
			DateFormat fl = DateFormat.getDateInstance(DateFormat.LONG);
			System.out.println(fl.format(d));
			
			//manera FULL
			DateFormat ff= DateFormat.getDateInstance(DateFormat.FULL);
			System.out.println(ff.format(d));
			
			DateFormat fff= DateFormat.getDateInstance(DateFormat.FULL,Locale.FRANCE);
			System.out.println(fff.format(d));
			
			DateFormat ffe= DateFormat.getDateInstance(DateFormat.FULL,Locale.ENGLISH);
			System.out.println(ffe.format(d));
			
			DateFormat df;
			df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.JAPAN);
			System.out.println("Japon : "+df.format(d));
			
			df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.KOREA);
			System.out.println("Korea : "+df.format(d));
			
			df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
			System.out.println("United States : "+df.format(d));
			System.out.println(d.getDate());
			
		

	}

}
