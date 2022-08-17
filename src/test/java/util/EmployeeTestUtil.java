package util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.EMS.entity.Address;
import com.example.EMS.entity.Employee;

public class EmployeeTestUtil {
	
	private DepartmentTestUtil deptUtil = new DepartmentTestUtil();
	
	public final Employee RECORD1 = Employee.builder()
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
			.department(deptUtil.RECORD1)
			.build();
	
	public final String RECORD1_JSON = "{\r\n"
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
			+ "        \"department\": "+deptUtil.RECORD1_JSON
			+ "    }";
	
	
	public final Employee RECORD2 = Employee.builder()
			.id(2)
			.name("Yuvraj")
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
			.department(deptUtil.RECORD1)
			.build();
	
	public final String RECORD2_JSON = "{\r\n"
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
			+ "        \"department\": "+deptUtil.RECORD1_JSON
			+ "    }";
	
	public final Employee RECORD3 = Employee.builder()
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
			.department(deptUtil.RECORD1)
			.build();
	
	public final String RECORD3_JSON = "{\r\n"
			+ "        \"id\": 3,\r\n"
			+ "        \"name\": \"Amit\",\r\n"
			+ "        \"email\": \"xyz@gmail.com\",\r\n"
			+ "        \"phone\": \"9876543210\",\r\n"
			+ "        \"address\": {\r\n"
			+ "            \"addressLine1\": \"temp street\",\r\n"
			+ "            \"addressLine2\": \"temp locality\",\r\n"
			+ "            \"city\": \"temp city\",\r\n"
			+ "            \"state\": \"BR\",\r\n"
			+ "            \"country\": \"IN\",\r\n"
			+ "            \"zipCode\": \"123456\"\r\n"
			+ "        },\r\n"
			+ "        \"department\": "+deptUtil.RECORD1_JSON
			+ "    }";
	
	public final List<Employee> EMPLOYEE_LIST = Arrays.asList(RECORD1,RECORD2,RECORD3);
	
	public final String EMPLOYEE_LIST_JSON = "[\r\n"
			+ RECORD1_JSON
			+"," + RECORD2_JSON
			+","+ RECORD3_JSON
			+ "]";
	
	
	public final Map<Integer, Map<String,String>> NAME_DEPT_MAP;
	{
		NAME_DEPT_MAP = new HashMap<>();
		NAME_DEPT_MAP.put(1, Map.of("Anshuman Yuvraj","Accounting - Delhi"));
		NAME_DEPT_MAP.put(2, Map.of("Yuvraj","Accounting - Delhi"));
		NAME_DEPT_MAP.put(3, Map.of("Amit","Accounting - Delhi"));

	}
	
	public final String NAME_DEPT_MAP_JSON = "{\r\n"
			+ "    \"1\": {\r\n"
			+ "        \"Anshuman Yuvraj\": \"Accounting - Delhi\"\r\n"
			+ "    },\r\n"
			+ "    \"2\": {\r\n"
			+ "        \"Yuvraj\": \"Accounting - Delhi\"\r\n"
			+ "    },\r\n"
			+ "    \"3\": {\r\n"
			+ "        \"Amit\": \"Accounting - Delhi \"\r\n"
			+ "    }\r\n"
			+ "}";
	
}