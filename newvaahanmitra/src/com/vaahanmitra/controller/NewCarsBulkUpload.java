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

import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.daoImpl.AddCarDaoImpl;
import com.vaahanmitra.model.NewCar;
/**
 * Servlet implementation class NewCarsBulkUpload
 */
public class NewCarsBulkUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCarsBulkUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename ="",returnstring="";
		List<NewCar> al=new ArrayList<NewCar>();
		
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
		
		RequestDispatcher rd=request.getRequestDispatcher("./AddNewCars.jsp");
		
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
						NewCar newcar=new NewCar();
						
						cellValue=row.getCell(1);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setCAR_BRAND(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(2);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setCAR_MODEL(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(3);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setVARIANT_NAME(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(4);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setNO_OF_GEARS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(5);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setCAR_MAKE_YEAR(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(6);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setENGINE_TYPE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(7);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setENGINE_DISPLACEMENT(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(8);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setNO_OF_CYLINDERS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(9);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setVALVES_PER_CYLINDERS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(10);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setMAX_POWER(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(11);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setMAX_TORQUE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(12);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setFUEL_SUPPLY_SYSTEM(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(13);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setTRANSMISSION_TYPE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(14);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setGEAR_BOX(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(15);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setWHEEL_DRIVE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(16);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setFRONT_SUSPENSION(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(17);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setREAR_SUSPENSION(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(18);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setSTEERING_TYPE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(19);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setTURNING_RADIONS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(20);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setMILEAGE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(21);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setFUEL_TYPE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(22);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setFUEL_TANK_CAPACITY(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(23);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setTOP_SPEED(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(24);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setACCELERATION(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(25);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setFRONT_BRAKE_TYPE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(26);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setRARE_BRAKE_TYPE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(27);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setANTI_LOCK_BRAKING_SYSTEM(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(28);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setTYRE_SIZE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(29);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setWHEEL_SIZE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(30);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setPOWER_STEERING(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(31);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setAIR_CONDITIONER(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(32);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setREAR_AC(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(33);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setSTEERING_ADJUSTMENT(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(34);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setKEYLESS_START(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(35);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setPARKING_SENSORS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(36);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setPARKING_ASSIST(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(37);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setAIR_BAGS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(38);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setSEAT_BELT_WARNING(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(39);
						cellValue=row.getCell(40);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setBODY_TYPE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(41);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setTYRE_TYPE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(42);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setEX_SHOWROOM_PRICE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(43);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setON_ROAD_PRICE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(44);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setENGINE_IMMOBILIZER(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(45);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setCENTRAL_LOCKING_SYSTEM(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(46);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setCHILD_LOCKING_SYSTEM(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(47);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setAUTOMATIC_HEAD_LAMPS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(48);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setFOR_LAMPS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(49);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setTAIL_LAMPS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(50);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setHEAD_LIGHT(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(51);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setHEIGHT_ADJUSTER(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(52);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setMUSIC_SYSTEM(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(53);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setDISPLAY(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(54);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setDISPLAY_SCREEN_REAR_PASSENGERS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(55);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setGPS_NAVIGATION_SYSTEM(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(56);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setSPEAKERS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(57);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setUSB_COMPATIBILITY(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(58);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setMP3_PLAYER(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(59);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setCD_PLAYER(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(60);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setDVD_PLAYER(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(61);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setFM_RADIO(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(62);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setWARRANTY_YEAR(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(63);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setWARRANTY_KMS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(64);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setCLOCK(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(65);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setLOW_FUEL_LEVEL_WARNING(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(66);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setDOOR_CLOSE_WARNING(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(67);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setPOWER_WINDOWS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(68);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setREAR_DETOGGER(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(69);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setREAR_WIPER(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(70);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setRAIN_SENSING_WIPER(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(71);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setNO_OF_DOORS(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(72);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setSEATING_CAPACITY(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(73);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setADJUST_PASSENGER_SEAT(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(74);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setFOLDING_REAR_SEAT(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(75);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setSPLIT_RARE_SEAT(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(76);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setLENGTH(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(77);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setWIDTH(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(78);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setHEIGHT(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(79);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setWHEEL_BASE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(80);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setGROUND_CLEARANCE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(81);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setBOOT_SPACE(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(82);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setKRAB_WEIGHT(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(83);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setBLUETOOTH(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(84);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setTRIP_METER(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(85);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setGEAR_SHIFT_INDICATOR(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						cellValue=row.getCell(86);
						objFormulaEvaluator.evaluate(cellValue);
						newcar.setCOLOR(objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator));
						
//						newcar.setImage(imageInFile);
						al.add(newcar);
					}
				} catch (Exception e) {
					count++;
				}
				
				}
			
			rows++;
			}

			AddCarDao cardao=new AddCarDaoImpl();
			
			b=cardao.addNewCars(al);
			if(b)
			{
				returnstring="New Cars Inserted Successfully.....";
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
