package june11;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
		
			MultipartUploading multiPart = new MultipartUploading(request);
			String title = multiPart.getParameter("TITLE");
			String desc = multiPart.getParameter("DESC");
			String fileName = multiPart.getFileName("UPLOAD_FILE");
			
			ServletContext context = getServletContext();
			String newPath = context.getRealPath("/upfiles/"+fileName); //상대 경로
//			String newPath = "c:/upload_files/"+fileName;				//절대 경로
			System.out.print(newPath);
			multiPart.saveFile("UPLOAD_FILE", newPath);
			response.sendRedirect("uploadResult.jsp?TITLE="+title+"&"+"DESC="+desc+"&FILE_NAME="+fileName);
			
		} catch (Exception e) {
			
			throw new ServletException(e);
		}
		
	}

}
