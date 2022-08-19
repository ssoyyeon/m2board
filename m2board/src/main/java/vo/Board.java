package vo;

public class Board {
   private int boardNo;
   private String boardTitle;
   private String boardWriter;
   private String createDate;
   private int boardViews;
   private int boardNice;
   
   public Board(int boardNo, String boardTitle, String boardWriter, String createDate, int boardViews, int boardNice) {
      super();
      this.boardNo = boardNo;
      this.boardTitle = boardTitle;
      this.boardWriter = boardWriter;
      this.createDate = createDate;
      this.boardViews = boardViews;
      this.boardNice = boardNice;
   }
   public Board() {
	}
   public int getBoardNo() {
      return boardNo;
   }
   public void setBoardNo(int boardNo) {
      this.boardNo = boardNo;
   }
   public String getBoardTitle() {
      return boardTitle;
   }
   public void setBoardTitle(String boardTitle) {
      this.boardTitle = boardTitle;
   }
   public String getBoardWriter() {
      return boardWriter;
   }
   public void setBoardWriter(String boardWriter) {
      this.boardWriter = boardWriter;
   }
   public String getCreateDate() {
      return createDate;
   }
   public void setCreateDate(String createDate) {
      this.createDate = createDate;
   }
   public int getBoardViews() {
      return boardViews;
   }
   public void setBoardViews(int boardViews) {
      this.boardViews = boardViews;
   }
   public int getBoardNice() {
      return boardNice;
   }
   public void setBoardNice(int boardNice) {
      this.boardNice = boardNice;
   }
   @Override
   public String toString() {
      return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardWriter=" + boardWriter
            + ", createDate=" + createDate + ", boardViews=" + boardViews + ", boardNice=" + boardNice + "]";
   }
   
   
}