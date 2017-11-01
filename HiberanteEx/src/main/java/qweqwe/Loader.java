package qweqwe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		
		File f = new File(".");
		File[] matchingFiles = f.listFiles((dir, name) -> name.endsWith("txt"));
		
		BufferedReader[] bfr = new BufferedReader[matchingFiles.length];
		
		for(int i = 0; i< matchingFiles.length; i++){
			bfr[i] = new BufferedReader(new InputStreamReader(new FileInputStream(matchingFiles[i])));
		}
		
		
		
		
		
//		try{
//		FileInputStream fs1 = new FileInputStream(new File("1.txt"));
//		BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(""))));
//		FileInputStream fs2 = new FileInputStream(new File("2.txt"));
//		BufferedReader br2 = new BufferedReader(new InputStreamReader(fs2));
//		
//		String strLine1, strLine2;
//		String[] strMass1,strMass2;
//
//		//Read File Line By Line
//		while ((strLine1 = br1.readLine()) != null && (strLine2 = br2.readLine())!= null){
//			strMass1 = strLine1.split(",");
//			strMass2 = strLine2.split(",");
//			
//			Integer chslo1 = Integer.parseInt(strMass1[1]);
//			Integer chslo2 = Integer.parseInt(strMass2[4]);
//			
//			
//			System.out.println(chslo1 * chslo2);
//			
//			
//			
//
//		}
//		}finally {
//			
//		}
	}

}
