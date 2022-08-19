package service;

import java.util.Map;

public interface IBoardService {
	// 반환값 = List<Board>, int lastPage
	Map<String, Object> getBoardList(int rowPerPage , int currentPage);
}
