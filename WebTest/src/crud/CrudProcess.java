package crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import model.BBSItem;
import model.BBSList;
import model.BBSPost;
import model.IdSequence;
import model.UserInfo;

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
			int result = sqlSession.insert(namespace+".insertSequenceManager");
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
	
}
