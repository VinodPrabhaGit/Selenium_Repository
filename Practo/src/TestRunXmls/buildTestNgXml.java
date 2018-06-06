package TestRunXmls;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Libraries.ExcelUtil;

public class buildTestNgXml {

	private static String newline = System.lineSeparator();
	private static ExcelUtil exUtl;
	private static String controlFileName = ".\\src\\TestController\\controlFile.xlsx";
	private static String testNgxmlfile = ".\\src\\TestRunXmls\\testng.xml";
	
	public static void main(String[] args) throws IOException {

		FileWriter fw = new FileWriter(testNgxmlfile);		
		BufferedWriter bf = new BufferedWriter(fw);
		try{
			Set<String> brwList = filterBrowsers(controlFileName);
			
			Iterator<String> brwItr = brwList.iterator();
			
			exUtl = new ExcelUtil(controlFileName, "Sheet1");
			int rowcnt = exUtl.RowCount();
			String testClass, testRun_YN;
			
			bf.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+newline);
			bf.write("<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\">"+newline);
			bf.write("<suite name=\"Suite\" parallel=\"tests\" thread-count=\""+rowcnt+"\">"+newline);
			while(brwItr.hasNext()){
				String txtbrower = brwItr.next();
				bf.write("<test name=\""+txtbrower+"TestCase\" preserve-order=\"false\">"+newline);
				bf.write("<parameter name=\"browser\" value=\""+txtbrower+"\"/>"+newline);
				bf.write("<classes>"+newline);				
				for(int rw=1;rw<=rowcnt;rw++){
					if(txtbrower.equalsIgnoreCase(exUtl.GetCellData(rw, 1))){
						testClass = exUtl.GetCellData(rw, 0);
						testRun_YN = exUtl.GetCellData(rw, 2);
						if(testRun_YN.equalsIgnoreCase("Y") && (!testClass.isEmpty())){
							bf.write("<class name=\"testCases."+testClass+"\"/>"+newline);
						}
					}			
				}
				bf.write("</classes>"+newline);
				bf.write("</test>"+newline);
				
			}
			bf.write("</suite>");
			bf.flush();
			bf.close();
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("TestNG Xml file constuction done sucessfully!");

	}
	
	private static Set<String> filterBrowsers(String xlFileName) throws IOException{
		Set<String> brwSet = new HashSet<String>();
		exUtl = new ExcelUtil(xlFileName, "Sheet1");
		int rwcnt = exUtl.RowCount();
		for(int i=1;i<=rwcnt;i++){
			brwSet.add(exUtl.GetCellData(i,1));	
		}
		return brwSet;		
	}

}
