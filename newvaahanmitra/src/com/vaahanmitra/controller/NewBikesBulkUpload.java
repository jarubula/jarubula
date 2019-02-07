package com.vaahanmitra.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vaahanmitra.dao.AddBikeDao;
import com.vaahanmitra.daoImpl.AddBikeDaoImpl;
import com.vaahanmitra.model.NewBike;

/**
 * Servlet implementation class NewBikesBulkUpload
 */
public class NewBikesBulkUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBikesBulkUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename ="",returnstring="";
		List<NewBike> al=new ArrayList<NewBike>();
		
		/*-------------------------*/
		String RealPath = getServletContext().getRealPath("/images")+File.separator;
	//	System.out.println(RealPath);
		String imagePath = RealPath+"ServiceImage.png";
	//	System.out.println(imagePath);
		String base64Image = "";
		File file1 = new File(imagePath);
		InputStream imageInFile = null;
		try {
			imageInFile = new FileInputStream(file1);
			// Reading a Image file from file system
			byte imageData[] = new byte[(int) file1.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		
		/*--------------------*/
		
		RequestDispatcher rd=request.getRequestDispatcher("./AddNewBikes.jsp");
		
		try {
			boolean ismultipart=ServletFileUpload.isMultipartContent(request);
			if(!ismultipart){
				
			}else{
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items = null;
			
			try{
			items = upload.parseRequest(request);
			}catch(Exception e){
			}
			
			boolean b=false;
			Iterator itr = items.iterator();
			while(itr.hasNext()){
			FileItem item = (FileItem)itr.next();
			if(item.isFormField()){
//			System.out.println("Form field here "+item.getFieldName());
			}else{
			String itemname = item.getName();
			if((itemname==null || itemname.equals(""))){
			continue;
			}
			filename = FilenameUtils.getName(itemname);
			//System.out.println("File Name is "+filename);
			//FileInputStream file = new FileInputStream(new File(filename));
			InputStream file =item.getInputStream();
			Workbook workbook=null;
			DataFormatter objDefaultFormat = new DataFormatter();// new added code
			FormulaEvaluator objFormulaEvaluator =null;
			//Create Workbook instance holding reference to .xlsx file
			if(filename.endsWith(".xls"))
			{
				workbook = new HSSFWorkbook(file);
				objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);// new added code
			}
			else
				if(filename.endsWith(".xlsx"))
				{
					workbook = new XSSFWorkbook(file);
					objFormulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) workbook);// new added code
				}
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			int rows=1,cols=1,count=0;
			int lastrow=sheet.getLastRowNum()+1;		
			while (rowIterator.hasNext()){
			Row row = rowIterator.next();
			
			if(rows>=2 && rows<=lastrow)
			{
				Cell cellValue = null;
				try {
					cellValue=row.getCell(0);
					if(cellValue==null || cellValue.equals(""))
					{}
					else
					{
						NewBike newbike=new NewBike();
						
						cellValue=row.getCell(1);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setBIKE_BRAND(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(2);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setBIKE_MODEL(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(3);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setVARIANT_NAME(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(4);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setCOLOR(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(5);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setBIKE_PRODUCTION_YEAR(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(6);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setENGINE_TYPE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(7);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setDISPLACEMENT_CC(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(8);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setMAX_POWER(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(9);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setMAX_TORQUE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(10);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setBORE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(11);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setSTROKE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(12);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setFUEL_SYSTEM(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(13);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setFUEL_TYPE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(14);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setIGNITION(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(15);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setDIGITAL_FUEL_INDICATOR(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(16);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setENGINE_STARTING(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(17);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setNO_OF_GEARS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(18);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setFRONT_BRAKE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(19);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setREAR_BRAKE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(20);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setMILEAGE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(21);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setTOP_SPEED(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(22);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setCHASSIS_TYPE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(23);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setFRONT_SUSPENSION(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(24);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setREAR_SUSPENSION(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(25);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setTYRE_TYPE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(26);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setFRONT_TYRE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(27);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setREAR_TYRE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(28);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setWHEEL_SIZE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(29);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setWHEEL_TYPE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(30);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setLENGTH(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(31);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setWIDTH(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(32);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setHEIGHT(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(33);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setWHEEL_BASE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(34);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setGROUND_CLEARANCE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(35);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setFUEL_CAPACITY(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(36);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setKERBWEIGHT(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(37);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setBATTERY_CAPACITY(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(38);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setHEAD_LAMP(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(39);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setSTANDARD_WARRANTY_YEARS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(40);
						objFormulaEvaluator.evaluate(cellValue);
						newbike.setSTANDARD_WARRANTY_KMS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
												
//						newbike.setImage(imageInFile);
						al.add(newbike);
					}
				} catch (Exception e) {
					count++;
				}
				
				}
			
			rows++;
			}

			AddBikeDao cardao=new AddBikeDaoImpl();
			
			b=cardao.addNewBikes(al);
			if(b)
			{
				returnstring="New Bikes Inserted Successfully.....";
			}
			else
			{
				returnstring="Please Check the Uploaded File once and Upload..";
			}
			}
			}
			
			}

			}catch(Exception e){
				e.printStackTrace();
			}
			
			request.setAttribute("returnstring", returnstring);
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
