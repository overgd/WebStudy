package crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import model.BBSItem;
import model.BBSList;
import model.BBSPost;
import model.IdSequence;
import model.UserInfo;
import model.Writing;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CrudProcess {

	private final String namespace = "configurations.MyMapper";
	
	private SqlSessionFactory getSqlSessionFactory() {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream; //파일처리
		
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
			return (UserInfo)sqlSession.selectOne(namespace+".selectMemberByPK", id); //검색결과가 하나일 때
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
	
	public Integer selectMaxGroupId() {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			Object result = sqlSession.selectOne(namespace+".selectMaxGroupId");
			if(result == null) {
				return 0;
			}else {
				return Integer.parseInt(String.valueOf(result));
			}
		}finally {
			sqlSession.close();
		}
		
	}
	
	public Integer insertIdSequence(IdSequence idSequence) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			int result = sqlSession.insert(namespace+".insertSequenceManager",idSequence);
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
	
	public Integer selectLastId(String name) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			Object result = sqlSession.selectOne(namespace+".selectLastId", name);
			
			if(result == null) {
				return 0;
			}else {
				return Integer.parseInt(String.valueOf(result));
			}
			
		}finally {
			sqlSession.close();
		}
	}
	
	public Integer updateSequenceManager(IdSequence idSequence) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			int result = sqlSession.update(namespace+".updateSequenceManager", idSequence);
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
	
	public Integer insertWritingContent(Writing writing) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			int result = sqlSession.insert(namespace+".insertWritingContent", writing);
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
	
	public Integer insertWritingInfo(Writing writingInfo) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			int result = sqlSession.insert(namespace+".insertWritingInfo", writingInfo);
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
	
	public List<Writing> selectBBSList() {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
			return sqlSession.selectList(namespace+".selectBBSList");
		
		}finally {
			sqlSession.close();
		}
		
	}
	
	public List<Writing> selectWritingInfo(int writingid) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return sqlSession.selectList(namespace+".selectWritingInfo", writingid);
		}finally {
			sqlSession.close();
		}
	}
	
	public Writing selectOneWritingInfo(int writingid) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return sqlSession.selectOne(namespace+".selectWritingInfo", writingid);
		}finally {
			sqlSession.close();
		}
	}
	
	public String selectWritingContent(int writingid) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return sqlSession.selectOne(namespace+".selectWritingContent", writingid);
		}finally {
			sqlSession.close();
		}
	}
	
	public Integer deleteWritingInfo(int writingid) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			int result = sqlSession.delete(namespace+".deleteWritingInfo", writingid);
			
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
	
	public Integer deleteWritingContent(int writingid) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			int result = sqlSession.delete(namespace+".deleteWritingContent", writingid);
		
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
	
	public Integer updateWritingInfo(Writing writing) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
			String statement = namespace+".updateWritingInfo";
			
			int result = sqlSession.update(statement, writing);
		
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
	
	public Integer updateWritingContent(Writing writing) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
			String statement = namespace+".updateWritingContent";
			
			int result = sqlSession.update(statement, writing);
		
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
	
	public Integer selectMaxOrderIdReply(Writing writing) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			String statement = namespace + ".selectMaxOrderIdReply";
			
			Object result = sqlSession.selectOne(statement, writing);
			
			if(result == null) {
				return 0;
			}else {
				return Integer.parseInt(String.valueOf(result));
			}
		
		}finally {
			sqlSession.close();
		}
		
	}
	
}
