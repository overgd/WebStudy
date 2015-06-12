package Servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import june11.ImageUtility;
import june11.MultipartUploading;
import model.Writing;
import crud.CrudProcess;

/**
 * Servlet implementation class UpdateWritingServlet
 */
public class UpdateWritingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWritingServlet() {
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
		
		MultipartUploading multiPart = null;
		
		try {
			multiPart = new MultipartUploading(request);
		}catch(Exception e)	{}
		
		Writing writing = new Writing(); //변경 정보
		
		String writeid = multiPart.getParameter("id");
		String password = multiPart.getParameter("password");
		
		CrudProcess crud = new CrudProcess();
		Writing oldWriting = crud.selectOneWritingInfo(Integer.parseInt(writeid)); //변경 전 정보 검색
		writing.setWritingid(Integer.parseInt(writeid));
		if(oldWriting.getPassword().equals(password)) { //암호가 일치하는 경우
			String fileName = multiPart.getFileName("imagename");
			if(fileName.equals("")) {//이미지를 변경하지 않는 경우
				writing.setImagename(oldWriting.getImagename());
			}else {
				String path = getServletContext().getRealPath("upload_files");
				String newPath = path + "/" + fileName;
				try {
					multiPart.saveFile("imagename", newPath);
				}catch(Exception e) {}
				String thumbPath = path + "/thumb." + fileName;
				
				File orgFile = new File(newPath);
				File thumbFile = new File(thumbPath);
				
				ImageUtility.resize(orgFile, thumbFile, 50, ImageUtility.RATIO);
				writing.setImagename(fileName);
			}
			
			writing.setTitle(multiPart.getParameter("title"));
			writing.setWritername(multiPart.getParameter("writername"));
			writing.setEmail(multiPart.getParameter("email"));
			writing.setContent(multiPart.getParameter("content"));
			//DB에서 update(writing_info, writing_content)
			crud.updateWritingInfo(writing);
			crud.updateWritingContent(writing);
			
		}else { //암호가 일치하지 않는 경우
			request.setAttribute("RESULT", "FAIL");
		}
		request.setAttribute("id", writeid);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?CONTENTPAGE=update_result.jsp");
		rd.forward(request, response);
	}

}
