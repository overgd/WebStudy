package model;

import java.sql.SQLException;

import crud.CrudProcess;

public class SequenceManager {

	public synchronized static int nextId(String tableName) throws SQLException { //동시에 처리되면 안되기 때문에 동기화처리를 해줘야 한다.
		
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
