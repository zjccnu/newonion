package bean;

public class AllInfo {
  private String currentPage;
  private String currentResult;
  private boolean entityOrField;
  private CourseInfo[] items;
public String getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(String currentPage) {
	this.currentPage = currentPage;
}
public String getCurrentResult() {
	return currentResult;
}
public void setCurrentResult(String currentResult) {
	this.currentResult = currentResult;
}
public boolean isEntityOrField() {
	return entityOrField;
}
public void setEntityOrField(boolean entityOrField) {
	this.entityOrField = entityOrField;
}
public CourseInfo[] getCourseInfos() {
	return items;
}
public void setCourseInfos(CourseInfo[] items) {
	this.items = items;
}
  
}
