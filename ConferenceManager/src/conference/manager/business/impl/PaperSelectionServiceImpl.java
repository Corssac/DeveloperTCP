package conference.manager.business.impl;

import conference.manager.business.PaperSelectionService;
import conference.manager.business.CommitteeAllocationService;
import conference.manager.business.domain.Conference;
import conference.manager.business.domain.Paper;
import conference.manager.data.Database;
import java.util.List;

public class PaperSelectionServiceImpl implements PaperSelectionService, CommitteeAllocationService {

	private Database database;

	public PaperSelectionServiceImpl(Database database) {

	}

	public List<Conference> getConferences() {
		return null;
	}

	public List<Paper> getAcceptedPapers(Conference conference) {
		return null;
	}

	public List<Paper> getRejectedPapers(Conference conference) {
		return null;
	}


	/**
	 * @see conference.manager.business.CommitteeAllocationService#getUnallocatedConferences()
	 */
	public List<Conference> getUnallocatedConferences() {
		return null;
	}


	/**
	 * @see conference.manager.business.CommitteeAllocationService#getunallocatedPapersICSE(conference.manager.business.domain.Conference)
	 */
	public List<Paper> getunallocatedPapersICSE(Conference conference) {
		return null;
	}


	/**
	 * @see conference.manager.business.CommitteeAllocationService#allocatePapers(, conference.manager.business.domain.Conference, int)
	 */
	public List<Paper> allocatePapers(List<Paper> papers, Conference conference, int numReviewers) {
		return null;
	}

}
