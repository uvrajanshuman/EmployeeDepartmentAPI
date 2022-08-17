package util;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.example.EMS.entity.Address;
import com.example.EMS.entity.Employee;

public class EmployeeTestUtil {
	
	public static final Employee RECORD1 = Employee.builder()
			.id(1)
			.name("Anshuman Yuvraj")
			.email("abc@gmail.com")
			.phone("123456789")
			.address(Address.builder()
					.addressLine1("temp street")
					.addressLine2("temp locality")
					.city("temp city")
					.state("BR")
					.country("IN")
					.zipCode("123456")
					.build())
			.department(DepartmentTestUtil.RECORD1)
			.build();
	
	public static final String RECORD1_JSON = "{\r\n"
			+ "        \"id\": 1,\r\n"
			+ "        \"name\": \"Anshuman Yuvraj\",\r\n"
			+ "        \"email\": \"abc@gmail.com\",\r\n"
			+ "        \"phone\": \"123456789\",\r\n"
			+ "        \"address\": {\r\n"
			+ "            \"addressLine1\": \"temp street\",\r\n"
			+ "            \"addressLine2\": \"temp locality\",\r\n"
			+ "            \"city\": \"temp city\",\r\n"
			+ "            \"state\": \"BR\",\r\n"
			+ "            \"country\": \"IN\",\r\n"
			+ "            \"zipCode\": \"123456\"\r\n"
			+ "        },\r\n"
			+ "        \"department\": {\"id\" : 1, \"code\" : \"ACC-DLI\", \"name\" : \"Accounting - Delhi\"}"
			+ "    }";
	
	
	public static final Employee RECORD2 = Employee.builder()
			.id(2)
			.name("Anshuman Yuvraj")
			.email("def@gmail.com")
			.phone("123456789")
			.address(Address.builder()
					.addressLine1("temp street")
					.addressLine2("temp locality")
					.city("temp city")
					.state("BR")
					.country("IN")
					.zipCode("123456")
					.build())
			.department(DepartmentTestUtil.RECORD1)
			.build();
	
	public static final String RECORD2_JSON = "{\r\n"
			+ "        \"id\": 2,\r\n"
			+ "        \"name\": \"Yuvraj\",\r\n"
			+ "        \"email\": \"def@gmail.com\",\r\n"
			+ "        \"phone\": \"123456789\",\r\n"
			+ "        \"address\": {\r\n"
			+ "            \"addressLine1\": \"temp street\",\r\n"
			+ "            \"addressLine2\": \"temp locality\",\r\n"
			+ "            \"city\": \"temp city\",\r\n"
			+ "            \"state\": \"BR\",\r\n"
			+ "            \"country\": \"IN\",\r\n"
			+ "            \"zipCode\": \"123456\"\r\n"
			+ "        },\r\n"
			+ "        \"department\": {\\\"id\\\" : 1, \\\"code\\\" : \\\"ACC-DLI\\\", \\\"name\\\" : \\\"Accounting - Delhi\\\"}"
			+ "    }";
	
	public static final Employee RECORD3 = Employee.builder()
			.id(3)
			.name("Amit")
			.email("xyz@gmail.com")
			.phone("9876543210")
			.address(Address.builder()
					.addressLine1("temp street")
					.addressLine2("temp locality")
					.city("temp city")
					.state("BR")
					.country("IN")
					.zipCode("123456")
					.build())
			.department(DepartmentTestUtil.RECORD1)
			.build();
	
	public static final String RECORD3_JSON = "{\r\n"
			+ "        \"id\": 3,\r\n"
			+ "        \"name\": \"Yuvraj\",\r\n"
			+ "        \"email\": \"def@gmail.com\",\r\n"
			+ "        \"phone\": \"123456789\",\r\n"
			+ "        \"address\": {\r\n"
			+ "            \"addressLine1\": \"temp street\",\r\n"
			+ "            \"addressLine2\": \"temp locality\",\r\n"
			+ "            \"city\": \"temp city\",\r\n"
			+ "            \"state\": \"BR\",\r\n"
			+ "            \"country\": \"IN\",\r\n"
			+ "            \"zipCode\": \"123456\"\r\n"
			+ "        },\r\n"
			+ "        \"department\": {\\\"id\\\" : 1, \\\"code\\\" : \\\"ACC-DLI\\\", \\\"name\\\" : \\\"Accounting - Delhi\\\"}"
			+ "    },";
	
	public static final List<Employee> EMPLOYEE_LIST = Arrays.asList(RECORD1,RECORD2,RECORD3);
	
	public static final String EMPLOYEE_LIST_JSON = "[\r\n"
			+ RECORD1_JSON
			+"," + RECORD2_JSON
			+","+ RECORD3_JSON
			+ "]";
	
}