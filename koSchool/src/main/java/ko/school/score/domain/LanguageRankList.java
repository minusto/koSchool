package ko.school.score.domain;

public class LanguageRankList {
	//작성자 : 이재승  = 모든과목 랭킹
	private int rank;
	private int standardScore;
	private String studentId;
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getStandardScore() {
		return standardScore;
	}
	public void setStandardScore(int standardScore) {
		this.standardScore = standardScore;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	
	
}
