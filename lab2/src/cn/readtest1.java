package cn;

import java.io.FileInputStream;

import java.io.IOException;

import java.io.InputStream;

import jxl.Cell;

import jxl.Sheet;

import jxl.Workbook;

import jxl.read.biff.BiffException;

public class readtest1 {
     public static  void main (String[] args) throws BiffException,IOException{
    	// 1������excel�ļ�����������
      
    	 String  sFilePath="C:/Users/1122/Desktop/������Լ���/�����������.xls";
 
    	 InputStream is = new FileInputStream(sFilePath);
    	// 2����������������
    	 Workbook rwb = Workbook.getWorkbook(is);
   
    	 // 3����ù������ĸ���,��Ӧ��һ��excel�еĹ��������
  
    	 rwb.getNumberOfSheets();
    
    	 Sheet oFirstSheet = rwb.getSheet(0);// ʹ��������ʽ��ȡ��һ��������Ҳ����ʹ��rwb.getSheet(sheetName);����sheetName��ʾ���ǹ����������

 
    	 //   System.out.println("���������ƣ�" + oFirstSheet.getName());

 
    	 int rows = oFirstSheet.getRows();//��ȡ�������е�������
   
    	 int columns = oFirstSheet.getColumns();//��ȡ�������е�������
   
    	 for (int i = 0; i < rows; i++) {
  
    		 for (int j = 0; j < columns; j++) {

   
    			 Cell oCell= oFirstSheet.getCell(j,i);//��Ҫע����������getCell�����Ĳ�������һ����ָ���ڼ��У��ڶ�����������ָ���ڼ���

   
    			 System.out.println(oCell.getContents()+"\r\n");

         }
     }
     }
}
