package Servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CrudProcess;
import june11.ImageUtility;
import june11.MultipartUploading;
import model.SequenceManager;
import model.Writing;

/**
 * Servlet implementation class WriteServlet
 */
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
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

		Writing writing = new Writing();
		MultipartUploading multiPart = null;
		
		try {
			multiPart = new MultipartUploading(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String fileName = multiPart.getFileName("imagename");
		String parentId = multiPart.getParameter("parentid");
		String groupId = multiPart.getParameter("groupid");
		String orderNo = multiPart.getParameter("orderno");
		CrudProcess crud = new CrudProcess();
		
		if(parentId == null || parentId.equals("")) { //�θ���� ���� ���
			//����
			writing.setParentid(0);
			writing.setOrderno(0);

			int maxGroup = crud.selectMaxGroupId();//�׷���̵� �˻�
			maxGroup++;
			
			writing.setGroupid(maxGroup);
		}else { //����� ���
			
		}
		
		String uploadPath = getServletContext().getRealPath("upload_files");
		
		try {
			multiPart.saveFile("imagename", uploadPath+"/"+fileName);
		}catch(Exception e) {}
		
		String tmpPath = uploadPath + "/thumb."+fileName;
		String orgPath = uploadPath + "/"+fileName;
		File orgFile = new File(orgPath);
		File newFile = new File(tmpPath);
		ImageUtility.resize(orgFile, newFile, 50, ImageUtility.RATIO);
		
		writing.setRegisterdate(new Timestamp(System.currentTimeMillis()).toString()); //���� ��¥
		writing.setImagename(fileName);
		writing.setWritername(multiPart.getParameter("writername"));
		writing.setEmail(multiPart.getParameter("email"));
		writing.setPassword(multiPart.getParameter("password"));
		writing.setTitle(multiPart.getParameter("title"));
		writing.setContent(multiPart.getParameter("content"));
		
		try {
			writing.setWritingid(SequenceManager.nextId("writing_info"));
		}catch(Exception e) {}
			//writing_info�� ����. writing_content�� ����
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?CONTENTPAGE=write_result.jsp");
		rd.forward(request, response);
		
	}

}
