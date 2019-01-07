package A;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A {
	static HashMap<String,String> hm= new HashMap<String, String>();
	static HashMap<String,String> mapInFile=new HashMap<String,String>();
	static HashMap<String,String> map;


	public static void B() {
		hm.put("1","A");
        hm.put("2","B");
        hm.put("3","C");
	}
	public static void C() {
		hm.put("4","D");
        hm.put("5","E");
        hm.put("6","F");
	}
	public static void method2(HashMap<String,String> map,HashMap<String,String> map2, HashMap<String,String> map3){
	    //write to file : "fileone"
	    try{
	    File f=new File("filetwo.txt");
	    if(f.exists() && !f.isDirectory()) { 
	        method3(map);
	    }
	    FileOutputStream fos=new FileOutputStream(f);
	        PrintWriter pw=new PrintWriter(fos);
	        if(mapInFile!=null) {
	        	map3 = new HashMap<>(map);
	    		map3.putAll(map2);
	    		map = map3;
	        }
	        for(Map.Entry<String,String> m :map.entrySet()){
	            pw.println(m.getKey()+"="+m.getValue());
	        }

	        pw.flush();
	        pw.close();
	        fos.close();
	    }catch(Exception e){}

	    

	  }
	public static void method3(HashMap<String,String> map){
		
		//read from file 
	    try{
	        File toRead=new File("filetwo.txt");
	        FileInputStream fis=new FileInputStream(toRead);

	        Scanner sc=new Scanner(fis);

	        
	        //read data from file line by line:
	        String currentLine;
	        while(sc.hasNextLine()){
	            currentLine=sc.nextLine();
	            //now tokenize the currentLine:
	            StringTokenizer st=new StringTokenizer(currentLine,"=",false);
	            //put tokens ot currentLine in map
	            mapInFile.put(st.nextToken(),st.nextToken());
	        }
	        fis.close();

	        //print All data in MAP
	        for(Map.Entry<String,String> m :mapInFile.entrySet()){
	            System.out.println(m.getKey()+" : "+m.getValue());
	        }
	    }catch(Exception e){}
	}

	public static void main(String args[]){

		C();
		method3(hm);
		method2(hm,mapInFile,map);       
        //mergeMap();
        //method2(hm,mapInFile,map);    
}
}
