import java.io.File;  
import java.io.FileInputStream;
import java.io.IOException;  
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Appliance {
//all relevant variable from the database	
int type;
String name;
double startUse;
double endUse;
double offPeakStart;
double offPeakEnd;
double midPeakStart;
double midPeakEnd;
double onPeakStart;
double onPeakEnd;
double offPeakRate;
double midPeakRate;
double onPeakRate;
double hourlyConsumption;


public Appliance (int type) throws IOException {//constructor
	
	this.type = type;
	
	FileInputStream fis = new FileInputStream(new File("C:\\Users\\Luka\\Documents\\Career\\SHMS.xlsx"));//change path file to wherever the database is located on your computer
	XSSFWorkbook wb = new XSSFWorkbook(fis);//workbook object to navigate the excel file
	XSSFSheet sheet = wb.getSheetAt(0);//sheet object to navigate sheets within a workbook
	Row row = sheet.getRow(type);//row object to navigate rows within a sheet

	//read in all data from corresponding cells in the DB according to the row specified by the variable "type" which the user sends us when they select from the main menu
	//the main menu was designed to be compatible with the database as the item number of each appliance in the menu, corresponds to it's row in the database
	this.name = row.getCell(1).getStringCellValue();
	this.offPeakStart = row.getCell(2).getNumericCellValue();
	this.offPeakEnd = row.getCell(3).getNumericCellValue();
	this.midPeakStart = row.getCell(4).getNumericCellValue();
	this.midPeakEnd = row.getCell(5).getNumericCellValue();
	this.onPeakStart = row.getCell(6).getNumericCellValue();
	this.onPeakEnd = row.getCell(7).getNumericCellValue();
	this.offPeakRate = row.getCell(8).getNumericCellValue();
	this.midPeakRate = row.getCell(9).getNumericCellValue();
	this.onPeakRate = row.getCell(10).getNumericCellValue();
	this.hourlyConsumption = row.getCell(11).getNumericCellValue();
	this.startUse = row.getCell(12).getNumericCellValue();
	this.endUse = row.getCell(13).getNumericCellValue();
	
}

public double calculateCost() { //currently limited to just 1 of the 3 rates ie. no overlap
	//this method calculates a monthly cost projection based on the use time and end time and other information from the database like the energy consumption of each appliance and varying electricity rates
	if ((startUse >= offPeakStart) && (endUse <= offPeakEnd)) {
		return ((endUse - startUse) * offPeakRate * hourlyConsumption * 30);
	}
	else if ((startUse >= midPeakStart) && (endUse <= midPeakEnd)) {
		return ((endUse - startUse) * midPeakRate * hourlyConsumption * 30);
	}
	else return ((endUse - startUse) * onPeakRate * hourlyConsumption * 30);
}

public void setStartUse(double start) {//allows user to change the start time of an appliance
	this.startUse = start;
}

public void setEndUse(double end) {//allows the user to change the end time of an appliance
	this.endUse = end;
}

public double getType() {
	return type;
}

public String getName() {
	return name;
}
}