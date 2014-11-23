package conference.manager.business.domain;

import java.util.ArrayList;
import java.util.List;

public class Conference {

	private String acronym;

	private Researcher coordenator;

	private List<Paper> gradedPapers;

	private List<Paper> ungradedPapers;

	private List<Paper> unallocatedPapers;

	private List<Reviewer> reviewers;
	
	public Conference(String acronym, List<Reviewer> committeeMembers, List<Paper> unallocatedPapers) {
		this.acronym = acronym;
		this.reviewers = committeeMembers;
		this.unallocatedPapers = unallocatedPapers;
		
		this.ungradedPapers = new ArrayList<>();
		this.gradedPapers = new ArrayList<>();
	}

	public void allocatePaper(Paper paper, List<Reviewer> reviewers) {
		paper.addReviewers(reviewers);
		
		for (Reviewer reviewer : reviewers) {
			reviewer.addPaperToReview(paper);
		}
		
		removeFromUnallocatedPapers(paper);
		addToUngradedPapers(paper);
	}

	public void assignGrade(Paper paper, Reviewer reviewer, int grade) {
		paper.addGrade(reviewer, grade);
		
		if(paper.isGraded()){
			addToGradedPapers(paper);
			removeFromUngradedPapers(paper);
		}
	}

	private void addToGradedPapers(Paper selectedPaper) {
		gradedPapers.add(selectedPaper);
	}
	
	private void addToUngradedPapers(Paper selectedPaper) {
		ungradedPapers.add(selectedPaper);
	}
	
	private void removeFromUnallocatedPapers(Paper selectedPaper) {
		for(int i = 0; i < unallocatedPapers.size(); i++){
			Paper currentUnallocatedPaper = unallocatedPapers.get(i);
			if(currentUnallocatedPaper.equals(selectedPaper))
				unallocatedPapers.remove(i);
		}
	}
	
	private void removeFromUngradedPapers(Paper selectedPaper) {
		for(int i = 0; i < ungradedPapers.size(); i++){
			Paper p = ungradedPapers.get(i);
			if(selectedPaper.equals(p)){
				ungradedPapers.remove(p);
			}
		}
	}
	
	public List<Paper> getGradedPapers() {
		return gradedPapers;
	}

	public List<Paper> getUngradedPapers() {
		return ungradedPapers;
	}

	public List<Paper> getUnallocatedPapers() {
		return unallocatedPapers;
	}

	public String getAcronym() {
		return acronym;
	}

	public List<Reviewer> getReviewers() {
		return reviewers;
	}

	public Researcher getCoordenator(){
		return coordenator;
	}
	
	public boolean isValidAcronym() {
		if (this.acronym != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean equals(Conference conference) {
		return this.acronym.equals(conference.getAcronym());
	}
	
	public String toString() {
		return this.acronym;
	}

	public boolean isGraded() {
		if(this.getUngradedPapers().isEmpty() && this.getUnallocatedPapers().isEmpty()){
			return true;
		}
		return false;
	}
}
