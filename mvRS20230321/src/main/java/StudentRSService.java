import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Student;

@Path("student/data")
public class StudentRSService {
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentRecord() {
		Student student = new Student();
		student.setFirstName("Elizabeth");
		student.setLastName("Hayden");
		student.setSchool("Little Flower");
		student.setStandard("One");
		student.setRollNumber(1113);
		return student;
	}
	@POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postStudentRecord(Student student){ //回傳值直接變成student的物件
        String result = "Record entered: "+ student;
        return Response.status(201).entity(result).build();
    }

}