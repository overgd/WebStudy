package model;

import java.sql.SQLException;

import crud.CrudProcess;

public class SequenceManager {

	public synchronized static int nextId(String tableName) throws SQLException { //���ÿ� ó���Ǹ� �ȵǱ� ������ ����ȭó���� ����� �Ѵ�.
		
		CrudProcess crud = new CrudProcess();
		int count = crud.selectLastId(tableName);
		
		if(count > 0) {
			
			count = count + 1;
			IdSequence idSequence = new IdSequence();
			idSequence.setName(tableName);
			idSequence.setLastid(count);
			crud.updateSequenceManager(idSequence);
			
			return count;
			
		}else {
			
			IdSequence idSequence = new IdSequence();
			idSequence.setName(tableName);
			idSequence.setLastid(1);
			crud.insertIdSequence(idSequence);
			
			return 1;
			
		}
	}
	
}
