package june11;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class MultipartUploading {

	List<FileItem> items;
	private HashMap<String, String[]> parameterMap;
	private boolean multipart;
	
	public MultipartUploading(HttpServletRequest request) throws Exception {
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		items = upload.parseRequest(request);
		
		if(ServletFileUpload.isMultipartContent(request)) {
			multipart = true; //파라미터 하나에 복수개를 가지고 있으면
		}
		
		parameterMap = new HashMap<String, String[]>();
		
		for(FileItem fileItem : items) {
			String name = fileItem.getFieldName();
			if(fileItem.isFormField()) {//input type = file을 제외한 처리
				String value = "";
				value = new String(fileItem.getString().getBytes("iso-8859-1")); //한글 처리
				String[] values = parameterMap.get(name);
				if(values == null) { 
					values = new String[]{value};
				}else {
					String[] tempValues = new String[values.length+1];
					System.arraycopy(values, 0, tempValues, 0, values.length);
					tempValues[tempValues.length-1] = value;
					values = tempValues;
				}
				parameterMap.put(name, values);
			}
		}
	}
	
	public String getParameter(String filedName) throws UnsupportedEncodingException{
		
		for(int cnt = 0; cnt < items.size(); cnt++) {
			FileItem item = (FileItem)items.get(cnt);
			if(item.getFieldName().equals(filedName)) {
				return item.getString("euc-kr");
			}
		}
		
		return null;
	}
	
	public String[] getParameteValues(String fieldName) throws UnsupportedEncodingException {
		
		if(multipart) {
			String params[] = parameterMap.get(fieldName);
			if(params == null) return null;
			return params;
		}else {
			return null;
		}
		
	}
	
	public String getFilePath(String fieldName) throws UnsupportedEncodingException {
		
		for(int cnt = 0; cnt < items.size(); cnt++) {
			FileItem item = (FileItem)items.get(cnt);
			if(item.getFieldName().equals(fieldName)) {
				return item.getName();
			}
		}
		return null;

	}
	
	public String getFileName(String fieldName) throws UnsupportedEncodingException {
		
		String path = getFilePath(fieldName);
		
		int index1 = path.lastIndexOf("/");		//경로 구분
		int index2 = path.lastIndexOf("\\");	//역슬래쉬 표현은 //두개로 되있어서
		int index = 0;
	
		if(index1 > index2) {
			index = index1;
		}else {
			index = index2;
		}
		
		if(index < 0) {
			return path;
		}else {
			return path.substring(index + 1);
		}
		
	}
	
	public void saveFile(String fieldName, String path) throws Exception {
		
		for(int cnt = 0; cnt < items.size() ;cnt++) {
			FileItem item = (FileItem)items.get(cnt);
			if(item.getFieldName().equals(fieldName)) {
				if(!item.isFormField()) {
					File filePath = new File(path);
					File fileDir = filePath.getParentFile();
					fileDir.mkdir();
					item.write(new File(path));
					return;
				}
			}
		}
	}
	
}
