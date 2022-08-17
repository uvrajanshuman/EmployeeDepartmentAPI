package util;

import java.util.Arrays;
import java.util.List;

import com.example.EMS.entity.Department;

public class DepartmentTestUtil {
	
	public static final Department RECORD1 = Department.builder()
			.id(1)
			.code("ACC-DLI")
			.name("Accounting - Delhi")
			.build();
	
	public static final String RECORD1_JSON = "{\"id\" : 1, \"code\" : \"ACC-DLI\", \"name\" : \"Accounting - Delhi\"}";
	
	
	public static final Department RECORD2 = Department.builder()
			.id(2)
			.code("HR-DLI")
			.name("Human Resources - Delhi")
			.build();
	
	public static final String RECORD2_JSON = "{\"id\" : 2, \"code\" : \"HR-DLI\", \"name\" : \"Human Resources - Delhi\"}";
	
	public static final Department RECORD3 = Department.builder()
			.id(3)
			.code("PRJT-DLI")
			.name("Projects - Delhi")
			.build();
	
	public static final String RECORD3_JSON = "{\"id\" : 3, \"code\" : \"PRJT-DLI\", \"name\" : \"Projects - Delhi\"}";
	
	public static final List<Department> DEPARTMENT_LIST = Arrays.asList(RECORD1,RECORD2,RECORD3);
	
	public static final String DEPARTMENT_LIST_JSON = "["
			+ RECORD1_JSON
			+","+RECORD2_JSON
			+","+RECORD3_JSON
			+ "]";

	
//	public static final String DEPARTMENT_LIST_JSON = "[{\"id\" : 1, \"code\" : \"ACC-DLI\", \"name\" : \"Accounting - Delhi\"},{\"id\" : 2, \"code\" : \"HR-DLI\", \"name\" : \"Human Resources - Delhi\"},{\"id\" : 3, \"code\" : \"PRJT-DLI\", \"name\" : \"Projects - Delhi\"}]";
}
