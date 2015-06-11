package june11;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageUploadServlet
 */
public class ImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageUploadServlet() {
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
			String fileName = multiPart.getFileName("UPLOAD_FILE");
			ServletContext context = getServletContext();
			String newPath = context.getRealPath("/upfiles/"+fileName);
			String thumbPath = context.getRealPath("/upfiles/thumb."+fileName);
			
			multiPart.saveFile("UPLOAD_FILE", newPath); //¿øº»
			
			File newFile = new File(newPath);
			File thumbFile = new File(thumbPath);
			
			ImageUtility.resize(newFile, thumbFile, 100, ImageUtility.RATIO);
			
			request.setAttribute("ORG", fileName);
			request.setAttribute("DEST", "thumb."+fileName);
			
			System.out.println(newPath);
			
			RequestDispatcher rd = request.getRequestDispatcher("showImage.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {

			e.printStackTrace();
		
		}
		
	}

}
