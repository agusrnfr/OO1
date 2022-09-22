package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class JobSchedulerLIFO extends JobScheduler{
	
	public JobDescription next() {
    	JobDescription nextJob = null;
		nextJob = jobs.get(jobs.size()-1);
    	this.unschedule(nextJob);
    	return nextJob;
	}

}
