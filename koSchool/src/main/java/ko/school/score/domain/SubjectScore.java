package ko.school.score.domain;

import java.io.Serializable;

public class SubjectScore implements Serializable {
    private String subjectId;   
    private String midExam;
    private String finalExam;
    private String perfomanceEvaluation;
    private String memberId;
    private int semester;
    private int nesinYear;
   private String[] arrSubjectId;   
   private String[] arrMidExam;
   private String[] arrFinalExam;
   private String[] arrPerformanceEvaluation;
   private String[] arrMemberId;
   private int[] arrNesinYear;

   public SubjectScore(){}
   
   
   
   public String getPerfomanceEvaluation() {
	return perfomanceEvaluation;
}



public void setPerfomanceEvaluation(String perfomanceEvaluation) {
	this.perfomanceEvaluation = perfomanceEvaluation;
}



public int getNesinYear() {
	return nesinYear;
}



public void setNesinYear(int nesinYear) {
	this.nesinYear = nesinYear;
}



public int[] getArrNesinYear() {
	return arrNesinYear;
}



public void setArrNesinYear(int[] arrNesinYear) {
	this.arrNesinYear = arrNesinYear;
}



public int getSemester() {
	return semester;
   }


   public void setSemester(int semester) {
	   this.semester = semester;
   }


/**
    * @return the arrSubjectId
    */
   public String[] getArrSubjectId() {
      return arrSubjectId;
   }

   /**
    * @param arrSubjectId the arrSubjectId to set
    */
   public void setArrSubjectId(String[] arrSubjectId) {
      this.arrSubjectId = arrSubjectId;
   }

   /**
    * @return the arrMidExam
    */
   public String[] getArrMidExam() {
      return arrMidExam;
   }

   /**
    * @param arrMidExam the arrMidExam to set
    */
   public void setArrMidExam(String[] arrMidExam) {
      this.arrMidExam = arrMidExam;
   }

   /**
    * @return the arrFinalExam
    */
   public String[] getArrFinalExam() {
      return arrFinalExam;
   }

   /**
    * @param arrFinalExam the arrFinalExam to set
    */
   public void setArrFinalExam(String[] arrFinalExam) {
      this.arrFinalExam = arrFinalExam;
   }

   /**
    * @return the arrPerformanceEvaluation
    */
   public String[] getArrPerformanceEvaluation() {
      return arrPerformanceEvaluation;
   }

   /**
    * @param arrPerformanceEvaluation the arrPerformanceEvaluation to set
    */
   public void setArrPerformanceEvaluation(String[] arrPerformanceEvaluation) {
      this.arrPerformanceEvaluation = arrPerformanceEvaluation;
   }

   /**
    * @return the arrMemberId
    */
   public String[] getArrMemberId() {
      return arrMemberId;
   }

   /**
    * @param arrMemberId the arrMemberId to set
    */
   public void setArrMemberId(String[] arrMemberId) {
      this.arrMemberId = arrMemberId;
   }

   public String getSubjectId() {
      return subjectId;
   }

   public void setSubjectId(String subjectId) {
      this.subjectId = subjectId;
   }

   public String getMidExam() {
      return midExam;
   }

   public void setMidExam(String midExam) {
      this.midExam = midExam;
   }

   public String getFinalExam() {
      return finalExam;
   }

   public void setFinalExam(String finalExam) {
      this.finalExam = finalExam;
   }

   public String getPerformanceEvaluation() {
      return perfomanceEvaluation;
   }

   public void setPerformanceEvaluation(String perfomanceEvaluation) {
      this.perfomanceEvaluation = perfomanceEvaluation;
   }

   public String getMemberId() {
      return memberId;
   }

   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }

}