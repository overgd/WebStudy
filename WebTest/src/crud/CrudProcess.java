package crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import model.BBSItem;
import model.BBSList;
import model.BBSPost;
import model.UserInfo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CrudProcess {

	private final String namespace = "configurations.MyMapper";
	
	private SqlSessionFactory getSqlSessionFactory() {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream; //����ó��
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		}catch(IOException e) {
			throw new IllegalArgumentException(e);
		}
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		return builder.build(inputStream);
		
	}
	
	public UserInfo selectMemberById(String id) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return (UserInfo)sqlSession.selectOne(namespace+".selectMemberByPK", id); //�˻������ �ϳ��� ��
		}finally {
			sqlSession.close();
		}
	
	}
	
	public Integer selectMaxSeqNo() {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return (Integer)sqlSession.selectOne(namespace+".selectMaxSeqNo");
		}finally {
			sqlSession.close();
		}
		
	}
	
	public Integer insertBBS(BBSPost bbs) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
			int result = sqlSession.insert(namespace+".insertBBSInfo", bbs);
			
			if(result > 0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
			return result;
	
		}finally {
			sqlSession.close();
		}
		
	}
	
	public Integer getBBSCount() {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
			return sqlSession.selectOne(namespace+".selectCount");
		
		}finally {
			sqlSession.close();
		}
	}
	
	public List<BBSList> selectBBSListAll() {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return sqlSession.selectList(namespace+".selectBBSinfo");
		}finally {
			sqlSession.close();
		}
		
	}
	
	public BBSItem selectBBSitem(int seqno) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return sqlSession.selectOne(namespace+".selectBBSitem", seqno);
		}finally {
			sqlSession.close();
		}
		
	}
}
