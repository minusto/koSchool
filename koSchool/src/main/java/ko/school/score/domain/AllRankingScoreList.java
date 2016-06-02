package ko.school.score.domain;

import java.io.Serializable;

public class AllRankingScoreList implements Serializable {
	private int rank;
	private String subjectId;
	private String memberId;
	private String subjectTotal;
	
	public AllRankingScoreList(){}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getSubjectTotal() {
		return subjectTotal;
	}

	public void setSubjectTotal(String subjectTotal) {
		this.subjectTotal = subjectTotal;
	}
	
	
}
